package com.Storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoomRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Room(Long.valueOf(1), "small", 12.99,10,10)));
            log.info("Preloading " + repository.save(new Room(2L, "mmedium", 15.99,10,10)));
        };
    }
}