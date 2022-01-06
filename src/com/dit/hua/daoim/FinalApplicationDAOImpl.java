package com.dit.hua.daoim;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import javax.transaction.*;
import java.util.*;

@Repository
public class FinalApplicationDAOImpl implements FinalApplicationDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void insertFinalApplication(FinalApplication finalApplication) {
        this.sessionFactory.getCurrentSession().save(finalApplication);
    }
    @Override
    @Transactional
    public List<FinalApplication> getFinalApplications(){
        return this.sessionFactory.getCurrentSession().
                createQuery("from FinalApplication ",FinalApplication.class).getResultList();
    }
}