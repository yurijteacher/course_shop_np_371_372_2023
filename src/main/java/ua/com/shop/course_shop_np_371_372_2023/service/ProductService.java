package ua.com.shop.course_shop_np_371_372_2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.shop.course_shop_np_371_372_2023.entity.Category;
import ua.com.shop.course_shop_np_371_372_2023.entity.Product;
import ua.com.shop.course_shop_np_371_372_2023.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

     @Cacheable(cacheNames = "prod", key = "#category.getId()")
    public List<Product> getProductsByCategory(Category category){
        return productRepository.findAllByCategories(category);
    }

    @Cacheable(cacheNames = "productsbycategory", key = "#pageable.pageNumber")
    public Page<Product> getPageProductByCategory(Category category, Pageable pageable){
        return productRepository.findAllByCategories(pageable, category);
    }
}
