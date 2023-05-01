//import necessary libraries
package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//configure BillController as Controller 
@Controller
public class BillController {
	
	
	@Autowired
	private Third_Password_Images third_Password_Images;
	
	@Autowired
	private DatabaseOperations databaseOperations;
	
	// inject EmailService dependency
	@Autowired
	private EmailService emailService;

	// inject FormService dependency
	@Autowired
	private FormService formService;

	// create random number object
	Random random = new Random();
	// generate a random number
	int OtpNumber = random.nextInt(90000) + 10000;

	// handle GET request for RegisterUser page
	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public String Register(ModelMap model) {
		return "Register";
	}
	@RequestMapping(value = "/Second_Password", method = RequestMethod.POST)
	public String RegisterPost(HttpSession session,@ModelAttribute("Register") Register register, ModelMap model) {
	    session.setAttribute("Register", register);
		return "Second_Password";
	}
	@RequestMapping(value = "/Third_Password", method = RequestMethod.POST)
	public String ThirdPasswordPost(HttpSession session,@ModelAttribute("Second_Password_Model") Second_Password_Model second_Password_Model,ModelMap model) {
		Register register = (Register) session.getAttribute("Register");
		session.setAttribute("Register", register);
		session.setAttribute("Second_Password_Model", second_Password_Model);
		List<Images> images = third_Password_Images.getImages();
		model.addAttribute("Images",images);
		return "Third_Password";
	}
	
	@RequestMapping(value = "/Third_Password", method = RequestMethod.GET)
	public String ThirdPasswordGET(HttpSession session,ModelMap model) {
		List<Images> images = third_Password_Images.getImages();
		model.addAttribute("Images",images);
		return "Third_Password";
	}
	
	@RequestMapping(value = "/Main_Page", method = RequestMethod.POST)
	public String MainPagedPost(HttpSession session,@RequestParam("image1") String[] selectedCheckboxes,ModelMap model) {
		Register register = (Register) session.getAttribute("Register");
		Second_Password_Model second_Password_Model = (Second_Password_Model) session.getAttribute("Second_Password_Model");
		if(databaseOperations.checkUser(register)) {
			model.addAttribute("message","User exists try different username and email");
			return "LoginPage";
		}else {
			if(databaseOperations.insert(register,second_Password_Model,selectedCheckboxes)) {
				model.addAttribute("message","Registerd Successfully");
				return "LoginPage";
			}else {
				model.addAttribute("message","User Creation Failed");
				return "LoginPage";
			}
		}
		
	}
	
	
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String Login(ModelMap model) {
		return "LoginPage";
	}
	@RequestMapping(value = "/Second_Password_Login", method = RequestMethod.POST)
	public String LoginPost(HttpSession session,@ModelAttribute("Login_User_Model") Login login, ModelMap model) {
	    session.setAttribute("Login", login);
		return "Second_Password_Login";
	}
	@RequestMapping(value = "/Third_Password_Login", method = RequestMethod.POST)
	public String ThirdPasswordLoginPost(HttpSession session,@ModelAttribute("Second_Password_Model") Second_Password_Model second_Password_Model,ModelMap model) {
		Login login = (Login) session.getAttribute("Login");
		session.setAttribute("Login", login);
		session.setAttribute("Second_Password_Model", second_Password_Model);
		List<Images> images = third_Password_Images.getImages();
		model.addAttribute("Images",images);
		return "Third_Password_Login";
	}
	
	
	@RequestMapping(value = "/Main_Page_Login", method = RequestMethod.POST)
	public String MainPagedLoginPost(HttpSession session,@RequestParam("image1") String[] selectedCheckboxes,ModelMap model) {
		Login login = (Login) session.getAttribute("Login");
		Second_Password_Model second_Password_Model = (Second_Password_Model) session.getAttribute("Second_Password_Model");
		if(databaseOperations.checkUserLogin(login,second_Password_Model,selectedCheckboxes)) {
			session.setAttribute("Login", login);
			List<FormModel> details = formService.getDetails(login);
			model.addAttribute("Details",details);
			model.addAttribute("Login",login);
			model.addAttribute("message","Login Sucessfull");
			return "MainPageLogin";
		}else {
			model.addAttribute("message","Login Failed");
			return "LoginPage";
		}
	}
	

