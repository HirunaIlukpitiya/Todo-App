package toDoApp.toDo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Todo {

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private Boolean status;
    private LocalDate date;
    private String category;

    /**
     * Default constructor for the Todo class.
     */
    public Todo() {

    }

    /**
     * Constructor for the Todo class with all parameters.
     *
     * @param id          the ID of the todo
     * @param title       the title of the todo
     * @param description the description of the todo
     * @param status      the status of the todo
     * @param date        the date of the todo
     * @param category    the category of the todo
     */
    public Todo(Long id,
                String title,
                String description,
                Boolean status,
                LocalDate date,
                String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
        this.category = category;
    }

    /**
     * Constructor for the Todo class without the ID parameter.
     *
     * @param title       the title of the todo
     * @param description the description of the todo
     * @param status      the status of the todo
     * @param date        the date of the todo
     * @param category    the category of the todo
     */
    public Todo(String title,
                String description,
                Boolean status,
                LocalDate date,
                String category) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
        this.category = category;
    }

    /**
     * Get the ID of the todo.
     *
     * @return the ID of the todo
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the todo.
     *
     * @param id the ID of the todo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the title of the todo.
     *
     * @return the title of the todo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the todo.
     *
     * @param title the title of the todo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the description of the todo.
     *
     * @return the description of the todo
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the todo.
     *
     * @param description the description of the todo
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the status of the todo.
     *
     * @return the status of the todo
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Set the status of the todo.
     *
     * @param status the status of the todo
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Get the date of the todo.
     *
     * @return the date of the todo
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the date of the todo.
     *
     * @param date the date of the todo
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get the category of the todo.
     *
     * @return the category of the todo
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the todo.
     *
     * @param category the category of the todo
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get a string representation of the todo.
     *
     * @return a string representation of the todo
     */
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", category='" + category + '\'' +
                '}';
    }
}
