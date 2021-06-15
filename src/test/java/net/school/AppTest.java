//package net.school;
//
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AppTest {
//    // Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
//    private Jdbi jdbi;
//    LearnerService learnerService;
//
//    public Jdbi getJdbiDatabaseConnection(String defaultJdbcUrl) throws URISyntaxException, SQLException {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        String database_url = processBuilder.environment().get("DATABASE_URL");
//        if (database_url != null) {
//
//            URI uri = new URI(database_url);
//            String[] hostParts = uri.getUserInfo().split(":");
//            String username = hostParts[0];
//            String password = hostParts[1];
//            String host = uri.getHost();
//
//            int port = uri.getPort();
//
//            String path = uri.getPath();
//            String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);
//
//            return Jdbi.create(url, username, password);
//        }
//
//        return Jdbi.create(defaultJdbcUrl);
//
//    }
//
//    public boolean connectDb(){
//        try {
//            jdbi = getJdbiDatabaseConnection("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        connectDb();
//        jdbi.withHandle(h -> {
//            h.execute("delete from learner");
//            return null;
//        });
//    }
//
////    @Test
////    public void shouldBeAbleToConnectToPostgreSQL() {
////
////        int count = jdbi.withHandle(h -> h.createQuery("select count(*) from learner")
////                .mapTo(int.class)
////                .findOnly());
////
////        assertTrue(count >= 0);
////
////    }
//
////    @Test
////    public void shouldBeAbleToCleanTable() {
////
////        int count = jdbi.withHandle(h -> {
////            return h.createQuery("select count(*) from users")
////                    .mapTo(int.class)
////                    .findOnly();
////        });
////        assertEquals(0, count);
////    }
//
//    @Test
//    public void shouldBeAbleToAddLearner() {
//        this.connectDb();
//        learnerService = new LearnerService(jdbi);
//
//        Person learner = new Person("Buli", "Nodwengu", "buli@gmail.com", 2);
//        learnerService.addLearner(learner);
//
////        int counter = jdbi.withHandle(h -> {
////            h.execute("insert into learner (first_name, last_name, email, tokens) values (?, ?, ?, ?)",
////                    "Thando",
////                    "Nodwengu",
////                    "thando@email.com",
////                    0);
////
////            int count = h
////                    .createQuery("select count(*) from learner where first_name = ?")
////                    .bind(0, "Thando")
////                    .mapTo(int.class)
////                    .findOnly();
////
////            return count;
////        });
//
//        //assertEquals(1, counter);
//    }
////
////    @Test
////    public void shouldBeAbleToFindAll() {
////
////        final String INSERT_USER = "insert into users (first_name, last_name, email) values (?, ?, ?)";
////
////        List<Person> people = jdbi.withHandle(h -> {
////            h.execute(INSERT_USER, "Name two", "LastName one", "Email one");
////            h.execute(INSERT_USER, "Name three", "LastName three", "Email one");
////            h.execute(INSERT_USER, "Name four", "LastName four", "Email one");
////
////            List<Person> listPerson = h.createQuery("select first_name, last_name, email from users")
////                    .mapToBean(Person.class)
////                    .list();
////            return listPerson;
////        });
////
////        assertEquals(3, people.size());
////        assertEquals("Name three", people.get(1).getFirstName());
////        assertEquals("LastName three", people.get(1).getLastName());
////    }
//
//
//
//}