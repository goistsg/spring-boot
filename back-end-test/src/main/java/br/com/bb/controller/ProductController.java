package br.com.bb.controller;

import br.com.bb.model.Product;
import br.com.bb.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository service;

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/listAll")
    public List<Product> findAll() {
        return (List<Product>) service.findAll();
    }

    @GetMapping(value = "/listByCategory/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return (List<Product>) service.findAll();
    }
}
