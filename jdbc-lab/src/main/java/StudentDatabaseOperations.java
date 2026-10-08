import java.sql.*;

public class StudentDatabaseOperations {

    private static final String SERVER_URL =
            "jdbc:mysql://localhost:3306/";

    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/StudentsDB";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "_PASSWORD";

    public static void main(String[] args) {

        try {
            // Task 1
            createDatabase();
            createTable();

            // Task 2
            insertStudents();

            // Task 3
            retrieveStudents();

            // Task 4
            updateStudentName(1, "UpdatedJohn");

            // Task 5
            deleteStudent(2);

            // Task 6
            calculateAverageGrade();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TASK 1: Create StudentsDB
    private static void createDatabase() throws SQLException {

        String sql = "CREATE DATABASE IF NOT EXISTS StudentsDB";

        try (Connection connection =
                     DriverManager.getConnection(
                             SERVER_URL,
                             USERNAME,
                             PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);

            System.out.println(
                    "StudentsDB database created successfully."
            );
        }
    }

    // TASK 1: Create students table
    private static void createTable() throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT PRIMARY KEY,
                    firstname VARCHAR(255),
                    lastname VARCHAR(255),
                    grade INT
                )
                """;

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);

            System.out.println(
                    "Students table created successfully."
            );
        }
    }

    // TASK 2: Insert 11 students
    private static void insertStudents() throws SQLException {

        String sql = """
                INSERT INTO students
                (id, firstname, lastname, grade)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            Object[][] students = {
                    {1, "John", "Doe", 90},
                    {2, "Abebe", "Kebede", 85},
                    {3, "Marta", "Tesfaye", 92},
                    {4, "Dawit", "Haile", 78},
                    {5, "Sara", "Mohammed", 88},
                    {6, "Hana", "Bekele", 95},
                    {7, "Samuel", "Alemu", 81},
                    {8, "Meron", "Getachew", 89},
                    {9, "Daniel", "Tadesse", 73},
                    {10, "Betty", "Kassa", 91},
                    {11, "Yonas", "Abraham", 86}
            };

            for (Object[] student : students) {

                statement.setInt(1, (Integer) student[0]);
                statement.setString(2, (String) student[1]);
                statement.setString(3, (String) student[2]);
                statement.setInt(4, (Integer) student[3]);

                statement.executeUpdate();
            }

            System.out.println(
                    "Student data inserted successfully."
            );
        }
    }

    // TASK 3: Retrieve five students
    private static void retrieveStudents() throws SQLException {

        String sql = "SELECT * FROM students LIMIT 5";

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            System.out.println("\nFirst five students:");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String firstname =
                        resultSet.getString("firstname");

                String lastname =
                        resultSet.getString("lastname");

                int grade =
                        resultSet.getInt("grade");

                System.out.println(
                        "ID: " + id +
                        ", Name: " + firstname + " " + lastname +
                        ", Grade: " + grade
                );
            }
        }
    }

    // TASK 4: Update student's firstname
    private static void updateStudentName(
            int id,
            String newFirstName) throws SQLException {

        String sql =
                "UPDATE students SET firstname = ? WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, newFirstName);
            statement.setInt(2, id);

            int rowsUpdated =
                    statement.executeUpdate();

            System.out.println(
                    "\nUpdated rows: " + rowsUpdated
            );
        }
    }

    // TASK 5: Delete student
    private static void deleteStudent(int id)
            throws SQLException {

        String sql =
                "DELETE FROM students WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted =
                    statement.executeUpdate();

            System.out.println(
                    "Deleted rows: " + rowsDeleted
            );
        }
    }

    // TASK 6: Calculate average grade
    private static void calculateAverageGrade()
            throws SQLException {

        String sql =
                "SELECT AVG(grade) AS average_grade FROM students";

        try (Connection connection =
                     DriverManager.getConnection(
                             DATABASE_URL,
                             USERNAME,
                             PASSWORD);
             Statement statement =
                     connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            if (resultSet.next()) {

                double averageGrade =
                        resultSet.getDouble("average_grade");

                System.out.println(
                        "Average Grade: " + averageGrade
                );
            }
        }
    }
}