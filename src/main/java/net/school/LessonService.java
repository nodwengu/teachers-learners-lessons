//package net.school;
//
//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;
//import org.jdbi.v3.core.Jdbi;
//import org.jdbi.v3.core.mapper.JoinRowMapper;
//import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
//
//import java.util.List;
//import java.util.Map;
//
//public class LessonService {
//   private Jdbi jdbi;
//
//   public LessonService(Jdbi jdbi) {
//      this.jdbi = jdbi;
//   }
//
//   public void addLesson(Lesson lesson) {
//      jdbi.useHandle( handle -> handle.execute("INSERT INTO lesson(lesson_name, time, subject_id) VALUES(?,?,?)",
//              lesson.getLesson_name(),
//              lesson.getTime(),
//              lesson.getSubject()) );
//      System.out.println("Added lesson for: " + lesson.getLesson_name());
//   }
//
//   public List<Lesson> getAll() {
//      return jdbi.withHandle( handle -> handle.createQuery("SELECT id, subject_id, lesson_name, time FROM lesson")
//              .mapToBean(Lesson.class)
//              .list() );
//   }
//
//   public Multimap<Lesson, Subject> getLessonForSubject() {
//      Multimap<Lesson, Subject> joined = HashMultimap.create();
//
//      String sql = "SELECT s.id s_id, s.subject_name s_subject_name, l.id l_id, l.lesson_name l_name, l.time l_time, l.subject_id l_subject_id " +
//              "FROM subject s " +
//              "INNER JOIN lesson l " +
//              "ON s.id = l.subject_id";
//
//      return  jdbi.withHandle( handle -> {
//         handle.registerRowMapper(ConstructorMapper.factory(Lesson.class, "l"));
//         handle.registerRowMapper(ConstructorMapper.factory(Subject.class, "s"));
//
//         handle.createQuery(sql)
//                 .map(JoinRowMapper.forTypes(Lesson.class, Subject.class))
//                 .forEach(jr -> joined.put(jr.get(Lesson.class), jr.get(Subject.class)));
//
//         return joined;
//      });
//   }
//
//
//
//}
