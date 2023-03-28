package com.rutuja.CustomerApplication.configs;

import com.rutuja.CustomerApplication.model.Customer;
import com.rutuja.CustomerApplication.model.Order;
import com.rutuja.CustomerApplication.model.Status;
import com.rutuja.CustomerApplication.repository.CustomerRepository;
import com.rutuja.CustomerApplication.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);
    @Bean
    CommandLineRunner initDatabase (CustomerRepository customerRepository, OrderRepository orderRepository){
        return args -> {
            log.info("preloading"+customerRepository.save(new Customer("rutuja","kamble","rutujak7147@gmail.com","hadapsar")));
            log.info("preloading"+customerRepository.save(new Customer("anjali","jadhav","anjalijadhav@gmail.com","shewalewadi")));

            log.info("preloading"+ orderRepository.save(new Order("rutuja kamble", Status.COMPLETED)));
            log.info("preloading"+orderRepository.save(new Order("anjali jadhav",Status.IN_PROGRESS)));

        };
    }

}
