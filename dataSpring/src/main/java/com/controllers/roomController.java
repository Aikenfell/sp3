package com.controllers;

// import java.util.List;
import java.util.Optional;

// import org.springframework.data.jpa.domain.Specification;
// import org.springframework.data.util.Optionals;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repositories.RoomRepository;
// import com.repositories.EntityOneSpecifications;
// import com.repositories.RoomRepository;
import com.models.Room;

  @CrossOrigin(origins = "*")
@RestController
public class roomController {

  // ...

  private final RoomRepository roomRepository;

  public roomController(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  // @GetMapping("/entityOneDynamicTest")
  // public List<room> dynamicTest() {

  // return
  // this.roomRepository.findAll(EntityOneSpecifications.testingDynamics("propertyOneOne"));
  // }

  // @GetMapping("/entityOneDynamicComplex")
  // public List<room> dynamicTestComplex() {
  // Specification<room> spec = Specification.where(null);
  // final String propertyOne = "propertyOneOne";
  // final String propertyTwo = "propertyTwoOne";
  // final String propertyThree = null;
  // if (propertyOne != null && !propertyOne.isEmpty()) {
  // spec = spec.and(EntityOneSpecifications.testingDynamics(propertyOne));
  // }
  // if (propertyTwo != null && !propertyTwo.isEmpty()) {
  // spec = spec.and(EntityOneSpecifications.testingDynamicsComplex(propertyTwo));
  // }

  // return this.roomRepository.findAll(spec);
  // }

  @GetMapping("/rooms")
  public Iterable<Room> findAllEntities() {
    return this.roomRepository.findAll();
  }

 @PostMapping(value = "/room", consumes = { "*/*" })
  public Room addOneEntity(@RequestBody Room entity) {
    entity.setAvailable(true);

    return roomRepository.save(entity);
  }
  @GetMapping("/room/{ID}")
  public Optional<Room> getEntityById(@PathVariable Integer ID) {
    // Optional<Room> target = this.roomRepository.findById(ID);
    // Integer retSum = 0;
    //     if (target.isPresent()) {
    //       Room foundTarget = target.get();
    //       retSum = this.roomRepository.getQuantitySum(ID);
    //       foundTarget.setOccupied(retSum);
    //       roomRepository.save(foundTarget);
    //     }

    // Optional<entityOne> entityOne =
    // this.roomRepository.findByPropertyOne(propertyOne);

    return this.roomRepository.findById(ID);
  }

//   @GetMapping("/room/{ID}/del")
//   public void delEntityById(@PathVariable Integer ID) {
//     Optional<Room> target = this.roomRepository.findById(ID);
//         if (target.isPresent()) {
//           Room foundTarget = target.get();
//           roomRepository.delete(foundTarget);
//         }
//   }

//   @GetMapping("/roomNum/{ID}")
//   public Integer getInventorySum(@PathVariable Integer ID) {
//     Optional<Room> target = this.roomRepository.findById(ID);
//     Integer retSum = 0;
//         if (target.isPresent()) {
//           Room foundTarget = target.get();
//           retSum = this.roomRepository.getQuantitySum(ID);
//           foundTarget.setOccupied(retSum);
//           roomRepository.save(foundTarget);
//         }
//     // Optional<entityOne> entityOne =
//     // this.roomRepository.findByPropertyOne(propertyOne);

//     return retSum;
//   }




  


//   @PostMapping(value = "/room/{ID}", consumes = { "*/*" })
//   public Optional<Room> modifyWareHouseByID(@PathVariable Integer ID, @RequestBody Room entity) {
//     Optional<Room> target = this.roomRepository.findById(ID);
//     // Optional<entityOne> entityOne =
//     // this.roomRepository.findByPropertyOne(propertyOne);
//     if (target.isPresent()) {
//       // Modify the fields of the entity object
//       Room foundTarget = target.get();
//       String newLocation = entity.getLocation();
//       String newName = entity.getName();
//       Integer newLimit = entity.getLimitWarning();
//       foundTarget.setLocation(newLocation);
//       foundTarget.setName(newName);
//       foundTarget.setLimitWarning(newLimit);

//       // Save the entity
//       roomRepository.save(foundTarget);
//     }

//     return target;
//   }

}