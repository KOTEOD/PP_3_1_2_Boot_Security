package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Model.Goods;
import ru.kata.spring.boot_security.demo.Model.User;
import ru.kata.spring.boot_security.demo.service.GoodsService;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final GoodsService goodsService;
    private static final String REDIRECT = "redirect:/admin";

    public AdminController(UserService userService, RoleService roleService,
                           PasswordEncoder encoder, GoodsService goodsService) {
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
        this.goodsService = goodsService;
    }

    @GetMapping()
    public String index(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("authUser", user);
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("goodsAll",goodsService.getAllGoods());
        model.addAttribute("newGoods", new Goods());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping()
    public String createNewAdmin(@ModelAttribute("user") User user) {
        userService.save(user);
        return REDIRECT;
    }

    @PostMapping("/add")
    public String addGoods(@ModelAttribute("newGoods")Goods newGoods) {
        goodsService.save(newGoods);
        return REDIRECT;
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.update(id, user);
        return REDIRECT;
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return REDIRECT;
    }
}