	@RequestMapping(value = "/MainPageLogin", method = RequestMethod.GET)
	public String MainPagedLoginGet(HttpSession session,ModelMap model) {
		Login login = (Login) session.getAttribute("Login");
		session.setAttribute("Login", login);
		List<FormModel> details = formService.getDetails(login);
		model.addAttribute("Details",details);
		model.addAttribute("Login",login);
			return "MainPageLogin";
	}
	
	@RequestMapping(value = "/Form", method = RequestMethod.GET)
	public String Form(HttpSession session,ModelMap model) {
		Login login = (Login) session.getAttribute("Login");
		session.setAttribute("Login", login);
		model.addAttribute("Login",login);
			return "Form";
	}
	@RequestMapping(value = "/Form", method = RequestMethod.POST)
	public String FormPost(HttpSession session,@ModelAttribute("FormModel") FormModel formModel,ModelMap model) {
		Login login = (Login) session.getAttribute("Login");
		
		if(formService.AddFormData(login,formModel)) {
			session.setAttribute("Login", login);
			List<FormModel> details = formService.getDetails(login);
			model.addAttribute("Details",details);
			model.addAttribute("Login",login);
			
			return "MainPageLogin";
		}else {
			session.setAttribute("Login", login);
			List<FormModel> details = formService.getDetails(login);
			model.addAttribute("Details",details);
			model.addAttribute("Login",login);
			return "MainPageLogin";	
		}
	}

	
	
	
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String ForgetPassword(HttpSession session,ModelMap model) {
			return "ForgetPassword";
	}
	
//	// OTP
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public String ForgetPasswordPost(HttpSession session,@RequestParam(name = "Email", required = true) String Email, ModelMap model) {
		if (emailService.isValidEmail(Email) && emailService.checkEmailExists(Email)) {
//			emailService.sendSimpleMessage(Email, "OTP to reset your Password",
//					"OTP is " + OtpNumber);
			System.out.println(OtpNumber);
			model.put("Email", Email);
			 session.setAttribute("Email", Email);
			return "Second_Password_Forget_Password";
		} else {
			model.put("message", "Invalid Email ID");
			return "ForgetPassword";
		}
	}
	
	
	
	@RequestMapping(value = "/Second_Password_Forget_Password", method = RequestMethod.POST)
	public String SecondPasswordForgetPasswordPost(HttpSession session,@RequestParam(name = "Email", required = true) String Email, ModelMap model) {
	    session.setAttribute("Email", Email);
		return "Second_Password_Forget_Password";
	}
	@RequestMapping(value = "/Third_Password_Forget_Password", method = RequestMethod.POST)
	public String ThirdPasswordForgetPasswordPost(HttpSession session,@ModelAttribute("Second_Password_Model") Second_Password_Model second_Password_Model,ModelMap model) {
		String Email = (String) session.getAttribute("Email");
		session.setAttribute("Email", Email);
		session.setAttribute("Second_Password_Model", second_Password_Model);
		List<Images> images = third_Password_Images.getImages();
		model.addAttribute("Images",images);
		return "Third_Password_Forget_Password";
	}
	
	@RequestMapping(value = "/Reset_Password", method = RequestMethod.POST)
	public String ResetPasswordPost(HttpSession session,@RequestParam("image1") String[] selectedCheckboxes,
			@RequestParam("OTP") String OTP,
			@RequestParam("Password") String Password,ModelMap model) {
		String Email = (String) session.getAttribute("Email");
		Second_Password_Model second_Password_Model = (Second_Password_Model) session.getAttribute("Second_Password_Model");
		if (Integer.parseInt(OTP)==OtpNumber) {
			boolean y = databaseOperations.updateUser(Email,Password,second_Password_Model,selectedCheckboxes);
			return "LoginPage";
			
		}else {
			session.setAttribute("Email", Email);
			session.setAttribute("Second_Password_Model", second_Password_Model);
			List<Images> images = third_Password_Images.getImages();
			model.addAttribute("Images",images);
			return "Third_Password_Forget_Password";
		}
		
	}
	
}