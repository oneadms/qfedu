package demo1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

public class DBUtils {

  private static DataSource dataSource;

  private static Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(DBUtils.class.getResourceAsStream("/db.properties"));

      dataSource = DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }

//    String url = "jdbc:mysql:///day02db?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
//    dataSource.setUrl(url);
//    dataSource.setUsername("root");
//    dataSource.setPassword("aaa1024");
////      设置初始连接数
//    dataSource.setInitialSize(100);
////      设置最小空闲数
//    dataSource.setMinIdle(10);
////      设置最大等待时间
//    dataSource.setMaxWait(60000);
////      设置连接池最大连接数
//    dataSource.setMaxActive(200);
  }

  private  static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
  public static Connection getConnection() {
    Connection con = threadLocal.get();
    if (con == null) {
      Connection connection = null;
      try {
        connection = dataSource.getConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      threadLocal.set(connection);
      return connection;
    }
    return con;
  }

  public static void close(PreparedStatement ps) {
    try {
      if (ps != null
      ) {
        ps.close();

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(ResultSet rs) {
    try {
      if (rs != null
      ) {
        rs.close();

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(Connection con) {
    try {
      if (con != null
      ) {
        threadLocal.remove();
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
