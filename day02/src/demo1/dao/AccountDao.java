package demo1.dao;

import demo1.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

  public int addMoney(String username, Integer money ) throws SQLException {
    PreparedStatement ps = null;
    Connection connection = DBUtils.getConnection();
    connection.setAutoCommit(false);
    ps = connection.prepareStatement(
        "update account set money=money+? where username=?");
    ps.setInt(1, money);
    ps.setString(2, username);
    int res = ps.executeUpdate();
    DBUtils.close(ps);

    return res;

  }

  public int subMoney(String username, Integer money) throws SQLException {
    PreparedStatement ps = null;
    Connection connection = DBUtils.getConnection();
    connection.setAutoCommit(false);
    ps = connection.prepareStatement(
        "update account set money=money-? where username=?");
    ps.setInt(1, money);
    ps.setString(2, username);
    int res = ps.executeUpdate();
    DBUtils.close(ps);
    return res;

  }


}
