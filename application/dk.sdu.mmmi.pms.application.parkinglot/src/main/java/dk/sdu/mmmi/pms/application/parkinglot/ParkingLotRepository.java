package dk.sdu.mmmi.pms.application.parkinglot;

import dk.sdu.mmmi.pms.core.parkinglot.ParkingLot;
import java.util.Optional;
import java.util.UUID;

public interface ParkingLotRepository {
    void save(ParkingLot parkingLot);
    void update(ParkingLot parkingLot);
    Optional<ParkingLot> findById(UUID id);
    void deleteById(UUID id);
    Iterable<ParkingLot> findAll();
}