package net.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes {
   private String title;
   private String subject;
   private String source;
   private String notes;
   private Lesson lesson;
   private ArrayList<String> notesList = new ArrayList();
   private ArrayList<Notes> notesArrayList = new ArrayList<>();
   
   
   public Notes(Lesson lesson) {
      this.lesson = lesson;
      this.title = lesson.getTitle();
      this.subject = lesson.getSubject();
      this.source = "Attended";
   }
   
   public void setNotes(String notes) {
      this.notes = notes;
      notesList.add(this.notes);
   }
   
   public void setNotesArrayList(Notes notes) {
      this.notesArrayList.add(notes);
   }
   
   public ArrayList<Notes> getNotesArrayList() {
      return notesArrayList;
   }
   
   //   public void setNotesArrayList(ArrayList<Notes> notesArrayList) {
//      this.notesArrayList = notesArrayList;
//   }
   
   public void setTitle(String title) {
      this.title = title;
   }
   
   public String getTitle() {
      return title;
   }
   
   public void setSource(String source) {
      this.source = source;
   }
   
   public void setLesson(Lesson lesson) {
      this.lesson = lesson;
   }
   
   public Lesson getLesson() {
      return lesson;
   }
   
   public String getSource() {
      return source;
   }
   
   public void setSubject(String subject) {
      this.subject = subject;
   }
   
   public String getSubject() {
      return subject;
   }
   
   public String getNotes() {
      return notes;
   }
   
   public ArrayList<String> getNotesList() {
      return notesList;
   }
   
   public void showNotesList() {
      for (String s: notesList) {
         System.out.print(s);
      }
   }
   
   @Override
   public String toString() {
      return "Notes{" +
              "title='" + title + '\'' +
              ", subject='" + subject + '\'' +
              ", source='" + source + '\'' +
              ", notes='" + notes + '\'' +
              '}';
   }
}
