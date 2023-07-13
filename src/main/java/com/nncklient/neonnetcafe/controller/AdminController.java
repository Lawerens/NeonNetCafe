package com.nncklient.neonnetcafe.controller;

import com.nncklient.neonnetcafe.entity.Users;
import com.nncklient.neonnetcafe.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UsersService usersService;
    public AdminController(UsersService theUsersService){
        usersService = theUsersService;
    }

    @GetMapping("/pracownicy")
    public String listPracownicy(Model theModel){
        List<Users> theUsers = usersService.findAll();
        theModel.addAttribute("users", theUsers);
        return "klienci/list-pracownicy";
    }

    @GetMapping("/rejestracja")
    public String addForm(Model theModel){
        Users theUsers = new Users();
        theModel.addAttribute("users", theUsers);
        return "admin-form";
    }
}
