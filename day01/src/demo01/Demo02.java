package demo01;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

//TODO jdbc链接 预编译sql查询
public class Demo02 {

  public static void main(String[] args) throws SQLException {
//    Connection connection = DriverManager.getConnection(
//        "jdbc:mysql:///student?serverTimezone=Asia/Shanghai", "root",
//        "aaa1024");
//    则当查询条件是中文时，会出现查询空（原因：idea使用UTF-8编码，需指定连接Mysql过程中也使用UTF8，才不会编解码错误）
    Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8",
        "root", "aaa1024");
    String sql = "select * from student where StudentName= ? ;";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, "大凡");
    ResultSet resultSet = ps.executeQuery();

    while (resultSet.next()) {
      System.out.println(resultSet.getString(1));
      System.out.println(resultSet.getString(2));
      System.out.println(resultSet.getString(3));
    }
    resultSet.close();
    ps.close();
    connection.close();
  }

}
