package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Feed {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String title;

  private String description;
  
  private String publication;
  
  private String img;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getPublication() {
	    return publication;
	  }

   public void setPublication(String publication) {
	    this.publication = publication;
	  }
   
   public String getImg() {
	    return img;
	  }

  public void setImg(String img) {
	    this.img = img;
	  }
}
