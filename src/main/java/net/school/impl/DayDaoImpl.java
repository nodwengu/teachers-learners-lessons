package net.school.impl;

import net.school.dao.DayDao;
import net.school.model.Day;
import org.jdbi.v3.core.Jdbi;

import javax.sql.rowset.JdbcRowSet;
import java.util.List;

public class DayDaoImpl implements DayDao {
   private Jdbi jdbi;

   public DayDaoImpl(Jdbi jdbi) {
      this.jdbi = jdbi;
   }

   @Override
   public List<Day> getAll() {
      return jdbi.withHandle(handle -> handle.createQuery("SELECT id, day_name FROM day")
         .mapToBean(Day.class)
         .list() );
   }

   @Override
   public Day getById(Long id) {
      return jdbi.withHandle(handle -> handle.createQuery("SELECT id, day_name FROM day WHERE id = :id"))
              .bind("id", id)
              .mapToBean(Day.class)
              .findOnly();
   }
}
