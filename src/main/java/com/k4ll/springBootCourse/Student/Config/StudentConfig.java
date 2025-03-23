package com.k4ll.springBootCourse.Student.Config;

import com.k4ll.springBootCourse.Student.Model.Student;
import com.k4ll.springBootCourse.Student.Repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student kall = new Student(
                    "kall",
                    "kall@example.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student test1 = new Student(
                    "test1",
                    "test1@example.com",
                    LocalDate.of(2002, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(kall, test1)
            );
        };
    }

}
