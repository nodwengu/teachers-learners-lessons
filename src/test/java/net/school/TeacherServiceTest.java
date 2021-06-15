//package net.school;
//
//import org.jdbi.v3.core.Jdbi;
//import org.jdbi.v3.core.mapper.JoinRow;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TeacherServiceTest {
//   private Jdbi jdbi;
//   TeacherService teacherService;
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
////   @BeforeEach
////   void beforeEach() {
////      connectDb();
////      jdbi.withHandle(h -> {
////         h.execute("delete from teacher");
////         return null;
////      });
////   }
//
////   @Test
////   public void shouldBeAbleToAddLearner() {
////      this.connectDb();
////      teacherService = new TeacherService(jdbi);
////      Teacher teacher = new Teacher("Thomas", "Khumalo", "thomas@gmail.com", 20);
////      teacherService.addTeacher(teacher);
////   }
//
//   @Test
//   public void shouldBeToReturnAllTeachers() {
//      this.connectDb();
//      teacherService = new TeacherService(jdbi);
//      assertEquals(7,  teacherService.getAll().size());
//   }
//
//   @Test
//   public void shouldBeToDeleteTeacher() {
//      this.connectDb();
//      teacherService = new TeacherService(jdbi);
//      teacherService.deleteById(17);
//      assertEquals(7,  teacherService.getAll().size());
//   }
//
//   @Test
//   public void shouldBeReturnTeacher() {
//      this.connectDb();
//      teacherService = new TeacherService(jdbi);
//      Teacher teacher = teacherService.getById(18);
//      //System.out.println(teacher.getFirstName());
//      assertEquals("Thomas",  teacher.getFirst_name());
//      assertEquals(7,  teacherService.getAll().size());
//   }
//
//   @Test
//   public void shouldBeAbleToSelectSubject() {
//      this.connectDb();
//      teacherService = new TeacherService(jdbi);
//      teacherService.selectSubject(27, 11);
//      //assertEquals("Thomas",  teacher.getFirstName());
//      //assertEquals(1,  teacherService.getAll().size());
//   }
//
//
//   @Test
//   public void shouldReturLessonsForTeacher() {
//      this.connectDb();
//      teacherService = new TeacherService(jdbi);
//      List<JoinRow> rows = teacherService.getLessonForTeacher(26);
//      System.out.println("List<JoinRow>: " + rows.size());
//      System.out.println();
//      List<Object> objList = new ArrayList<>();
//
//      for (JoinRow row: rows) {
//         objList.add(row.get(Teacher.class).getFirst_name());
//         objList.add(row.get(Lesson.class).getLesson_name());
//         objList.add(row.get(TeacherSubject.class).getTeacher_id());
//
////         System.out.println("Name: " + row.get(Teacher.class).getFirst_name());
////         System.out.println("Lesson: "  + row.get(Lesson.class).getLesson_name());
////         System.out.println("Subject: "  + row.get(Subject.class).getSubject_name());
////         System.out.println("TeacherSubject: "  + row.get(TeacherSubject.class).getSubject_id());
//         System.out.println();
//      }
//
//      for (Object object: objList) {
//         System.out.println(object);
//      }
//
//      //assertEquals(2,  rows.size());
//   }
//
//
//
//}
