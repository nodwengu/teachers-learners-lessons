//package net.school.impl;
//
//
//import net.school.dao.TeacherDao;
//import net.school.model.Teacher;
//import org.jdbi.v3.core.Jdbi;
//
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//import java.net.URI;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.*;
//
//// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class TeacherDaoImplTest {
//   private Jdbi jdbi;
//   TeacherDao teacherDao;
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
//         teacherDao = new TeacherDaoImpl(jdbi);
//      } catch (URISyntaxException e) {
//         e.printStackTrace();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
//
//   @Test
//   @Disabled
//   public void shouldBeAbleToAddTeacher() {
//      Teacher teacher = new Teacher(31,"Vuyo", "Bathembu", "vuyo@gmail.com", 10);
//      teacherDao.addTeacher(teacher);
//   }
//
//   @Test
//   @DisplayName("Testing getAll() teachers method")
//   public void shouldBeToReturnAllTeachers() {
//      assertEquals(8,  teacherDao.getAll().size(), "The getAll() method should return all teachers");
//   }
//
//   @Test
//   @Disabled
//   public void shouldBeToDeleteTeacher() {
////      teacherDao.deleteById(17);
//      assertEquals(7,  teacherDao.getAll().size());
//   }
//
//   @Test
//   @DisplayName("Should return teacher by id")
//   public void shouldReturnById() {
//      Teacher teacher = teacherDao.getById(18);
//      assertEquals("Thomas",  teacher.getFirstName());
//      assertEquals("thomas@gmail.com",  teacher.getEmail());
//   }
//
//   @Test
//   @Disabled
//   @DisplayName("Teacher should be able to choose a subject")
//   public void shouldBeAbleToSelectSubject() {
//      teacherDao.selectSubject(18, 8);
//      assertEquals(3, teacherDao.getTeacherLessons(18).size());
//   }
//
//   @Test
//   @DisplayName("Should Return lessons for the teacher")
//   public void shouldReturnTeacherLessons() {
//      assertEquals(1, teacherDao.getTeacherLessons(26).size());
//      assertEquals(3, teacherDao.getTeacherLessons(18).size());
//   }
//
//
//   @Test
//   @Disabled
//   @DisplayName("Testing testDivide method")
//   public void shouldThrowAnException() {
//      // assertArrayEquals();
//      // assertIterableEquals();
//      // assertFalse(true);
//
//      // Have a look at Test Driven Methodology
//      // Write test first and the will fail
//      // Then write your method to make your tests pass
//
//      // Write a and ensure that it throws an exception when the denominator is zero
//      TeacherDaoImpl testDao = new TeacherDaoImpl(jdbi);
//      assertThrows(ArithmeticException.class, () -> testDao.testDivide(2, 0), "Dividing by zero should throw an exception");
//
//      // TEST LIFE CYCLE...
//      // Methods should be independent of each other
//      // JUnit create a test instance for every method
//      // Hooks to initialize something before every method and class
//      // Hooks to initialize something after every method and class
//      // @BeforeAll     @AfterAll      @BeforeEach       @AfterEach
//
//      // ANNOTATIONS TO SCALE YOUR TESTS...
//      // @DisplayName("Testing getAll() teachers method")
//      // @Disabled
//
//      // CONDITIONAL EXECUTION
//
//   }
//
//   @Test
//   @DisplayName("Testing @Disabled")
//   @Disabled
//   public void testDisabled() {
//      fail("Testing fail");
//
//   }
//
//
//
//}
