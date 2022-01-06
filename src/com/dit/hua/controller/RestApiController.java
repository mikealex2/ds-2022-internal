package com.dit.hua.controller;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RestApiController{
    @Autowired
    private ApplicationDAO applicationDAO;
    @Autowired
    private UserDAO userDAO;
    @GetMapping("/applications")
    public List<Application> getApplications(){
        return applicationDAO.getApplications();
    }
    @PostMapping(path="/applications"/*,consumes="application/x-www-form-urlencoded",
            headers="Accept=application/x-www-form-urlencoded"*/)
    public Application addApplication(Application application){
        applicationDAO.insertApplication(application);
        return application;
    }
}