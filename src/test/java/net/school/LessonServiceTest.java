//package net.school;
//
//import com.google.common.collect.Multimap;
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//import java.time.LocalTime;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class LessonServiceTest {
//   private Jdbi jdbi;
//   private LessonService lessonService;
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
//
//      return Jdbi.create(defaultJdbcUrl);
//
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
////   public void shouldBeAbleToAddLesson() {
////      this.connectDb();
////      lessonService = new LessonService(jdbi);
////
////      Lesson lesson1 = new Lesson("Algebra", LocalTime.parse("08:30"), 3);
////      lessonService.addLesson(lesson1);
////   }
//
////   @Test
////   public void shouldReturnAllLesson() {
////      this.connectDb();
////      lessonService = new LessonService(jdbi);
////
////     assertEquals(5, lessonService.getAll().size());
////   }
//
//   @Test
//   public void shouldReturnLessonsForSubject() {
//      this.connectDb();
//      lessonService = new LessonService(jdbi);
//
//      Multimap<Lesson, Subject> lessonsForSubject = lessonService.getLessonForSubject();
//      assertEquals(5, lessonsForSubject.size());
//
////      for (Map.Entry<Lesson, Subject> item: lessonsForSubject.entries()) {
////         System.out.print("Lesson Name: " + item.getKey().getLesson_name() + "  " + "Lesson Time: " + item.getKey().getTime() + "  ");
////         System.out.println("Subject Name: " + item.getValue().getSubject_name() + "  " );
////      }
////      System.out.println("JOINED SIZE: " + lessonsForSubject.size());
//
//   }
//
//}