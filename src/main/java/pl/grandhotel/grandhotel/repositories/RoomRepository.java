package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
