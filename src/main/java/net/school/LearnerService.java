//package net.school;
//import org.jdbi.v3.core.Jdbi;
//import org.jdbi.v3.core.mapper.JoinRow;
//import org.jdbi.v3.core.mapper.JoinRowMapper;
//import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
//
//import java.util.List;
//
//public class LearnerService {
//   Jdbi jdbi;
//
//   public LearnerService(Jdbi jdbi) {
//      this.jdbi = jdbi;
//   }
//
//   //Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
//
//   public void add(Person learner) {
//      jdbi.useHandle( handle ->
//         handle.execute("insert into learner (first_name, last_name, email, tokens) values(?,?,?,?)",
//                 learner.getFirstName(),
//                 learner.getLastName(),
//                 learner.getEmail(),
//                 learner.getTokens() )
//      );
//   }
//
//   public List<Learner> getAll() {
//      return jdbi.withHandle( handle -> handle.createQuery("SELECT id, first_name, last_name, email, tokens FROM learner")
//         .mapToBean(Learner.class)
//         .list() );
//   }
//
//   public boolean delete(int id) {
//      jdbi.useHandle( handle -> handle.execute("DELETE FROM learner WHERE id = ?", id) );
//      System.out.println("Deleted LEARNER with id: " + id);
//      return true;
//   }
//
//   public Learner getById(int id) {
//      return jdbi.withHandle( handle -> handle.createQuery("SELECT id, first_name, last_name, email, tokens FROM learner WHERE id = :id")
//              .bind("id", id)
//              .mapToBean(Learner.class)
//              .findOnly()
//      );
//   }
//
//   public void selectSubject(int learnerId, int subjectId) {
//      jdbi.useHandle( handle -> handle.execute("INSERT INTO learner_subject(learner_id, subject_id) VALUES(?, ?)",
//              learnerId, subjectId) );
//      System.out.println("INSERT INTO learner_subject");
//   }
//
//   public boolean getNotesFrom(int learner1Id, int learner2Id, int notesId) {
//      NotesService notesService = new NotesService(jdbi);
//
//      int count = jdbi.withHandle( handle -> handle.createQuery("SELECT COUNT(*) FROM learner_notes WHERE learner_id = ? AND notes_id = ?")
//         .bind(0, learner2Id)
//         .bind(1, notesId)
//         .mapTo(int.class)
//         .findOnly() );
//
//      if (count > 0)
//         notesService.giveNotes(learner1Id, notesId);
//      else
//         System.out.println("DOES NOT HAVE THE NOTES");
//
//      System.out.println("COUNT: " + count);
//      return true;
//   }
//
//   public List<JoinRow> getLessonForLearner(int id) {
//      System.out.println("IN THE LESSON FOR TEACHER METHOD");
//      String sql = "SELECT l.id l_id, l.lesson_name l_name, l.subject_id l_subject_id, l.time l_time, " +
//              "s.id s_id, s.subject_name s_subject_name, " +
//              "t.id t_id, t.first_name t_first_name, t.last_name t_last_name, t.email t_email, t.tokens t_tokens, " +
//              "ts.id ts_id, ts.teacher_id ts_teacher_id, ts.subject_id ts_subject_id " +
//              "FROM lesson l " +
//              "INNER JOIN subject s " +
//              "ON l.subject_id = s.id " +
//              "INNER JOIN teacher_subject ts " +
//              "ON s.id = ts.subject_id " +
//              "INNER JOIN teacher t " +
//              "ON ts.teacher_id = t.id " +
//              "WHERE t.id = :id";
//
//      return jdbi.withHandle( handle -> {
//         handle.registerRowMapper(ConstructorMapper.factory(Lesson.class, "l"));
//         handle.registerRowMapper(ConstructorMapper.factory(Subject.class, "s"));
//         handle.registerRowMapper(ConstructorMapper.factory(Teacher.class, "t"));
//         handle.registerRowMapper(ConstructorMapper.factory(TeacherSubject.class, "ts"));
//
//         handle.registerRowMapper(JoinRowMapper.forTypes(Lesson.class, Subject.class, Teacher.class, TeacherSubject.class));
//
//         List<JoinRow> list = handle.createQuery(sql)
//                 .bind("id", id)
//                 .mapTo(JoinRow.class)
//                 .list();
//         return list;
//      });
//
//   }
//
//
//
//}
