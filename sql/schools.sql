CREATE TABLE teacher (
   id SERIAL NOT NULL PRIMARY KEY,
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   email TEXT NOT NULL,
   tokens INT NOT NULL
);

CREATE TABLE learner (
   id SERIAL NOT NULL PRIMARY KEY,
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   email TEXT NOT NULL,
   tokens INT NOT NULL
);

CREATE TABLE subject (
   id SERIAL NOT NULL PRIMARY KEY,
   subject_name TEXT NOT NULL
);

CREATE TABLE teacher_subject (
   id SERIAL NOT NULL PRIMARY KEY,
   teacher_id INT NOT NULL,
   subject_id INT NOT NULL,
   FOREIGN KEY (teacher_id) REFERENCES teacher(id),
   FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE learner_subject (
    id SERIAL NOT NULL PRIMARY KEY,
    learner_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (learner_id) REFERENCES learner(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE lesson (
   id SERIAL NOT NULL PRIMARY KEY,
   subject_id INT NOT NULL,
   lesson_name TEXT NOT NULL,
   time TEXT NOT NULL,
   FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE lesson1 (
   id SERIAL NOT NULL PRIMARY KEY,
   subject_id INT NOT NULL,
   lesson_name TEXT NOT NULL,
   grade_id TEXT NOT NULL,
   day_id TEXT NOT NULL
   time TEXT NOT NULL,
   FOREIGN KEY (subject_id) REFERENCES subject(id)
   FOREIGN KEY (grade_id) REFERENCES grade(id)
   FOREIGN KEY (day_id) REFERENCES day(id)
);

--CREATE TABLE teacher_lesson (
--   id SERIAL NOT NULL PRIMARY KEY,
--   teacher_id INT NOT NULL,
--   lesson_id INT NOT NULL,
--   FOREIGN KEY(teacher_id) REFERENCES teacher(id),
--   FOREIGN KEY(learner_id) REFERENCES lesson(id)
--);

CREATE TABLE learner_lesson_attendant (
   id SERIAL NOT NULL PRIMARY KEY,
   learner_id INT NOT NULL,
   lesson_id INT NOT NULL,
   FOREIGN KEY(learner_id) REFERENCES learner(id),
   FOREIGN KEY(lesson_id) REFERENCES lesson(id)
);

CREATE TABLE notes (
   id SERIAL NOT NULL PRIMARY KEY,
   title TEXT NOT NULL,
   notes TEXT NOT NULL,
   source TEXT NOT NULL,
   lesson_id INT NOT NULL,
   FOREIGN KEY(lesson_id) REFERENCES lesson(id)
);

CREATE TABLE learner_notes (
   id SERIAL NOT NULL PRIMARY KEY,
   learner_id INT NOT NULL,
   notes_id INT NOT NULL,
   FOREIGN KEY(learner_id) REFERENCES learner(id),
   FOREIGN KEY(notes_id) REFERENCES notes(id)
);

SELECT l.first_name, n.title, n.notes, n.source
FROM learner As l
INNER JOIN learner_notes As ln
ON l.id = ln.learner_id
INNER JOIN notes As n
ON ln.notes_id = n.id
WHERE l.id = 42;

SELECT *
FROM learner As l
INNER JOIN learner_lesson_attendant As lla
ON l.id = lla.learner_id
WHERE lla.lesson_id = 6;








INSERT INTO subject(subject_name) VALUES('Mathematics');
INSERT INTO subject(subject_name) VALUES('Biology');
INSERT INTO subject(subject_name) VALUES('English');
INSERT INTO subject(subject_name) VALUES('Geography');
INSERT INTO subject(subject_name) VALUES('Life Science');
INSERT INTO subject(subject_name) VALUES('History');
INSERT INTO subject(subject_name) VALUES('Consumer Studies');
INSERT INTO subject(subject_name) VALUES('Accounting');
INSERT INTO subject(subject_name) VALUES('Economics');

insert into teacher (first_name, last_name, email, tokens) values ('Lindani', 'Pani', 'lindani@email.com', 0);
insert into teacher (first_name, last_name, email, tokens) values ('Simba', 'Dlamini', 'siba@khumalo.com', 0);
insert into teacher (first_name, last_name, email, tokens) values ('Gorge', 'Smith', 'elliott@email.com', 0);
insert into teacher (first_name, last_name, email, tokens) values ('Busiswa', 'Mogale', 'busi@khumalo.com', 0);
insert into teacher (first_name, last_name, email, tokens) values ('John', 'Doe', 'john@email.com', 0);
insert into teacher (first_name, last_name, email, tokens) values ('Chris', 'Ells', 'chris@khumalo.com', 0);


insert into learner (first_name, last_name, email, tokens) values ('Matthew', 'Xhakana', 'matt@gmail.com', 0);
insert into learner (first_name, last_name, email, tokens) values ('James', 'Bond', 'james@gmail.com', 0);
insert into learner (first_name, last_name, email, tokens) values ('Vusi', 'Mava', 'vusi@gmail.com', 0);
insert into learner (first_name, last_name, email, tokens) values ('Thomas', 'Modise', 'thomas@gmail.com', 0);
insert into learner (first_name, last_name, email, tokens) values ('Themba', 'Nodwengu', 'themba@gmail.com', 0);
insert into learner (first_name, last_name, email, tokens) values ('Zintle', 'Xhakana', 'zintle@gmail.com', 0);

INSERT INTO learner_subject (learner_id, subject_id) VALUES (42, 4);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (42, 5);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (42, 6);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (42, 11);

INSERT INTO learner_subject (learner_id, subject_id) VALUES (43, 4);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (43, 5);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (43, 7);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (43, 8);

INSERT INTO learner_subject (learner_id, subject_id) VALUES (44, 6);
INSERT INTO learner_subject (learner_id, subject_id) VALUES (44, 8);


INSERT INTO notes(title, notes, source, lesson_id) VALUES('English notes', 'Reading skills', 'Attended', 7);
INSERT INTO notes(title, notes, source, lesson_id) VALUES('History notes', 'Courses of world war 1: ', 'Attended', 8);
INSERT INTO notes(title, notes, source, lesson_id) VALUES('Life Science notes', 'Chemistry: test test test', 'Attended', 9);
INSERT INTO notes(title, notes, source, lesson_id) VALUES('Maths notes', 'Geometry notes', 'Attended', 10);

SELECT *
FROM learner As l
INNER JOIN learner_subject As ls
ON l.id = ls.learner_id
INNER JOIN subject As s
ON ls.subject_id = s.id
WHERE l.id = 41;

SELECT *
FROM learner As l
INNER JOIN learner_ As ls
ON l.id = ls.learner_id
INNER JOIN subject As s
ON ls.subject_id = s.id
WHERE l.id = 41;




id | first_name | last_name |       email       | tokens
----+------------+-----------+-------------------+--------
 18 | Thomas     | Khumalo   | thomas@gmail.com  |     20
 25 | Lindani    | Pani      | lindani@email.com |      0
 26 | Simba      | Dlamini   | siba@khumalo.com  |      0
 27 | Gorge      | Smith     | elliott@email.com |      0
 28 | Busiswa    | Mogale    | busi@khumalo.com  |      0
 29 | John       | Doe       | john@email.com    |      0
 30 | Chris      | Ells      | chris@khumalo.com |      0

id |   subject_name
----+------------------
  3 | Mathematics
  4 | Biology
  5 | English
  6 | Geography
  7 | Life Science
  8 | History
  9 | Consumer Studies
 10 | Accounting
 11 | Economics

INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(18, 3);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(25, 4);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(26, 5);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(27, 6);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(28, 7);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(29, 8);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(30, 9);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(18, 10);
INSERT INTO teacher_subject(teacher_id, subject_id) VALUES(26, 11);


INSERT INTO lesson (lesson_name, time, subject_id) VALUES ('Algebra', '08:30', 3);
INSERT INTO lesson (lesson_name, time, subject_id) VALUES ('Reading skills', '09:30', 5);
INSERT INTO lesson (lesson_name, time, subject_id) VALUES ('World war', '10:30', 8);
INSERT INTO lesson (lesson_name, time, subject_id) VALUES ('Chemistry', '11:30', 7);

INSERT INTO lesson (lesson_name, time, subject_id) VALUES ('Geometry', '12:30', 3);

SELECT *
FROM lesson As l
INNER JOIN subject As s
ON l.subject_id = s.id
INNER JOIN teacher_subject As ts
ON s.id = ts.subject_id
INNER JOIN teacher As t
ON ts.teacher_id = t.id
WHERE t.id = 18;

SELECT *
FROM teacher As t
INNER JOIN teacher_subject As ts
ON t.id = ts.teacher_id
INNER JOIN subject As s
ON ts.subject_id = s.id
INNER JOIN lesson As l
ON l.subject_id = s.id
WHERE t.id = 18;



SELECT s.id s_id, s.subject_name, l.id l_id,
l.lesson_name, l.time, l.subject_id l_subj_id
FROM subject As s
INNER JOIN lesson As l
ON s.id = l.subject_id;


SELECT s.id, s.subject_name, l.id, l.lesson_name, l.time, l.subject_id
FROM subject s  +
INNER JOIN lesson l
ON s.id = l.subject_id

SELECT *
FROM learner As ln
INNER JOIN learner_subject As ls
ON ls.learner_id = ln.id
INNER JOIN subject As s
ON s.id = ls.subject_id
WHERE ln.id = 42;

SELECT ln.first_name, s.subject_name, t.first_name, l.lesson_name
FROM learner As ln
INNER JOIN learner_subject As ls
ON ls.learner_id = ln.id
INNER JOIN subject As s
ON s.id = ls.subject_id
INNER JOIN teacher_subject As ts
ON s.id = ts.subject_id
INNER JOIN teacher As t
ON ts.teacher_id = t.id
INNER JOIN lesson As l
ON s.id = l.subject_id
WHERE ln.id = 42;

--DELETE LEARNER SUBJECT BY ID
DELETE FROM learner_subject WHERE subject_id = 8;

--GET SUBJECT BY LESSON ID (FOR A LESSON)
SELECT *
FROM subject As s
INNER JOIN lesson As l
ON s.id = l.subject_id
WHERE l.id = 7;




id | first_name | last_name |      email      | tokens | id | learner_id | subject_id | id | subject_name
----+------------+-----------+-----------------+--------+----+------------+------------+----+--------------
 42 | Buli       | Nodwengu  | buli@gmail.com  |     10 |  1 |         42 |          4 |  4 | Biology
 42 | Buli       | Nodwengu  | buli@gmail.com  |     10 |  2 |         42 |          5 |  5 | English
 42 | Buli       | Nodwengu  | buli@gmail.com  |     10 |  3 |         42 |          6 |  6 | Geography
 42 | Buli       | Nodwengu  | buli@gmail.com  |     10 |  4 |         42 |         11 | 11 | Economics
 43 | Matthew    | Xhakana   | matt@gmail.com  |      0 |  5 |         43 |          4 |  4 | Biology
 43 | Matthew    | Xhakana   | matt@gmail.com  |      0 |  6 |         43 |          5 |  5 | English
 43 | Matthew    | Xhakana   | matt@gmail.com  |      0 |  7 |         43 |          7 |  7 | Life Science
 43 | Matthew    | Xhakana   | matt@gmail.com  |      0 |  8 |         43 |          8 |  8 | History
 44 | James      | Bond      | james@gmail.com |      0 |  9 |         44 |          6 |  6 | Geography
 44 | James      | Bond      | james@gmail.com |      0 | 10 |         44 |          8 |  8 | History
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 11 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 12 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 13 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 14 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 15 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 16 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 17 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 18 |         45 |         10 | 10 | Accounting
 45 | Vusi       | Mava      | vusi@gmail.com  |      0 | 19 |         45 |         10 | 10 | Accounting


--CREATE GRADE 10 STUDENT TABLE AND ADD 5 LEARNERS
CREATE TABLE grade10_learner (
   id SERIAL NOT NULL PRIMARY KEY,
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   email TEXT NOT NULL,
   tokens INT NOT NULL
);

CREATE TABLE grade10learner_subject (
    id SERIAL NOT NULL PRIMARY KEY,
    learner_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (learner_id) REFERENCES grade10_learner(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE day (
    id SERIAL NOT NULL PRIMARY KEY,
    day_name TEXT NOT NULL,
);

CREATE TABLE grade (
    id SERIAL NOT NULL PRIMARY KEY,
    grade_name TEXT NOT NULL,
);
INSERT INTO grade (grade_name) VALUES ('GRADE10');
INSERT INTO grade (grade_name) VALUES ('GRADE11');
INSERT INTO grade (grade_name) VALUES ('GRADE12');

INSERT INTO day (day_name) VALUES ('Monday');
INSERT INTO day (day_name) VALUES ('Tuesday');
INSERT INTO day (day_name) VALUES ('Wednesday');
INSERT INTO day (day_name) VALUES ('Thursday');
INSERT INTO day (day_name) VALUES ('Friday');





