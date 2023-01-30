package ua.com.shop.course_shop_np_371_372_2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.course_shop_np_371_372_2023.entity.Address;
import ua.com.shop.course_shop_np_371_372_2023.entity.Client;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByClientes(Client client);
}
