package br.com.gabrielxavier.strproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

	private final KafkaTemplate<String, String>  kafkaTemplate;

	public void sendMessage(String message) {
		kafkaTemplate.send("str-topic", message).addCallback(
				sucess -> {
					if (sucess != null) {
						RecordMetadata response = sucess.getRecordMetadata();
						log.info("Send message with sucess {}", message);
						log.info("Partition {}, Offset {}", response.partition(), response.offset());
					}
				},
				error -> log.error("Error send message")
		);
	}
}
