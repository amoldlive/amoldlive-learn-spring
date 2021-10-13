package com.data.dao.entitymanager;

import com.data.entity.Student;

public interface IStudentRepository {
	
	public void save(Student student);
	public void update(Student student,Long studentId);
	public Student get(Long studentId);
	public void delete(Long studentId);
	
}
