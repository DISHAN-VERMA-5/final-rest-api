package com.dishan.myrestapi.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.dishan.myrestapi.mybatis.MyBatisUtil;
import com.dishan.myrestapi.mybatis.UserMapper;

//basically here we put all the methods and function that we can perform
@Component
public class UserDao {
//	private static List<User> users=new ArrayList<User>();
//	private static int count=2;
//	static {
//		users.add(new User(0,"papa","verma"));
//		users.add(new User(1,"jhuna","verma"));
//	}
	public List<User> findAll()
	{
		//return users;
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  List<User> user=mapper.selectAllUsers();
		  System.out.println("i am dao wala");
		  for(User y:user) {
				System.out.println(y.getFirstName()+" "+y.getLastName()+" "+y.getId());
			}
		  session.commit();
		  session.close();
		  return user;
	}
	public String save(User user) {
//		if(user.getId()==null) {
//			count++;
//			user.setId(count);
//			users.add(user);
//			return user;
//		}
//		
//		users.set(user.getId(), user);
//		return user;
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  mapper.insertUser(user);
		  session.commit();
		  session.close();
		  return "user saved";
		
	}
	public User findOne(int id)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  User user=mapper.selectUser(id);
		  session.commit();
		  session.close();
		  return user;
	}
	public String deleteUser(int id)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  mapper.deleteUser(id);
		  session.commit();
		  session.close();
		  return "deleted";
//		User user=findOne(id);
//		users.remove(user);
//		return user;
	}
}
