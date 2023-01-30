package ua.com.shop.course_shop_np_371_372_2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.course_shop_np_371_372_2023.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsernameAndPassword(String username, String pass);

    Users findByUsernameAndPassword(String user, String pass);
}
