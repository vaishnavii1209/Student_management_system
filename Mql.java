package project7;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Insert data into student table
		/*
		 * DriverManager
Connection
Statement
ResultSet
		 * */
		Connection con;
		Statement sm;
		String query;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/?", "root", "theROOT@123");
			System.out.println(con);
			sm=con.createStatement();
			// create database college
			query="create database if not exists players";
			sm.execute(query);
			// create table student
			query="use players";
			sm.execute(query);
			query="create table if not exists bowler(\r\n"
					+ "id int(4) primary key auto_increment,\r\n"
					+ "name varchar(40),\r\n"
					+ "overs int(10),\r\n"
					+ "runs int(8),\r\n"
					+ "wickets int(20)\r\n"
					+ ")";
			sm.execute(query);
			
			System.out.println("How many bowlers");
			int n= Integer.parseInt(br.readLine());
			String name;
			int overs,runs,wickets;
			for (int i = 0; i < n; i++) 
			{
				System.out.println("Bowler No. "+(i+1));
				System.out.print("Name:");
				name=br.readLine();
				System.out.print("Overs:");
				overs=Integer.parseInt(br.readLine());
				System.out.print("Runs:");
				runs=Integer.parseInt(br.readLine());
				System.out.print("Wickets:");
				wickets=Integer.parseInt(br.readLine());
				query="insert into bowler (name,overs,runs,wickets) values ('"+name+"',"+ overs+","+ runs+","+ wickets+")";
				sm.execute(query);	
//				query="select name,runs from bowler order by name asc";
//				sm.execute(query);	
//				query="select name from bowler where overs=10";
//				sm.execute(query);	
//				query="select name from bowler where overs=0";
//				sm.execute(query);	
//				query="update bowler set overs=8,runs=48,wickets=2 where name='hf'";
//				sm.execute(query);	
			}//for
			
			// insert data
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

