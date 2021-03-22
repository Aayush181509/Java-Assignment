import java.sql.*;
import java.util.*;


class Main {

    static int i=0;
    static  String n;
    public static void main (String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter Employee Id");
                int empId = scan.nextInt();
                System.out.println("Enter Employee Name");
                String empName = scan.next();
                System.out.println("Enter Employee Address");
                String empAddress = scan.next();
                System.out.println("Enter Employee Email Id");
                String email = scan.next();
                PreparedStatement stmt = conn.prepareStatement("Insert Into employee values(?,?,?,?)");
                stmt.setInt(1,empId);
                stmt.setString(2,empAddress);
                stmt.setString(3,empName);
                stmt.setString(4,email);
                stmt.executeUpdate();
                i++;
                ResultSet rs = stmt.executeQuery("select * from employee");
                while(rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" ");
                }
                System.out.println("Enter n to exit");
                n=scan.next();
            }while(!n.startsWith("n"));
            System.out.println("rows altered: "+i);
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
