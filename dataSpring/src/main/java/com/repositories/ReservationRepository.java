package com.repositories;
import com.models.Inventory;
import com.models.Reservation;
import com.models.Room;
import com.models.Warehouse;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>, JpaSpecificationExecutor<Reservation> {
    Optional<Reservation> findByid(Integer ID);


    List<Reservation> findAll();
    
    List<Reservation> findAllByRoom(Room room);
    
    List<Reservation> findAllByReserver(String reserver);
    
    List<Reservation> findByEndDateBefore(LocalDate endDate);
    List<Reservation> findByEndDateAfter(LocalDate endDate);

    List<Reservation> findByStartDateBefore(LocalDate startDate);
    List<Reservation> findByStartDateAfter(LocalDate startDate);

    // List<entityOne> findAllByPropertyOnes(){
    //         return this.findAll(EntityOneSpecifications.testingDynamics("lulz"));
    // };

    

//   Optionals findByPropertyOne(entityOne propertyOne);


}