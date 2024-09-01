package project7;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDbmsService {

	static Connection con;
	static Statement sm;
	static PreparedStatement psm;
	static PreparedStatement psm1;
	static String query;
	static ResultSet rs;
	static String connectionUrl="jdbc:mysql://localhost:3306/?", userName="root", password="theROOT@123";
	public StudentDbmsService()
	{
			init();
	}
	public void init()
	{
		// get connection
		try {
			con=DriverManager.getConnection(connectionUrl, userName, password );
			sm=con.createStatement();
//			create database if not exists
			query="create database if not exists college";
			sm.execute(query);
			query="use college";
			sm.execute(query);
			// create table if not exists
			query="create table if not exists student (studentId int primary key auto_increment, rollno int(4), name varchar(40), marks decimal(6,2) )";
			sm.execute(query);
			// Create a preparedStatement object also
			query="insert into student (rollno, name, marks) values (?,?,?)";
			psm=con.prepareStatement(query);
			query="update student set rollno=?, name=?, marks=? where studentId=?";
			psm1=con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Student> findAll()
	{
		ArrayList<Student> stList=new ArrayList<Student>();
		query="select * from student";
		try {
			rs=sm.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int studentId;
		int rollno;
		String name;
		float marks;
		Student st;
		try {
			while(rs.next())
			{
				studentId=rs.getInt("studentId");
				rollno=rs.getInt("rollno");
				name=rs.getString("name");
				marks=rs.getFloat("marks");
				st=new Student(studentId, rollno, name, marks);
				stList.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//while		
		return stList;
	}
	
	boolean add(Student s)
	{
		try {
			psm.setInt(1, s.getRollno() );
			psm.setString(2, s.getName() );
			psm.setFloat(3, s.getMarks() );
			psm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				return false;
		}
		return true; //success
	}
	void remove(Student st)
	{
		query="delete from student where studentId="+st.getStudentId();
		try {
			sm.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void set(Student st)
	{
		try {
			psm1.setInt(1, st.getRollno() );
			psm1.setString(2, st.getName() );
			psm1.setFloat(3, st.getMarks() );
			psm1.setInt(4, st.getStudentId() );
			psm1.execute();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	
}
