package cn.edu.shu.society.admin;

import cn.edu.shu.society.dto.ResponseDTO;
import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin/response")
public class AdminResponseController {
    @Autowired
    ResponseService responseService;
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/add/{currMessageTypeId}/page/{pageNum}/{isPassed}", method = RequestMethod.POST)
    public ModelAndView response(@PathVariable("pageNum") Integer pageNum, @PathVariable("currMessageTypeId") Long currMessageTypeId, @PathVariable("isPassed") Long isPassed, ResponseDTO responseDTO, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/message/list/" + currMessageTypeId + "/page/" + pageNum + "/" + isPassed);
        UserDTO userDTO = (UserDTO) httpSession.getAttribute("user");
        responseDTO.setUserId(userDTO.getUserId());
        responseDTO.setTitle("");
        responseService.insert(responseDTO);
        messageService.updateIsPassed(responseDTO.getMessageId(), true);
        return modelAndView;
    }
}
