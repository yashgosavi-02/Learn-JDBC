import java.sql.*;
public class ViewData {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String username = "root";
        String password = "qwerty123";
        String query = "select * from employee;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            // Connection - Interface
            System.out.println("Connected Established Successfully");
            Statement stat = con.createStatement();
            // does not take any argument
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("ID = "+id+" Name = "+name+" Job_Title = "+job_title+" Salary = "+salary);
            }
            rs.close();
            stat.close();
            con.close();
            System.out.println("Connection Closed Successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
* String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "qwerty123";
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected to DB");
            System.out.println(connection);
        }
        catch (SQLException e){
            System.err.println("Connection Failed: "+e.getMessage());
        }
*/

/*
Class.forName("com.mysql.cj.jdbc.Driver"); // loading driver
Connection con = DriverManager.getConnection(url,username,password); // established connection
Statement stat = con.createStatement(); // creating statement
ResultSet rs = stat.executeQuery(query); // Executed SQL Query
 */