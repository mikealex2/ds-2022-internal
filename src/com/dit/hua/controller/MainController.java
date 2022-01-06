package com.dit.hua.controller;
import com.dit.hua.dao.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import java.security.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.logout.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class MainController{
	@Autowired
    private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ValidatedApplicationDao validatedApplicationDao;
	@Autowired
	private FinalApplicationDAO finalApplicationDAO;
	@RequestMapping("/")
    public String home(Model model,Principal principal){
		model.addAttribute("users",authoritiesDAO.getAuthorities());
		model.addAttribute("username",principal.getName());
		model.addAttribute("applications",applicationDAO.getApplications());
		model.addAttribute("finalApplications",finalApplicationDAO.getFinalApplications());
		model.addAttribute("validatedApplications",validatedApplicationDao.getValidatedApplications());
    	return "index";
    }
    @RequestMapping("/login")
    public String showLogin(){
            return "login";
    }
    @RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
			new SecurityContextLogoutHandler().logout(request,response,authentication);
		return "redirect:login";
    }
}