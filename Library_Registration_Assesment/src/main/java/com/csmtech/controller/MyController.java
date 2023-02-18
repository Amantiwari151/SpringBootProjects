package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csmtech.model.Library;
import com.csmtech.model.Registration_Details;
import com.csmtech.model.Subscription;
import com.csmtech.service.LibraryServiceImpl;
import com.csmtech.service.RegistrationServiceImpl;
import com.csmtech.service.SubscriptionService;
import com.csmtech.service.SubscriptionServiceImpl;

@Controller
public class MyController {
	@Autowired
	private LibraryServiceImpl libService;
	
	@Autowired
	private SubscriptionServiceImpl subService;
	
	@Autowired
	private RegistrationServiceImpl regService;
	
	@GetMapping("/")
	public String getForm(Model model) {
		List<Library> allLibrary = libService.getAllLibrary();
		//System.out.println(allLibrary);
		model.addAttribute("LibraryList", allLibrary);
		
		List<Subscription> allSubscription = subService.getAllSubscription();
		//System.out.println(allSubscription);
		model.addAttribute("SubList", allSubscription);
		return "Registration";
	}
	
	
	@PostMapping("/dataRegister")
	public String saveForm(@ModelAttribute Registration_Details details
							,@RequestParam("image") MultipartFile userImage
							) {
		
		System.out.println(details);
		File file = new File("E:/MyDemo"+ userImage.getOriginalFilename());
		BufferedOutputStream bf =null;
		try {
			byte[] bytes = userImage.getBytes();
			bf = new BufferedOutputStream(new FileOutputStream(file));
			bf.write(bytes);
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		details.setImage_path("E:/MyDemo"+ userImage.getOriginalFilename());
		regService.saveDetails(details);
		return "redirect:./getDetails";
		
	}
	
	@GetMapping("/getDetails")
	public String getDetails(Model model) {
		List<Library> allLibrary = libService.getAllLibrary();
		//System.out.println(allLibrary);
		model.addAttribute("LibraryList", allLibrary);
		
				
		List<Registration_Details> allRegistration = regService.getAllRegistration();
		model.addAttribute("RegList", allRegistration);
		return "Details";
	}
	
	@GetMapping("/searchData")
	public String searchData(Model model,@RequestParam("library") Library lib) {
		List<Library> allLibrary = libService.getAllLibrary();
		//System.out.println(allLibrary);
		model.addAttribute("LibraryList", allLibrary);
		
//		regService.getByLibrary(lib.getLibrary_name()).forEach(System.out::println);
		model.addAttribute("searchLibrary",regService.getByLibrary(lib.getLibrary_name()));
		//System.out.println(		regService.getByLibrary(lib.getLibrary_name()));
				
		return "Details";
	}
	
	@GetMapping("/updateDetails")
	public String updateDetais(@RequestParam("registration_id") Integer id,Model model) {
		Registration_Details registerById = regService.getRegisterById(id);
		model.addAttribute("update", registerById);
		System.out.println(registerById);
		return "Registration";
	}

}
