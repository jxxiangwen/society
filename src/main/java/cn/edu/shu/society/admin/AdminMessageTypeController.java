package cn.edu.shu.society.admin;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.entity.Message;
import cn.edu.shu.society.entity.MessageType;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/add/{currMessageTypeId}",method = RequestMethod.POST)
    public String add(@PathVariable("currMessageTypeId") Long currMessageTypeId,@RequestParam("typeName") String typeName, HttpSession session, Model model) {
        if (messageTypeService.selectByMessageTypeName(typeName).size() > 0) {
            model.addAttribute("typeNameRepeated", true);
            return "forward:/messagetype/list/"+currMessageTypeId;
        } else {
            MessageType messageType = new MessageType();
            messageType.setTypeName(typeName);
            messageType.setUserId(0L);
            messageTypeService.insert(BeanUtility.beanCopy(messageType, MessageTypeDTO.class));
            MessageTypeDTO messageTypeDTO=messageTypeService.selectByMessageTypeName(typeName).get(0);
            return "forward:/messagetype/list/"+(messageTypeDTO==null?0:messageTypeDTO.getId());
        }
    }

    @RequestMapping("/delete/{currMessageTypeId}/{messageTypeId}")
    public String delete(@PathVariable("currMessageTypeId") Long currMessageTypeId,@PathVariable("messageTypeId") Long messageTypeId, HttpSession session, Model model) {
        PageInfo<MessageDTO> messageDTOPageInfo = messageService.selectByMessageTypeIdAndPassStatus(1, 1, messageTypeId,null);
        if (messageDTOPageInfo.getTotal() > 0) {
            model.addAttribute("isMsgTypeDelSucc", false);
        } else {
            model.addAttribute("isMsgTypeDelSucc", true);
            messageTypeService.deleteByPrimaryKey(messageTypeId);
        }
            return "forward:/admin/message/list/"+currMessageTypeId;

    }

    @RequestMapping("/update/{currMessageTypeId}")
    public String updateMessageType(@PathVariable("currMessageTypeId") Long currMessageTypeId,MessageTypeDTO messageTypeDTO, HttpSession session, Model model) {
        MessageTypeDTO oldMessageTypeDTO = messageTypeService.selectByPrimaryKey(messageTypeDTO.getId());
        if (messageTypeDTO == null) {
            model.addAttribute("noSuchTypeId", true);
        } else if (messageTypeDTO.getTypeName().equals(oldMessageTypeDTO.getTypeName()) && messageTypeDTO.getUserId() == oldMessageTypeDTO.getUserId()) {
            model.addAttribute("typeNameRepeated", true);
        } else {
            oldMessageTypeDTO.setTypeName(messageTypeDTO.getTypeName());
            oldMessageTypeDTO.setUserId(messageTypeDTO.getUserId());
            messageTypeService.updateByPrimaryKey(oldMessageTypeDTO);
        }
        return "forward:/admin/message/list/"+currMessageTypeId;
    }





}
