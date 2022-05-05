package com.example.t2004espring.controller;

import com.example.t2004espring.entity.Food;
import com.example.t2004espring.repository.FoodRepository;
import com.example.t2004espring.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/*
* Lưu ý khi đặt link cũng như method của 1 api
* /api/version/resources (số nhiều)
* - /api/v1/products
* - /api/v1/orders
* - /api/v1/categories
*
* - GET http://localhost:8080/api/v1/products - trả về danh sách sản phẩm
* - GET http://localhost:8080/api/v1/products/1 - trả về chi tiết sản phẩm có id - 1
* - GET http://localhost:8080/api/v1/products - tạo mới sản phẩm
* - PUT http://localhost:8080/api/v1/products/1 - update sản phẩm id là 1
* - DELETE http:localhost:8080/api/v1/products/1 - delete sản phẩm 1
 */

@RestController
@RequestMapping(path ="api/v1/foods")
public class FoodController {
    @Autowired
    FoodService foodService;

    //get full list using List (path variable)
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Object> getList(){
//        return foodService.findAll();
//    }

    //get full list using map (query string)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam (required = false, defaultValue = "1")int page,@RequestParam(defaultValue = "10") int limit){
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", foodService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Food> create(@RequestBody Food food){
//        listFood.add(food);
        foodService.save(food);
        return new ResponseEntity<Food>(food, HttpStatus.CREATED);
    }

    //get details
    @RequestMapping(method = RequestMethod.GET, path = "/detail/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<Food> optionalFood = foodService.findById(id);
        if(optionalFood.isPresent()){
            return new ResponseEntity<>(foodService.findById(id).orElse(null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //update
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Food updateFood){
        Optional<Food> optionalFood = foodService.findById(id);
        if(optionalFood.isPresent()){
            Food food = optionalFood.get();
            food.setName(updateFood.getName());
            food.setDescription(updateFood.getDescription());
            food.setPrice(updateFood.getPrice());
            food.setStatus(updateFood.getStatus());
            foodService.save(food);
            return new ResponseEntity<>(food, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
     public ResponseEntity<Object> delete(@PathVariable int id){
        Optional<Food> optionalFood = foodService.findById(id);
        if(optionalFood.isPresent()){
            foodService.delete(optionalFood.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
