package org.classroom;


import org.classroom.repository.StudentRepository;
import org.classroom.repository.ClassRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

/**
 * Main application
 * @author alexc
 *
 */
@SpringBootApplication
public class RestStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestStarterApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, ClassRepository classRepository) {
        return args -> {

        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
