package net.ean.msorder.controller;

import net.ean.msorder.service.OrderService;
import net.ean.msorder.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/Orders")
    public String findAll(Model model){
        List<Order> Orders = orderService.findAll();
        model.addAttribute("Orders", Orders);
        return "Order-list";
    }

    @GetMapping("/order-create")
    public String createOrderForm(Order Order){
        return "order-create";
    }

    @PostMapping("/order-create")
    public String createOrder(Order Order){
        orderService.saveOrder(Order);
        return "redirect:/Orders";
    }

    @GetMapping("order-delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    @GetMapping("/Order-update/{id}")
    public String updateOrderForm(@PathVariable("id") Long id, Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order-update";
    }

    @PostMapping("/order-update")
    public String updateOrder(Order Order){
        orderService.saveOrder(Order);
        return "redirect:/Orders";
    }
}
