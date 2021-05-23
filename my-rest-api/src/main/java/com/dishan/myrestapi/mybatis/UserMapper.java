package com.dishan.myrestapi.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dishan.myrestapi.user.User;

@Mapper
public interface UserMapper {
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name")
      })
	@Select("SELECT * from user WHERE id = #{id}")
	User selectUser(int id);
	
	@Insert("INSERT into user(first_name,last_name) VALUES(#{firstName}, #{lastName})")
	void insertUser(User user);
	
	@Update("UPDATE user SET first_name=#{firstName}, last_name =#{lastName} WHERE id =#{id}")
	void updateUser(User user);
	
	@Delete("DELETE FROM user WHERE id =#{id}")
	void deleteUser(int id);
	
	@Select("SELECT id,first_name as firstName,last_name as LastName FROM user")
	public List<User> selectAllUsers();

}
