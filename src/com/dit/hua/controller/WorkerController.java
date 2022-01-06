package com.dit.hua.controller;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import java.security.*;

@Controller
@RequestMapping("/")
public class WorkerController{
    @Autowired
    private ValidatedApplicationDao validatedApplicationDao;
    @Autowired
    private ApplicationDAO applicationDAO;
    @Secured("ROLE_WORKER")
    @PostMapping("/approveApplication")
    public String approveApplication(HttpServletRequest request,Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        model.addAttribute("applications",applicationDAO.getApplications());
        model.addAttribute("validatedApplications",validatedApplicationDao.getValidatedApplications());
        String workerUsername=principal.getName();
        String citizenUsername=request.getParameter("citizenUserName");
        String citizenFirstName=request.getParameter("citizenFirstName");
        String citizenLastName=request.getParameter("citizenLastName");
        String citizenEmail=request.getParameter("citizenEmail");
        int citizenAmka=Integer.parseInt(request.getParameter("citizenAmka"));
        int citizenStratNumber=Integer.parseInt(request.getParameter("citizenStratNumber"));
        String reason_time_delay=request.getParameter("reason");
        validatedApplicationDao.insertValidatedApplication(new ValidatedApplication(workerUsername,
                citizenUsername,citizenFirstName,citizenLastName,citizenEmail,
                citizenAmka,citizenStratNumber,reason_time_delay));
        model.addAttribute("applications",applicationDAO.getApplications());
        model.addAttribute("validatedApplications",validatedApplicationDao.getValidatedApplications());
        return "index";
    }
}