package br.com.gabrielxavier.jsonconsumer.listener;

import br.com.gabrielxavier.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2
public class JsonListener {

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) {
		log.info("Recebi o pagamento {}", payment.toString());
		sleep(2000);

		log.info("Validando fraude ... ");
		sleep(2000);

		log.info("Compra aprovada ... ");
		sleep(3000);
	}

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment payment) {
		log.info("Gerando PDF do produto de id {}... ", payment.getIdProduct());
		sleep(2000);
	}

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		log.info("Enviando email de confirmacao ... ");
		sleep(2000);
	}
}
