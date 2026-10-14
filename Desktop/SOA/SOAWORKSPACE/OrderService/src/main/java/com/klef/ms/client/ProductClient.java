package com.klef.ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.klef.ms.dto.ProductResponse;

@FeignClient(name = "ProductService")  //SPRING APPLICATION NAME

public interface ProductClient 
{
	@GetMapping("/product/display/{id}")
ProductResponse getProductById(@PathVariable Long id);
}
