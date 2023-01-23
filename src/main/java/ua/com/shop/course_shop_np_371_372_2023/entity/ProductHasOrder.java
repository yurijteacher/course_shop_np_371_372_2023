package ua.com.shop.course_shop_np_371_372_2023.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductHasOrder {

    private Long id;

    private Product product;

    private Order order;

    private int quantity;

}
