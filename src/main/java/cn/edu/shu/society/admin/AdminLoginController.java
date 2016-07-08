package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.AdminUserDTO;
import cn.edu.shu.society.enums.LoginEnums;
import cn.edu.shu.society.service.AdminUserService;
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
@RequestMapping(value = "/admin/user")
public class AdminLoginController {

    private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);

    @Autowired
    AdminUserService adminUserService;


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
        AdminUserDTO adminUserDTO = adminUserService.selectByUserId(userId);
        if(null == adminUserDTO || !StringUtil.getEncryptPassword(password).equals(adminUserDTO.getPassword())){
            request.setAttribute("errorMsg","用户名或密码错误");
            return new ModelAndView(LoginEnums.ADMIN_LOGIN_HOME.getMsg());
        }
        request.getSession().setAttribute("adminUser",adminUserDTO);
        return new ModelAndView("admin/index");
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
        ModelAndView modelAndView = new ModelAndView(LoginEnums.ADMIN_LOGIN_HOME.getMsg());
        request.getSession().setAttribute("user",null);
        return modelAndView;
    }

}