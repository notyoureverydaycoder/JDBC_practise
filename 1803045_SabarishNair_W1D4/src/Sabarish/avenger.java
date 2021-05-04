package Sabarish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.*;


public class avenger
{
	
		public static void main(String[] args) throws Exception 
		{
			
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				//Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost/sakila";
				Connection con = DriverManager.getConnection(mysqlUrl, "root", "Plaphoom123");
				//Creating a Statement object
				Statement stmt = con.createStatement();
				//Retrieving the data
				ResultSet rs = stmt.executeQuery("select * from Avengers");
			
			ArrayList<student> studList = new ArrayList<>();
			//Adding the Records of the table to the Array List
		    InputStreamReader r=new InputStreamReader(System.in);
		    BufferedReader in=new BufferedReader(r);
		    System.out.println("Enter your choice(1:display,2:dispay according to serial)");
		    String data =in.readLine();
		    int ch=Integer.parseInt(data);
		    switch(ch)
		    {
		    case 1:
		    	while(rs.next()) {
			    student studObj= new student();
			    studObj.setFname(rs.getString("FirstName"));
			    studObj.setLname(rs.getString("LastName"));
			    studObj.setSerial(rs.getInt("Serial"));
			    studObj.setAlias(rs.getString("Alias"));
			    studObj.setQuote(rs.getString("Quote"));
			    studList.add(studObj);
			    }
			    for (student obj : studList) {
				System.out.print("FirstName: "+obj.getFname()+", ");
				System.out.print("LastName: "+obj.getLname()+", ");
				System.out.print("Serial: "+obj.getSerial()+", ");
				System.out.print("Alias: "+obj.getAlias()+", ");
				System.out.print("Quote: "+obj.getQuote()+", ");
				System.out.println();
				}
			    break;
		    case 2:
		    	InputStreamReader reader =new InputStreamReader(System.in);
		    	BufferedReader br=new BufferedReader(reader);
		    	System.out.println("Enter Serial no");
		    	String ro=br.readLine();
		    	int Serialno=Integer.parseInt(ro);
		    	System.out.println("fetching records....");
		    	while(rs.next())
		    	{
		    		if(Serialno==rs.getInt("Serial"))
		    		{
		    			System.out.println("serialno:"+rs.getInt("Serial"));
		    			System.out.println("Alias:"+rs.getString("Alias"));
		    			System.out.println("Quote:"+rs.getString("Quote"));
		    		    System.out.println();
		    		    break;
		    		}
		    		else if(rs.isLast())
		    		{
		    			if(Serialno!=rs.getInt("Serial"))
		    			{
		    				System.out.println("no such serial no.....");
		    			}
		    		}
		    	}
		    	
		    
		    }
		    
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			
		

	}

}
