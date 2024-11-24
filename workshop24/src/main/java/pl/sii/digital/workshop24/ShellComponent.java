package pl.sii.digital.workshop24;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@org.springframework.shell.standard.ShellComponent
public class ShellComponent {
    
    @Autowired
    StocksClient stocksClient;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @ShellMethod(key = "hello")
    public String getHello(){
        return "Hello CLI";
    }

    @ShellMethod(key = "stocks")
    public String getStocks(){
        return Arrays.toString(stocksClient.getStocksData());
    }

    @ShellMethod(key = "send")
    public void sendToTopic(String message, @ShellOption(defaultValue = "javatopic") String topicname){
        kafkaTemplate.send(topicname, message);
    }

}
