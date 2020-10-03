package com.manuja.shoppingapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.entity.ProductItemPIcture;
import com.manuja.shoppingapp.repository.ProductItemPictureRepository;
import com.manuja.shoppingapp.storage.StorageFileNotFoundException;
import com.manuja.shoppingapp.storage.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	
	@Autowired
	private ProductItemPictureRepository productItemPictureRepository;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {
		return "start";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

//	@PostMapping("/")
	
	
	@RequestMapping(value = "/adminPortal/imageDelete/{productId}/{fileId}", method = RequestMethod.GET)
	public ModelAndView deleteImage(@PathVariable String fileId,@PathVariable String productId,ModelMap modelMap) throws IOException {

		Optional<ProductItemPIcture> tempList =productItemPictureRepository.findById(Integer.valueOf(fileId));
		
		if(tempList.isPresent()) {
			ProductItemPIcture temp = tempList.get();
			File fileDirect = new File("C:\\wamp\\www\\shoplingAppImages\\"+temp.getPicture());
        if(fileDirect.exists()) {
        	if(fileDirect.delete()) {
        		System.out.println("file deleted");
        		productItemPictureRepository.deleteById(temp.getId());
        	}else {
        		System.out.println("file deleted22222");
        	}
        }else {
        	System.out.println("file deleted3333333");
        }
		}else {
			System.out.println("file not present");
		}
		
        return new ModelAndView("redirect:" + "/adminPortal/uploadImages/"+productId); 
    }
	
	private void deleteFileByName(String fileName) {
		
		File fileDirect = new File("C:\\wamp\\www\\shoplingAppImages\\"+fileName);
        if(fileDirect.exists()) {
        	if(fileDirect.delete()) {
        		System.out.println("file deleted");
        	}else {
        		System.out.println("file deleted22222");
        	}
        }else {
        	System.out.println("file deleted3333333");
        }
	}

	@GetMapping("/adminPortal/uploadImages/{productId}")
    public String uploadImages(@PathVariable Integer productId,Model model) {
		model.addAttribute("productId", productId);
		List<ProductItemPIcture> fileNames = productItemPictureRepository.getProductItemPIctureList(productId);

		switch (fileNames.size()) {
		case 0:
			model.addAttribute("image1", "");
			model.addAttribute("image2", "");
			model.addAttribute("image3", "");
			model.addAttribute("image4", "");
			model.addAttribute("path1", "");
			model.addAttribute("path2", "");
			model.addAttribute("path3", "");
			model.addAttribute("path4", "");
			break;
		case 1:
			model.addAttribute("image1", fileNames.get(0).getPicture());
			model.addAttribute("image2", "");
			model.addAttribute("image3", "");
			model.addAttribute("image4", "");
			model.addAttribute("path1", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(0).getId());
			model.addAttribute("path2", "");
			model.addAttribute("path3", "");
			model.addAttribute("path4", "");
			break;
		case 2:
			model.addAttribute("image1",  fileNames.get(0).getPicture());
			model.addAttribute("image2",  fileNames.get(1).getPicture());
			model.addAttribute("image3", "");
			model.addAttribute("image4", "");
			model.addAttribute("path1", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(0).getId());
			model.addAttribute("path2", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(1).getId());
			model.addAttribute("path3", "");
			model.addAttribute("path4", "");
			break;
		case 3:
			model.addAttribute("image1",  fileNames.get(0).getPicture());
			model.addAttribute("image2",  fileNames.get(1).getPicture());
			model.addAttribute("image3",  fileNames.get(2).getPicture());
			model.addAttribute("image4", "");
			model.addAttribute("path1", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(0).getId());
			model.addAttribute("path2", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(1).getId());
			model.addAttribute("path3", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(2).getId());
			model.addAttribute("path4", "");
			break;
		case 4:
			model.addAttribute("image1",  fileNames.get(0).getPicture());
			model.addAttribute("image2",  fileNames.get(1).getPicture());
			model.addAttribute("image3",  fileNames.get(2).getPicture());
			model.addAttribute("image4",  fileNames.get(3).getPicture());
			model.addAttribute("path1", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(0).getId());
			model.addAttribute("path2", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(1).getId());
			model.addAttribute("path3", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(2).getId());
			model.addAttribute("path4", "/adminPortal/imageDelete/"+productId+"/"+fileNames.get(3).getId());
			break;

		default:
			model.addAttribute("image1", "");
			model.addAttribute("image2", "");
			model.addAttribute("image3", "");
			model.addAttribute("image4", "");
			break;
		}
    	return "upload";
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminPortal/imageUpload/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String handleFileUpload(
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,
			@RequestParam("file3") MultipartFile file3,
			@RequestParam("file4") MultipartFile file4,
			@PathVariable Integer productId,
			RedirectAttributes redirectAttributes) {
		MultipartFile arra [] = {file1,file2,file3,file4}; 
		List<ProductItemPIcture> itemList = productItemPictureRepository.getProductItemPIctureList(Integer.valueOf(productId));
		for(int i=0;i<4;i++) {
			if(!arra[i].isEmpty()) {
				String fileName = storageService.saveFile(arra[i]);
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + fileName + "!");
				
				Product product = new Product();
				product.setId(productId);
				ProductItemPIcture pIcture = new ProductItemPIcture();
				pIcture.setProductItemId(product);
				pIcture.setPicture(fileName);
				if(itemList.size() > i) {
					pIcture.setId(itemList.get(i).getId());
					deleteFileByName(itemList.get(i).getPicture());
				}
				productItemPictureRepository.save(pIcture);
			}
		}
		return "redirect:/adminPortal/products";
	}
	
	
	@RequestMapping(value = "/adminPortal/image/get/{filename}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("C:/wamp/www/shoplingAppImages/"+filename);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
    
    @RequestMapping(value = "/image/get/list/{product_id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<List<String>> getImageList(@PathVariable String product_id) throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(productItemPictureRepository.getProductItemPIctureNameList(Integer.valueOf(product_id)));
    }
	
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
