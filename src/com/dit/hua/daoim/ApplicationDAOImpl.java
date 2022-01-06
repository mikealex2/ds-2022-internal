package com.dit.hua.daoim;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import javax.transaction.*;
import java.util.*;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void insertApplication(Application application){
        this.sessionFactory.getCurrentSession().save(application);
    }
    @Override
    @Transactional
    public List<Application> getApplications(){
        return this.sessionFactory.getCurrentSession().
                createQuery("from Application ",Application.class).getResultList();
    }
}