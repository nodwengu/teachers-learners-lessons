//package net.school;
//
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//import java.time.LocalTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LearnerServiceTest {
//   private Jdbi jdbi;
//   private LearnerService learnerService;
//
//   public Jdbi getJdbiDatabaseConnection(String defaultJdbcUrl) throws URISyntaxException, SQLException {
//      ProcessBuilder processBuilder = new ProcessBuilder();
//      String database_url = processBuilder.environment().get("DATABASE_URL");
//      if (database_url != null) {
//         URI uri = new URI(database_url);
//         String[] hostParts = uri.getUserInfo().split(":");
//         String username = hostParts[0];
//         String password = hostParts[1];
//         String host = uri.getHost();
//
//         int port = uri.getPort();
//
//         String path = uri.getPath();
//         String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);
//
//         return Jdbi.create(url, username, password);
//      }
//      return Jdbi.create(defaultJdbcUrl);
//   }
//
//   public boolean connectDb(){
//      try {
//         jdbi = getJdbiDatabaseConnection("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
//      } catch (URISyntaxException e) {
//         e.printStackTrace();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//      return true;
//   }
//
////   @Test
////   public void shouldBeAbleToAddLearner() {
////      this.connectDb();
////      learnerService = new LearnerService(jdbi);
////      learnerService.add(new Learner("Buli", "Nodwengu", "buli@gmail.com", 10));
////   }
//
//   @Test
//   public void shouldReturnAllLearners() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//      assertEquals(7, learnerService.getAll().size());
//   }
//
//   @Test
//   public void shouldBeAbleToDeleteLearner() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//      learnerService.delete(41);
//      assertEquals(7, learnerService.getAll().size());
//   }
//
//   @Test
//   public void shouldReturnLearnerById() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//      Learner learner = learnerService.getById(42);
//      assertEquals("Buli", learner.getFirst_name());
//   }
//
//   @Test
//   public void shouldBeAbleToSelectSubject() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//      learnerService.selectSubject(45, 10);
//   }
//
//   @Test
//   public void shouldBeAbleToGetNotesFromOthers() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//      learnerService.getNotesFrom(45,44, 2);
//   }
//
//   @Test
//   public void shouldReturnLearnerLessons() {
//      this.connectDb();
//      learnerService = new LearnerService(jdbi);
//
//      // learnerService.getLessonForLearner(8);
//
//   }
//
//
//}