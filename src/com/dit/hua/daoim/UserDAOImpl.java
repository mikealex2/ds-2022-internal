package com.dit.hua.daoim;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;
import javax.transaction.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@Override
    @Transactional
	public void insertUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(user);
	}
	@Override
	@Transactional
	public User getUserByUsername(String username){
		Session session=this.sessionFactory.getCurrentSession();
		User user=null;
		try{user=session.createQuery("from User where username='"+username+"'",User.class).getSingleResult();
		}catch(Exception ignored){}
		return user;
	}
	@Override
	@Transactional
	public void deleteUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(user);
	}
	}