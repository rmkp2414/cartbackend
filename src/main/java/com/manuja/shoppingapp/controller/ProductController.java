package com.manuja.shoppingapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.CategorySubType;
import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.service.CategorySubTypeService;
import com.manuja.shoppingapp.service.CategoryTypeService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.storage.StorageService;


@Controller
public class ProductController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    ProductService productService;
    
    @Autowired
    CategorySubTypeService categorySubTypeService;
    
    private final StorageService storageService;

	@Autowired
	public ProductController(StorageService storageService) {
		this.storageService = storageService;
	}
	
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    //private static String UPLOAD_FOLDER = "/var/www/upload/";
    //private static String UPLOAD_FOLDER = "\\META-INF.resources\\imgs\\";
    private static String UPLOAD_FOLDER = "src//web//images//";
    
    @GetMapping("/adminPortal/products")
    public String adminProducts(ModelMap modelMap) {
    	logger.info("Running Admin portal products GET API Call..");
    	
    	 List<ProductDetailsDto> products = productService.getAllProducts();
         modelMap.addAttribute("products",products);
    	 return "AdminProducts";      
    }
    
    @GetMapping("/adminPortal/addProduct")
    public String adminAddProduct(ModelMap modelMap) {
    	logger.info("Running Admin portal add products GET API Call..");
    	
    	 List<ProductDetailsDto> products = productService.getAllProducts();
    	 List<CategoryDto> categories = categoryTypeService.getAllCategories();
         modelMap.addAttribute("products",products);
         modelMap.addAttribute("categories",categories);
    	 return "AddProduct";      
    }
    
    @PostMapping("/adminPortal/addProductSubmit")
    public String addProductSubmit(@ModelAttribute ProductDetailsDto productDetailsDto, ModelMap modelMap) {
    	logger.info("Running addProductSubmit POST API Call..");
    	logger.info("Add Product Submit with details..." + productDetailsDto.getName() + " | " + productDetailsDto.getDescription()); 
    	ResponseDto responseDto = productService.createProduct(productDetailsDto);
    	//UserDto userDto = loginService.login(loginDto);
    	if(responseDto.getStatus()) {
    		List<ProductDetailsDto> products = productService.getAllProducts();
            modelMap.addAttribute("products",products);
            return "AdminProducts";
    	}else {
    		return "AddProduct";
    	}
    }
    
    
    
    @GetMapping("/adminPortal/updateProduct/{id}")
    public String updateProduct(@PathVariable String id, ModelMap modelMap) {
    	logger.info("Running updateProduct GET API Call..");
    	logger.info("Update Product with id :" + id); 
    	ResponseDto responseDto = productService.getProductById(id);
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
        
    	//UserDto userDto = loginService.login(loginDto);
    	if(responseDto.getStatus()) {
    		logger.info("Product data taken from DB with id :" + id); 
            modelMap.addAttribute("product",responseDto.getData());
            modelMap.addAttribute("categories",categories);
            return "UpdateProduct";
    	}else {
    		List<ProductDetailsDto> products = productService.getAllProducts();
            modelMap.addAttribute("products",products);
            return "AdminProducts";
    	}
    }
    
    @PostMapping("/adminPortal/updateProductSubmit")
    public String updateProductSubmit(@ModelAttribute ProductDetailsDto productDetailsDto, ModelMap modelMap) {
    	logger.info("Running updateProductSubmit POST API Call..");
    	logger.info("Update Product Submit with details..." + productDetailsDto.getName() + " | " + productDetailsDto.getDescription()); 
    	ResponseDto responseDto = productService.updateProduct(productDetailsDto);
    	//UserDto userDto = loginService.login(loginDto);
    	if(responseDto.getStatus()) {
    		List<ProductDetailsDto> products = productService.getAllProducts();
    		modelMap.addAttribute("products",products);
    		return "AdminProducts";
    	}else {
    		modelMap.addAttribute("product",responseDto.getData());
            return "UpdateProduct";
    	}
    }
    
    @GetMapping("/adminPortal/deleteProduct/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id, ModelMap modelMap) {
    	logger.info("Running deleteProduct GET API Call..");
    	logger.info("Deleting Product with id :" + id); 
    	ResponseDto responseDto = productService.deleteProduct(id);
    	List<ProductDetailsDto> products = productService.getAllProducts();
        modelMap.addAttribute("products",products);
        modelMap.addAttribute("deletedMessage",responseDto.getStatusMessage());
        return new ModelAndView("redirect:" + "/adminPortal/products"); 
    }
    
    @RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}
    
    
    @PostMapping("/upload")
	public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		logger.info("uoloaded..."); 
		return new ModelAndView("status", "message", "File Uploaded sucessfully");
	}
    
    @PostMapping("/uploadssss")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    	logger.info("Upload called.."); 
		if (file.isEmpty()) {
			return new ModelAndView("status", "message", "Please select a file and try again");
		}

			
			
			InputStream inputStream = null;
	        OutputStream outputStream = null;
	        //MultipartFile file = file;
	        String fileName = file.getOriginalFilename();
	        File newFile = new File("//WEB-INF//jsp/nadeeshan//" + "nadee.jpg");

	        try {
	            inputStream = file.getInputStream();

	            if (!newFile.exists()) {
	            	//new File("/path/directory").mkdirs()
	                newFile.mkdirs();
	            }
	            outputStream = new FileOutputStream(newFile);
	            int read = 0;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }
	            
	            logger.info("uoloaded..."); 
	        } catch (IOException e) {
	        	logger.info("failed..."); 
	            e.printStackTrace();
	        }

	       // return newFile.getAbsolutePath();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			final String imagePath = "classpath:images"; //path
