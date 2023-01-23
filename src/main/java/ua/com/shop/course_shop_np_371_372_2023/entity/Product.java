package ua.com.shop.course_shop_np_371_372_2023.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {

    private Long id;
    private String name;

    private String description;

    private BigDecimal price;

    private String image;

    private Category category;

    private List<ProductHasOrder> productHasOrderList;

    private List<AttributeHasProduct> attributeHasProductList;

}
