package com.dvFabricio.hr_payroll.services;

import com.dvFabricio.hr_payroll.entities.Payment;
import com.dvFabricio.hr_payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) throws Exception {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        if (worker == null) {

            throw new Exception("Worker not found with ID: " + workerId);
        }

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
