package demo02;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mysql.jdbc.ConnectionImpl;
import demo02.mapper.UserMapper;
import demo02.mapper.anoi.Insert;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.java2d.pipe.SpanIterator;

public class DBUtils {

  private static Connection connection;

  private static DruidDataSource dataSource;

  static {


      String url = "jdbc:mysql:///student?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
      dataSource = new DruidDataSource();
      dataSource.setUrl(url);
      dataSource.setUsername("root");
      dataSource.setPassword("aaa1024");
//      设置初始连接数
      dataSource.setInitialSize(100);
//      设置最小空闲数
      dataSource.setMinIdle(10);
//      设置最大等待时间
      dataSource.setMaxWait(60000);
//      设置连接池最大连接数
      dataSource.setMaxActive(200);
  }

  public static Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        con.close();

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    UserMapper userMapper = executeEntity(UserMapper.class);
    userMapper.addUser("riit", "adsa");
  }

  public static <T> T executeEntity(Class<T> mapper) {
    Object o = Proxy.newProxyInstance(mapper.getClassLoader(), new Class[]{mapper},
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method[] methods = mapper.getMethods();
            for (Method m : methods) {
              if (m.isAnnotationPresent(Insert.class)) {

                 Insert insertAno = m.getAnnotation(Insert.class);
                for (Parameter params
                    : m.getParameters()) {
                  System.out.println(params.getName());
                }
                for (Parameter parameter : m.getParameters()) {
                  System.out.println(parameter);
                }
                String value = insertAno.value();
                for (Object arg : args) {

                }
              }
            }

            return proxy;
          }
        });
    return ((T) o);


  }

}
