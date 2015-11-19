
package kata5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kata5 {

   
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("org.sqlite.JDBC");
	//Connection conect= DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system", "orcl");
        Connection conect= DriverManager.getConnection("jdbc:sqlite:KATA.DB");
        Statement state =conect.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        
	ResultSet rs = state.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getString("NAME"));
        }
        String nameFile="C:\\Users\\usuario\\Desktop\\Nuevo documento de texto.txt";
        
        BufferedReader reader = new BufferedReader (new FileReader (new File(nameFile)));
        
        String mail;
        
        while((mail=reader.readLine())!=null){
            query="INSERT INTO MAILS (MAIL) VALUES ('"+mail+"')";
        
        state.executeUpdate(query);
          
        }
        
        
       rs.close();
       state.close();
       conect.close();
    }
}
