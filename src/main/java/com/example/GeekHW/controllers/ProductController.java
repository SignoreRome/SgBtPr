package com.example.GeekHW.controllers;


import com.example.GeekHW.entities.ProductEntity;
import com.example.GeekHW.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "filter", required = false) String filter) {
        model.addAttribute("products", productsService.filterProductStr(filter));
        model.addAttribute("filter", filter);
        return "/index";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "/new";
    }

    @PostMapping()
    public String createNewProduct(@ModelAttribute("product") ProductEntity productEntity) {
        productsService.createNewProduct(productEntity);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productsService.showProduct(id));
        return "/show";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productsService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productsService.showProduct(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("product") ProductEntity productEntity) {
        productsService.updateProduct(id, productEntity);
        return "redirect:/product";
    }
}
