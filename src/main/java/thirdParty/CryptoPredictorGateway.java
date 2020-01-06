package thirdParty;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CryptoPredictorGateway {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "https://crypto-predicator.azurewebsites.net/crypto/tomorrowPrice/";

    public Prediction getCoinPrediction(String cryptoCoin){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Prediction> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url + cryptoCoin, HttpMethod.GET, entity, Prediction.class).getBody();
    }
}
