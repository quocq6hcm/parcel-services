package com.interview.parcelservices.data;

import com.interview.parcelservices.repository.ParcelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final ParcelRepository parcelRepository;


    public DataInitializer(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Bean
    CommandLineRunner initData() {
        return args -> {
            // init data
        };
    }
}