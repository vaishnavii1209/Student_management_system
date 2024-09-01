package project7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentConsole {

	StudentDB sdb;
	
	StudentConsole()
	{
		sdb= new StudentDB();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int menu() throws NumberFormatException, IOException
	{
		System.out.println("1---> Add a student");
		System.out.println("2---> Display all students");
		System.out.println("3---> Search a student by name");
		System.out.println("4---> How many passed/failed");
		System.out.println("5---> Delete a student");
		System.out.println("6---> Edit a student");
		System.out.println("7---> End of program");
		System.out.println("\t\tEnter your choice");
		int choice=Integer.parseInt(br.readLine());
		return choice;
	}
	
	void start() throws NumberFormatException, IOException
	{
		int choice;
		int rollno;
		String name;
		float marks;
		Student st;
		String target;
		int rno,c1,c2, i;
		while(true)
		{
			choice=menu();
			switch(choice)
			{
			case 1:// Add a student
							System.out.println("Enter data.. r,n,m");
							rollno=Integer.parseInt(br.readLine());
							name=br.readLine();
							marks=Float.parseFloat(br.readLine());
							st=new Student(rollno, name, marks);
							// add this student to sdb
							if(sdb.add(st))
							{
								System.out.println("Added Successfully....");	
							}
							else
							{
								System.out.println("Error... Couldn't add ....");
							}
							
							break;
			case 2://Display all students
							if(sdb.size()==0)
							{
								System.out.println("List is empty");
								break;
							}
							
								for ( i = 0; i < sdb.size(); i++) {
									st=sdb.get(i);
									st.display();
								}
				
				break;
			case 3://Search a student by name
						System.out.println("Enter name to be searched");
						target=br.readLine();
						st=sdb.findByName(target);
						if(st==null)
							System.out.println("No such student");
						else
						{
							System.out.println("Present... his/her data is");
							st.display();
						}
				break;
		
			case 4://How many passed/failed
				
						for ( i = 0,c1=0,c2=0; i < sdb.size(); i++) {
							
							if(sdb.get(i).getMarks()>=40)
							{
								c1++;
							}
							else
							{
								c2++;
							}
						}//for
						System.out.println(c1+" students passed");
						System.out.println(c2+" students failed");
				break;
			case 5://Deleting a student
				System.out.println("Enter name to be deleted: ");
				target=br.readLine();
				st=sdb.findByName(target);
				if(st==null)
					System.out.println("No such student");
				else
				{
					System.out.println("Present... his/her data is");
					st.display();
					sdb.remove(st);
					System.out.println("Deleted sucessfully");
				}
				break;
				
			case 6://Edit a student
				System.out.println("Enter name to be edited: ");
				target=br.readLine();
				st=sdb.findByName(target);
				if(st==null)
					System.out.println("No such student");
				else
				{
					System.out.println("Present... his/her data is");
					st.display();
					int pos=sdb.indexOf(st);
					System.out.println("Enter new data for student: ");
					System.out.println("Enter data.. r,n,m");
					rollno=Integer.parseInt(br.readLine());
					name=br.readLine();
					marks=Float.parseFloat(br.readLine());
					st=new Student(rollno, name, marks);
					sdb.set(pos,st);
				}
				System.out.println("Edited sucessfully");
				break;
				
			case 7:  System.out.println("End of program..");
						System.exit(0);
			
			}//switch
			
			
		}//while
		
	}//start
}//class

