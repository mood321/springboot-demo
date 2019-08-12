package com.mood.productviewservicefeign.client;

import com.mood.productviewservicefeign.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = UserClientHystrix.class)
public interface UsersClientFeign {

	@GetMapping("/getAll")
	public List<Users> getAll();
}
