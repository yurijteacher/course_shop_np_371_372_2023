package ua.com.shop.course_shop_np_371_372_2023.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.shop.course_shop_np_371_372_2023.bl.Cart;
import ua.com.shop.course_shop_np_371_372_2023.entity.Category;
import ua.com.shop.course_shop_np_371_372_2023.entity.Product;
import ua.com.shop.course_shop_np_371_372_2023.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category/{id}")
    public String getAllProductByCategory(@PathVariable(name = "id") Category category,
                                          Model model){
        List<Product> productList = productService.getProductsByCategory(category);
        model.addAttribute("allProductByCategory", productList);

        String name = (!productList.isEmpty()) ? category.getName() : " ";
        model.addAttribute("category", name);

        return "productByCategory";
    }



    @PostMapping("/cart")
    public String addNewItemToCart(@RequestParam(name = "id") Product product,
                                   @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request
                                   ){

        HttpSession session = request.getSession();
        // get/set
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null) cart = new Cart();

        cart.addNewItemToCart(product, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model){

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart==null) cart = new Cart();

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totalEl", cart.getSumItemCart());
        model.addAttribute("totalValue", cart.getTotalVal());

        return "cart";
    }

    @PostMapping("/updateItemCart")
    public String updateItemCart(@RequestParam(name = "id") Product product,
                                @RequestParam(name = "quantity") int quantity,
                                HttpServletRequest request
                                 ){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart==null) cart = new Cart();

        cart.updateItemCart(product, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteItemCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                     HttpServletRequest request){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart==null) cart = new Cart();

        cart.deleteItemFromCart(product);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteItemsCart")
    public String deleteItemsFromCart(HttpServletRequest req){

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();

        cart.deleteAllItemFromCart();

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/login")
    public String getPageOrder(){

        // return "redirect:/registration";

        return "redirect:/order";
    }


    @GetMapping("/login")
    public String getPageAuth(){
        return "login";
    }

}
