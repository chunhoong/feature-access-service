package com.chunhoong.featureaccessservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureAccessRepository extends JpaRepository<FeatureAccess, Long> {

  public Optional<FeatureAccess> findOneByEmailAndFeatureName(String email, String featureName);

}