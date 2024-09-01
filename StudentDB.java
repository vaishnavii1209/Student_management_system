package project7;

import java.util.ArrayList;

public class StudentDB {
  private ArrayList<Student> stList;
  private StudentDbmsService sds;

  public StudentDB( )
  {
	  sds=new StudentDbmsService ();
	  stList=sds.findAll();
  }//
  //
  int size()
  {
  	return stList.size();
  }
boolean add(Student st)
{
	// Add to ArrayList	
	// Add to mysqll table also
	if(sds.add(st))
	{
		stList=sds.findAll();
		return true;
	}
	return false;
}
Student get(int i)
{
	return stList.get(i);
	
}
int indexOf(Student st)
{
	return stList.indexOf(st);
	}
void set(int pos,Student st)
{
	stList.set(pos, st);
	sds.set(st);
}
Student findByName(String target)	// 
{
	for (int i = 0; i < stList.size(); i++) {
		Student st = stList.get(i);
		if(st.getName().equals(target))
				return st;		//found		
	}//for
	return null;		//not found
}
void remove(Student st)
{
	stList.remove(st);
	sds.remove(st);
}

}
