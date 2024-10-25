package pro.stevendev.rawdatawriterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pro.stevendev.rawdatawriterservice","pro.stevendev.kafkautils"})
public class RawDataWriterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RawDataWriterServiceApplication.class, args);
    }
}
