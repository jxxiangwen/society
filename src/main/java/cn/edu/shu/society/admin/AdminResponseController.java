package cn.edu.shu.society.admin;

import cn.edu.shu.society.dto.ResponseDTO;
import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by chencen on 2016/7/5.
 */
@Controller
@RequestMapping("/admin/response")
public class AdminResponseController {
    @Autowired
    ResponseService responseService;
    @Autowired
    MessageService messageService;
    @RequestMapping("/add/{currMessageTypeId}/page/{pageNum}")
    public void response(@PathVariable("pageNum") Integer pageNum,@PathVariable("currMessageTypeId") Long currMessageTypeId,@PathVariable("messageId") Long messageId, ResponseDTO responseDTO, HttpSession httpSession){
        UserDTO userDTO=(UserDTO) httpSession.getAttribute("user");
        responseDTO.setUserId(userDTO.getUserId());
        messageService.updateIsPassed(messageId,true);
        responseService.insert(responseDTO);
        String url="/admin/message/list/"+currMessageTypeId+"/page/"+pageNum;
    }
}
