package com.dit.hua.controller;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.*;
import org.springframework.security.crypto.password.*;
import javax.servlet.http.*;
import java.security.*;

@Controller
@RequestMapping("/")
public class AdminController{
	@Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthoritiesDAO authoritiesDAO;
    @Secured("ROLE_ADMIN")
    @PostMapping("/register")
    public String register(HttpServletRequest request,Model model,Principal principal){
        userShow(model,principal);
        User check=userDAO.getUserByUsername(request.getParameter("mUsername"));
		if(check==null){
         String mUsername=request.getParameter("mUsername");
         String mPassword=request.getParameter("mPassword");
         String role=request.getParameter("role");
         userDAO.insertUser(new User(mUsername,passwordEncoder.encode(mPassword),1));
         authoritiesDAO.insertAuthorities(new Authorities(mUsername,"ROLE_"+role.toUpperCase()));
		}
        userShow(model,principal);
    	return "index";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request,Model model,Principal principal){
        userShow(model,principal);
        userDAO.deleteUser(userDAO.getUserByUsername(request.getParameter("deleteUsername")));
        userShow(model,principal);
        return "index";
    }
    private void userShow(Model model,Principal principal){
        model.addAttribute("users",authoritiesDAO.getAuthorities());
        model.addAttribute("username",principal.getName());
    }
}