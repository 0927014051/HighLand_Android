package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Category;
import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.entity.Product;
import com.javaweb.exception.ProductException;
import com.javaweb.reponsitory.CategoryRepo;
import com.javaweb.reponsitory.PriceUpdateRepo;
import com.javaweb.reponsitory.ProductRepo;
import com.javaweb.request.CreateProductRequest;
import com.javaweb.service.ProductService;
import com.javaweb.service.UserService;

@Service
public class ProductServiceImpl implements ProductService{
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int CODE_LENGTH = 6;
	private ProductRepo productRepo;
	private PriceUpdateRepo priceUpdateRepo;

	public ProductServiceImpl(ProductRepo productRepo,PriceUpdateRepo priceUpdateRepo) {
		this.productRepo = productRepo;
		this.priceUpdateRepo = priceUpdateRepo;
		
	}
	
	@Override
	public Product createProduct(CreateProductRequest req) {
		List<Product> listProducts = productRepo.findAll();
		String productIdGeneration = generateProductCode();
		while(isProductCodeExists(listProducts, productIdGeneration)) {
			productIdGeneration = generateProductCode();
		}
		Product product = new Product();
		product.setProduct_id(productIdGeneration);
		product.setCategory_id(req.getCategory_id());
		product.setCreated_at(LocalDateTime.now());
		product.setDescription(req.getDescription());
		product.setImage(req.getImage());
		product.setProduct_name(req.getProduct_name());
		product.setStatus(req.getStatus());
		product.setUpdated_at(LocalDateTime.now());	
		product.setCreated_by(req.getStaff_id());
		product.setUpdated_by(req.getStaff_id());
		Product savedProduct = productRepo.save(product);
		if(savedProduct != null) {
			PriceUpdateDetail priceUpdateDetail = new PriceUpdateDetail();
			priceUpdateDetail.setCreated_at(LocalDateTime.now());
			priceUpdateDetail.setCreated_by(req.getStaff_id());
			priceUpdateDetail.setUpdated_by(req.getStaff_id());
			priceUpdateDetail.setPrice_new(req.getPrice());
			priceUpdateDetail.setPrice_old(req.getPrice());
			priceUpdateDetail.setProduct_id(savedProduct.getProduct_id());
			priceUpdateDetail.setUpdated_at(LocalDateTime.now());
			PriceUpdateDetail savePriceUpdateDetail = priceUpdateRepo.save(priceUpdateDetail);
		}
		return savedProduct;
	}
	
	@Override
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	  public static boolean isProductCodeExists(List<Product> productList, String productCode) {
	        for (Product product : productList) {
	            if (product.getProduct_id().equals(productCode)) {
	                return true;
	            }
	        }
	        return false;
	    }
	  
	  @Override
	  public Product updateProduct(String productId,Product rq,Long staff_id)throws ProductException{
		  Product product = findProductById(productId);
		  if(!rq.getDescription().equals(null)) {
			  product.setDescription(rq.getDescription());
		  }
		  if(!rq.getImage().equals(null)) {
			  product.setImage(rq.getImage());
		  }
		  if(rq.getCategory_id() != null) {
			  product.setCategory_id(rq.getCategory_id());
		  }
		  if(!rq.getProduct_name().equals(null)) {
			  product.setProduct_name(rq.getProduct_name());
		  }
		  if(staff_id != null) {
			  product.setUpdated_by(staff_id);
		  }
		  product.setUpdated_at(LocalDateTime.now());
		  return productRepo.save(product);
	  }
	  
	  @Override
	  public Product findProductById(String id) throws ProductException {
	      Optional<Product> optionalProduct = productRepo.findById(id);
	      if (optionalProduct.isPresent()) {
	          System.err.println("find product");
	          return optionalProduct.get();
	      }
	      throw new ProductException("Product not found with id " + id);
	  }
	  
	  @Override
	  public String deleteProduct(String productId,Long staff_id) throws ProductException{
		  Product product = findProductById(productId);
		  System.err.println("delete product " + product.getProduct_id() + " - " + productId);
		  product.setStatus(1);
		  product.setUpdated_by(staff_id);
		  productRepo.save(product);
		  return "Stopped Selling Success";
	  }
	  
	  @Override
	  public List<Product> findProductByCategory(String category){
		  System.err.println("category name --> " + category);
		  List<Product> products = productRepo.findByCategory(category);
		  return products;
	  }
	 public static String generateProductCode() {
	        Random random = new Random();
	        StringBuilder codeBuilder = new StringBuilder();

	        for (int i = 0; i < CODE_LENGTH; i++) {
	            char randomChar = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
	            codeBuilder.append(randomChar);
	        }

	        return codeBuilder.toString();
	    }

}
