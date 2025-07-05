package com.models;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String type;

  private Integer beds;

  private Integer occupants;

  private Integer price;

  private Boolean available;

  @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
  private List<Reservation> reservations;

  private Room() {
  }

  public Room(String name, String type, Integer beds, Integer occupants, Integer price, Boolean available) {
    this.name = name;
    this.type = type;
    this.price = price;
    this.beds = beds;
    this.occupants = occupants;
    this.available = available;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setBeds(Integer beds) {
    this.beds = beds;
  }

  public Integer getBeds() {
    return this.beds;
  }

  public void setOccupants(Integer occupants) {
    this.occupants = occupants;
  }

  public Integer getOccupants() {
    return this.occupants;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public Boolean getAvailable() {
    return this.available;
  }

  // public void setName(String name) {
  //   this.name = name;
  // }

  // public String getName() {
  //   return this.name;
  // }

  // public void setName(String name) {
  //   this.name = name;
  // }

}