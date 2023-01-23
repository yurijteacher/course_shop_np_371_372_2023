package ua.com.shop.course_shop_np_371_372_2023.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Roles {

    private Long id;
    private String name;
    private Set<Users> usersSet;
}
