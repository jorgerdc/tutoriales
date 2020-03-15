/**
 * Project.java
 * Creation Date: 17/07/2018, 18:47:12
 *
 * Copyright (C) The Project *properties-spring-boot* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot.entity;

import java.net.URL;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This class defines a simple bean (POJO) which is used to show how can inject
 * attribute values using the spring boot properties mechanism. All the attribute names
 * match with a property name. See /config/application.properties file.
 */
// add this bean to the application context
@Component
@ConfigurationProperties(prefix = "app.project")
public class Project {

  private String name;

  private Long projectId;

  private URL url;

  private boolean active;

  private Person owner;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the projectId
   */
  public Long getProjectId() {
    return projectId;
  }

  /**
   * @param projectId the projectId to set
   */
  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  /**
   * @return the url
   */
  public URL getUrl() {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(URL url) {
    this.url = url;
  }

  /**
   * @return the active
   */
  public boolean isActive() {
    return active;
  }

  /**
   * @param active the active to set
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * @return the owner
   */
  public Person getOwner() {
    return owner;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  /*
   * See the original documentation of the method declaration
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Project [name=");
    builder.append(name);
    builder.append(", projectId=");
    builder.append(projectId);
    builder.append(", url=");
    builder.append(url);
    builder.append(", active=");
    builder.append(active);
    builder.append(", owner=");
    builder.append(owner);
    builder.append("]");
    return builder.toString();
  }

}
