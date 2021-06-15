package net.school.impl;

import net.school.model.Grade10Learner;
import net.school.model.Learner;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LearnerDaoImplTest {
   private Jdbi jdbi;
   private Grade10LearnerDaoImpl grade10LearnerDao;

   public Jdbi getJdbiDatabaseConnection(String defaultJdbcUrl) throws URISyntaxException, SQLException {
      ProcessBuilder processBuilder = new ProcessBuilder();
      String database_url = processBuilder.environment().get("DATABASE_URL");
      if (database_url != null) {
         URI uri = new URI(database_url);
         String[] hostParts = uri.getUserInfo().split(":");
         String username = hostParts[0];
         String password = hostParts[1];
         String host = uri.getHost();
         int port = uri.getPort();
         String path = uri.getPath();
         String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);
         return Jdbi.create(url, username, password);
      }
      return Jdbi.create(defaultJdbcUrl);
   }

   @BeforeEach
   public void beforeEach() {
      try {
         jdbi = getJdbiDatabaseConnection("jdbc:postgresql://localhost/teachers_learners_lessons_db?user=thando&password=thando123");
         grade10LearnerDao = new Grade10LearnerDaoImpl(jdbi);
      } catch (URISyntaxException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Test
   @Disabled
   @DisplayName("Should register Grade 10 student")
   public void registerLearner() {
      Grade10Learner learner = new Grade10Learner(1L, "Thanduxolo", "Nodwengu", "thando@gmail.com", 10);
      grade10LearnerDao.registerGrade10Learner(learner);
      assertEquals(1, grade10LearnerDao.getAll());
   }

   @Test
   @DisplayName("Should be able to return all learners")
   public void getAllLearners() {
      assertEquals(5, grade10LearnerDao.getAll().size());
   }

   @Test
   @DisplayName("Should Return one learner by id")
   public void getLearnerById() {
      Grade10Learner learner = grade10LearnerDao.getById(4L);
      assertEquals("Nodwengu", learner.getLastName());
   }

   @Test
   @DisplayName("Should Return lessons for the learner")
   public void shouldReturnLearnerLessons() {
      assertEquals(2, grade10LearnerDao.getAllLessons(4L).size());
   }

}