# Todo-App
## Description
This is a Spring server for the Todo-App project.

## Prerequisites
- Java Development Kit (JDK) 8 or above
- Maven

## Installation
1. Clone the repository: `git clone https://github.com/your-username/Todo-App.git`
2. Navigate to the server directory: `cd Todo-App/toDo-Server`
3. Build the project: `mvn clean install`

## Usage
1. Start the server: `mvn spring-boot:run`
2. The server will be running at `http://localhost:8080`

## API Endpoints
- GET /todos: Get all todos
- POST /todos: Create a new todo
- PUT /todos/{id}: Update a todo by ID
- DELETE /todos/{id}: Delete a todo by ID

## Contributing
1. Fork the repository
2. Create your feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Submit a pull request

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
