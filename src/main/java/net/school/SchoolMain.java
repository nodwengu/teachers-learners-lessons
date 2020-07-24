package net.school;

import java.time.LocalTime;

public class SchoolMain {
   public static void main(String[] args) {
      Learner learner1 = new Learner("thando", "nodwengu", "thando@gmail");
      Learner learner2 = new Learner("bob", "Van Tonder", "bob@gmail");
      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");
   
      // Each learner needs to be registered for more than 3 subject
      learner1.registerForSubject("Maths");
      learner1.registerForSubject("English");
      learner1.registerForSubject("Biology");
   
      learner2.registerForSubject("Accounting");
      learner2.registerForSubject("Maths");
      learner2.registerForSubject("English");
   
      learner3.registerForSubject("Maths");
      learner3.registerForSubject("English");
      learner3.registerForSubject("Biology");
   
      learner4.registerForSubject("Accounting");
      learner4.registerForSubject("Maths");
      learner4.registerForSubject("English");
   
      learner5.registerForSubject("Maths");
      learner5.registerForSubject("English");
      learner5.registerForSubject("Biology");
   
      learner6.registerForSubject("Accounting");
      learner6.registerForSubject("Maths");
      learner6.registerForSubject("English");
   
      Lesson lesson1 = new Lesson("Xesha", LocalTime.parse("08:30"), "Maths", "Algebra"); // Lesson1 for maths
      Lesson lesson2 = new Lesson("James", LocalTime.parse("09:30"), "English", "Vocabulary");
      Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.parse("10:30"), "Biology", "Biotechonology");
      Lesson lesson4 = new Lesson("Xesha", LocalTime.parse("11:30"), "Maths", "Geometry");   // Lesson2 for maths
      Lesson lesson5 = new Lesson("James", LocalTime.parse("14:00"), "English", "Reading Skills");
   
      Lesson lesson6 = new Lesson("Xesha", LocalTime.parse("15:00"), "Maths", "Calculus"); // Lesson1 for maths
      Lesson lesson7 = new Lesson("Xesha", LocalTime.parse("17:00"), "Maths", "Trigonometry"); // Lesson1 for maths
      Lesson lesson8 = new Lesson("Xesha", LocalTime.parse("19:00"), "Maths", "Logic"); // Lesson1 for maths
      
      Teacher teacher1 = new Teacher("Xesha", "Modirharhe", "thomas@gmail");
      Teacher teacher2 = new Teacher("Khanyiso", "Mahlamvu", "khanyiso@gmail");
      teacher1.setQualification("Maths");
      teacher2.setQualification("English");
   
   
      // Students that will attend
      //learner1.attendLesson(lesson1);
      //learner1.attendLesson(lesson4);
//      learner3.attendLesson(lesson1);
//      learner4.attendLesson(lesson1);
   
//      learner1.attendLesson(lesson2);
//      learner2.attendLesson(lesson2);
//      learner3.attendLesson(lesson2);
//      learner4.attendLesson(lesson2);
//      learner5.attendLesson(lesson2);
   
//      lesson1.setNotes("lesson1 Mathematics notes");
      //lesson2.setNotes("lesson2 English notes");
      //lesson4.setNotes("lesson4 maths...");
      
      //lesson2.setNotes("lesson2 English notes");
      //lesson3.setNotes("lesson3 Biology notes");
      
//      learner1.getNotesFromOthers(lesson2, learner2);
//
//      System.out.println("LEARNER1 NOTES: " + learner1.getNotesMap());
//      System.out.println("LEARNER1 NOTES ARRAYLIST: " + learner1.getNotesArrayList());
//      System.out.println("LEARNER2 NOTES: " + learner2.getNotesMap());
   
      
      //teacher1.addNotes(lesson1, "lesson1 Mathematics notes");
      //teacher2.addNotes(lesson2, "lesson2 English notes");
   
