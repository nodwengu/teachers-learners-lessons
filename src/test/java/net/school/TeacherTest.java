package net.school;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
   private Lesson lesson1 = new Lesson("Xesha", LocalTime.now(), "Maths", "Algebra");
   private Lesson lesson2 = new Lesson("James", LocalTime.now(), "English", "Vocabulary");
   private Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.now(), "Biology", "Biotechonology");
   private Lesson lesson4 = new Lesson("Stone", LocalTime.now(), "Accounting", "Accounting basics");
   private Lesson lesson5 = new Lesson("Mtsotsoyi", LocalTime.now(), "Xhosa", "Ufundo ncwadi");
   private Lesson lesson6 = new Lesson("Bush", LocalTime.now(), "Economics", "Economics basics");
   private Lesson lesson7 = new Lesson("Mazibuko", LocalTime.now(), "History", "Causes of World War");

   @Test
   public void shouldBeAbleToTeachALesson() {
      Teacher teacher1 = new Teacher("Thomas", "Modirharhe", "thomas@gmail");
      teacher1.setQualification("Maths");

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

      learner2.registerForSubject("Accounting"); //lesson 4
      learner2.registerForSubject("Maths");
      learner2.registerForSubject("English");

      learner3.registerForSubject("Maths");
      learner3.registerForSubject("English");
      learner3.registerForSubject("Biology");

      learner4.registerForSubject("Accounting"); //lesson 4
      learner4.registerForSubject("Maths");
      learner4.registerForSubject("English");

      learner5.registerForSubject("Maths");
      learner5.registerForSubject("English");
      learner5.registerForSubject("Biology");

      learner6.registerForSubject("Accounting"); //lesson 4
      learner6.registerForSubject("Maths");
      learner6.registerForSubject("English");

      // Students that will attend
      learner1.attendLesson(lesson1);
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);
   
      teacher1.teach(lesson1, "lesson1 Mathematics notes");

      learner1.attendLesson(lesson2);
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      
      teacher1.setQualification("English");
      teacher1.teach(lesson2, "lesson2 English note");

      assertEquals(10, teacher1.getTokens());

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

   }

}