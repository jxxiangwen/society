package cn.edu.shu.society.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * action类
 * Created by jxxia on 2016/4/12 0012.
 */
@Controller
@RequestMapping("/admin/vote")
public class VoteController {
    @RequestMapping("/findAllUser")
    public String findAllUser(@RequestParam("id") Integer id, Model model) {
        return "/allUser";
    }
}
