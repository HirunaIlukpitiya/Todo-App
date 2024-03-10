package toDoApp.toDo.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The repository interface for managing Todo entities.
 * This interface extends the JpaRepository interface, providing CRUD operations for Todo entities.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
        List<Todo> findByCategory(String category);
}
