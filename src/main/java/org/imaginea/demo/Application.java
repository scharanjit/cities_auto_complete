package org.imaginea.demo;

import org.imaginea.demo.model.Cities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static void loadData() {
        LOG.info("Inside loadData() method " + Application.class.getSimpleName());
        List<String> list = null;
        URI uri = null;
        Cities cities = new Cities();

        try {
            uri = ClassLoader.getSystemResource("CityNames.txt").toURI();
        } catch (URISyntaxException e) {
            LOG.error(e.toString());
        }
        try (Stream<String> lines = Files.lines(Paths.get(uri))) {
            list = lines.collect(Collectors.toList());
            cities.setCities(list);
        } catch (IOException e) {
            LOG.error(e.toString());
        }

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            loadData();
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
