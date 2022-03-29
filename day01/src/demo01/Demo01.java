package demo01;

import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.Driver;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

//TODO jdbc连接 字符串拼接查询

public class Demo01 {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
//    Class.forName("com.mysql.jdbc.Driver");
//    DriverManager.registerDriver(new Driver());
    Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8",
        "root", "aaa1024");
    Statement statement = connection.createStatement();
    Scanner scanner = new Scanner(System.in);
    String studentname= scanner.nextLine();
    String passwd= scanner.nextLine();
    String sql = "select * from student where studentname='"+studentname+"' and "+"loginpwd='"+passwd+"'";
    System.out.println("sql = " + sql);
    ResultSet resultSet = statement.executeQuery(sql);
    while (resultSet.next()) {

      String studentName = resultSet.getString("studentName");
      System.out.println(studentName);
    }
  }
}
