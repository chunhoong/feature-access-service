package com.chunhoong.featureaccessservice.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import com.chunhoong.featureaccessservice.service.FeatureAccessService;
import com.chunhoong.featureaccessservice.dto.FeatureAccessCreationDTO;
import com.chunhoong.featureaccessservice.dto.FeatureAccessRetrievalDTO;
import com.chunhoong.featureaccessservice.form.FeatureAccessCreationForm;
import com.chunhoong.featureaccessservice.form.FeatureAccessRetrievalForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature")
public class FeatureAccessAPI {

  private FeatureAccessService featureAccessSvc;

  @Autowired
  public FeatureAccessAPI(FeatureAccessService featureAccessSvc) {
    this.featureAccessSvc = featureAccessSvc;
  }

  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody FeatureAccessCreationForm form) {
    // @formatter:off
    FeatureAccessCreationDTO dto = new FeatureAccessCreationDTO()
      .setFeatureName(form.getFeatureName())
      .setEmail(form.getEmail())
      .setEnable(form.getEnable());
    // @formatter:on

    if (featureAccessSvc.hasExistingRecord(dto)) {
      return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    featureAccessSvc.createAccess(dto);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> get(@Valid FeatureAccessRetrievalForm form) {
    FeatureAccessRetrievalDTO dto = new FeatureAccessRetrievalDTO().setEmail(form.getEmail())
        .setFeatureName(form.getFeatureName());
    var body = new LinkedHashMap<String, Object>();
    body.put("canAccess", featureAccessSvc.getFeatureAccess(dto));
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

}