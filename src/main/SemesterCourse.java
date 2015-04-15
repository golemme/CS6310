package main;

import java.util.List;

public class SemesterCourse {

	public Semester semester;
	public Course course;
	public int capacity;
	public List<Student> scheduledStudents;
	
	public SemesterCourse(){
		
	}
	
	public SemesterCourse(Semester semester, Course course){
		this.semester = semester;
		this.course = course;
		this.capacity = -1;
	}
	
	public SemesterCourse(Semester semester, Course course, int capacity){
		this.semester = semester;
		this.course = course;
		this.capacity = capacity;
	}
	

}
