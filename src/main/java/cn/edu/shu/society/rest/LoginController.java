package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.enums.LoginEnums;
import cn.edu.shu.society.service.UserService;
import cn.edu.shu.society.service.VoteItemService;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.RequestUtil;
import cn.edu.shu.society.util.StringUtil;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Api(value = "vote", description = "投票操作相关API")
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;


    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value="userId") Long userId, @RequestParam(value="password") String password, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserDTO userDTO = userService.selectByUserId(userId);
        if(null == userDTO || !StringUtil.getEncryptPassword(password).equals(userDTO.getPassword())){
            request.setAttribute("errorMsg","用户名或密码错误");
            return new ModelAndView(LoginEnums.LOGIN_HOME.getMsg());
        }
        request.getSession().setAttribute("user",userDTO);
        String redirect = "redirect:" + RequestUtil.retrieveSavedRequest(request);
        System.out.println(redirect);
        return new ModelAndView(redirect);
    }

    /**
     * 退出登录
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("login");
        request.getSession().setAttribute("user",null);
        return modelAndView;
    }

}