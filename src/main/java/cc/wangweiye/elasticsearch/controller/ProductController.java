package cc.wangweiye.elasticsearch.controller;


import cc.wangweiye.elasticsearch.model.Product;
import cc.wangweiye.elasticsearch.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/find/name")
    public List<Product> findByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/find/name/like")
    public List<Product> findByNameLike(@RequestParam String name) {
        return productService.findByNameLike(name);
    }

    @GetMapping("/find/name/notLike")
    public List<Product> findByNameNot(@RequestParam String name) {
        return productService.findByNameNot(name);
    }

    @GetMapping("/find/price/between")
    public List<Product> findByPriceBetween(@RequestParam Long priceFrom, @RequestParam Long priceTo) {
        return productService.findByPriceBetween(priceFrom, priceTo);
    }
}
