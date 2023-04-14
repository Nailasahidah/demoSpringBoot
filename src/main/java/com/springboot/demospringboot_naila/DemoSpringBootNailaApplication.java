package com.springboot.demospringboot_naila;

import com.springboot.demospringboot_naila.Customer.Customer;
import com.springboot.demospringboot_naila.Customer.CustomerRepository;
import com.springboot.demospringboot_naila.Product.Product;
import com.springboot.demospringboot_naila.Product.ProductRepository;
import com.springboot.demospringboot_naila.Student.Student;
import com.springboot.demospringboot_naila.Student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class DemoSpringBootNailaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootNailaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {
        return args -> {
            Product wafer = new Product(
                    1L,
                    12023l,
                    "nabati",
                    4500,
                    5000,
                    new Date()
            );

            Product susu = new Product(
                    2L,
                    22023l,
                    "indomilk",
                    3000,
                    3500,
                    new Date()

            );

            List<Product> products = List.of(wafer, susu);
            productRepository.saveAll(products);
        };
    }

//    @Bean
//    CommandLineRunner runner(StudentRepository studentRepository) {
//        return args -> {
//            Student andre = new Student(
//                    1L,
//                    12345,
//                    "Andre",
//                    "LAB2",
//                    "andre07@gmail.com",
//                    "cikijing"
//            );
//
//            Student fatimah = new Student(
//                    2L,
//                    123456,
//                    "Fatimah Azzahra",
//                    "LAB2A",
//                    "fatimah@gmail.com",
//                    "Cirebon"
//            );
//
//            List<Student> students = List.of(andre, fatimah);
//            studentRepository.saveAll(students);
//        };
//    }

//    @Bean
//    CommandLineRunner runner(CustomerRepository customerRepository) {
//        return args -> {
//            Customer andre = new Customer(
//                    "Andre Septian",
//                    "andre@gmail.com",
//                    21
//            );
//
//            Customer fatimah = new Customer(
//                    "Fatimah Azzahra",
//                    "fatimah@gmail.com",
//                    20
//            );
//
//            List<Customer> customers = List.of(andre, fatimah);
//            customerRepository.saveAll(customers);
//        };
//    }
}


//    @GetMapping("/hello")
//    public GreetResponse greet(
//            @RequestParam(value = "name", required = false) String name
//    ) {
//        String greetMessage = name == null || name.isBlank() ? "Hello" : "Hello " + name;
//        GreetResponse response = new GreetResponse(
//                greetMessage,
//                List.of("Java", "c", "Phyton", "Javascript", "Kotlin", "Typescript", "C++" ),
//                new Person(
//                        "Naila Sahidah",
//                        19,
//                        50_000_0000
//                )
//        );
//        return response;
//    }
//    record Person(
//            String name,
//            int age,
//            double salary) {}
//    record GreetResponse(
//            String greet,
   //            List<String> favProgrammingLanguages,
//            Person person
//    ){
//
//    }
//
//    class GreetResponse {
//        private final String greet;
//
//        public GreetResponse(String greet) {
//            this.greet = greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }

