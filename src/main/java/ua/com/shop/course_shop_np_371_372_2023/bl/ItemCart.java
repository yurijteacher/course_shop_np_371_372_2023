package ua.com.shop.course_shop_np_371_372_2023.bl;

import lombok.*;
import ua.com.shop.course_shop_np_371_372_2023.entity.Product;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemCart {
    private Product product;
    private int quantity;

}
