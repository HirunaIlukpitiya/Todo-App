package toDoApp.toDo.Todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository){
        return args -> {
            Todo todo01 = new Todo(
                    "todo 01",
                    "need to be done withing today",
                    true,
                    LocalDate.of(2000, Month.DECEMBER, 12),
                    "work"
            );

            Todo todo02 = new Todo(
                    "todo 02",
                    "need to be done withing a week",
                    false,
                    LocalDate.of(1998, Month.DECEMBER, 12),
                    "fun"
            );

            repository.saveAll(
                    List.of(todo01,todo02)
            );
        };
    }
}
