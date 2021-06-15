package net.school.dao;

import net.school.model.Grade10Learner;
import net.school.model.Learner;
import net.school.model.Lesson;

import java.util.List;

public interface LearnerDao {
   boolean registerGrade10Learner(Grade10Learner learner);
   List<Grade10Learner> getAll();
   Grade10Learner getById(Long id);
   void selectSubject(Long learnerId, Long subjectId);
   List<Grade10Learner> getLearnerSubjects(Long myId);
   List<Lesson> getAllLessons(Long theId);
   boolean attendLesson(Long learnerId, Long lessonId);

}
