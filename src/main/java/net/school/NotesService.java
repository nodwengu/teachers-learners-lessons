package net.school;

import org.jdbi.v3.core.Jdbi;
import java.util.List;

public class NotesService {
   private Jdbi jdbi;

   public NotesService(Jdbi jdbi) {
      this.jdbi = jdbi;
   }

   public boolean addNotes(Notes notes) {
      jdbi.useHandle( handle -> handle.execute("INSERT INTO notes(title, notes, source, lesson_id) VALUES(?,?,?,?)",
              notes.getTitle(),
              notes.getNotes(),
              notes.getSource(),
              notes.getLesson() )
      );
      System.out.println("ADDED NEW NOTES");
      return true;
   }

   public List<Notes> getAll() {
      return jdbi.withHandle( handle -> handle.createQuery("SELECT id, title, notes, source, lesson_id FROM notes")
              .mapToBean(Notes.class)
              .list()
      );
   }

   public boolean giveNotes(int learner_id, int notes_id) {
      jdbi.useHandle( handle -> handle.execute("INSERT INTO learner_notes(learner_id, notes_id) VALUES(?, ?)",
              learner_id, notes_id )
      );
      System.out.println("GIVEN NOTES");
      return true;
   }
}
