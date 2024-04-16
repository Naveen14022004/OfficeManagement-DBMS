/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package office;
import java.sql.*;
/**
 *
 * @author navee
 */
public class Office {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection con=DriverManager.getConnection(  
        "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","cksnaveen");  

        //step3 create the statement object  
            Statement stmt=con.createStatement();  

            //step4 execute query  
            PreparedStatement preparedStmt = con.prepareStatement("insert into customer values (?,?,?,?,?)");
            preparedStmt.setString(1, "v118");
            preparedStmt.setString(2, "Raja");
            preparedStmt.setString(3, "TVS Nagar");
            preparedStmt.setInt(4, 12345678);
            preparedStmt.setString(5, "a@gmail.com");
            preparedStmt.executeUpdate();
            ResultSet rs=stmt.executeQuery("select * from customer");
           
            while(rs.next())  
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(4)+" "+rs.getString(3));  

            //step5 close the connection object  
            con.close();

        }catch(SQLException e){ System.out.println(e);} 
        
    }
    
}
