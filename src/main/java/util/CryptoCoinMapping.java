package util;

public class CryptoCoinMapping {

    private static final String bitcoin = "bitcoin";
    private static final String ethereum = "ethereum";
    private static final String ripple = "ripple";
    private static final String tether = "tether";
    private static final String bitcoinCash = "bitcoin cash";
    private static final String litecoin = "litecoin";
    private static final String eos = "eos";
    private static final String binanceCoin = "binance coin";
    private static final String bitcoinSv = "bitcoin sv";
    private static final String tezos = "tezos";
    private static final String stellar = "stellar";
    private static final String cardano = "cardano";
    private static final String tron = "tron";
    private static final String monero = "monero";
    private static final String unusSedLeo = "unus sed leo";
    private static final String atomicCoin = "atomic coin";
    private static final String chainlink = "chainlink";
    private static final String huobiToken = "huobi token";
    private static final String neo = "neo";
    private static final String iota = "iota";
    private static final String maker = "maker";


    public static String getAppValue(String cryptoCoin){
        switch (cryptoCoin){
            case bitcoin:
                return "BTCUSD";
            case ethereum:
                return "ETHUSD";
            case ripple:
                return "XRPUSD";
            case tether:
                return "USDTUSD";
            case bitcoinCash:
                return "BCHUSD";
            case litecoin:
                return "LTCUSD";
            case eos:
                return "EOSUSD";
            case binanceCoin:
                return "BNBBUSD";
            case bitcoinSv:
                return "BSVUSD";
            case tezos:
                return "XTZUSD";
            case stellar:
                return "XLMUSDT";
            case cardano:
                return "ADAUSD";
            case tron:
                return "TRXUSD";
            case monero:
                return "XMRUSD";
            case unusSedLeo:
                return "LOEUSD";
            case atomicCoin:
                return "ATOUSD";
            case chainlink:
                return "LINKBTC";
            case huobiToken:
                return "HTHUSD";
            case neo:
                return "NEOUSD";
            case iota:
                return "IOTUSD";
            case maker:
                return "MKRUSD";
        }
        return null;
    }

    public static String getCommonValue(String appCryptoCoin){
        switch (appCryptoCoin){
            case "BTCUSD":
                return bitcoin;
            case "ETHUSD":
                return ethereum;
            case "XRPUSD":
                return ripple;
            case "USDTUSD":
                return tether;
            case "BCHUSD":
                return bitcoinCash;
            case "LTCUSD":
                return litecoin;
            case "EOSUSD":
                return eos;
            case "BNBBUSD":
                return binanceCoin;
            case "BSVUSD":
                return bitcoinSv;
            case "XTZUSD":
                return tezos;
            case "XLMUSDT":
                return stellar;
            case "ADAUSD":
                return cardano;
            case "TRXUSD":
                return tron;
            case "XMRUSD":
                return monero;
            case "LOEUSD":
                return unusSedLeo;
            case "ATOUSD":
                return atomicCoin;
            case "LINKBTC":
                return chainlink;
            case "HTHUSD":
                return huobiToken;
            case "NEOUSD":
                return neo;
            case "IOTUSD":
                return iota;
            case "MKRUSD":
                return maker;
        }
        return null;
    }
}
