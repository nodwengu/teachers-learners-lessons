package net.school;

public class Notes {
   private String title;
   private String notes;
   private String source;
   private int lesson;

   public Notes(){}

   public Notes(String title, String notes, String source, int lesson) {
     this.title = title;
     this.notes = notes;
     this.source = source;
     this.lesson = lesson;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setNotes(String notes) {
      this.notes = notes;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public void setLesson(int lesson) {
      this.lesson = lesson;
   }

   public int getLesson() {
      return lesson;
   }

   public String getTitle() {
      return title;
   }

   public String getNotes() {
      return notes;
   }

   public String getSource() {
      return source;
   }
}
