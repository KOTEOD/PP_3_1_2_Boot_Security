package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.Model.Goods;
import ru.kata.spring.boot_security.demo.service.GoodsService;
import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    private final String urlAdminGoods = "redirect:/admin/goods";

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public String goodsPage (Model model) {
        model.addAttribute("goodsAll",goodsService.getAllGoods());
        model.addAttribute("newGoods",new Goods());
        return "admin";
    }


    @PostMapping()
    public String addGoods(@ModelAttribute("newGoods")Goods newGoods) {
        goodsService.save(newGoods);
        return urlAdminGoods;
    }

    @PostMapping("/edit/{id}")
    public String editGoods(@PathVariable ("id") Long id, @ModelAttribute Goods updatedGoods) {
        goodsService.update(id, updatedGoods);
        return urlAdminGoods;
    }

    @PostMapping("/delete/{id}")
    public String deleteGoods(@PathVariable ("id") Long id) {
        goodsService.delete(id);
        return urlAdminGoods;
    }
}
