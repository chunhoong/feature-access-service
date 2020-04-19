package com.chunhoong.featureaccessservice.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FeatureAccessRetrievalForm {

  @NotBlank(message = "Feature name cannot be blank")
  private String featureName;

  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Email must be in valid format")
  private String email;

}