      learner1.attendLesson(lesson1);
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);
      learner5.attendLesson(lesson1);
   
      learner1.attendLesson(lesson4);
      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);

      learner1.attendLesson(lesson2);
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
      learner1.attendLesson(lesson6);
      learner2.attendLesson(lesson6);
      learner3.attendLesson(lesson6);
      learner4.attendLesson(lesson6);
   
      learner1.attendLesson(lesson7);
      learner2.attendLesson(lesson7);
      learner3.attendLesson(lesson7);
      learner4.attendLesson(lesson7);
   
      learner1.attendLesson(lesson8);
      learner2.attendLesson(lesson8);
      learner3.attendLesson(lesson8);
      learner4.attendLesson(lesson8);
      
      
      System.out.println(teacher1.teach(lesson1, "lesson1 Mathematics notes"));
      System.out.println(teacher1.teach(lesson4, "lesson4 Maths notes"));
      System.out.println(teacher2.teach(lesson2, "lesson2 English note"));
   
      System.out.println(teacher1.teach(lesson6, "lesson6 Calculus notes"));
      System.out.println(teacher1.teach(lesson7, "lesson7 Trigonometry notes"));
      System.out.println(teacher1.teach(lesson8, "lesson8 Logic notes"));
      
      System.out.println();
      
   
      // LESSON NOTES
      //System.out.println("LESSON NOTES MAP: " + lesson1.getLesson());
      //System.out.println("LESSON NOTES LIST: " + lesson1.getNotSubject("Maths"));
      //System.out.println("NOTES MAP: " + lesson1.getNotes());
      //System.out.println();
      
      // LEARNER NOTES
      //System.out.println(": " + lesson1.getNotesForSubject());
      //System.out.println(": " + lesson1.getNotSubject("Maths"));
      //System.out.println("LEARNER MAP: " + lesson1.getNotes());
      System.out.println();
      
      Teacher teacher = new Teacher();
      Lesson lesson = new Lesson();
   
      // LESSON NOTES
//      System.out.println("LESSONS MAP: " + lesson.getLessonMap());
//      System.out.println("LESSONS MAP: " + lesson.getLessonMap().entrySet().size());
      //System.out.println("LESSON NOTES LIST: " + lesson.getNotSubject("Maths"));
      //System.out.println("NOTES MAP: " + lesson.getNotesForSubject());
      System.out.println();
   
      
//      teacher1.buyDrink();
//
//      System.out.println();
//      System.out.println("No of lessons taught: " + teacher1.getNoOfLessonTaught());
//      System.out.println("TOKENS: " + teacher1.getTokens());
//      System.out.println("No of lessons taught: " + teacher2.getNoOfLessonTaught());
//      System.out.println("TOKENS: " + teacher2.getTokens());
      System.out.println();
   
   
      System.out.print("NOTES & TOKENS: ");
      System.out.println(learner3.showNotes());
      
      System.out.println();
      
   
      // NEED TO CHECK THIS NOT WORKING FOR NOW
       //Returns set view
//      Set<Map.Entry<String, Lesson> > lessonSet = lesson.getLessonMap().entrySet();
//      System.out.println(lessonSet.size());
//
//      Map<String, Lesson> lessonsFor = new HashMap<>();
//      Lesson lesson12 = null;
//
//      for (Map.Entry<String, Lesson> item: lessonSet) {
//         lesson12 = item.getValue();
//         System.out.println(item.getKey() + ": ");
//
//         if (lesson12.getSubject() == "Maths") {
//            lessonsFor.put(lesson12.getTitle(), lesson12);
//            System.out.println(lesson12.getTime());
//         }
//
//      }
//      System.out.println();
//      System.out.println(lessonsFor.size());
//      System.out.println(lessonsFor.get("Algebra").getTime());
//      System.out.println();
      
      
//      System.out.println(lesson.getLessonsFor("Maths").size());
//      System.out.println(lesson.getLessonsFor("Maths"));
//      //System.out.println(lesson.getLessonsFor("Maths").get("Geometry").getTime());
//      System.out.println(lesson.getLessonsFor("Maths").get("Algebra").getTime());
//      System.out.println();
//
//      System.out.println(lesson.getCancelledLessons().get(0).getTitle());
//      System.out.println(lesson.getCancelledLessons().get(0).getTime());
//
//      System.out.println("No of lessons taught: " + teacher1.getNoOfLessonTaught());
//
      
      


//      System.out.println("LESSON DATA: " + lesson1.getItemData());
//      System.out.println("DATA ITEM: " + lesson1.getItemData().get(0));
//      System.out.println();
//      System.out.println(lesson1.getNotSubject("Maths"));
//      System.out.println();
   
//      System.out.println("LESSON NOTES: " + lesson1.getLessonNotesMap());
//      System.out.println(lesson1.getNoOfLearners());;
//      System.out.println();
//
//      //.out.println("  " + lesson1);
//      //System.out.println();
//
//      learner1.getNotesFromOthers(lesson2, learner2);
//
//      System.out.println("LEARNERS: " + lesson1.getLearners());
//      System.out.println("LEARNER NOTES: " + learner1.getNotesMap());
//      System.out.println();
   
