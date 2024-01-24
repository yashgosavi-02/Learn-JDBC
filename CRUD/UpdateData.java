import java.sql.*;
public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "qwerty123";
        String query = "Update employee SET job_title = 'DevOps Engineer', salary = 80000 where id = 1;";
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
                System.out.println("Update Successful "+rowsAffected+" rows affected");
            }else{
                System.out.println("Updation Failed");
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
 * int rowsAffected = stmt.executeUpdate(query);
 *
 * executeQuery - retrieve
 * ResultSet rs = stmt.executeQuery(query);
 * */

/*
* DELETE from table_name where fieldName;
* Update table_name
* SET column1 = newVal1, column2 = newVal2
* Where some_column = someValue;
*
* */