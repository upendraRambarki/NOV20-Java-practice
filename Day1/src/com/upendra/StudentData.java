package com.upendra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentData implements Comparable<StudentData> {

	
		public int studentId;
		public String studentName;
	 
		public StudentData(int studentId, String studentName) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
		}
	 
		public int getStudentId() {
			return studentId;
		}
	 
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
	 
		public String getStudentName() {
			return studentName;
		}
	 
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
	 
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
		}
	 
		@Override
		public int compareTo(StudentData that) {
	 
			return Integer.compare(this.studentId, that.studentId);
		}
	 	
		public static void main(String[] args) {
			List<StudentData> students = new ArrayList<>(
					List.of(new StudentData(5, "ranga"), new StudentData(2, "gopi")));
			List<StudentData> StudentDatas = new ArrayList<>(students);
			System.out.println(StudentDatas);
			Collections.sort(StudentDatas);
			System.out.println(StudentDatas);
		}
	 
	

}
