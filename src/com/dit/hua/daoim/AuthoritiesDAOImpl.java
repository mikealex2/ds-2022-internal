package com.dit.hua.daoim;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;
import javax.transaction.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.*;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@Override
    @Transactional
	public void insertAuthorities(Authorities authority){
		Session session=this.sessionFactory.getCurrentSession();
		session.save(authority);
	}

	@Override
	@Transactional
	public List<Authorities> getAuthorities(){
		 Session session=this.sessionFactory.getCurrentSession();
		 Query<Authorities> query=session.createQuery("from Authorities",Authorities.class);
		 return query.getResultList();
	}

}