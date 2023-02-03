package ua.com.shop.course_shop_np_371_372_2023.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.shop.course_shop_np_371_372_2023.entity.Category;
import ua.com.shop.course_shop_np_371_372_2023.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Cacheable(cacheNames = {"category"})
    public List<Category> getAllCategory(){

//        List<Category> categories = new ArrayList<>();
//        categories = categoryRepository.findAll();
//        return categories;

        return categoryRepository.findAll();
    }

    @Cacheable(cacheNames = "cate", key = "#pageable.pageNumber")
    public Page<Category> getAllPageCategory(Pageable pageable){
       return categoryRepository.findAll(pageable);
    }

}
