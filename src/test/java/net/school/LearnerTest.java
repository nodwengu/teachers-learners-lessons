package net.school;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LearnerTest {
   Lesson lesson1 = new Lesson("Xesha", LocalTime.parse("08:30"), "Maths", "Algebra"); // Lesson1 for maths
   Lesson lesson2 = new Lesson("James", LocalTime.parse("09:30"), "English", "Vocabulary");
   Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.parse("10:30"), "Biology", "Biotechonology");
   Lesson lesson4 = new Lesson("Xesha", LocalTime.parse("11:30"), "Maths", "Geometry");   // Lesson2 for maths
   
   @Test
   public void shouldBeAbleToRegisterForSubject() {
      Learner learner = new Learner("thando", "Nodwengu", "thando@gmail");
      assertEquals(0, learner.getSubjects().size());

      learner.registerForSubject("Biology");
      learner.registerForSubject("History");
      assertEquals(2, learner.getSubjects().size());
      
      learner.registerForSubject("Maths");
      learner.registerForSubject("Science");
      assertEquals(4, learner.getSubjects().size());
   }
   
   @Test
   public void shouldBeAbleToAttendLessons() {
      Learner learner1 = new Learner("James", "Smith", "james@gmail");
      
      learner1.registerForSubject("Maths");
      learner1.registerForSubject("English");
      
      assertEquals(2, learner1.getSubjects().size());
      
      assertEquals("Need to be registered for 3 or MORE subjects", learner1.attendLesson(lesson1));

      learner1.registerForSubject("Science");
      
      assertEquals(3, learner1.getSubjects().size());
      
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson1));
      
      assertEquals("Welcome to English", learner1.attendLesson(lesson2));

      assertEquals("You are not registered for this subject", learner1.attendLesson(lesson3));
   }
   
   @Test
   public void shouldBeReturnTokens() {
      Learner learner1 = new Learner("Thando", "nodwengu", "thando@gmail");
      Learner learner2 = new Learner("James", "Bond", "james@gmail");

      learner1.registerForSubject("Maths");
      learner1.registerForSubject("English");
      learner1.registerForSubject("Biology");
   
      learner2.registerForSubject("Accounting"); //lesson 4
      learner2.registerForSubject("Maths");
      learner2.registerForSubject("English");

      assertEquals(0, learner1.getTokens());
      
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson1));

      assertEquals(3, learner1.getTokens());
      
      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson4));

      assertEquals(9, learner1.getTokens());
   
      assertEquals("Welcome to Maths", learner2.attendLesson(lesson1));
      assertEquals(3, learner2.getTokens());
   }

   @Test
   public void shouldBeAbleToGetNotes() {
      Learner learner1 = new Learner("thando", "nodwengu", "thando@gmail");
      Learner learner2 = new Learner("bob", "Van Tonder", "bob@gmail");
      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");
   
      Teacher teacher1 = new Teacher("Xesha", "Modirharhe", "thomas@gmail");
      Teacher teacher2 = new Teacher("Khanyiso", "Mahlamvu", "khanyiso@gmail");
      teacher1.setQualification("Maths");
      teacher2.setQualification("English");
   
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
   
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson1));
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);
      learner5.attendLesson(lesson1);
      
//      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English note");
      
      assertEquals(1, learner1.getNotesList().size());

      learner1.getNotesFromOthers(lesson2, learner2);

      assertEquals(2, learner2.getNotesList().size());
   
      assertEquals("Subject-Maths, Time-08:30, Source-ATTENDED, Notes-lesson1 Mathematics notes", learner1.getNotesFor(lesson1));

      assertEquals("Subject-English, Time-09:30, Source-BOUGHT, Notes-lesson2 English note", learner1.getNotesFor(lesson2));
   }


   @Test
   public void shouldBeAbleToKeepTrackOfNotesAndTokens() {
      Learner learner1 = new Learner("thando", "nodwengu", "thando@gmail");
      Learner learner2 = new Learner("bob", "Van Tonder", "bob@gmail");
      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");
   
      Teacher teacher1 = new Teacher("Xesha", "Modirharhe", "thomas@gmail");
      Teacher teacher2 = new Teacher("Khanyiso", "Mahlamvu", "khanyiso@gmail");
      teacher1.setQualification("Maths");
      teacher2.setQualification("English");
   
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
   
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson1));
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);
//      learner5.attendLesson(lesson1);

      assertEquals("Welcome to Maths", learner1.attendLesson(lesson4));
//      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);

//      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English notes");
      teacher1.teach(lesson4, "lesson4 Maths notes");
      
      assertEquals(6, learner1.getTokens());

      assertEquals(6, learner2.getTokens());

     learner1.getNotesFromOthers(lesson2, learner2);

      assertEquals("Subject-Maths, Time-08:30, Source-ATTENDED, Notes-lesson1 Mathematics notes", learner1.getNotesFor(lesson1));
      assertEquals("Subject-English, Time-09:30, Source-BOUGHT, Notes-lesson2 English notes", learner1.getNotesFor(lesson2));

      assertEquals("Subject-English, Time-09:30, Source-ATTENDED, Notes-lesson2 English notes", learner2.getNotesFor(lesson2));
      assertEquals("Subject-Maths, Time-08:30, Source-ATTENDED, Notes-lesson1 Mathematics notes", learner2.getNotesFor(lesson1));

      assertEquals(8, learner2.getTokens());
      assertEquals(4, learner1.getTokens());
   }
}
