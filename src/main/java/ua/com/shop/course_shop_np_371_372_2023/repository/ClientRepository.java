package ua.com.shop.course_shop_np_371_372_2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.shop.course_shop_np_371_372_2023.entity.Client;
import ua.com.shop.course_shop_np_371_372_2023.entity.Users;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUser(Users users);
}
