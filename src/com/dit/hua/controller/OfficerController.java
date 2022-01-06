package com.dit.hua.controller;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.ui.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import java.security.*;

@Controller
@RequestMapping("/")
public class OfficerController{
    @Autowired
    private FinalApplicationDAO finalApplicationDAO;
    @Autowired
    private ValidatedApplicationDao validatedApplicationDao;
    @Secured("ROLE_OFFICER")
    @PostMapping("/approveValidated")
    public String approveValidatedApplication(HttpServletRequest request,Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        model.addAttribute("finalApplications",finalApplicationDAO.getFinalApplications());
        model.addAttribute("validatedApplications",validatedApplicationDao.getValidatedApplications());
        String officerUsername=principal.getName();
        String citizenUsername=request.getParameter("fcitizenUserName");
        String citizenFirstName=request.getParameter("fcitizenFirstName");
        String citizenLastName=request.getParameter("fcitizenLastName");
        String citizenEmail=request.getParameter("fcitizenEmail");
        int citizenAmka=Integer.parseInt(request.getParameter("fcitizenAmka"));
        int citizenStratNumber=Integer.parseInt(request.getParameter("fcitizenStratNumber"));
        String age=request.getParameter("age");
        finalApplicationDAO.insertFinalApplication(new FinalApplication(officerUsername,
                citizenUsername,citizenFirstName,citizenLastName,citizenEmail,
                citizenAmka,citizenStratNumber,age));
        model.addAttribute("finalApplications",finalApplicationDAO.getFinalApplications());
        model.addAttribute("validatedApplications",validatedApplicationDao.getValidatedApplications());
        return "index";
    }
}