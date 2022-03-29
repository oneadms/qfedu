package demo02.mapper;


import demo02.mapper.anoi.Insert;

public interface UserMapper {
  @Insert("insert into user(#{username},#{passwd})")
  void addUser(String username, String passwd);
}
