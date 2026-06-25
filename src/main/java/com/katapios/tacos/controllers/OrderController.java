package com.katapios.tacos.controllers;

import com.katapios.tacos.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;
import com.katapios.tacos.TacoOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ModelAttribute("tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

