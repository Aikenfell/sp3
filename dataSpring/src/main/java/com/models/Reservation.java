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
@Table(name = "reservation")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private LocalDate startDate;

  private LocalDate endDate;

  private String reserver;


  @ManyToOne()
  @JoinColumn(name = "room", referencedColumnName = "id", nullable = false)
  private Room room;


  // Hibernate expects entities to have a no-arg constructor,
  // though it does not necessarily have to be public.  
  private Reservation() {
  }

  public Reservation(LocalDate startDate, LocalDate endDate, String reserver) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.reserver = reserver;
  }

  public Integer getId() {
    return this.id;
  }

  public Room getRoom() {
    return this.room;
  }

  public LocalDate getStartDate() {
    return this.startDate;
  }

  public LocalDate getEndDate() {
    return this.endDate;
  }

  public String getReserver() {
    return this.reserver;
  }

  public void setRoom(Room room){
  this.room = room;}

  public void setStartDate(LocalDate startDate){
  this.startDate = startDate;}

  public void setEndDate(LocalDate endDate){
  this.endDate = endDate;}

  public void setReserver(String reserver){
  this.reserver = reserver;}

}