import java.sql.*;
import java.util.Scanner;

public class jdbc {
    public static void main (String [] args) throws  Exception{
     createDb();
     createTable();
     insert();
     delete();
     update();

    }
    public static void createDb () throws Exception{

        String url = "jdbc:mysql://localhost:3306/";
        String username ="root";
        String password = "";
        String query = "create database if not exists cuddalore ";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement s = con.createStatement();
        s.executeUpdate(query);
        System.out.println("database created successfully");
        con.close();
    }
    public static void createTable () throws Exception{

        String url = "jdbc:mysql://localhost:3306/college";
        String username ="root";
        String password = "";
        String query = "create table if not exists studentt("+" id int, "+" name varchar(20))";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement s = con.createStatement();
        s.executeUpdate(query);
        System.out.println("Table created successfully");
        con.close();
    }

    public static void read () throws Exception{

        String url = "jdbc:mysql://localhost:3306/college";
        String username ="root";
        String password = "";
        String query = "select * from student";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()) {
            System.out.println("id " + rs.getInt("id"));
            System.out.println("name " + rs.getString("name"));
            System.out.println("city " + rs.getString("city"));
        }
        con.close();
    }
    public static  void insert() throws  Exception{

        Connection con = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the id ");
        int id = sc.nextInt();
        System.out.println("Enter the name");
        String name = sc.next();
        System.out.println("Enter the city");
        String city = sc.next();

        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "";
            String query = "insert into student values (" + id + ", '" + name + "', '" + city + "')";
            con = DriverManager.getConnection(url, username, password);
            Statement s = con.createStatement();
            int row = s.executeUpdate(query);
            System.out.println("The no of rows affected " + row);
        } catch (SQLException e) {
            System.out.println("error"+ e.getMessage());
        }
        con.close();
    }

    public static void preparedstinsert() throws Exception{
        String url = "jdbc:mysql://localhost:3306/college";
        String username ="root";
        String password = "";
        int id=10;
        String name="vijay";
        String city = "kanyakumari";

        String query = "insert into student values (?,?,?)";
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,city);

        int row = pst.executeUpdate();
        System.out.println("The no of rows affected "+row);
        con.close();
    }

    public static void delete() throws Exception{
        String url = "jdbc:mysql://localhost:3306/college";
        String username ="root";
        String password = "";

        int id=10;
        String query = "delete from student where id="+id;
        Connection con = DriverManager.getConnection(url,username,password);
        Statement s = con.createStatement();
        int row = s.executeUpdate(query);
        System.out.println("The no of rows affected "+row);
        con.close();
    }
    public static void update() throws Exception{
        String url = "jdbc:mysql://localhost:3306/college";
        String username ="root";
        String password = "";

        String query = "update student set city='marina' where id=2";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement s = con.createStatement();
        int row = s.executeUpdate(query);
        System.out.println("The no of rows affected "+row);
        con.close();
    }
}
