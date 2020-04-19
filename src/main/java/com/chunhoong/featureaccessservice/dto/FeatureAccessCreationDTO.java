package com.chunhoong.featureaccessservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FeatureAccessCreationDTO {

  private String featureName;
  private String email;
  private boolean enable;

}