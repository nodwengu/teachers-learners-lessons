package net.school;

import java.util.*;

public class Learner extends Person {
   private int tokens;
   private List<String> subjects = new ArrayList<String>();
   private Map<String, String> subjectsMap = new HashMap<>();
   private List<String> notesList = new ArrayList<>();
   private Map<String, String> notesMap = new HashMap<>();
   private Learner learner;
   
   public Learner(){}
   
   public Learner(String firstName, String lastName, String email) {
      super(firstName, lastName, email);
   }
   
   public void registerForSubject(String subject) {
      for (Subject item: Subject.values()) {
         if (item.toString() == subject) {
            subjects.add(subject);
            subjectsMap.put(this.getEmail(), subject);
            break;
         }
      }
   }
   
   public String attendLesson(Lesson lesson) {
      String welcomeMsg = null;
      
      if (subjects.size() >= 3) {
         if (subjects.contains(lesson.getSubject())) {
            welcomeMsg = "Welcome to " + lesson.getSubject();
            tokens += 3;
            lesson.setNoOfStudents();
            setLearner(this);
            lesson.getLearners().put(this.getLearner().getEmail(), learner);
         } else {
            welcomeMsg = "You are not registered for this subject";
         }
      } else {
         welcomeMsg = "Need to be registered for 3 or MORE subjects";
      }
      
      return welcomeMsg;
   }
   
   public void setLearner(Learner learner) {
      this.learner = learner;
   }
   
   public Learner getLearner() {
      return learner;
   }
   
   public void getNotesFromOthers(Lesson lesson, Learner learner) {
      if (this.subjects.size() < 3)
         return;
      
      if (tokens < 2)
         return;
      
      if ( learner.getSubjects().contains(lesson.getSubject()) ) {
         if (learner.getNotesMap().containsKey(lesson.getTitle())) {
            String notesString = "Subject-" + lesson.getSubject() + ", Time-" + lesson.getTime() + ", Source-" + Sources.BOUGHT + ", Notes-" + lesson.getMyNotes();
            notesMap.put(lesson.getTitle(), notesString);
            tokens -= 2;
            learner.addTokens(2);
         } else {
            System.out.println(learner.getFirstName() + " DOES NOT HAVE NOTES FOR THE LESSON " + lesson.getTitle());
         }
      } else {
         System.out.println(learner.getFirstName() + "NOT REGISTERED" + lesson.getSubject());
      }
   }
   
   public String getNotesFor(Lesson lesson) {
      return notesMap.get(lesson.getTitle());
   }
   
   public void getNotesAndTokens() {
      System.out.println("====================================================================");
      System.out.println("Notes and Token for: " + getFirstName() + " " + getLastName());
      System.out.println("====================================================================");

      if (notesList.size() > 0) {
         for (String note: notesList) {
            System.out.println(note);
         }
      } else {
         System.out.println(getFirstName() + " " + getLastName() + " has NO notes yet");
      }
      System.out.println("Tokens: " + tokens);
      System.out.println("===================================================================");
   }
   
   public Map<String, String> getNotesMap() {
      return notesMap;
   }
   
   public List<String> getNotesList() {
      return notesList;
   }
   
   public String showNotes() {
      String notesList = "";
      
      for (int i = 0; i < this.notesList.size(); i++) {
         notesList += this.notesList.get(i) + ", ";
      }
      return notesList;
   }
   
   public void addTokens(int tokens) {
      this.tokens += tokens;
   }
   
   public void buyBreakfast() {
      if (tokens >= 4)
         tokens -= 4;
   }
   
   public void buyLunch() {
      if (tokens >= 6)
         tokens -= 6;
   }
   
   public void buyAfternoonSnack() {
      if (tokens >= 3)
         tokens -= 3;
   }
   
   public void buyDrink() {
      if (tokens >= 2)
         tokens -= 2;
   }
   
   public void setTokens() {
      tokens = tokens - 3;
   }
   
   public int getTokens() {
      return tokens;
   }
   
   public List<String> getSubjects() {
      return subjects;
   }
   
   public Map<String, String> getSubjectsMap() {
      return subjectsMap;
   }
   
   @Override
   public String toString() {
      return "Learner{" +
              "Name=" + getFirstName() +
              //"tokens=" + tokens +
             // ", subjects=" + subjects +
              //", notesArrayList=" + notesArrayList +
              ", notesMap=" + notesMap +
             // ", allNotes=" + allNotes +
              '}';
   }
   
   
   @Override
   public void talk() {
      System.out.println("Learner speaking");
   }
}