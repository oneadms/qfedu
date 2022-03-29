package demo1.model.entity;

import java.io.Serializable;

/**
 * @author cnmgb
 * @date 2022/3/29
 **/
public class User implements Serializable {

  public User(Integer id, String username, double money) {
    this.id = id;
    this.username = username;
    this.money = money;
  }

  public User() {
    
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
