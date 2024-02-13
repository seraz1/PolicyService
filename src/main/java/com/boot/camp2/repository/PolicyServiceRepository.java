package com.boot.camp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.camp2.entity.PolicyServiceEntity;

   @Repository
   public interface PolicyServiceRepository extends JpaRepository<PolicyServiceEntity, Integer>{

}

