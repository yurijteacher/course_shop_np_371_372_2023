package ua.com.shop.course_shop_np_371_372_2023.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreated;

    private String payment;

    private String delivery;

    private boolean statusOrder;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<ProductHasOrder> productHasOrdersList;

}