//	        FileOutputStream output = new FileOutputStream(imagePath+file.getOriginalFilename());
//	        logger.info("output path..." + file.getAbsolutePath()); 
//	        
//	        output.write(file.getBytes());

	        
	        
			// read and write the file to the selected location-
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get("classpath:images" + "nadee.jpg");
//			Files.write(path, bytes);
			
		

		return new ModelAndView("status", "message", "File Uploaded sucessfully");
	}
    
    
    
    
    
    
    
    
    
    
    

    @GetMapping("/shop/product/{id}")
    public String signUp(ModelMap model, @PathVariable String id) {
    	logger.info("Running Product GET API Call..");
    	ResponseDto productStatus = productService.getProductById(id);
    	if(productStatus.getStatus()) {
    		logger.info("Found product..");
    		model.addAttribute("userId", USER_ID);
    		model.addAttribute("productDetails",productStatus.getData());
    		return "ViewProduct";
    	}else {
    		logger.info("No product found..");
    		return "NoProductPage";
    	}
    	
    }
    
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public String loadProductForm(ModelMap modelMap){
        Product product = new Product();
        modelMap.addAttribute("productObj",product);

        List<Product>products = productService.findAll();
        modelMap.addAttribute("products",products);

        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
        modelMap.addAttribute("saveFlag",true);
        return "Product";
    }
    
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public String saveProduct(Product product, ModelMap modelMap){
        productService.Save(product);

        Product product1 = new Product();
        modelMap.addAttribute("productObj",product1);

        List<Product>products = productService.findAll();
        modelMap.addAttribute("products",products);

        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
        modelMap.addAttribute("saveFlag",true);
        return "Product";
    }
    
    
    
    @RequestMapping(value = "/edit-Product-{id}",method = RequestMethod.GET)
    public  String editProduct(ModelMap modelMap, @PathVariable String id){
        Integer Id = Integer.parseInt(id);
        Product product = productService.FindById(Id);
        modelMap.addAttribute("productObj",product);

        List<Product>products = productService.findAll();
        modelMap.addAttribute("products",products);

        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
        modelMap.addAttribute("saveFlag",false);
        return "Product";
    }
    @RequestMapping(value = "/edit-Product-{id}",method = RequestMethod.POST)
    public  String updateProduct(ModelMap modelMap, Product product){
        productService.Update(product);

        Product product1 = new Product();
        modelMap.addAttribute("productObj",product1);

        List<Product>products = productService.findAll();
        modelMap.addAttribute("products",products);

        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
        modelMap.addAttribute("saveFlag",true);
        return "Product";
    }
//    @RequestMapping(value = "/delete-Product-{id}",method = RequestMethod.GET)
//    public  String deleteProduct(@PathVariable String id, ModelMap modelMap){
//        Integer Id = Integer.parseInt(id);
//        Product product = productService.FindById(Id);
//        productService.Delete(product);
//
//        Product product1 = new Product();
//        modelMap.addAttribute("productObj",product1);
//
//        List<Product>products = productService.findAll();
//        modelMap.addAttribute("products",products);
//
//        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
//        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
//        modelMap.addAttribute("saveFlag",true);
//        return "Product";
//    }
}
