package com.obvious;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@EntityScan(basePackages = "com.obvious.authority.entity")
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class App 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}