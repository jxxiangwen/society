package cn.edu.shu.society.controller;

import cn.edu.shu.society.domain.User;
import cn.edu.shu.society.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * action类
 * Created by jxxia on 2016/4/12 0012.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser")
    public String findAllUser(@RequestParam("id") Integer id, Model model) {
        System.out.println(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("user_name", "邹祥文");
        System.out.println(userService);
        List<User> listUser = userService.find(userMap);
        model.addAttribute("listUser", listUser);
        return "/allUser";
    }
}
