package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.model.OrderDetails;
import com.phaseThreeAssesment.eCommerceAssesment.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phaseThree/orderDetails")
public class OrderDetailsController {
    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping("/")
    public List<OrderDetails> findAllOrders(){
        return orderDetailsService.fetchList();
    }

    @GetMapping("/{id}")
    public OrderDetails getOrderById(@PathVariable(value = "id") long id){
        return orderDetailsService.findById(id);
    }

    @PostMapping("/")
    public OrderDetails createOrder(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.create(orderDetails);
    }

    @PutMapping("/{id}")
    public OrderDetails updateOrder(@PathVariable(value = "id") long id,@RequestBody OrderDetails orderDetails){
        return orderDetailsService.update(id,orderDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable(value = "id") long id){
        orderDetailsService.delete(id);
        return "Deleted";
    }

}
