package com.example.t2004espring.controller;

import com.example.t2004espring.entity.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //@Controller
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    @RequestMapping(method = RequestMethod.POST)
    public Category create(){
        return new Category(1, "Cate 01");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getList(){
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(1, "Cate 01"));
        list.add(new Category(2, "Cate 02"));
        list.add(new Category(3, "Cate 03"));
        list.add(new Category(4, "Cate 04"));
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/11")
    public Category getDetail(){
        return new Category(11, "Cate 11");
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/12")
    public Category update(){
        return new Category(12, "Cate 12");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/13")
    public boolean delete(){
        return true;
    }
}
