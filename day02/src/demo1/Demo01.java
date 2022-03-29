package demo1;

import demo1.service.AccountService;



public class Demo01 {

  public static void main(String[] args) {
      new AccountService().transferMoney("小陈","小李",1000);
  }

}
