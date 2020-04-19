package com.chunhoong.featureaccessservice.service;

import com.chunhoong.featureaccessservice.entity.FeatureAccess;
import com.chunhoong.featureaccessservice.dto.FeatureAccessCreationDTO;
import com.chunhoong.featureaccessservice.dto.FeatureAccessRetrievalDTO;
import com.chunhoong.featureaccessservice.exception.ResourceNotFoundException;
import com.chunhoong.featureaccessservice.repository.FeatureAccessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureAccessService {

  private FeatureAccessRepository featureAccessRepo;

  @Autowired
  public FeatureAccessService(FeatureAccessRepository featureAccessRepo) {
    this.featureAccessRepo = featureAccessRepo;
  }

  public void createAccess(FeatureAccessCreationDTO dto) {
    featureAccessRepo.saveAndFlush(new FeatureAccess()
      .setEmail(dto.getEmail())
      .setFeatureName(dto.getFeatureName())
      .setEnable(dto.isEnable())
    );
  }

  public boolean getFeatureAccess(FeatureAccessRetrievalDTO dto) {
    String email = dto.getEmail();
    String featureName = dto.getFeatureName();
    return featureAccessRepo.findOneByEmailAndFeatureName(email, featureName)
      .orElseThrow(ResourceNotFoundException::new)
      .isEnable();
  }

  public boolean hasExistingRecord(FeatureAccessCreationDTO dto) {
    var email = dto.getEmail();
    var featureName = dto.getFeatureName();
    return featureAccessRepo.findOneByEmailAndFeatureName(email, featureName).isPresent();
  }


}