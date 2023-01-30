package ua.com.shop.course_shop_np_371_372_2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.shop.course_shop_np_371_372_2023.entity.Client;
import ua.com.shop.course_shop_np_371_372_2023.entity.Users;
import ua.com.shop.course_shop_np_371_372_2023.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByUser(Users users){
        return clientRepository.findByUser(users);
    }
}
