package pl.sii.digital.workshop24;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class Workshop24Application {

	public static void main(String[] args) {
		SpringApplication.run(Workshop24Application.class, args);
	}

	@Bean
	public NewTopic topic(){
		return TopicBuilder.name("javatopic")
				.partitions(1)
				.replicas(1)
				.build();
	}

	@KafkaListener(id = "listener1", topics = "javatopic")
	public void listen(String inbound) {
		System.out.println("Got this from topic: " + inbound);
	}

}
