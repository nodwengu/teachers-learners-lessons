//package net.school;
//
//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;
//import org.jdbi.v3.core.Jdbi;
//import org.jdbi.v3.core.generic.GenericType;
//import org.jdbi.v3.core.mapper.JoinRow;
//import org.jdbi.v3.core.mapper.JoinRowMapper;
//import org.jdbi.v3.core.mapper.reflect.BeanMapper;
//import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
//
//import java.util.*;
//
//public class TeacherService {
//   private Jdbi jdbi;
//
//
//   public TeacherService(Jdbi jdbi) {
//      this.jdbi = jdbi;
//   }
//
//   public void addTeacher(Teacher teacher) {
//      jdbi.useHandle( (handle) ->
//              handle.execute("INSERT INTO teacher (first_name, last_name, email, tokens) VALUES(?, ?, ?, ?)",
//                      teacher.getFirst_name(),
//                      teacher.getLast_name(),
//                      teacher.getEmail(),
//                      teacher.getTokens() )
//      );
//   }
//
//   public List<Teacher> getAll() {
//      return jdbi.withHandle( (handle) -> handle.createQuery("SELECT first_name, last_name, email, tokens FROM teacher")
//              .mapToBean(Teacher.class)
//              .list() );
//   }
//
//   public void deleteById(int id) {
//      jdbi.useHandle( (handle -> handle.execute("DELETE FROM teacher WHERE id = ?", id)) );
//      System.out.println("Deleted TEACHER with id: " + id);
//   }
//
//   public Teacher getById(int id) {
//      return jdbi.withHandle( (handle) -> handle.createQuery("SELECT id, first_name, last_name, email, tokens FROM teacher WHERE id = :id")
//              .bind("id", id)
//              .mapToBean(Teacher.class)
//              .findOnly() );
//   }
//
//   public void selectSubject(int teacherId, int subjectId) {
//      jdbi.useHandle( handle -> handle.execute("INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(?, ?)",
//              teacherId, subjectId) );
//   }
//
//
//
////   public List<JoinRow> lessonsFor(int id) {
////
////      System.out.println("IN THE LESSON FOR METHOD");
////      String sql = "SELECT " +
////                  "l.id l_id, l.lesson_name l_name, l.subject_id l_subject_id, l.time l_time, " +
////                  "s.id s_id, s.subject_name s_subject_name, " +
////                  "ts.id ts_id, ts.teacher_id ts_teacher_id, ts.subject_id ts_subject_id, " +
////                  "t.id t_id, t.first_name t_first_name, t.last_name t_last_name, t.email t_email, t.tokens t_tokens " +
////                  "FROM lesson l " +
////                  "INNER JOIN subject s " +
////                  "ON l.subject_id = s.id " +
////                  "INNER JOIN teacher_subject ts " +
////                  "ON s.id = ts.subject_id " +
////                  "INNER JOIN teacher t " +
////                  "ON ts.teacher_id = t.id " +
////                  "WHERE t.id = :id";
////
////      return jdbi.withHandle( handle -> {
////         handle.registerRowMapper(ConstructorMapper.factory(Lesson.class, "l"));
////         handle.registerRowMapper(ConstructorMapper.factory(Subject.class, "s"));
////         handle.registerRowMapper(ConstructorMapper.factory(Teacher.class, "t"));
////         handle.registerRowMapper(ConstructorMapper.factory(TeacherSubject.class, "ts"));
////
////         handle.registerRowMapper(JoinRowMapper.forTypes(Lesson.class, Subject.class, Teacher.class, TeacherSubject.class));
////
////         List<JoinRow> list = handle.createQuery(sql)
////                 .bind("id", id)
////                 .mapTo(JoinRow.class)
////                 .list();
////         return list;
////      });
////
////
////   }
//
//   public void testMethod() {
//
//      String sql = "SELECT t.id, t.first_name, t.last_name, t.email, t.tokens " +
//              "ts.id, ts.teacher_id, ts.subject_id, " +
//              "s.id, s.subject_name " +
//              "FROM teacher t " +
//              "INNER JOIN teacher_subject ts " +
//              "ON t.id = ts.teacher_id " +
//              "INNER JOIN subject s " +
//              "ON s.id = ts.subject_id";
//
//      jdbi.useHandle( handle -> {
//         Multimap<Teacher, Subject> map = handle.createQuery(sql)
//                 .registerRowMapper(ConstructorMapper.factory(Teacher.class, "t"))
//                 .registerRowMapper(ConstructorMapper.factory(Subject.class, "s"))
//                 .collectInto(new GenericType<Multimap<Teacher, Subject>>() {});
//
//
//         System.out.println(map);
//      });
//
//   }
//
////   public void tester1() {
////      Multimap<Teacher, Subject> joined = HashMultimap.create();
////      String sql = "SELECT s.id s_id, s.subject_name, " +
////              "l.id l_id, l.lesson_name, l.time, l.subject_id l_subj_id " +
////              "FROM subject s " +
////              "INNER JOIN lesson l " +
////              "ON s.id = l.subject_id";
////
////      jdbi.useHandle( handle -> {
////         handle.registerRowMapper(ConstructorMapper.factory(Teacher.class, "t"));
////         handle.registerRowMapper(ConstructorMapper.factory(Subject.class, "s"));
////
////         handle.createQuery(sql)
////                 .map(JoinRowMapper.forTypes(Teacher.class, Subject.class))
////                 .forEach(jr -> joined.put(jr.get(Teacher.class), jr.get(Subject.class)));
////      });
////
////      System.out.println(joined);
////      // Returns set view
////      Collection<Map.Entry<Teacher, Subject> > set = joined.entries();
////
////      for (Map.Entry<Teacher, Subject> item: set) {
////         System.out.println(item);
////         System.out.print(item.getKey() + ": ");
////         System.out.println(item.getValue());
////      }
////   }
//
//   public List<JoinRow> getLessonForTeacher(int id) {
//
//      System.out.println("IN getLessonsForTeacher(int id) METHOD");
//      String sql = "SELECT l.id l_id, l.lesson_name l_name, l.subject_id l_subject_id, l.time l_time, " +
//                  "s.id s_id, s.subject_name s_subject_name, " +
//                  "t.id t_id, t.first_name t_first_name, t.last_name t_last_name, t.email t_email, t.tokens t_tokens, " +
//                  "ts.id ts_id, ts.teacher_id ts_teacher_id, ts.subject_id ts_subject_id " +
//                  "FROM lesson l " +
//                  "INNER JOIN subject s " +
//                  "ON l.subject_id = s.id " +
//                  "INNER JOIN teacher_subject ts " +
//                  "ON s.id = ts.subject_id " +
//                  "INNER JOIN teacher t " +
//                  "ON ts.teacher_id = t.id " +
//                  "WHERE t.id = :id";
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
//   public List<JoinRow> getLessonForTeacher111(int id) {
//
//      System.out.println("IN getLessonsForTeacher(int id) METHOD");
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
//
////
////         Multimap<Long, JoinRow> myList = handle.createQuery(sql)
////                 .registerRowMapper(BeanMapper.factory(Lesson.class, "l"))
////                 .registerRowMapper(BeanMapper.factory(Subject.class, "s"))
////                 .registerRowMapper(BeanMapper.factory(Teacher.class, "t"))
////                 .registerRowMapper(BeanMapper.factory(TeacherSubject.class, "ts"))
////                 .reduceRows(new LinkedHashMap<Long, JoinRow>(),
////                         (map, rowView) -> {
////                            Lesson lesson = map.computeIfAbsent(
////                                    rowView.getColumn("l_id", Long.class),
////                                    id -> rowView.getRow(Lesson.class));
////
////                            if (rowView.getColumn("p_id", Long.class) != null) {
////                               contact.addPhone(rowView.getRow(Phone.class));
////                            }
////
////                            return map;
////                         })
////                 .values()
////                 .stream()
////                 .collect(toList());
//
////         return myList;
//      });
//
//
//
//   }
//
//
//}
