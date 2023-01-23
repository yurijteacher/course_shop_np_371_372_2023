package ua.com.shop.course_shop_np_371_372_2023.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String unit;

    @OneToMany(mappedBy = "attribute")
    private List<AttributeHasProduct> attributeHasProducts;
}
