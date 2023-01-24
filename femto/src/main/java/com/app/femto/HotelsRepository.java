package com.app.femto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelsRepository {
      
	Connection con= null;
    
    public HotelsRepository() {
  	  String url="jdbc:mysql://localhost:3306/App";
  	  String name="root";
  	  String pass="";
  	  try {
  		  Class.forName("com.mysql.jdbc.Driver");
  	      con=DriverManager.getConnection(url,name,pass);
  	  
        }
  	  catch(Exception e) {
  		  System.out.println(e);
  	  }
    }
    
    
    public List<Hotels> gethotelDetails() {
		List<Hotels> hList=new ArrayList<>();
		String sql="SELECT h.hotel_name , h.hotel_id , f.dish_name , f.fType , f.price , h.address"
				+ "FROM hotels h INNER JOIN food f ON h.hotel_id= f.h_id ";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Hotels a=new Hotels();
				a.setName(rs.getString(1));
				a.setAddress(rs.getString(6));
				a.setHid(rs.getInt(2));
				Food f = new Food();
				f.setDname(rs.getString(3));
				f.setHid(rs.getInt(2));
				f.setPrice(rs.getInt(5));
				f.setType(rs.getString(4));
				f.setDid(rs.getInt(7));
		        hList.add(a);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return hList;
	}
    
	public Hotels getHoteldetail(int id) {
		
	  Hotels a=new Hotels();
  	  String sql = "SELECT h.hotel_name , h.hotel_id , f.dish_name , f.fType , f.price , h.address "
  	  		+ "FROM hotels h INNER JOIN food f ON h.hotel_id= f.h_id "
  	  		+ "WHERE h.hotel_id=1 AND f.d_id="+id;
  	  try {
  		  Statement st= con.createStatement();
  		  ResultSet rs=st.executeQuery(sql);
  		  if(rs.next()) {
  			  
  			a.setName(rs.getString(1));
			a.setAddress(rs.getString(6));
			a.setHid(rs.getInt(2));
			Food f = new Food();
			f.setDname(rs.getString(3));
			f.setHid(rs.getInt(2));
			f.setPrice(rs.getInt(5));
			f.setType(rs.getString(4));  
			f.setDid(rs.getInt(7));
  		  }
  		  System.out.println("Message: data retrived with id="+id);
  		  System.out.print("Details:");
  		  return a; 
  	  }
  	  catch(Exception e) {
  		  System.out.println(e);
  	  }
  	  
  	 return new Hotels();
	}
}
