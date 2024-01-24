import java.rmi.dgc.DGC;
import java.sql.*;
public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "qwerty123";
        String query = "Insert into employee(id,name,job_title,salary) values(5,'Shanthinath','Web Developer',60000);";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully");
            Statement stm = con.createStatement();
            int rowsAffected = stm.executeUpdate(query);
            if(rowsAffected > 0){
                System.out.println("Insert Successful "+rowsAffected+" rows affected");
            }else{
                System.out.println("Insertion Failed");
            }
            stm.close();
            con.close();
            System.out.println("Connection Closed Successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
* executeUpdate - insert
* int rowsAfftected = stmt.executeUpdate(query);
*
* executeQuery - retrieve
* ResultSet rs = stmt.executeQuery(query);
* */