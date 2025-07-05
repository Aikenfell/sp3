package com.controllers;

import java.time.LocalDate;
import java.util.List;
// import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
// import org.springframework.data.util.Optionals;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repositories.WatchlistRepository;
import com.repositories.WarehouseRepository;
// import com.repositories.WarehouseRepository;
import com.repositories.WatchlistSpecifications;
// import com.repositories.WarehouseRepository;
import com.models.Watchlist;
// import com.models.Warehouse;
import com.models.Warehouse;

  @CrossOrigin(origins = "*")
@RestController
public class watchlistController {

  // ...

  private final WatchlistRepository watchlistRepository;
  private final WarehouseRepository warehouseRepository;

  public watchlistController(WatchlistRepository watchlistRepository, WarehouseRepository warehouseRepository) {
    this.watchlistRepository = watchlistRepository;
    this.warehouseRepository = warehouseRepository;
  }

  // @GetMapping("/entityOneDynamicTest")
  // public List<warehouse> dynamicTest() {

  // return
  // this.warehouseRepository.findAll(EntityOneSpecifications.testingDynamics("propertyOneOne"));
  // }

  // @GetMapping("/entityOneDynamicComplex")
  // public List<warehouse> dynamicTestComplex() {
  // Specification<warehouse> spec = Specification.where(null);
  // final String propertyOne = "propertyOneOne";
  // final String propertyTwo = "propertyTwoOne";
  // final String propertyThree = null;
  // if (propertyOne != null && !propertyOne.isEmpty()) {
  // spec = spec.and(EntityOneSpecifications.testingDynamics(propertyOne));
  // }
  // if (propertyTwo != null && !propertyTwo.isEmpty()) {
  // spec = spec.and(EntityOneSpecifications.testingDynamicsComplex(propertyTwo));
  // }

  // return this.warehouseRepository.findAll(spec);
  // }

  // @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/watchlist/{userID}")
  public Iterable<Watchlist> findAllEntities(@PathVariable String userID) {
    return this.watchlistRepository.findByUserID(userID);
  }

  @PostMapping("/watchlist/{userID}/{videoID}")
  public Iterable<Watchlist> findWatchlistEntry(@PathVariable String userID, @PathVariable String videoID, @RequestBody Watchlist entity) {
    Optional<Watchlist> target = this.watchlistRepository.findByUserIDAndVideoID(userID,videoID);
    if (target.isPresent()) {
      Watchlist foundTarget = target.get();
      watchlistRepository.delete(foundTarget);

    }
    else{
            watchlistRepository.save(entity);
    }


    return this.watchlistRepository.findByUserID(userID);
  }

}