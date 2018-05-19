package spring.web.controller;

import org.springframework.web.client.RestTemplate;

public class RestAPI {
    static String url="http://openweathermap.org/data/2.5/weather?q=hanoi&appid=b6907d289e10d714a6e88b30761fae22";


    public static void main(String[] args) {
        printAll();
    }
    public  static void printAll(){
        RestTemplate restTemplate=new RestTemplate();


//        WeatherInfo  s = restTemplate.getForObject(url, WeatherInfo.class);
        //restTemplate.exchange("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22", HttpMethod.GET, new HttpEntity<>(null), String.class);
//        System.out.println(s.getMain().getTemp());
//        WeatherInfo weatherInfo = null;
//        try {
//            //weatherInfo = new ObjectMapper().readValue(s, WeatherInfo.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //System.out.println(s);

    }
}
