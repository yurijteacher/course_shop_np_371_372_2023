package ua.com.shop.course_shop_np_371_372_2023.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Category {

    private Long id;
    private String name;
    private String description;
    private String image;
    private List<Product> productList;
}
