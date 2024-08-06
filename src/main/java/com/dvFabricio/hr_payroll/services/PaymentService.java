package com.dvFabricio.hr_payroll.services;

import com.dvFabricio.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return  new Payment("bob", 200.0, days);

    }
}
