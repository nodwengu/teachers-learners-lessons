package net.school.model;

import java.util.ArrayList;
import java.util.List;

public class Learner extends Person {
//   private List<TeacherSubject> teacherSubjects = new ArrayList<>();
   private List<LearnerSubject> learnerSubjects = new ArrayList<>();
   private List<Subject> subjects = new ArrayList<>();
   private List<LearnerLessonAttendant> learnersFor = new ArrayList<>();

   public Learner(){}

   public Learner(Long id, String first_name, String last_name, String email, int tokens) {
      super(id, first_name, last_name, email, tokens);
   }

   public void addSubject(Subject subject) {
      subjects.add(subject);
   }
   public void addLearnerSubject(LearnerSubject subject) {
      learnerSubjects.add(subject);
   }
   public List<Subject> getSubjects() {
      return subjects;
   }

   public void addLearnerFor(LearnerLessonAttendant learner) {
      learnersFor.add(learner);
   }
   public List<LearnerLessonAttendant> getLearnerFor() {
      return learnersFor;
   }

   @Override
   public String toString() {
      return "Learner{" +
              "id=" + this.getId() +
              ", firstName='" + getFirstName() + '\'' +
              ", lastName='" + getLastName() + '\'' +
              ", email='" + getEmail() + '\'' +
              ", tokens=" + getTokens() + '\'' +
              ", subjects=" + subjects +
              '}';
   }
}