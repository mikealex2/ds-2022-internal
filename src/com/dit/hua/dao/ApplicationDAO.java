package com.dit.hua.dao;
import com.dit.hua.entity.*;
import java.util.*;

public interface ApplicationDAO{
    void insertApplication(Application application);
    List<Application> getApplications();
}