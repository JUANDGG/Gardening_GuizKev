package com.guizKev.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.product.ProductService;
import com.guizKev.api.persistence.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //PERFECT
    //EXAMPLE :GET /products/byRangeAndStock?range=ornamentales&quantity=100
    @GetMapping("/byRangeAndStock")
    public List<Product> findProductsByRangeAndStock(@RequestParam String range, @RequestParam int quantity) {
        return productService.findProductsByRangeAndStock(range, quantity);
    }

    
    //PERFECT
    @GetMapping("/notInOrders")
    public List<Product> findProductsNotInOrders() {
        return productService.findProductsWithoutOrderDetails();
    }

    
    //Perfect
    @GetMapping("/notInOrdersWithDetails")
    public List<Object[]> findProductsNotInOrdersWithDetails() {
        return productService.findProductsNotInOrderDetails();
    }


    //Perfect
    @GetMapping("/maxAndMinSalesPrice")
    public Object[] findMaxAndMinSalesPrice() {
        return productService.findMaxAndMinPrice();
    }


    //Perfect, I just need a method with the first 20 datas
    //@RequestParam String range
    @GetMapping("/topByUnitsSold")
    public List<Object[]> findTopProductsByUnitsSold() {
        return productService.findTop20BestSellingProducts();
    }


}