package com.boot.camp2.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.camp2.entity.PolicyServiceEntity;
import com.boot.camp2.repository.PolicyServiceRepository;

   @Service
   public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyServiceRepository policyServiceRepository;
    
	@Override
	public PolicyServiceEntity addPolicy(PolicyServiceEntity policyServiceEntity) {
		return policyServiceRepository.save(policyServiceEntity);
    
   }
      @Override
	  public List<PolicyServiceEntity> findall() {
      List<PolicyServiceEntity> list = policyServiceRepository.findAll();
	  return list;
	}
  
       @Override
       public PolicyServiceEntity updatePolicy(PolicyServiceEntity policyServiceEntity) {
	   Optional<PolicyServiceEntity> PolicyService = policyServiceRepository
			   .findById(policyServiceEntity.getPolicyno());
	   if(PolicyService.isEmpty()) {
		   throw new NoSuchElementException("No data found for policy Id" + "PolicyService" + "in database"); 
	   }
	   return policyServiceRepository.save(policyServiceEntity);
   }
       
     @Override
     public void deletePolicyId(int policyId) {
    	 Optional<PolicyServiceEntity> policyServiceEntity = policyServiceRepository.findById(policyId);
    	 if(policyServiceEntity.isEmpty()) {
    		 throw new NoSuchElementException("no data found for Policy id " + policyId + "in database");
    	 }
    	 
     }
    

}
	


