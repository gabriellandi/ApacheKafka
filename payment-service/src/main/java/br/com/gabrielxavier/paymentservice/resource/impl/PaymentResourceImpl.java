package br.com.gabrielxavier.paymentservice.resource.impl;

import br.com.gabrielxavier.paymentservice.model.Payment;
import br.com.gabrielxavier.paymentservice.resource.PaymentResource;
import br.com.gabrielxavier.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

	private final PaymentService paymentService;

	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
