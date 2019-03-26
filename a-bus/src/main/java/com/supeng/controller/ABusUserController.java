package com.supeng.controller;

import com.supeng.model.ABusUser;
import com.supeng.service.impl.ABusUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ABusUserController {

    private ABusUserServiceImpl aBusUserService;

    @Autowired
    public ABusUserController(ABusUserServiceImpl aBusUserService) {
        this.aBusUserService = aBusUserService;
    }

    @RequestMapping("login")
    public String login(String username, String password){
        if("admin".equals(username) && "admin".equals(password)){
            return "user-manage";
        }
        return "index";
    }

    @RequestMapping("getUserList")
    public String getUserList(Model model){
        model.addAttribute("userList", aBusUserService.selectUserList());
        return "user-list";
    }

    @ResponseBody
    @RequestMapping("deleteUser")
    public int deleteUser(String id){
        aBusUserService.deleteUser(Integer.parseInt(id));
        return 1;
    }

    @RequestMapping("toUpdateUserView")
    public String toUpdateUserView(String id, Model model){
        model.addAttribute("user", aBusUserService.selectUserById(Integer.parseInt(id)));
        return "user-edit";
    }

    @ResponseBody
    @RequestMapping("updateUser")
    public void updateUser(ABusUser user){
        aBusUserService.updateUser(user);
    }

    @RequestMapping("register")
    public int register(String username, String password, String telephone){
        return aBusUserService.insert(new ABusUser(username, password, telephone, 2, 0, System.currentTimeMillis() + ""));
    }
}
