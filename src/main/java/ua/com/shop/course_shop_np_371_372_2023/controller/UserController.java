package ua.com.shop.course_shop_np_371_372_2023.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.shop.course_shop_np_371_372_2023.bl.Cart;
import ua.com.shop.course_shop_np_371_372_2023.bl.ItemCart;
import ua.com.shop.course_shop_np_371_372_2023.entity.*;
import ua.com.shop.course_shop_np_371_372_2023.repository.AddressRepository;
import ua.com.shop.course_shop_np_371_372_2023.repository.OrderRepository;
import ua.com.shop.course_shop_np_371_372_2023.repository.ProductHasOrderRepository;
import ua.com.shop.course_shop_np_371_372_2023.service.ClientService;
import ua.com.shop.course_shop_np_371_372_2023.service.UserService;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {


    private final UserService userService;
    private final ClientService clientService;
    private final AddressRepository addressRepository;

    private final OrderRepository orderRepository;

    private final ProductHasOrderRepository productHasOrderRepository;


    @Autowired
    public UserController(UserService userService, ClientService clientService, AddressRepository addressRepository, OrderRepository orderRepository, ProductHasOrderRepository productHasOrderRepository) {
        this.userService = userService;
        this.clientService = clientService;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.productHasOrderRepository = productHasOrderRepository;
    }

    @PostMapping("/login")
    public String getPageOrder(@RequestParam(name = "username") String users,
                               @RequestParam(name = "password") String password,
                               HttpServletRequest request){

        if(userService.getLogicByUsernameAndPassword(users, password)){

            Users users1 = userService.getUserByUsernameAndPassword(users, password);
            HttpSession session = request.getSession();

            session.setAttribute("user", users1);

            return "redirect:/order";
        } else {
            return "redirect:/registration";
        }

    }


    @GetMapping("/login")
    public String getPageAuth(){
        return "login";
    }


    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request, Model model){


        HttpSession session = request.getSession();

        Users user = (Users) session.getAttribute("user");

        if(user == null) {
            return "redirect:/";
        }

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart==null) return "redirect:/";

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totalEl", cart.getSumItemCart());
        model.addAttribute("totalValue", cart.getTotalVal());


        Client client = clientService.getClientByUser(user);

        List<Address> addresses = addressRepository.findAllByClientes(client);




        model.addAttribute("client", client);

        model.addAttribute("addresses", addresses);


        return "order";
    }


    @GetMapping("/registration")
    public String getPageRegistration(){
        return "registration";
    }


    @PostMapping("/order")
    public String saveOrderToDB(@RequestParam(name = "delivery") String  delivery,
                                @RequestParam(name = "payment") String payment,
                                @RequestParam(name = "address") Address address,
                                HttpServletRequest request
                                ){

        HttpSession session = request.getSession();

      Cart cart  = (Cart) session.getAttribute("cart");
      Users user = (Users) session.getAttribute("user");

      Client client = clientService.getClientByUser(user);


        Order order = new Order();
        order.setDateCreated(new Date());
        order.setClient(client);
        order.setDelivery(delivery);
        order.setPayment(payment);
        order.setStatusOrder(false);


        Order order1 = orderRepository.save(order);

        // save
        // Order + Id
        // Cart -> List<ItemCart>
        // foreach

        for (ItemCart el : cart.getCart()) {
            productHasOrderRepository.save(new ProductHasOrder(el.getProduct(), el.getQuantity(), order1));
        }

        return "thank";
    }


    @GetMapping("/thank")
    public String getPageThank(){
        return "thank";
    }


}
