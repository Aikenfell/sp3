package com.repositories;
import com.models.Inventory;
import com.models.Warehouse;
import com.models.Watchlist;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer>, JpaSpecificationExecutor<Watchlist> {
    Optional<Watchlist> findByid(Integer ID);


    List<Watchlist> findByUserID(String userID);

    Optional<Watchlist> findByUserIDAndVideoID(String userID,String videoID);

    // List<entityOne> findAllByPropertyOnes(){
    //         return this.findAll(EntityOneSpecifications.testingDynamics("lulz"));
    // };

    

//   Optionals findByPropertyOne(entityOne propertyOne);


}