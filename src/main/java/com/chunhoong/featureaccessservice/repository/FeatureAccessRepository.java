package com.chunhoong.featureaccessservice.repository;

import java.util.Optional;

import com.chunhoong.featureaccessservice.entity.FeatureAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureAccessRepository extends JpaRepository<FeatureAccess, Long> {

  public Optional<FeatureAccess> findOneByEmailAndFeatureName(String email, String featureName);

}