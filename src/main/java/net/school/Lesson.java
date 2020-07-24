package net.school;

import java.time.LocalTime;
import java.util.*;

public class Lesson implements Notes1{
   private String teacher;
   private LocalTime time;
   private String subject;
   private String title;
   private Lesson lesson;
   
   private String myNotes;
   
   private int noOfLearners;
   private String notes;
   //private ArrayList<String> lesonNotesList = new ArrayList<>();
   
   //private Map<String, String> notesListMap = new HashMap<>();
   private Map<String, String> lessonNotesMap = new HashMap<>();
   
   static ArrayList<Map<String, String>> notesForSubject = new ArrayList<>();
   
   private Map<String, Learner> learnersMap = new HashMap<>();
   private static Map<String, Lesson> lessonMap = new HashMap<>();
   private static List<Lesson> cancelledLessons = new ArrayList<>();
   
   public Map<String, Lesson> lessonsForSubject;
   
   private static int noOfCancelledLessons;
   
   public Lesson(){}
   
   public Lesson(String teacher, LocalTime time, String subject, String title) {
      this.teacher = teacher;
      this.time = time;
      this.subject = subject;
      this.title = title;
   }
   
   public void setNotes(String notes) {
      this.myNotes = notes;
      this.notes = "Subject-" + this.subject + ", Time-" + this.time + ", Source-" + Sources.ATTENDED + ", Notes-" + notes;
      this.addNotes(lessonNotesMap, this.notes);
      
   }
   
//   public Map<String, String> getNotesListMap() {
//      return lessonNotesMap;
//   }
//
   
   
   public void setLesson(Lesson lesson) {
      this.lesson = lesson;
   }
   
   public Lesson getLesson() {
      return lesson;
   }
   
   public Map<String, Lesson> getLessonMap() {
      return lessonMap;
   }
   
   public String getNotes() {
      return notes;
   }
   
   public String getMyNotes() {
      return myNotes;
   }
   
   @Override
   public void addNotes(Map<String, String> notes, String notesString) {
//      lesonNotesList.add(this.getNotes());
      lessonNotesMap.put(this.getSubject(), this.getNotes());
      
      notes.put(this.title, this.getNotes());
      //notesListMap.put(this.title, this.getNotes());
      notesForSubject.add(notes);
      setLearnerNotes();
   }
   
   public void setLearnerNotes() {
      for (Map.Entry<String, Learner> item: learnersMap.entrySet()) {
         item.getValue().getNotesMap().put(this.getTitle(), this.getNotes());
         item.getValue().getNotesList().add(this.getNotes());
      }
   }
   
   public ArrayList<Map<String, String>> getNotesForSubject() {
      return notesForSubject;
   }
   
   public Map<String, Lesson> getLessonsFor(String subject) {
      Map<String, Lesson> lessonsFor = new HashMap<>();
      Set<Map.Entry<String, Lesson> > lessonsSet = getLessonMap().entrySet();
      Lesson lesson1 = null;
   
      for (Map.Entry<String, Lesson> item: lessonsSet) {
         lesson1 = item.getValue();
         
         if (lesson1.getSubject().equals(subject)) {
            lessonsFor.put(lesson1.getTitle(), lesson1);
         }
      }
      return lessonsFor;
   }
   
   public Map<String, String> getNotSubject(String subject) {
      Map<String, String> subjectNotes = new HashMap<>();
      
      Set<Map.Entry<String, String> > entrySet;
   
      for (int x = 0; x < getNotesForSubject().size(); x++) {
         entrySet = getNotesForSubject().get(x).entrySet();
      
         for (Map.Entry<String, String> item: entrySet) {
            
            if (item.getKey().equals(subject)) {
               subjectNotes.put(this.getSubject(), item.getValue());
               System.out.print(item.getKey() + ": ");
               System.out.println(item.getValue());
            }
         }
      }
      return subjectNotes;
   }
   
//   public Map<String, Map<String, String>> getNotesForSubject() {
//      return notesForSubject;
//   }

   public Map<String, String> getLessonNotesMap() {
      return lessonNotesMap;
   }
   
//   public ArrayList<String> getLesonNotesList() {
//      return lesonNotesList;
//   }
   
   
   public String cancelLesson(Lesson lesson) {
      String msg = "Cancelling " + getTitle();
      for (Map.Entry<String, Learner> entry: learnersMap.entrySet()) {
         entry.getValue().setTokens();
      }
      cancelledLessons.add(lesson);
//      noOfCancelledLessons++;
//      System.out.println("Cancelled lessons: " + cancelledLessons);
      
      return msg;
   }
   
   public List<Lesson> getCancelledLessons() {
      return cancelledLessons;
   }
   
   public int getNoOfCancelledLessons() {
      return noOfCancelledLessons;
   }
   
   public void setTeacher(String teacher) {
      this.teacher = teacher;
   }
   
   public void setTime(LocalTime time) {
      this.time = time;
   }
   
   public void setSubject(String subject) {
      this.subject = subject;
   }
   
   public void setNoOfStudents() {
//      learnersMap.put(learner.getEmail(), learner);
      this.noOfLearners++;
   }
   
   public String getTeacher() {
      return teacher;
   }
   
   public LocalTime getTime() {
      return time;
   }
   
   public String getSubject() {
      return subject;
   }
   
   public int getNoOfLearners() {
      return noOfLearners;
   }
   
   public String getTitle() {
      return title;
   }
   
   public Map<String, Learner> getLearners() {
      return learnersMap;
   }
}
