package cn.edu.shu.society.admin;


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
@RequestMapping("/admin/message")
public class AdminMessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageTypeService messageTypeService;
    @Autowired
    ResponseService responseService;

    @RequestMapping("/list/{messageTypeId}")
    public ModelAndView list(@PathVariable("messageTypeId") Long messageTypeId, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isPassed", defaultValue = "false") Boolean isPassed,HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<MessageDTO> messageDTOPageInfo = messageService.selectByMessageTypeIdAndPassStatus(pageNum, ConstantUtil.MESSAGELIST_PAGE_SIZE, messageTypeId, isPassed?new boolean[]{true}:new boolean[]{false});
        List<MessageDTO> messageDTOList = messageDTOPageInfo.getList();
        if (null != messageDTOList && messageDTOList.size() > 0) {
            for (MessageDTO messageDTO : messageDTOList) {
                messageDTO.setResponseDTOList(responseService.selectByMessageId(messageDTO.getId()));
            }
            modelAndView.addObject("pages", messageDTOPageInfo.getPages());
            modelAndView.addObject("currPageNum", pageNum);
            modelAndView.addObject("messageList", messageDTOList);
        }
        List<MessageTypeDTO> messageTypeDTOList = messageTypeService.selectAll();
        if (null != messageTypeDTOList && messageTypeDTOList.size() > 0) {
            modelAndView.addObject("messageTypeList", messageTypeDTOList);
            boolean existType=false;
            if(messageTypeService.selectByPrimaryKey(messageTypeId)!=null){
                modelAndView.addObject("currMessageTypeId", messageTypeId);
            }else{
                modelAndView.addObject("currMessageTypeId", messageTypeDTOList.get(0).getId());
            }
        }
        modelAndView.setViewName("message/downstageList");
        return modelAndView;
    }


    @RequestMapping("/delete/{currMessageTypeId}/{messageId}")
    public String delete(@PathVariable("currMessageTypeId") Long currMessageTypeId,@PathVariable("messageId") Long messageId, Model model, HttpSession httpSession) {
        MessageDTO messageDTO = messageService.selectByPrimaryKey(messageId);
        if (null!=messageDTO) {
            messageTypeService.deleteByPrimaryKey(messageId);
            model.addAttribute("isMsgDelSucc", true);
        } else {
            model.addAttribute("isMsgDelSucc", false);
        }
        return "forword:/admin/message/list/"+currMessageTypeId;
    }


    @RequestMapping("changetype/{messageId}/${messageTypeId}")
    public String changeType(Long messageId, Long messageTypeId) {
        MessageDTO messageDTO = messageService.selectByPrimaryKey(messageId);
        Long oldMessageTypeId=messageDTO.getMessageTypeId();
        if(messageTypeId!=oldMessageTypeId) {
            messageDTO.setMessageTypeId(messageTypeId);
            messageService.updateByPrimaryKey(messageDTO);
        }
        return "forword:/admin/message/list"+messageTypeId;
    }
}
