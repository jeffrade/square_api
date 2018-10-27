package com.github.jeffrade.square.api;

import com.github.jeffrade.square.api.service.OAuth2Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {

    @Value("${square.domain}")
    private String squareDomain;

    private OAuth2Service oAuth2Service;

    @PostConstruct
    public void init(){
        oAuth2Service = initOAuth2Service();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public OAuth2Service initOAuth2Service() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(squareDomain)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(OAuth2Service.class);
    }
}