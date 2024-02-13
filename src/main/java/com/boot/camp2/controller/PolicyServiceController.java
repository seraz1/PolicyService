package com.boot.camp2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.camp2.entity.PolicyServiceEntity;
import com.boot.camp2.service.PolicyService;

@RestController
public class PolicyServiceController {

	@Autowired
	public PolicyService policyService;

	@PostMapping("/savePolicy")
   	public PolicyServiceEntity addPolicy(@RequestBody PolicyServiceEntity policyServiceEntity){
		return policyService.addPolicy(policyServiceEntity);
		
 }
	
	@GetMapping("/findall")
	public List<PolicyServiceEntity>  findallPolicy() {
		return policyService.findall();
	}

	@PutMapping("/updatepolicy")
	public ResponseEntity<PolicyServiceEntity> updatePolicy(@RequestBody PolicyServiceEntity policyServiceIntity){
		PolicyServiceEntity policytest = new PolicyServiceEntity();
		try {
			policytest = policyService.updatePolicy(policyServiceIntity);
			return ResponseEntity.of(Optional.of(policytest));
		}catch (NoSuchElementException e) {
		  Map<String,String> responseBody = new HashMap<>();
		  responseBody.put("error",e.getMessage());
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
     	   @DeleteMapping("/deletePolicyId")
	       public ResponseEntity<?>deletePolicy(@RequestParam(value = "userId") int policyId){
			try {
				policyService.deletePolicyId(policyId);
				return ResponseEntity.status(HttpStatus.OK).build();
			}catch (NoSuchElementException e) {
				Map<String,String> responseBody = new HashMap<>();
				responseBody.put("error", e.getMessage());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
				
			}
		}

	}
    
	









