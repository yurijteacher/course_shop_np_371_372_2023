package ua.com.shop.course_shop_np_371_372_2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.course_shop_np_371_372_2023.entity.ProductHasOrder;

public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrder, Long> {
}
