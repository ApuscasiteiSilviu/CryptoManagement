package thirdParty;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CryptoCompareGateway {
    private RestTemplate restTemplate = new RestTemplate();
    private String CRYPTO_COMPARE_START_PART = "https://min-api.cryptocompare.com/data/v2/histoday?fsym=";
    private String CRYPTO_COMPARE_LAST_PART = "&tsym=USD&limit=1&api_key=409b2bce1e8c9f05d32323cf70ba4f1114cfdebc9106f4d596d5c05bf34617b9";

    public Double getInitialValue(String cryptoCoin){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CryptoCompare> entity = new HttpEntity<>(headers);

        CryptoCompare cryptoCompare = restTemplate.exchange(CRYPTO_COMPARE_START_PART + cryptoCoin + CRYPTO_COMPARE_LAST_PART, HttpMethod.GET, entity, CryptoCompare.class).getBody();
        List<CoinExchange> coinExchangeList = cryptoCompare.Data.Data;

        return coinExchangeList.get(0).high;
    }
}
