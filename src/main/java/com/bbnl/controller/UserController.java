package com.bbnl.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbnl.entity.User;
import com.bbnl.repository.UserRepository;
import com.bbnl.service.UserService;
import com.bbnl.entity.PasswordResetToken;
import com.bbnl.repository.PasswordResetTokenRepository;
import com.google.common.collect.ImmutableMap;
import com.bbnl.entity.VerificationToken;
import com.bbnl.eventandlistener.OnRegistrationCompleteEvent;
import com.bbnl.exception.EmailExistsException;

@Controller
public class UserController {
	
	

	@Autowired
	PasswordResetTokenRepository passwordTokenRepository;
	
	
	private UserService service;
	
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@Autowired
	private UserRepository repo;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
    private JavaMailSender mailSender;
	
	 @Autowired
	private Environment env;
	
	@GetMapping("/")
	public String HomePage() {
		return "home";
	}
	
	@RequestMapping("/forgotPassword")
	public String defectDetails() {
	    return "forgotPassword";
	}
	
	@GetMapping("/user")
	public String userDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		model.addAttribute("title", "User Dashboard");
		return "userdashboard";
	}
	
	@GetMapping("/customer")
	public String custDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		model.addAttribute("title", "Customer Dashboard");
		return "custdashboard";
	}
	
	@GetMapping("/provider")
	public String provDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		model.addAttribute("title", "Provider Dashboard");
		return "provdashboard";
	}
	@GetMapping("/ministerial")
	public String minisDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		model.addAttribute("title", "Ministry Dashboard");
		return "minisdashboard";
	}
	
	@RequestMapping(value = "/signup")
	public String signupUser(Model model) {
		model.addAttribute("user", new User());
		return "userSignup";
	}
	
	@GetMapping("/addconnection")
	public String newConn() {
		return "newConnection";
	}
	
	
	
	
	/*
	 * @RequestMapping(value = "/saveuser", method = RequestMethod.POST) public
	 *	956780-String saveUser(@ModelAttribute("user") User user, Model model) {
	 * user.setEnabled(false);
	 * user.setPassword(passwordEncoder.encode(user.getPassword()));
	 * service.saveUser(user);
	 * 
	 * model.addAttribute("register", "Registration Sucessfull !!"); return
	 * "redirect:/signin"; }
	 */
	 @RequestMapping(value = "/saveuser")
	    public ModelAndView registerUser(@Valid final User user, final BindingResult result, final HttpServletRequest request) {
	        if (result.hasErrors()) {
	            return new ModelAndView("userSignup", "user", user);
	        }
	        try {
	        	//System.out.println("user"+veriService.registerNewUser(user));
	            final User registered = service.registerNewUser(user);

	            final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl));
	        } catch (EmailExistsException e) {
	            result.addError(new FieldError("user", "email", e.getMessage()));
	            return new ModelAndView("userSignup", "user", user);
	        }
	        return new ModelAndView("redirect:/signin?verify");
	    }
	 
	 @RequestMapping(value = "/registrationConfirm")
	    public ModelAndView confirmRegistration(final Model model, @RequestParam("token") final String token, final RedirectAttributes redirectAttributes) {
		 System.out.println("token"+token);
		 System.out.println("tokenservice"+service.getVerificationToken(token));
		 
		 final VerificationToken verificationToken = service.getVerificationToken(token);
	        System.out.println("verification token"+verificationToken);
	        if (verificationToken == null) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Invalid account confirmation token.");
	            return new ModelAndView("redirect:/signin");
	        }

	        final User user = verificationToken.getUser();
	        final Calendar cal = Calendar.getInstance();
	        if ((verificationToken.getExpiryDate()
	            .getTime()
	            - cal.getTime()
	                .getTime()) <= 0) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Your registration token has expired. Please register again.");
	            return new ModelAndView("redirect:/signin");
	        }

	        user.setStatus(true);
	        service.saveRegisteredUser(user);
	        redirectAttributes.addFlashAttribute("message", "Your account verified successfully");
	        return new ModelAndView("redirect:/signin?success");
	    }
	 
	 @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
	    @ResponseBody
	    public ModelAndView resetPassword(final HttpServletRequest request, @RequestParam("email") final String userEmail, final RedirectAttributes redirectAttributes) {
		 System.out.println("user emailid ="+userEmail);  
		 
		 final User user = service.findUserByEmail(userEmail);
	        System.out.println("user is null ? ="+user);
	        if (user != null) {
	            final String token = UUID.randomUUID()
	                .toString();
	            service.createPasswordResetTokenForUser(user, token);
	            final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	            final SimpleMailMessage email = constructResetTokenEmail(appUrl, token, user);
	            mailSender.send(email);
	        }

	        redirectAttributes.addFlashAttribute("message", "You should receive an Password Reset Email shortly");
	        return new ModelAndView("redirect:/signin");
	    }
	 
	 @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	    public ModelAndView showChangePasswordPage(@RequestParam("id") final String id, @RequestParam("token") final String token, final RedirectAttributes redirectAttributes) {
	        final PasswordResetToken passToken = service.getPasswordResetToken(token);
	        if (passToken == null) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Invalid password reset token");
	            return new ModelAndView("redirect:/signin");
	        }
	       // final User user = passToken.getUser();
			/*
			 * if (user.getUserId() != id) {
			 * redirectAttributes.addFlashAttribute("errorMessage",
			 * "Invalid password reset token"); return new ModelAndView("redirect:/login");
			 * }
			 */

	        final Calendar cal = Calendar.getInstance();
	        if ((passToken.getExpiryDate()
	            .getTime()
	            - cal.getTime()
	                .getTime()) <= 0) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Your password reset token has expired");
	            return new ModelAndView("redirect:/login");
	        }

	        final ModelAndView view = new ModelAndView("resetPassword");
	        view.addObject("token", token);
	        return view;
	    }

	    @RequestMapping(value = "/user/savePassword", method = RequestMethod.POST)
	    @ResponseBody
	    public ModelAndView savePassword(@RequestParam("password") final String password, @RequestParam("passwordConfirmation") final String passwordConfirmation, @RequestParam("token") final String token, final RedirectAttributes redirectAttributes) {

	        if (!password.equals(passwordConfirmation)) {
	            return new ModelAndView("resetPassword", ImmutableMap.of("errorMessage", "Passwords do not match"));
	        }
	        final PasswordResetToken p = service.getPasswordResetToken(token);
	        if (p == null) {
	            redirectAttributes.addFlashAttribute("message", "Invalid token");
	        } else {
	            final User user = p.getUser();
	            if (user == null) {
	                redirectAttributes.addFlashAttribute("message", "Unknown user");
	            } else {
	                service.changeUserPassword(user, password);
	                redirectAttributes.addFlashAttribute("message", "Password reset successfully");
	            }
	        }
	        return new ModelAndView("redirect:/signin");
	    }

	    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final String token, final User user) {
	        final String url = contextPath + "/user/changePassword?id=" + user.getUserId() + "&token=" + token;
	        final SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(user.getEmail());
	        email.setSubject("Reset Password");
	        email.setText("Please open the following URL to reset your password: \r\n" + url);
	        email.setFrom(env.getProperty("support.email"));
	        return email;
	    }
	 
	@GetMapping("/signin")
	public String signinUser(Model model) {
		return "userSignin";
	}
}