//      Cafeteria cafeteria = new Cafeteria();
      //cafeteria.sell(teacher1);
//      lesson1.cancelLesson();
//      lesson2.cancelLesson();

//      System.out.println();
//      System.out.println("TOKENS: " + teacher1.getTokens());
//      System.out.println("TOKENS: " + learner1.getTokens());
//      System.out.println("TOKENS: " + learner2.getTokens());
//      System.out.println();
      
//      System.out.println(lesson1.getNotSubject("Maths"));
//      System.out.println();
//      System.out.println(lesson1.getNotesList());

      
      
      
      
      
      
      
      
      
   
//      System.out.println("TOTAL TOKENS: " + cafeteria.getTotalDailyTokens());
//
//      cafeteria.sellBreakFast(teacher1); // 4
//      cafeteria.sellDrink(learner1);      // 2
//      cafeteria.sellLunch(learner2);      // 6
//      cafeteria.sellAfternoonSnack(teacher2);
      
      //System.out.println("TOKENS: " + learner2.getTokens());
//      System.out.println("TOTAL TOKENS: " + cafeteria.getTotalDailyTokens());
//      cafeteria.showSales();
      
      
   
//      // Returns set view
//      Set<Map.Entry<String, String> > entrySet;
//
//      for (int x = 0; x < lesson1.getItemData().size(); x++) {
//         entrySet = lesson1.getItemData().get(x).entrySet();
//
//         for (Map.Entry<String, String> item: entrySet) {
//            if (item.getKey().equals("Maths")) {
//               System.out.print(item.getKey() + ": ");
//               System.out.println(item.getValue());
//            }
//
//         }
//      }
   
      // Returns set view
//      Set<Map.Entry<String, Map<String, String>> > outerSet = learner2.getAllNotes().entrySet();
//
//      for (Map.Entry<String, Map<String, String>> item: outerSet) {
//         System.out.println(item.getKey() + ": ");
//         System.out.println(item.getValue());
//      }
//
//      System.out.println();
//      System.out.println("======================================================");
//      System.out.println(learner2.getAllNotes());
   
      
     
      
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
//      System.out.println("LEARNER1: " + lesson1.getNotesListMap());
//      System.out.println("LEARNER1 MAP: ");
//      System.out.println("LEARNER1 ARRAY LIST: " + lesson1.getNotesList());
//      System.out.println("NOTES FOR SUBJECT OUTER MAP: " + lesson1.getNotesForSubject());
   
//      List<String> list = lesson1.getNotesList();
//
//      for (int i = 0; i < list.size(); i++) {
//         System.out.println(i + ". " + list.get(i));
//      }
//
//      System.out.println();
//      // Returns set view
//      Set<Map.Entry<String, Map<String, String>>> outerSet = lesson1.getNotesForSubject().entrySet();
//
//      System.out.println(outerSet.size());
//
//      for (Map.Entry<String, Map<String, String>> item: outerSet) {
//         System.out.print(item.getKey() + ": ");
//         System.out.println(item.getValue());
      
//      System.out.println("all together: " + outerSet.size() + "each element is:  value: " + item);
//      }
//
//
//      System.out.println();
      // Returns set view
//      Set<Map.Entry<String, String>> set2 = lesson1.getNotesListMap().entrySet();

//
//      for (Map.Entry<String, String> item: set2) {
//         System.out.print(item.getKey() + ": ");
//         System.out.println(item.getValue());
//      }
//
//
//      System.out.println();
      // Returns set view
//      Set<Map.Entry<String, Map<String, String>>> set3 = lesson1.getNotesForSubject().entrySet();
//
//      //Map<String,String> nestedHashMap = set3.size();
//
//      for (Map.Entry<String, Map<String, String>> item: set3) {
//         System.out.print(item.getKey() + ": ");
//         System.out.println(item.getValue());
//      }
//
//      System.out.println(set2.size());
//      System.out.println(set3.size());
      
//      System.out.println();
//      Map<String, Map<String, String>> outerSet1 = lesson2.getNotesForSubject();
//      //You can get value from inner map like this:
//
//         Object value = outerSet1.get("Maths").get("Geometry");
//         Object value1 = outerSet1.get("Maths");
//         System.out.println(value);
//         System.out.println(value1);
      
     
      
      
      
   
   }
}
