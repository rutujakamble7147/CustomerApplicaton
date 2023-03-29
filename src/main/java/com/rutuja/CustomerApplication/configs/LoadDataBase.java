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
            log.info("preloading"+customerRepository.save(new Customer("divya","wadkar","divyaW@gmail.com","malwadi")));
            log.info("preloading"+customerRepository.save(new Customer("gayatri","gavli" ,"gayatri257@gmail.com","manjri")));
            log.info("preloading"+customerRepository.save(new Customer("sakshi","kasbe","sakshiKasbe@gmail.com","15 no.")));
            log.info("preloading"+customerRepository.save(new Customer("mahesh","keskar","MKeskar@gmail.com","manjri BK.")));
            log.info("preloading"+customerRepository.save(new Customer("pratik","shinde","pratikshinde45@gmail.com","hadapsar")));
            log.info("preloading"+customerRepository.save(new Customer("saurabh","jagtap","saurabh147@gmail.com","sasane nagar")));
            log.info("preloading"+customerRepository.save(new Customer("vrushabh","kamble","vrushabh7147@gmail.com","hadapsar")));
            log.info("preloading"+customerRepository.save(new Customer("sakshi","bhandari","sakshiB3355@gmail.com","shewalewadi")));
            log.info("preloading"+customerRepository.save(new Customer("samiksha","karande","samikshaK@gmail.com","15 no.")));
            log.info("preloading"+customerRepository.save(new Customer("kiran","naik","kiranNaik3322@gmail.com","shewalewadi")));
            log.info("preloading"+customerRepository.save(new Customer("vaibhavi","jadhav","VaibhaviJadhav22@gmail.com","hadapsar")));
            log.info("preloading"+customerRepository.save(new Customer("vicky","gavhane","vickyGavhane44@gmail.com","shewalewadi")));



            log.info("preloading"+ orderRepository.save(new Order("rutuja kamble", Status.COMPLETED)));
            log.info("preloading"+orderRepository.save(new Order("anjali jadhav",Status.IN_PROGRESS)));
            log.info("preloading"+ orderRepository.save(new Order("samiksha karande", Status.CANCELLED)));
            log.info("preloading"+orderRepository.save(new Order("saurabh jagtap",Status.IN_PROGRESS)));
            log.info("preloading"+ orderRepository.save(new Order("vaibhavi jadhav", Status.CANCELLED)));
            log.info("preloading"+orderRepository.save(new Order("pratik shinde",Status.IN_PROGRESS)));

        };
    }

}
