package cn.edu.shu.society.rest;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.entity.MessageType;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "messageType", description = "留言提问类别相关API")
@RestController
@RequestMapping("/messageType")
public class MessageTypeController {
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/list")
    public ModelAndView list(HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("message/userMessageType");
        List<MessageTypeDTO> messageTypeDTOList=messageTypeService.selectAll();
        if(messageTypeDTOList!=null&&messageTypeDTOList.size()>0){
            for(MessageTypeDTO messageTypeDTO:messageTypeDTOList){
                messageTypeDTO.setCount(messageService.selectCountByMessageTypeIdAndPassStatus(messageTypeDTO.getId(),new boolean[]{true}));
            }
            modelAndView.addObject("messageTypeList",messageTypeDTOList);
        }
        return modelAndView;
    }

}
