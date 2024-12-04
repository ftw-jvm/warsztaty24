package pl.sii.digital.workshop24;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Workshop24ApplicationTests {


	@Autowired
    KafkaConsumer consumer;

    @Autowired
    KafkaProducer producer;

	@Test
	public void contextLoads() {
		assertNotNull(consumer);
		assertNotNull(producer);
	}


}
