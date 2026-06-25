package com.katapios.tacos.controllers;

import com.katapios.tacos.repository.IngredientRepository;
import com.katapios.tacos.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IngredientRepository ingredientRepository;
    @MockBean
    private OrderRepository orderRepository;

    @Test
    void rejectsStateLongerThanTwoCharacters() throws Exception {
        mockMvc.perform(post("/orders")
                        .param("deliveryName", "Test User")
                        .param("deliveryStreet", "123 Test St")
                        .param("deliveryCity", "Testville")
                        .param("deliveryState", "wdqqw")
                        .param("deliveryZip", "12345")
                        .param("ccNumber", "4111111111111111")
                        .param("ccExpiration", "12/29")
                        .param("ccCVV", "123"))
                .andExpect(status().isOk())
                .andExpect(view().name("orderForm"))
                .andExpect(model().attributeHasFieldErrors("tacoOrder", "deliveryState"));

        verify(orderRepository, never()).save(org.mockito.ArgumentMatchers.any());
    }
}
