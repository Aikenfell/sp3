package com.repositories;
import com.models.Room;
import com.models.Warehouse;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {
    Optional<Room> findByName(String name);

    List<Room> findAll();


    // @Query(value = "SELECT sum(quantity) from inventory where warehouse=:warehouse", nativeQuery = true)
    // Integer getQuantitySum(@Param("warehouse") Integer warehouse);    
    // List<entityOne> findAllByPropertyOnes(){
    //         return this.findAll(EntityOneSpecifications.testingDynamics("lulz"));
    // };

    

//   Optionals findByPropertyOne(entityOne propertyOne);


}