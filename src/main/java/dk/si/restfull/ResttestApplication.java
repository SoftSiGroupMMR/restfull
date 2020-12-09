package dk.si.restfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ResttestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ResttestApplication.class, args);
    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ResttestApplication.class);




    }
}
