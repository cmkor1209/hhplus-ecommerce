package com.hanghae.e_commerce.interfaces.api.payment;

import com.hanghae.e_commerce.interfaces.api.payment.response.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    /**
     * 주문
     */
    @PostMapping("/api/order/pay")
    public ResponseEntity<PaymentResponse> payment() {
        return ResponseEntity.ok().body(new PaymentResponse());
    }
}
