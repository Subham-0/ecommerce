package org.example;

import com.sevices.ProductService;

public class ExpHQL {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
//        productService.findByProductName("iphone");
//        productService.findByProductPrice(100000);
        productService.findByName("iphone");
    }

}
