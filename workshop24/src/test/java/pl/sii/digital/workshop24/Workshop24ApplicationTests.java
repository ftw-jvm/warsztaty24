package pl.sii.digital.workshop24;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class Workshop24ApplicationTests {


	@Autowired
    KafkaConsumer consumer;

    @Autowired
    KafkaProducer producer;

	@Test
	public void messagesFlow(){
		producer.send("javatopic", "testMSG");

		await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> {
            String msgReceived = consumer.payload;
            assertEquals("testMSG", msgReceived);
        });
	}

}
