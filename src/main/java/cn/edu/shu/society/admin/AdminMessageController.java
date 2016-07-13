package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.service.ResponseService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "message", description = "留言相关API")
@RestController
@RequestMapping("/admin/message")
public class AdminMessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    ResponseService responseService;


    @RequestMapping("/list/{messageTypeId}/page/{pageNum}/{isPassed}")
    public ModelAndView list(@PathVariable("messageTypeId") Long messageTypeId, @PathVariable("pageNum") Integer pageNum, @PathVariable("isPassed") Integer isPassed, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo = messageService.selectByMessageTypeIdAndPassStatus(pageNum <= 0 ? 1 : pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, messageTypeId, 0 != isPassed ? new boolean[]{true} : new boolean[]{false});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        modelAndView.addObject("pageInfo", messageDTOPageInfo);
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectResAndNameByMessageId(messageDTO.getId()));
            }
        }
        List<MessageTypeDTO> messageTypeDTOList = messageTypeService.selectAll();
        modelAndView.addObject("messageTypeList", messageTypeDTOList);
        modelAndView.addObject("currMessageTypeId", messageTypeId);
        modelAndView.addObject("isPassed", isPassed);
        modelAndView.setViewName("admin/message/message");
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{currMessageTypeId}/{messageId}/page/{pageNum}/{isPassed}")
    public ModelAndView delete(@PathVariable("currMessageTypeId") Long currMessageTypeId, @PathVariable("messageId") Long messageId, @PathVariable("pageNum") Integer pageNum, @PathVariable("isPassed") Long isPassed) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/admin/message/list/" + currMessageTypeId + "/page/" + pageNum + "/" + isPassed);
        responseService.deleteByMessageId(messageId);
        int result = messageService.deleteByPrimaryKey(messageId);
        if (result == 0) {
            modelAndView.addObject("delFailed", true);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/changetype/{currMessageTypeId}/{messageTypeId}/{messageId}/page/{pageNum}/{isPassed}", method = RequestMethod.GET)
    public ModelAndView changeType(@PathVariable("currMessageTypeId") Long currMessageTypeId, @PathVariable("messageTypeId") Long messageTypeId, @PathVariable("messageId") Long messageId, @PathVariable("pageNum") Integer pageNum, @PathVariable("isPassed") Long isPassed) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/message/list/" + currMessageTypeId + "/page/" + pageNum + "/" + isPassed);
        MessageDTO messageDTO = messageService.selectByPrimaryKey(messageId);
        if (messageTypeId != messageDTO.getMessageTypeId()) {
            messageDTO.setMessageTypeId(messageTypeId);
            messageService.updateByPrimaryKey(messageDTO);
        }
        return modelAndView;
    }
}
