package br.com.bb.controller;

import br.com.bb.model.Category;
import br.com.bb.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository service;

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(value = "/listAll")
    public List<Category> findAll() {
        return (List<Category>) service.findAll();
    }

    @GetMapping(value = "/listByCaracterOfName/{character}")
    public Category listByCaracterOfName(@PathVariable("character") String character) {
        System.out.println("Character: " + character);
        List<Category> listCategories = (List<Category>) service.findAll();
        Category categoryCharacter = listCategories.stream().max(Comparator.comparingLong(category ->
                category.getName().toLowerCase().chars().filter(ch -> ch == character.toLowerCase().chars().findFirst().getAsInt()).count())).get();
        return categoryCharacter;
    }
}
