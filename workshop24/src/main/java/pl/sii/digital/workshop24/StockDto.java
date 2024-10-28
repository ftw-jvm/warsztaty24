package pl.sii.digital.workshop24;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StockDto(
    String ticker, 
    @JsonProperty("no_of_comments") 
        Integer numberOfComments, 
    String sentiment, 
    @JsonProperty("sentiment_score") 
        Double sentimentScore) {

    @Override
    public String toString(){
        return ticker + ": score: " + sentimentScore + ", number of comments: " + numberOfComments + ", sentiment: " + sentiment + ".";
    }
} 