//package net.school;
//
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class NotesServiceTest {
//   private Jdbi jdbi;
//   private NotesService notesService;
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
////   public void shouldAddLessonNotes() {
////      this.connectDb();
////      notesService = new NotesService(jdbi);
////      Notes notes = new Notes("Algebra Notes", "Maths notes notes notes", "Attended", 6);
////      notesService.addNotes(notes);
////
////      //assertEquals(5, lessonService.getAll().size());
////   }
//
//   @Test
//   public void shouldReturnAllNotes() {
//      this.connectDb();
//      notesService = new NotesService(jdbi);
//
//      assertEquals(5, notesService.getAll().size());
//   }
//
////   @Test
////   public void shouldAddNotesForLearner() {
////      this.connectDb();
////      notesService = new NotesService(jdbi);
////
////      notesService.giveNotes(42, 2);
////      assertEquals(5, notesService.getAll().size());
////   }
//
//}