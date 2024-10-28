package pl.sii.digital.workshop24;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;

@org.springframework.shell.standard.ShellComponent
public class ShellComponent {
    
    @Autowired
    StocksClient stocksClient;

    @ShellMethod(key = "hello")
    public String getHello(){
        return "Hello CLI";
    }

    @ShellMethod(key = "stocks")
    public String getStocks(){
        return Arrays.toString(stocksClient.getStocksData());
    }


}
