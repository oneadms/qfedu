package demo1.model.entity;

/**
 * @author cnmgb
 * @date 2022/3/29
 **/
public class User {

  public User(String username, double money) {
    this.username = username;
    this.money = money;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  private Integer id;
  private String username;
  private double money;
}
