package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.dto.ResponseDTO;
import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.entity.Message;
import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.service.ResponseService;
import cn.edu.shu.society.util.BeanUtility;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "file", description = "文件操作相关API")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    ResponseService responseService;

    @RequestMapping("/list/{messageTypeId}/page/{pageNum}")
    public ModelAndView list(@PathVariable("messageTypeId") Long messageTypeId, @PathVariable("pageNum") Integer pageNum, HttpSession httpSession) {
        ModelAndView modelAndView=new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo=messageService.selectByMessageTypeIdAndPassStatus(pageNum<=0?1:pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, messageTypeId, new boolean[]{true});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        modelAndView.addObject("pageInfo",messageDTOPageInfo);
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectByMessageId(messageDTO.getId()));
            }
        }
        modelAndView.addObject("currMessageTypeId",messageTypeId);
        modelAndView.setViewName("message/downstageList");
        return modelAndView;
    }

    @RequestMapping("/add/{messageTypeId}/page/{pageNum}")
    public ModelAndView add(@PathVariable("pageNum") Integer pageNum,@PathVariable("messageTypeId") Long messageTypeId, MessageDTO messageDTO,HttpSession httpSession) {
        UserDTO userDTO=(UserDTO) httpSession.getAttribute("user");
        if(null==userDTO){
            throw new AppViewException(ClientError.USER_NOT_LOGIN.getMsg(),ClientError.USER_NOT_LOGIN.getCode());
        }else {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("redirect:/message/list/" + messageTypeId + "/page/" + pageNum);
            messageDTO.setUserId(userDTO.getUserId());
            messageDTO.setIsPassed(false);
            messageService.insert(messageDTO);
            return modelAndView;
        }
    }
}
