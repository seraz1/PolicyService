package com.boot.camp2.service;

import java.util.List;

import com.boot.camp2.entity.PolicyServiceEntity;

public interface PolicyService {

	public PolicyServiceEntity addPolicy(PolicyServiceEntity policyServiceEntity);
	
	public List<PolicyServiceEntity>  findall();
	
	public PolicyServiceEntity updatePolicy (PolicyServiceEntity policyServiceEntity);

	void deletePolicyId(int policyId);

}
