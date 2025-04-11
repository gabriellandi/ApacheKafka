package br.com.gabrielxavier.paymentservice.services;

import br.com.gabrielxavier.paymentservice.model.Payment;

public interface PaymentService {

	void sendPayment(Payment payment);
}
