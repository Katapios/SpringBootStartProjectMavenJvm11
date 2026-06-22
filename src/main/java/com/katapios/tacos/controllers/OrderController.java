package com.katapios.tacos.controllers;

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

    @ModelAttribute("tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid TacoOrder order, Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

