package common_use_bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.DBConnection_LMS_Portal;
/*
 *Program to use Getter and setter methods
 *Author :Sahil Rajeev Naik
 *Date started: 20/05/2021
 *Date ended: 	2/06/2021
 *Testing :Raksha Udupi
*/
public class Sequence_inventry_Id {
	
	
	
	/* * Method Name:main()
	    * Return Type:void
	    * Parameters :String[] args
	    * Description: Main Method  
	  */
	
	public static void main(String[] args) {
		
		
		Sequence_inventry_Id obj_Sequence_Book_Id=new Sequence_inventry_Id();
		
		obj_Sequence_Book_Id.create_table();
		System.out.println("Sequence book_id Id is "+obj_Sequence_Book_Id.get_inv_id());
		
	}
	/* * Method Name:get_inv_id()
	    * Return Type:String 
	    * Parameters :void
	    * Description: Update the sequence_inventry_id  
	  */
	public String get_inv_id(){
		PreparedStatement ps=null;
		Connection connection=null;
		ResultSet rs=null;
		DBConnection_LMS_Portal obj_DBConnection_LMS_Portal=new DBConnection_LMS_Portal();
		connection=obj_DBConnection_LMS_Portal.getConnection();
		String sequence_id="";
		String query="select sl_no from sequence_inventry_id";
		try {
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			rs.last();
			int sl_no=rs.getInt(1);
			
			
			query="update sequence_inventry_id set sl_no=sl_no+1 where sl_no=?";
			ps=connection.prepareStatement(query);
			ps.setInt(1, sl_no+0);
			//ps.setInt(2, sl_no);
			
			ps.executeUpdate();
			
			sequence_id=sl_no+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sequence_id;
		
		
		
		
		
		
		
	}
	
	
	/* * Method Name:create_table()
	    * Return Type:void
	    * Parameters :void
	    * Description: Creates table sequence_inventry_id in the database and add the values in the table  
	  */
	public  void create_table(){
		PreparedStatement ps=null;
		Connection connection=null;
		
		DBConnection_LMS_Portal obj_DBConnection_College_Portal=new DBConnection_LMS_Portal();
		connection=obj_DBConnection_College_Portal.getConnection();
		
		
		
		String query="create table sequence_inventry_id(sl_no int(255) not null,primary key(sl_no))";
		try {
			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
			
			
	        query="insert into sequence_inventry_id values(1)";
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
			System.out.println("Table created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
