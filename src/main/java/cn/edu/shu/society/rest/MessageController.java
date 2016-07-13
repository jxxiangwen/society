package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.service.ResponseService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "message", description = "留言相关API")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    ResponseService responseService;

    @RequestMapping(value="/list/{messageTypeId}/page/{pageNum}",method = RequestMethod.GET)
    public ModelAndView list(@PathVariable("messageTypeId") Long messageTypeId, @PathVariable("pageNum") Integer pageNum, HttpSession httpSession) {
        ModelAndView modelAndView=new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo=messageService.selectByMessageTypeIdAndPassStatus(pageNum<=0?1:pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, messageTypeId, new boolean[]{true});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        modelAndView.addObject("pageInfo",messageDTOPageInfo);
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectResAndNameByMessageId(messageDTO.getId()));
            }
        }
        modelAndView.addObject("currMessageTypeId",messageTypeId);
        modelAndView.setViewName("message/message");
        return modelAndView;
    }

    @RequestMapping(value="/add/{messageTypeId}/page/{pageNum}",method = RequestMethod.POST)
    public ModelAndView add(@PathVariable("pageNum") Integer pageNum, @PathVariable("messageTypeId") Long messageTypeId, MessageDTO messageDTO, HttpSession httpSession) {
        UserDTO userDTO=(UserDTO) httpSession.getAttribute("user");
        if(null==userDTO){
            throw new AppViewException(ClientError.USER_NOT_LOGIN.getMsg(), ClientError.USER_NOT_LOGIN.getCode());
        }else {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("redirect:/message/list/" + messageTypeId + "/page/" + pageNum);
            messageDTO.setUserId(userDTO.getUserId());
            messageDTO.setIsPassed(false);
            messageService.insert(messageDTO);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/list/user/page/{pageNum}/{isPassed}",method = RequestMethod.GET)
    public ModelAndView list( @PathVariable("pageNum") Integer pageNum, @PathVariable("isPassed") Integer isPassed, HttpSession httpSession) {
        UserDTO userDTO=(UserDTO) httpSession.getAttribute("user");
        if(userDTO==null){
            throw new AppViewException(ClientError.USER_NOT_LOGIN.getMsg(),ClientError.USER_NOT_LOGIN.getCode());
        }
        ModelAndView modelAndView=new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo=messageService.selectByUserIdAndPassStatus(pageNum<=0?1:pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, userDTO.getUserId(), 0!=isPassed?new boolean[]{true}:new boolean[]{false});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        modelAndView.addObject("pageInfo",messageDTOPageInfo);
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectResAndNameByMessageId(messageDTO.getId()));
            }
        }
        modelAndView.addObject("isPassed",isPassed);
        modelAndView.setViewName("message/usermessage");
        return modelAndView;
    }
}
