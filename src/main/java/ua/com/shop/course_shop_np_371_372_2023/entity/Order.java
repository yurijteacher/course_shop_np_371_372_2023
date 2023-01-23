package ua.com.shop.course_shop_np_371_372_2023.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Order {

    private Long id;
    private Date dateCreated;

    private String payment;

    private String delivery;

    private boolean statusOrder;

    private Client client;

    private List<ProductHasOrder> productHasOrderList;

}
