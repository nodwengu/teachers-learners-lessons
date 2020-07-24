package net.school;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {
   private Lesson lesson1 = new Lesson("Xesha", LocalTime.now(), "Maths", "Algebra");
   private Lesson lesson2 = new Lesson("James", LocalTime.now(), "English", "Vocabulary");
   private Lesson lesson3 = new Lesson("Mahlangeni", LocalTime.now(), "Biology", "Biotechonology");

   @Test
   public void shouldReturnTotalTokensReceived() {
      Cafeteria cafeteria = new Cafeteria();
      Teacher teacher1 = new Teacher("Thomas", "Modirharhe", "thomas@gmail");
      Teacher teacher2 = new Teacher("Zanele", "Buthelezi", "thomas@gmail");
      teacher1.setQualification("Maths");
      teacher1.setQualification("English");

      Learner learner1 = new Learner("thando", "nodwengu", "thando@gmail");
      Learner learner2 = new Learner("bob", "Van Tonder", "bob@gmail");
      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");

      // Registering Learners
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

      // Students attend lesson1
      learner1.attendLesson(lesson1);
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);

      // Students attend lesson2
      learner1.attendLesson(lesson2);
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
      learner6.attendLesson(lesson2);

      teacher1.teach(lesson1, "lesson1 Mathematics notes");
      teacher1.teach(lesson2, "lesson2 English notes");

      assertEquals(10, teacher1.getTokens());
      assertEquals(6, learner1.getTokens());
      assertEquals(6, learner2.getTokens());
      assertEquals(6, learner3.getTokens());
      assertEquals(6, learner4.getTokens());
      assertEquals(3, learner5.getTokens());
      assertEquals(3, learner6.getTokens());

      cafeteria.sellBreakFast(learner1);
      cafeteria.sellBreakFast(learner2);
      cafeteria.sellBreakFast(learner3);
      cafeteria.sellBreakFast(learner4);
      cafeteria.sellDrink(learner5);
      cafeteria.sellLunch(teacher1);
      cafeteria.sellDrink(teacher1);

      assertEquals(26, cafeteria.getTotalDailyTokens());
   }

   @Test
   public void shouldReturnAllSales() {
      Cafeteria cafeteria = new Cafeteria();

      Learner learner1 = new Learner("James", "Smith", "james@gmail");
      Learner learner2 = new Learner("Bob", "Marley", "bob@gmail");
      Learner learner3 = new Learner("vuyo", "bathembu", "vuyo@gmail");
      Learner learner4 = new Learner("mark", "albert", "mark@gmail");
      Learner learner5 = new Learner("jola", "xhakana", "jola@gmail");
      Learner learner6 = new Learner("xola", "mavuso", "xola@gmail");

      Teacher teacher1 = new Teacher("Thomas", "Modirharhe", "thomas@gmail");
      Teacher teacher2 = new Teacher("Zanele", "Buthelezi", "thomas@gmail");

      teacher2.setQualification("Maths");
      teacher2.setQualification("English");

      // Registering Learners
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


      // Students attend lesson1
      learner1.attendLesson(lesson1);
      learner2.attendLesson(lesson1);
      learner3.attendLesson(lesson1);
      learner4.attendLesson(lesson1);

      // Students attend lesson2
      learner1.attendLesson(lesson2);
      learner2.attendLesson(lesson2);
      learner3.attendLesson(lesson2);
      learner4.attendLesson(lesson2);
      learner5.attendLesson(lesson2);
      learner6.attendLesson(lesson2);

      teacher2.teach(lesson1, "lesson1 Mathematics notes");
      teacher2.teach(lesson2, "lesson2 English notes");

      assertEquals(10, teacher2.getTokens());
      assertEquals(6, learner1.getTokens());
      assertEquals(6, learner2.getTokens());
      assertEquals(6, learner3.getTokens());
      assertEquals(6, learner4.getTokens());
      assertEquals(3, learner5.getTokens());
      assertEquals(3, learner6.getTokens());

      cafeteria.sellBreakFast(learner1);
      cafeteria.sellBreakFast(learner2);
      cafeteria.sellBreakFast(learner3);
      cafeteria.sellBreakFast(learner4);
      cafeteria.sellBreakFast(learner5);  // Tokens < 4
      cafeteria.sellLunch(teacher2);
      cafeteria.sellDrink(teacher2);
      
      assertEquals(24, cafeteria.getTotalDailyTokens());
      assertEquals(6, cafeteria.getSales().size());

      //cafeteria.showSales();
   }

}