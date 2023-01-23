package ua.com.shop.course_shop_np_371_372_2023.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String city;

    private String building;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientes;



}
