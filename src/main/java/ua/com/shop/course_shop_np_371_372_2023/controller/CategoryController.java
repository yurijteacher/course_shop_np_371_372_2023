package ua.com.shop.course_shop_np_371_372_2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.shop.course_shop_np_371_372_2023.entity.Category;
import ua.com.shop.course_shop_np_371_372_2023.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getPageCategory(Model model){

        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("allCategory", categoryList);

        return "category";
    }

    @GetMapping("/categorypage")
    public String getPageCategory(Model model,
                                  @PageableDefault(sort = {"id"},
                                  direction = Sort.Direction.ASC,
                                  size = 2) Pageable pageable){
        model.addAttribute("url","/categorypage");
        model.addAttribute("page",categoryService.getAllPageCategory(pageable));

        return "categorypage";
    }

}
