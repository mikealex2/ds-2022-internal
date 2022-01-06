package com.dit.hua.daoim;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import javax.transaction.*;
import java.util.*;

@Repository
public class ValidatedApplicationDaoImpl implements ValidatedApplicationDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void insertValidatedApplication(ValidatedApplication validatedApplication) {
        this.sessionFactory.getCurrentSession().save(validatedApplication);
    }
    @Override
    @Transactional
    public List<ValidatedApplication> getValidatedApplications(){
        return this.sessionFactory.getCurrentSession().
                createQuery("from ValidatedApplication ",ValidatedApplication.class).getResultList();
    }
}