package ua.com.shop.course_shop_np_371_372_2023.entity;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Attribute {

    private Long id;

    private String name;

    private String description;

    private String unit;

    private List<AttributeHasProduct> attributeHasProductList;
}
