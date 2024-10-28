package pl.sii.digital.workshop24;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StocksClient {
    RestTemplate restTemplate = null;

    public StocksClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }
    
    private final static String URL = "https://tradestie.com/api/v1/apps/reddit";

    StockDto[] getStocksData(){
        return restTemplate.getForObject(URL, StockDto[].class);
    }

}
