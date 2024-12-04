package pl.sii.digital.workshop24;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    public String payload;

    @KafkaListener(id = "listener1", topics = "javatopic", groupId = "consumer_group2")
	public void listen(String inbound) {
		System.out.println("Got this from topic: " + inbound);
        payload = inbound;
	}


}
