package br.com.bb.controller;

import br.com.bb.model.Product;
import br.com.bb.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository service;

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(value = "/listAll")
    public List<Product> findAll() {
        return (List<Product>) service.findAll();
    }

    @GetMapping(value = "/listByCategory/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable("categoryId") Long categoryId) {
        List<Product> listProducts = (List<Product>) service.findAll();
        return listProducts.stream().filter(product -> product.getCategory().getId() == categoryId).collect(Collectors.toList());
    }
}
