package com.dit.hua.dao;
import com.dit.hua.entity.*;
import java.util.*;

public interface UserDAO{
	void insertUser(User user);
	User getUserByUsername(String username);
	void deleteUser(User user);


}