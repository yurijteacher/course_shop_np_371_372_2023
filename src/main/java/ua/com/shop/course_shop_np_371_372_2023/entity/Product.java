package ua.com.shop.course_shop_np_371_372_2023.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;

    private BigDecimal price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToMany(mappedBy = "product")
    private List<ProductHasOrder> productHasOrders;
    @OneToMany(mappedBy = "productes")
    private List<AttributeHasProduct> attributeHasProductList;

}
