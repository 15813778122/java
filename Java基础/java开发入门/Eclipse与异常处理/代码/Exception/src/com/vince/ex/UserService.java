package com.vince.ex;

public class UserService {

	public User login(String username,String password)throws MyException{
		if(!"admin".equals(username)) {
			throw new  MyException("�û�������");
		}
		if(!"12345".equals(password)) {
			throw new MyException("�������");
		}
		User user = new User("admin","12345",18,"��");
		return user;
	}

}
