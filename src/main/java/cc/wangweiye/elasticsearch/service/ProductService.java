package cc.wangweiye.elasticsearch.service;


import cc.wangweiye.elasticsearch.model.Product;

import java.util.List;


public interface ProductService {

    Product save(Product product);

    List<Product> findByName(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameNot(String name);

    List<Product> findByPriceBetween(Long priceFrom, Long priceTo);
}
