package com.lightcodese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetingResponse greet(@RequestParam(value = "name", required = false) String name){
        String greetMessage = name == null || name.isBlank() ? "Hello" : "Hello " + name;
        GreetingResponse response = new GreetingResponse(greetMessage,
                List.of("Java", "Golang"),
                new Person("Light", 22));

        return response;
    }

    record Person(String name, int age) {}

    record GreetingResponse(String greet,
                            List<String> favProgrammingLanguages,
                            Person person) {}

//    class GreetingResponse {
//        private final String greet;
//
//        GreetingResponse(String greet) {
//            this.greet = greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetingResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetingResponse that = (GreetingResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
}
