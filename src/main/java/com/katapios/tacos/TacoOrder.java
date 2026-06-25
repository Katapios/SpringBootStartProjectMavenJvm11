package com.katapios.tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("Taco_Cloud_Order")
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;
    @NotBlank(message="Delivery name is required")
    @Size(max=50, message="Delivery name must be no more than 50 characters")
    private String deliveryName;
    @NotBlank(message="Street is required")
    @Size(max=50, message="Street must be no more than 50 characters")
    private String deliveryStreet;
    @NotBlank(message="City is required")
    @Size(max=50, message="City must be no more than 50 characters")
    private String deliveryCity;
    @NotBlank(message="State is required")
    @Size(min=2, max=2, message="State must be 2 characters")
    private String deliveryState;
    @NotBlank(message="Zip code is required")
    @Size(max=10, message="Zip code must be no more than 10 characters")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    @Size(max=16, message="Credit card number must be no more than 16 digits")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
