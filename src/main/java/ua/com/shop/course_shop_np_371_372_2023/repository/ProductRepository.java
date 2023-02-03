package ua.com.shop.course_shop_np_371_372_2023.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.shop.course_shop_np_371_372_2023.entity.Category;
import ua.com.shop.course_shop_np_371_372_2023.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories(Category category);

    Page<Product> findAllByCategories(Pageable pageable, Category category);

}
