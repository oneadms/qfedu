package demo1.service;

import demo1.dao.AccountDao;
import demo1.util.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {

  private AccountDao accountDao = new AccountDao();
  public void transferMoney(String from,String to,Integer money) {
    Connection con = DBUtils.getConnection();
    try {
      con.setAutoCommit(false);
      accountDao.addMoney(to, money);
      accountDao.subMoney(from, money);
      con.commit();
    } catch (Exception e) {
      try {
        con.rollback();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      e.printStackTrace();
    } finally {

      DBUtils.close(con);
    }
  }

}
