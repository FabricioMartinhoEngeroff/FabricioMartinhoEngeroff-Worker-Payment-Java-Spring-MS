package com.dvFabricio.hr_payroll.services;

import com.dvFabricio.hr_payroll.entities.Payment;
import com.dvFabricio.hr_payroll.entities.Worker;
import com.dvFabricio.hr_payroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) throws Exception {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        if (worker == null) {

            throw new Exception("Worker not found with ID: " + workerId);
        }

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
