package br.com.gabrielxavier.paymentservice.services.impl;

import br.com.gabrielxavier.paymentservice.model.Payment;
import br.com.gabrielxavier.paymentservice.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void sendPayment(Payment payment) {
		log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento {}", payment);
	}
}
