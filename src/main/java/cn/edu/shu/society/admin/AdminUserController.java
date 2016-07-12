package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.*;
import cn.edu.shu.society.service.UserService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Api(value = "topic", description = "投票操作相关API")
@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    UserService userService;

    /**
     * 查看投票方法
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/page/{pageNum}", method = RequestMethod.GET)
    public ModelAndView check(@PathVariable("pageNum") Integer pageNum) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/user");
        PageInfo<UserDTO> userDTOPageInfo = userService.selectAllByPage(pageNum, ConstantUtil.PAGE_SIZE);
        modelAndView.addObject("pageInfo", userDTOPageInfo);
        return modelAndView;
    }
}
