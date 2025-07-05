package com.models;

import java.time.LocalDate;
import com.models.Warehouse;

import jakarta.annotation.Nullable;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "watchlist")
public class Watchlist {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String videoID;

  private String userID;

  private String name;

  private String type;

  // Hibernate expects entities to have a no-arg constructor,
  // though it does not necessarily have to be public.  
  private Watchlist() {
  }

  public Watchlist(String videoID, String userID, String name, String type) {
    this.videoID = videoID;
    this.userID = userID;
    this.name = name;
    this.type = type;
  }

  public Integer getId() {
    return this.id;
  }

  public String getVideoID() {
    return this.videoID;
  }

  public String getUserID() {
    return this.userID;
  }

  public void setVideoID(String videoID) {
    this.videoID = videoID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }


  // public Integer getCapacity() {
  // return this.capacity;
  // }

  // public float getLimitWarning() {
  // return this.limitWarning;
  // }
}