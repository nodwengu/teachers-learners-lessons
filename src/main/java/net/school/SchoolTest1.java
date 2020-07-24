//package net.school;
//
//import java.time.LocalTime;
//
//public class SchoolTest1 {
//   public static void main(String[] args) {
//
//      Lesson lesson1 = new Lesson("Xesha", LocalTime.now(), "Maths", "Algebra");
//      Lesson lesson2 = new Lesson("James", LocalTime.now(), "English", "Vocabulary");
//      Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.now(), "Biology", "Biotechonology");
//      Lesson lesson4 = new Lesson("Stone", LocalTime.now(), "Accounting", "Accounting basics");
//      Lesson lesson5 = new Lesson("Mtsotsoyi", LocalTime.now(), "Xhosa", "Ufundo ncwadi");
//
//      Teacher teacher1 = new Teacher("Thomas", "Modirharhe", "thomas@gmail");
//      teacher1.setQualification("Maths");
//
//      Learner learner1 = new Learner("thando", "nodwengu", "thando@gmail");
//      Learner learner2 = new Learner("bob", "Van Tonder", "bob@gmail");
//      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
//      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
//      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
//      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");
//
//      // Each learner needs to be registered for more than 3 subject
//      learner1.registerForSubject("Maths");
//      learner1.registerForSubject("English");
//      learner1.registerForSubject("Biology");
//
//      learner2.registerForSubject("Accounting"); //lesson 4
//      learner2.registerForSubject("Maths");
//      learner2.registerForSubject("English");
//
//      learner3.registerForSubject("Maths");
//      learner3.registerForSubject("English");
//      learner3.registerForSubject("Biology");
//
//      learner4.registerForSubject("Accounting"); //lesson 4
//      learner4.registerForSubject("Maths");
//      learner4.registerForSubject("English");
//
//      learner5.registerForSubject("Maths");
//      learner5.registerForSubject("English");
//      learner5.registerForSubject("Biology");
//
//      learner6.registerForSubject("Accounting"); //lesson 4
//      learner6.registerForSubject("Maths");
//      learner6.registerForSubject("English");
//
//      // Students that will attend
//      learner1.attendLesson(lesson1);
//      learner2.attendLesson(lesson1);
//      learner3.attendLesson(lesson1);
//      learner4.attendLesson(lesson1);
//
//
//      learner1.attendLesson(lesson2);
//      learner2.attendLesson(lesson2);
//      learner3.attendLesson(lesson2);
//      learner4.attendLesson(lesson2);
//      learner6.attendLesson(lesson2);
//
//      lesson1.setNotes("lesson1 Mathematics notes");
//      lesson2.setNotes("lesson2 English notes");
//      lesson3.setNotes("lesson3 Biology notes");
//
//
////      // Returns set view
////      Set<Map.Entry<String, String> > set = learner1.getNotesMap().entrySet();
////
////      for (Map.Entry<String, String> item: set) {
////         System.out.print(item.getKey() + ": ");
////         System.out.println(item.getValue());
// //     }
//
//      //System.out.println(lesson1.getNotesList());
//
////      System.out.println();
////      System.out.println("LEARNER1: " + learner1.getNotesMap());
////      System.out.println("LEARNER2: " + learner2.getNotesMap());
////      System.out.println();
////      learner2.getNotesAndTokens();
//
//      System.out.println();
//
//      // Returns set view
////      Set<Map.Entry<String, Map<String, String>> > outerSet = learner2.getAllNotes().entrySet();
////
////
////      for (Map.Entry<String, Map<String, String>> item: outerSet) {
////         System.out.println(item.getKey() + ": ");
////         System.out.println(item.getValue());
////      }
////
////      System.out.println();
////      System.out.println("======================================================");
////      System.out.println(learner2.getAllNotes());
//
//     // System.out.println(teacher1.teach(lesson1));
//
//      System.out.println();
//      System.out.println("===========================================================================");
//      System.out.println("SURNAME: " + teacher1.getLastName());
//      System.out.println("QUALIFICATION: " + teacher1.getQualification());
//      System.out.println("QUALIFICATIONS: " + teacher1.getQualifications());
//      System.out.println("LESSONS TAUGHT: " + teacher1.getNoOfLessonTaught());
//      System.out.println("TOKENS: " + teacher1.getTokens());
//      System.out.println();
//      System.out.println("===============================================================================");
//
////      System.out.println(learner1.getNotesMap());
////      System.out.println(learner2.getNotesMap());
//
//      //learner6.getNotesFromOthers(lesson1, learner1);
//      //System.out.println(learner6.getNotesMap());
//
//      //System.out.println(lesson1.getNotesForSubject());
//      //System.out.println(lesson1.getNotesListMap());
//      //System.out.println(lesson2.getNotesListMap());
//
//
//      System.out.println(lesson1.getLessonNotesMap().get(lesson1.getTitle()));
//      System.out.println(lesson2);
//      System.out.println(lesson3.getLessonNotesMap());
//
//      System.out.println(lesson3.getLessonNotesMap());
//
//   }
//}
