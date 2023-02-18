package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csmtech.model.Details;
import com.csmtech.model.Provider;
import com.csmtech.model.Subscription;
import com.csmtech.service.DetailsServiceImpl;
import com.csmtech.service.ProviderServiceImpl;
import com.csmtech.service.SubscriptionServiceImpl;

@Controller
public class MyController {

	@Autowired
	private ProviderServiceImpl pService;

	@Autowired
	private SubscriptionServiceImpl subService;

	@Autowired
	private DetailsServiceImpl detailService;

	@GetMapping("/")
	public String getForm(Model model) {
		List<Provider> allProvider = pService.getAllProvider();
		System.out.println(allProvider);
		model.addAttribute("providerList", allProvider);

		List<Subscription> allSubscription = subService.getAllSubscription();
		System.out.println(allSubscription);
		model.addAttribute("SubList", allSubscription);
		return "Registration";
	}

	@PostMapping("/saveForm")
	public String saveForm(@ModelAttribute Details details, @RequestParam("image") MultipartFile userImage) {
		File file = new File("E:/MyDemo" + userImage.getOriginalFilename());
		BufferedOutputStream bf = null;
		try {
			byte[] bytes = userImage.getBytes();
			bf = new BufferedOutputStream(new FileOutputStream(file));
			bf.write(bytes);
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		details.setImage_path("E:/MyDemo"+userImage.getOriginalFilename());
		detailService.saveDetails(details);
		return "redirect:./getDetails";
	}
	
	@GetMapping("/getDetails")
	public String getDetails(Model model) {
		List<Details> allDetails = detailService.getAllDetails();
		System.out.println(allDetails);
		model.addAttribute("DetailList",allDetails);
		return "Details";
	}
}
