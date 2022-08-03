package com.bbnl.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbnl.FileUploadUtil;
import com.bbnl.entity.Block;
import com.bbnl.entity.District;
import com.bbnl.entity.RegisteredDocuments;
import com.bbnl.entity.ServiceProvider;
import com.bbnl.entity.ServiceType;
import com.bbnl.entity.State;
import com.bbnl.service.BlockService;
import com.bbnl.service.DistrictService;
import com.bbnl.service.RegisteredDocumentsService;
import com.bbnl.service.SProviderService;
import com.bbnl.service.ServiceTypeService;
import com.bbnl.service.StateService;

import org.springframework.util.StringUtils;

@Controller
@RequestMapping("/user")
public class ServiceProviderController {

	@Autowired
	public SProviderService service;

	@Autowired
	public ServiceTypeService servicetype;
	
	@Autowired
	private StateService stateService;
	
	@Autowired 
	private DistrictService districtService;
	
	@Autowired 
	private BlockService blockService;

	/*
	 * @Autowired private RegisteredDocumentsRepository documentsRepo;
	 */

	@Autowired
	private RegisteredDocumentsService documentsService;
	
	
	@RequestMapping("/ServiceProviderList")
	public String viewHomePage(Model model) {
		List<ServiceProvider> listServiceProvider = service.listAll();
		model.addAttribute("listServiceProvider", listServiceProvider);
		return "ServiceProviderInfo";

	}

	
	
	@RequestMapping("/saveServiceProvider")
	public String AcceptNewProviderForm(RegisteredDocuments registeredDocuments, 
			Model model) {
		
		
		  List<ServiceType> listServiceType = servicetype.listAllService();
		  model.addAttribute("listServiceType", listServiceType);
		  model.addAttribute("ServiceType", new ServiceType()); ServiceProvider
		  serviceProvider = new ServiceProvider();
		  model.addAttribute("serviceProvider", serviceProvider);
		  List<State> liststate = stateService.listAllState();
			model.addAttribute("liststate", liststate);
			
			List<District> listDistrict = districtService.listAllDistrict();
			model.addAttribute("listDistrict", listDistrict);
			
			List<Block> listBlock = blockService.listAllBlock();
			model.addAttribute("listBlock", listBlock);
			
		 
		  return "addServiceProvider";

	}

	@PostMapping("/serviceprovider/save")
	public String saveServiceProviderDetails(ServiceProvider serviceProvider, RedirectAttributes redirectAttributes,
			RegisteredDocuments registeredDocuments, Model model,
			@RequestParam(name="panDocs") MultipartFile multipartFilePan,
			@RequestParam(name="aadharDocs") MultipartFile multipartFileAadhar,
			@RequestParam(name="licenseDocs") MultipartFile multipartFileLicense,
			@RequestParam(name="gstinDocs") MultipartFile multipartFileGstin,
			@RequestParam(name="cicDocs") MultipartFile multipartFileCic)throws IOException {
           System.out.println("working condition");
		
		  System.out.println("multipan"+multipartFilePan);
		  service.save(serviceProvider);

		
		
		  
		
		  String documentPan=StringUtils.cleanPath(multipartFilePan.getName());
		  String documentAadhar=StringUtils.cleanPath(multipartFileAadhar.getName());
		  String documentLicense=StringUtils.cleanPath(multipartFileLicense.getName());
		  String documentgstin=StringUtils.cleanPath(multipartFileGstin.getName());
		  String documentCic=StringUtils.cleanPath(multipartFileCic.getName());
		  
		  String documents=documentPan+","+documentAadhar+","+documentLicense+","+documentgstin+","+documentCic;
		 		  
			    String panDocument =StringUtils.cleanPath(multipartFilePan.getOriginalFilename());
				String aadharDocument = StringUtils.cleanPath(multipartFileAadhar.getOriginalFilename());
				String licenseDocument =StringUtils.cleanPath(multipartFileLicense. getOriginalFilename());
				String gstinDocument =StringUtils.cleanPath(multipartFileGstin.getOriginalFilename());
				String cicDocument=StringUtils.cleanPath(multipartFileCic. getOriginalFilename());
																 
				  
				  registeredDocuments.setSpDocName(documents);
				  registeredDocuments.setServiceProvider(serviceProvider);
				  System.out.println("register"+registeredDocuments);
				  RegisteredDocuments savedDocuments = documentsService.save(registeredDocuments);
				  System.out.println("working"+savedDocuments);
				  String uploadDir = "serviceProvider/" + savedDocuments.getServiceProvider().getSpId();
				  System.out.println("uploaddirectory"+uploadDir);
				 	FileUploadUtil.saveFile(uploadDir, panDocument, multipartFilePan);
				 	FileUploadUtil.saveFile(uploadDir, aadharDocument, multipartFileAadhar);
					FileUploadUtil.saveFile(uploadDir, licenseDocument, multipartFileLicense);
					FileUploadUtil.saveFile(uploadDir, gstinDocument, multipartFileGstin);
					FileUploadUtil.saveFile(uploadDir, cicDocument, multipartFileCic);
					 
		
		redirectAttributes.addFlashAttribute("message", "The user has been saved successfully");
		return "redirect:/user";
	}
	//Edit connection
		@RequestMapping("ServiceProviderList/edit/{id}")
		public ModelAndView editConn(@PathVariable(name = "id") long id,Model model) {
			
			
			
			ModelAndView editView = new ModelAndView("editServiceProviderForm");
			ServiceProvider serviceProvider = service.get(id);
			
			List<State> liststate = stateService.listAllState();
			model.addAttribute("liststate", liststate);
			
			List<District> listDistrict = districtService.listAllDistrict();
			model.addAttribute("listDistrict", listDistrict);
			
			List<Block> listBlock = blockService.listAllBlock();
			model.addAttribute("listBlock", listBlock);
			
			
			editView.addObject("serviceProvider", serviceProvider);		
			return editView;
		}
	
	

}
