package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.entity.Message;
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

    @RequestMapping("/list/{messageTypeId}")
    public ModelAndView list(@PathVariable("messageTypeId") Long messageTypeId, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, HttpSession httpSession) {
        ModelAndView modelAndView=new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo=messageService.selectByMessageTypeIdAndPassStatus(pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, messageTypeId, new boolean[]{true});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectByMessageId(messageDTO.getId()));
            }
            modelAndView.addObject("pages",messageDTOPageInfo.getPages());
            modelAndView.addObject("currPageNum",pageNum);
            modelAndView.addObject("messageList", messageDTOList);
        }
        List<MessageTypeDTO> messageTypeDTOList=messageTypeService.selectAll();
        if(null != messageTypeDTOList && messageTypeDTOList.size() > 0){
            modelAndView.addObject("messageTypeList", messageTypeDTOList);
        }
        modelAndView.addObject("currMessageTypeId",messageTypeId);
        modelAndView.setViewName("message/downstageList");
        return modelAndView;
    }

    @RequestMapping("/add/{messageTypeId}")
    public String add(@PathVariable("messageTypeId") Long messageTypeId, MessageDTO messageDTO) {
        messageService.insert(messageDTO);
        return "forword:/message/list/"+messageTypeId;
    }
}
