package toDoApp.toDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import toDoApp.toDo.Model.request.SignupRequest;
import toDoApp.toDo.entity.TodoUser;

@Repository
public interface TodoUserRepository extends JpaRepository<TodoUser, Long>{

    TodoUser findByEmail(String email);

    void save(SignupRequest request);

}
