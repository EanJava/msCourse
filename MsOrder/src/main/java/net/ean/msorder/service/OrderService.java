package net.ean.msorder.service;

import net.ean.msorder.model.Order;
import net.ean.msorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id){
        return orderRepository.getOne(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}
