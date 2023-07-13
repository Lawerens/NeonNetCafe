package com.nncklient.neonnetcafe.controller;

import com.nncklient.neonnetcafe.entity.Klient;
import com.nncklient.neonnetcafe.service.KlientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/klienci")
public class KlientController {

    private KlientService klientService;
    public KlientController(KlientService theKlientService){
        klientService = theKlientService;
    }

    @GetMapping("/")
    public String showLanding() {
        return "landing";
    }

    @GetMapping("/list")
    public String listKlienci(Model theModel){
        List<Klient> theKlienci = klientService.findAll();
        theModel.addAttribute("klienci", theKlienci);
        return "klienci/list-klienci";
    }

    @GetMapping("/rejestracja")
    public String addForm(Model theModel){
        Klient theKlient = new Klient();
        theModel.addAttribute("klient", theKlient);
        return "klienci/klienci-form";
    }

    @GetMapping("/addFormUpdate")
    public String addFormUpdate(@RequestParam("klientId") int theId, Model theModel){
        Klient theKlient = klientService.findById(theId);
        theModel.addAttribute("klient", theKlient);
        return "klienci/klienci-form";
    }

    @PostMapping("/save")
    public String saveKlient(Authentication authentication, @ModelAttribute("klient") Klient theKlient) {
        klientService.save(theKlient);

        if (authentication != null && authentication.isAuthenticated()) {
            boolean isAdminOrObsluga = authentication.getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN") || role.getAuthority().equals("ROLE_OBSLUGA"));

            if (isAdminOrObsluga) {
                return "redirect:/klienci/list";
            }
        }

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("klientId") int theId){
        klientService.deleteById(theId);
        return "redirect:/klienci/list";
    }
}