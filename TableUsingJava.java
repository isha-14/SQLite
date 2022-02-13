import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;  
import java.sql.Connection;  
 
import java.sql.SQLException;  
import java.sql.Statement;  

public class TableUsingJava

{

public static void main( String args[] ) throws SQLException

{

Connection c = null;

Statement stmt = null;

try {

Class.forName("org.sqlite.JDBC");

c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");

System.out.println("Database Opened...\n");



}

catch ( Exception e ) {

System.err.println( e.getClass().getName() + ": " + e.getMessage() );

System.exit(0);

}
System.out.println("Select DML Operation For Product Movies...");

System.out.println("1. Insert");
stmt = c.createStatement();
String name="",sql="";
String actor="";
String actress="";
int year;
Scanner scanName;
Scanner reader = new Scanner(System.in);

System.out.println("Enter a choice: ");

int n = reader.nextInt();



switch(n){



case 1:

scanName=new Scanner(System.in);

System.out.println("Enter Movie Name:");

name=scanName.nextLine();

System.out.println("Enter Actor:");

actor=scanName.nextLine();

System.out.println("Enter Actress:");

actress=scanName.nextLine();
System.out.println("Enter Year:");

year=scanName.nextInt();

sql = "INSERT INTO Movies (m_name,m_actor,m_actress,yearofrelease) " +"VALUES ('" +name+ "','" +actor + "','" + actress + "','" +year+ "')";

stmt.executeUpdate(sql);
stmt.close();


System.out.println("Inserted Successfully!!!");
}}
public void selectAll(){
    String sql = "SELECT m_name,m_actor,m_actress,yearofrelease FROM Movies";
    
    try (Connection c = null;

         Statement stmt = null;
    	 
         Statement stmt1  = c.createStatement();
         ResultSet rs    = stmt1.executeQuery(sql)){
        
        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getString("m_name") +  "\t" + rs.getString("m_actor") + "\t"+rs.getString("m_actress")+"\t"+rs.getInt("yearofrelease"));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }}

}


  

