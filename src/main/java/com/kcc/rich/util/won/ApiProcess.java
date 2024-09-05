package com.kcc.rich.util.won;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcc.rich.mapper.RestaurantsMapper;
import com.kcc.rich.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

//@Component
@RequiredArgsConstructor
@PropertySources(
        @PropertySource("api.properties")
)
//@Controller
public class ApiProcess {
    private final RestaurantsMapper restaurantsMapper;
    private final RestaurantService restaurantService;
    @Value("${openApi.serviceKey}")
    private String apiKey;

    private final ObjectMapper objectMapper;
    @GetMapping("/api")
    public void getData(){
        String url = "http://openapi.seoul.go.kr:8088/"+apiKey+"/json/CrtfcUpsoInfo/"+1+"/"+400;
        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String result = null;

        try{
            URL apiUrl = new URL(url);
            urlConnection = (HttpURLConnection) apiUrl.openConnection();
            stream = getIntputStream(urlConnection);
            result = readStreamToString(stream);
            RestaurantJsonDTO restaurantJsonDTO = objectMapper.readValue(result, RestaurantJsonDTO.class);
            List<RestaurantJsonDTO.ResInfo> resList =
                    restaurantJsonDTO
                            .getCrtfcUpsoInfo()
                            .getResList()
                            .stream()
                            .filter(resInfo -> {
                        return resInfo.getRes_certification_code() == 15 || resInfo.getRes_certification_code() == 14;
                    }).toList();

            restaurantJsonDTO.getCrtfcUpsoInfo().setResList(resList);

            if(resList.size() > 0) {
                for (RestaurantJsonDTO.ResInfo resInfo : resList) {
                    restaurantService.addRestaurant(resInfo);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }

    private InputStream getIntputStream(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(3000);
        urlConnection.setDoInput(true);
        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }
        return urlConnection.getInputStream();
    }

    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            result.append(readLine + "\n\r");
        }

        br.close();

        return result.toString();
    }

    @Scheduled(cron = "0 0 0  * * ?")
    private int getTotalData(){
        String url = "http://openapi.seoul.go.kr:8088/"+apiKey+"/json/CrtfcUpsoInfo/1/1";

        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String result = null;
        RestaurantJsonDTO restaurantJsonDTO = null;
        try{
            URL apiUrl = new URL(url);
            urlConnection = (HttpURLConnection) apiUrl.openConnection();
            stream = getIntputStream(urlConnection);
            result = readStreamToString(stream);
            restaurantJsonDTO = objectMapper.readValue(result, RestaurantJsonDTO.class);

            System.out.println(restaurantJsonDTO.getCrtfcUpsoInfo().getListTotalCount());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return restaurantJsonDTO.getCrtfcUpsoInfo().getListTotalCount();
    }
}
