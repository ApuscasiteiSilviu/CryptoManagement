package thirdParty;


public class PredictionBuilder {

    private Float coinPrice;
    private String date;
    private String currency;

    public PredictionBuilder(){
    }

    public PredictionBuilder coinPrice(Float coinPrice){
        this.coinPrice = coinPrice;
        return this;
    }

    public PredictionBuilder date(String date){
        this.date = date;
        return this;
    }

    public PredictionBuilder currency(String currency){
        this.currency = currency;
        return this;
    }

    public Prediction build(){
        Prediction prediction = new Prediction();
        prediction.setCoinPrice(coinPrice);
        prediction.setDate(date);
        prediction.setCurrency(currency);

        return prediction;
    }

    public String toString(){
        return "Prediction.PredictionBuilder(coinPrice=" + this.coinPrice + ", date=" + this.date + ", currency=" + this.currency + ")";
    }
}
