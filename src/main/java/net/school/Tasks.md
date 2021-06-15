#####1. Create Maven project
#####2. Install plugins and dependencies

1. Maven plugins
2. Heroku maven plugin
3. Jupiter-api
4. Jupiter-Engine
5. Spark-Java
6. Spark-template-handdlebars
7. Jdbi
8. PostgreSql

#####3. Design and Create database tables
1. teacher
2. subject
3. teacher_subject
4. learner
5. learner_subject
6. lesson
7. learner_lesson
8. teacher_lesson
9. notes
10. learner_notes

#####3. Set up Test Classes and database

#####4. Create and Test addTeacher method
1. Create TeacherService class
2. Import Jdbi class and Add instance variable of type Jdbi
3. Create a constructor that accept variable of type Jdbi
4. Update instance variable with variable passed in the constructor
5. Create addTeacher method that accept 1 parameter of type Teacher
6. Call Jdbi useHandle method to obtain a Handle instance
7. Call execute method on the handle instance and pass the SQL string and the arguments
8. Create TeacherServiceTest class under tests

#####5. Create and Test getAll method
1. Create getAll method that returns a list of all teachers
2. Call Jdbi withHandle method to obtain a Handle instance
3. Call createQuery method on the handle instance and pass the SQL string

#####6. Create and Test deleteById method
1. Create deleteById that takes id as int parameter
2. Call Jdbi useHandle method to obtain a Handle instance
3. Call execute method on the handle instance and pass the SQL string and id as argument

#####7. Create and Test getById method
1. Create getById that accept id as int parameter
2. Call Jdbi withHandle method to obtain a Handle instance
3. Call createQuery method on the handle instance and pass the SQL string and id as argument


#####8. Create and Test addLesson method
1. Create LessonService class
2. Import Jdbi class and Add instance variable of type Jdbi
3. Create a constructor that accept variable of type Jdbi
4. Update instance variable with variable passed in the constructor
5. Create addLesson method that accept 1 parameter of type Lesson
6. Call Jdbi useHandle method to obtain a Handle instance
7. Call execute method on the handle instance and pass the SQL string and the arguments
8. Create LessonServiceTest class under tests and test addLesson method


#####9. Create and Test lessonsFor method
1. Create lessonsFor method that accept id as int parameter type
2. Call Jdbi useHandle method to obtain a Handle instance
3. Call createQuery method on the handle instance and pass the SQL string and the id arguments
4. Test the method

#####10. Create and Test getNotesFrom method
1. Create getNotesFrom method that accept learner_id for the learner who is asking and notes_id
2. Call Jdbi useHandle method to obtain a Handle instance
3. Call execute method on the handle instance and pass the SQL string and the id arguments
4. Test the method


#####11. Create teacher page
1. Create App class
2. Add the following imports
    import spark.ModelAndView;
    import spark.template.handlebars.HandlebarsTemplateEngine;
    import java.net.URI;
    import java.net.URISyntaxException;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.Map;
    import static spark.Spark.*;
3. Inside main add static files from public folder
4. Create home route 

#####12. Create learner page