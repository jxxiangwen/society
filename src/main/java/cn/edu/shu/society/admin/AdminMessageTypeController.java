package cn.edu.shu.society.admin;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.dto.UserDTO;
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
@RequestMapping("/admin/messageType")
public class AdminMessageTypeController {
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    MessageService messageService;

    @RequestMapping("/list")
    public ModelAndView list(HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin/message/messageType");
        List<MessageTypeDTO> messageTypeDTOList=messageTypeService.selectAll();
        if(messageTypeDTOList!=null&&messageTypeDTOList.size()>0){
            for(MessageTypeDTO messageTypeDTO:messageTypeDTOList){
                messageTypeDTO.setCount(messageService.selectCountByMessageTypeIdAndPassStatus(messageTypeDTO.getId(),new boolean[]{false}));
            }
            modelAndView.addObject("messageTypeList",messageTypeDTOList);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(MessageTypeDTO messageTypeDTO,HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forward:/admin/messageType/list");
        if (messageTypeService.selectByMessageTypeName(messageTypeDTO.getTypeName()).size() > 0) {
            modelAndView.addObject("typeNameRepeated", true);
        } else {
            MessageType messageType = new MessageType();
            messageType.setTypeName(messageTypeDTO.getTypeName());
            UserDTO userDTO=(UserDTO) session.getAttribute("user");
           messageType.setUserId(userDTO.getUserId());
            messageTypeService.insert(BeanUtility.beanCopy(messageType, MessageTypeDTO.class));
        }
        return modelAndView;
    }

    @RequestMapping("/delete/{messageTypeId}")
    public ModelAndView delete(@PathVariable("messageTypeId") Long messageTypeId,HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forward:/admin/messageType/list");
        if(messageService.selectCountByMessageTypeIdAndPassStatus(messageTypeId,new boolean[]{true,false})>0){
            modelAndView.addObject("delFailed", true);
        }else{
            messageTypeService.deleteByPrimaryKey(messageTypeId);
        }
        return modelAndView;
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ModelAndView updateMessageType(MessageTypeDTO messageTypeDTO, HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forward:/admin/messageType/list");
        MessageTypeDTO oldMessageTypeDTO = messageTypeService.selectByPrimaryKey(messageTypeDTO.getId());
        if (oldMessageTypeDTO == null) {
            modelAndView.addObject("noSuchTypeId", true);
        } else if (messageTypeService.selectByMessageTypeName(messageTypeDTO.getTypeName()).size() > 0) {
            modelAndView.addObject("typeNameRepeated", true);
        } else {
            oldMessageTypeDTO.setTypeName(messageTypeDTO.getTypeName());
         //   oldMessageTypeDTO.setUserId(messageTypeDTO.getUserId());
            messageTypeService.updateByPrimaryKey(oldMessageTypeDTO);
        }
        return modelAndView;
    }





}
