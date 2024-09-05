package com.kcc.rich.controller;

import com.kcc.rich.dto.TossPayDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TossPaymentController {

    @PostMapping("/payment")
    public String payMemnt(TossPayDTO tossPayDTO) {

        return "restaurantDetail/tossPay";
    }

}
