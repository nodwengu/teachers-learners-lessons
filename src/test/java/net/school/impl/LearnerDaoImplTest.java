//package net.school.impl;
//
//import net.school.model.Learner;
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LearnerDaoImplTest {
//   private Jdbi jdbi;
//   private LearnerDaoImpl learnerDaoImpl;
//   private LessonDaoImpl lessonDao;
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
//         int port = uri.getPort();
//         String path = uri.getPath();
//         String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);
//         return Jdbi.create(url, username, password);
//      }
//      return Jdbi.create(defaultJdbcUrl);
//   }
//
//   @BeforeEach
//   public void beforeEach() {
//      try {
//         jdbi = getJdbiDatabaseConnection("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
//         learnerDaoImpl = new LearnerDaoImpl(jdbi);
//         lessonDao = new LessonDaoImpl(jdbi);
//      } catch (URISyntaxException e) {
//         e.printStackTrace();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
//
////   @Test
////   @DisplayName("Should Return all the learners")
////   public void getAllLearners() {
////      System.out.println(learnerDaoImpl.getAll());
////      assertEquals(1, learnerDaoImpl.getAll().size());
////   }
//
//   @Test
//   @DisplayName("Should Return all the learners")
//   public void getAllLearners() {
//      System.out.println(lessonDao.getById(7L));
//      //assertEquals(1, lessonDao.getAll().size());
//
//   }
//
//   @Test
//   @DisplayName("Should Return one by id")
//   public void getLearnerById() {
//      Learner learner = learnerDaoImpl.getById(42L);
//      assertEquals("Nodwengu", learner.getLastName());
//   }
//
//   @Test
//   @DisplayName("Should Return lessons for the learner")
//   public void shouldReturnLearnerLessons() {
//      assertEquals(1, learnerDaoImpl.getAllLessons(42L).size());
//      assertEquals(3, learnerDaoImpl.getAllLessons(43L).size());
//      assertEquals(4, learnerDaoImpl.getAllLessons(46L).size());
//   }
//
//   @Test
//   @DisplayName("Should be able to attend a lesson")
//   public void attendLesson() {
//      learnerDaoImpl.attendLesson(46L, 7L);
//      assertEquals(3, learnerDaoImpl.getLearnersFor(7L).size());
//   }
//
//
//}