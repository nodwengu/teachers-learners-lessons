package net.school;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LessonTest {
   Lesson lesson1 = new Lesson("Xesha", LocalTime.parse("08:30"), "Maths", "Algebra"); // Lesson1 for maths
   Lesson lesson2 = new Lesson("James", LocalTime.parse("09:30"), "English", "Vocabulary");
   Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.parse("10:30"), "Biology", "Biotechonology");
   Lesson lesson4 = new Lesson("Xesha", LocalTime.parse("11:30"), "Maths", "Geometry");   // Lesson2 for maths
   Lesson lesson5 = new Lesson("James", LocalTime.parse("14:00"), "English", "Reading Skills");
   
   @Test
   public void shouldReturnLearnersAttendingLesson() {
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
      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);
      learner6.attendLesson(lesson4);

      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
    
      assertEquals(4, lesson1.getLearners().size());
   
      assertEquals(0, lesson3.getLearners().size());
   
      assertEquals(6, lesson4.getLearners().size());
   
      assertEquals(5, lesson2.getLearners().size());
     
   }
   
   @Test
   public void shouldReturnReturnLessonNotes() {
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
      teacher2.setQualification("Biology");
   
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
      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);
      learner6.attendLesson(lesson4);
   
      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English notes");
      teacher1.teach(lesson4, "lesson4 Maths notes");
   
      assertEquals("Subject-Maths, Time-08:30, Source-ATTENDED, Notes-lesson1 Mathematics notes", lesson1.getNotes());
      assertEquals("Subject-English, Time-09:30, Source-ATTENDED, Notes-lesson2 English notes", lesson2.getNotes());
      assertEquals("Subject-Maths, Time-11:30, Source-ATTENDED, Notes-lesson4 Maths notes", lesson4.getNotes());
   }
   
   @Test
   public void shouldReturnReturnLessonsForSubjects() {
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
      teacher2.setQualification("Biology");
      
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
      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);
      learner6.attendLesson(lesson4);
      
      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
      
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English notes");
      teacher1.teach(lesson4, "lesson4 Maths notes");
      
      Lesson lesson = new Lesson();
      
      assertEquals(3, lesson.getLessonMap().size());
      assertEquals(2, lesson.getLessonsFor("Maths").size());
      assertEquals(1, lesson.getLessonsFor("English").size());
   }
   
   @Test
   public void shouldReturnCancelledLessons() {
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
      teacher2.setQualification("Biology");
      
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
//      learner3.attendLesson(lesson1);
//      learner4.attendLesson(lesson1);
//      learner5.attendLesson(lesson1);
      
      
      assertEquals("Welcome to Maths", learner1.attendLesson(lesson4));
      learner2.attendLesson(lesson4);
      learner3.attendLesson(lesson4);
      learner4.attendLesson(lesson4);
      learner5.attendLesson(lesson4);
      learner6.attendLesson(lesson4);
      
      assertEquals("Welcome to English", learner1.attendLesson(lesson2));
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
   
//      assertEquals("Welcome to Biology", learner1.attendLesson(lesson3));
//      learner2.attendLesson(lesson3);
//      learner3.attendLesson(lesson3);
      learner4.attendLesson(lesson3);
      learner5.attendLesson(lesson3);
      
      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English notes");
      teacher2.teach(lesson3, "lesson3 Biology notes");
      teacher1.teach(lesson4, "lesson4 Maths notes");
      
      Lesson lesson = new Lesson();
   
      assertEquals(2, lesson.getCancelledLessons().size());
      
   }
   
   
}