package net.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Teacher extends Person {
   private int tokens;
   private int noOfLessonTaught;
   private String qualification;
   
   private ArrayList<String> qualifications = new ArrayList<>();
   private ArrayList<Lesson> lessonsTaught = new ArrayList<>();
   
   public Teacher() {}
   
   public Teacher(String firstName, String lastName, String email) {
      super(firstName, lastName, email);
   }
   
   public String teach(Lesson lesson, String theNotes) {
      String msg = null;
      
      if (qualifications.contains(lesson.getSubject())) {
         if (lesson.getNoOfLearners() >= 4) {
            lessonsTaught.add(lesson);
            tokens = tokens + 5;
            this.updateNoOfLessonTaught();
            msg = lesson.getSubject() + " lesson has enough learners";
            lesson.setNotes(theNotes);
            lesson.getLessonMap().put(lesson.getTitle(), lesson);
            
         } else {
            //System.out.println(lesson.cancelLesson());
            //msg = "Learners must be 4 0r more";
            msg = lesson.cancelLesson(lesson);
         }
      } else {
         msg = "Teacher must be qualified to teach " + lesson.getSubject();
      }
      return msg;
   }
   
   public ArrayList<Lesson> getLessonsTaught() {
      return lessonsTaught;
   }
   
   public void updateNoOfLessonTaught() {
      this.noOfLessonTaught++;
   }
   
   public void setQualification(String subject) {
      this.qualification = subject;
      this.qualifications.add(subject);
   }
   
   public void buyBreakfast() {
      if (tokens >= 4) {
         if (noOfLessonTaught >= 5) {
            System.out.println("YOU DESERVE DISCOUNT OF 25%");
            int discount = 4 * 25 / 100;
            tokens -= (4 - discount);
         } else {
            tokens -= 4;
         }
      }
   }
   
   public void buyLunch() {
      if (tokens >= 6) {
         if (noOfLessonTaught >= 5) {
            System.out.println("YOU DESERVE DISCOUNT OF 25%");
            int discount = 6 * 25 / 100;
            tokens -= (6 - discount);
         } else {
            tokens -= 6;
         }
      }
   }
   
   public void buyAfternoonSnack() {
      if (tokens >= 3) {
         if (noOfLessonTaught >= 5) {
            System.out.println("YOU DESERVE DISCOUNT OF 25%");
            int discount = 3 * 25 / 100;
            tokens -= (3 - discount);
         } else {
            tokens -= 3;
         }
      }
   }
   
   public void buyDrink() {
      if (tokens >= 2) {
         if (noOfLessonTaught >= 5) {
            System.out.println("YOU DESERVE DISCOUNT OF 25%");
            int discount = 2 * 25 / 100;
            tokens -= (2 - discount);
         } else {
            tokens -= 2;
         }
      }
   }
   
   public ArrayList<String> getQualifications() {
      return qualifications;
   }
   
   public String getQualification() {
      return qualification;
   }
   
   public int getTokens() {
      return tokens;
   }
   
   @Override
   public void talk() {
      System.out.println("Teacher speaking");
   }
}
