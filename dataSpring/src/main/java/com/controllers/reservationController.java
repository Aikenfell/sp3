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

import com.repositories.ReservationRepository;
import com.repositories.RoomRepository;
import com.repositories.UserRepository;
// import com.repositories.RoomRepository;
import com.repositories.ReservationSpecifications;
// import com.repositories.RoomRepository;
import com.models.Reservation;
// import com.models.Room;
import com.models.Room;
import com.models.User;

@CrossOrigin(origins = "*")
@RestController
public class reservationController {

  // ...

  private final ReservationRepository reservationRepository;
  private final RoomRepository roomRepository;
  private final UserRepository userRepository;

  public reservationController(ReservationRepository reservationRepository, RoomRepository roomRepository,
      UserRepository userRepository) {
    this.reservationRepository = reservationRepository;
    this.roomRepository = roomRepository;
    this.userRepository = userRepository;
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

  // @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/reservations/{Email}")
  public Iterable<Reservation> findAllEntities(@PathVariable String Email) {
    Optional<User> targetUser = this.userRepository.findByEmail(Email);
    String perms = "";
    if (targetUser.isPresent()) {
      User foundTarget = targetUser.get();
      perms = foundTarget.getUserType();
    }
    if (perms == "Admin"){

    return this.reservationRepository.findAllByReserver(Email);
    }
    else{
    return this.reservationRepository.findAll();

    }

  }

  @PostMapping(value = "/reserve/{ID}", consumes = { "*/*" })
  public Reservation addOneEntity(@PathVariable Integer ID, @RequestBody Reservation entity) {

    Optional<Room> target = this.roomRepository.findById(ID);
    // Integer retSum = 0;
    if (target.isPresent()) {
      // Modify the fields of the entity object
      Room foundTarget = target.get();
      entity.setRoom(foundTarget);
      reservationRepository.save(entity);

      // retSum = this.roomRepository.getQuantitySum(ID);
      // foundTarget.setOccupied(retSum);
      roomRepository.save(foundTarget);

    }

    return entity;
  }

  // @GetMapping("/item/{ID}")
  // public Optional<Reservation> getEntityById(@PathVariable Integer ID) {

  // // Optional<entityOne> entityOne =
  // // this.roomRepository.findByPropertyOne(propertyOne);

  // return this.reservationRepository.findByid(ID);
  // }

  // @GetMapping("/item/{ID}/del")
  // public void delEntityById(@PathVariable Integer ID) {

  // // Optional<entityOne> entityOne =
  // // this.roomRepository.findByPropertyOne(propertyOne);
  // Optional<Reservation> target = this.reservationRepository.findById(ID);
  // if (target.isPresent()) {
  // Reservation foundTarget = target.get();
  // reservationRepository.delete(foundTarget);

  // }
  // }

  // @PostMapping("/item/{ID}")
  // public Optional<Reservation> modifyEntityById(@PathVariable Integer ID,
  // @RequestBody Reservation entity) {

  // Optional<Reservation> target = this.reservationRepository.findById(ID);
  // if (target.isPresent()) {
  // // Modify the fields of the entity object
  // Reservation foundTarget = target.get();
  // String newDescription = entity.getDescription();
  // Integer newQuantity = entity.getQuantity();
  // LocalDate newDate = entity.getExpiryDate();
  // String newLocation = entity.getLocation();
  // foundTarget.setDescription(newDescription);
  // foundTarget.setQuantity(newQuantity);
  // foundTarget.setExpiryDate(newDate);
  // foundTarget.setLocation(newLocation);

  // reservationRepository.save(foundTarget);
  // }

  // return target;
  // }

  // @PostMapping("/itemTransfer/{ID}/{Target}")
  // public Optional<Reservation> moveItem(@PathVariable Integer ID, @PathVariable
  // Integer Destination) {

  // Optional<Reservation> target = this.reservationRepository.findById(ID);
  // Optional<Room> targetHouse = this.roomRepository.findById(Destination);
  // if (target.isPresent()) {
  // // Modify the fields of the entity object
  // Reservation foundTarget = target.get();
  // Room foundDestination = targetHouse.get();
  // foundTarget.setRoom(foundDestination);

  // reservationRepository.save(foundTarget);
  // }

  // return target;
  // }

  // @GetMapping(value = "/reservation/{ID}")
  // public Iterable<Reservation> getWareHouseReservation(@PathVariable Integer
  // ID) {
  // Optional<Room> target = this.roomRepository.findById(ID);
  // // Specification<Reservation> spec = Specification.where(null);
  // // spec = spec.and(ReservationSpecifications.getByRoomID(target));

  // // if (target.isPresent()) {
  // // // Modify the fields of the entity object
  // Room foundTarget = target.get();
  // Iterable<Reservation> reservationList =
  // this.reservationRepository.findAllByRoom(foundTarget);

  // // }

  // return reservationList;
  // }

}