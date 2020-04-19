package com.chunhoong.featureaccessservice.entity;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Accessors(chain = true)
@Table(name = "feature_access")
@Entity
public class FeatureAccess {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  @Column(name = "feature_name")
  private String featureName;

  @Column(name = "email")
  private String email;

  @Column(name = "enable")
  private boolean enable;

}