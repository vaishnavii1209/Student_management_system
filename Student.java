package project7;

import java.util.Objects;

public class Student {
		private int studentId;
		private int rollno;
		private String name;
		private float marks;
		public Student() {
			
			;
		}

		public Student(int studentId, int rollno, String name, float marks) {
			super();
			this.studentId = studentId;
			this.rollno = rollno;
			this.name = name;
			this.marks = marks;
		}

		public Student(int rollno, String name, float marks) {
			
			this.rollno = rollno;
			this.name = name;
			this.marks = marks;
		}
		public int getRollno() {
			return rollno;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getMarks() {
			return marks;
		}
		public void setMarks(float marks) {
			this.marks = marks;
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		void display()
		{
			System.out.println("Rollno:"+rollno+"\tName:"+name+"\tMarks:"+marks);
		}

		@Override
		public int hashCode() {
			return Objects.hash(marks, name, rollno, studentId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Float.floatToIntBits(marks) == Float.floatToIntBits(other.marks) && Objects.equals(name, other.name)
					&& rollno == other.rollno && studentId == other.studentId;
		}


			
		}


