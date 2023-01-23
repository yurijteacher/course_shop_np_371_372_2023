package ua.com.shop.course_shop_np_371_372_2023.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AttributeHasProduct {

    private Long id;
    private Attribute attribute;
    private Product product;
}
