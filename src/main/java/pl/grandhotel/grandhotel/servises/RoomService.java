package pl.grandhotel.grandhotel.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.exceptions.RoomExceptions.RoomException;
import pl.grandhotel.grandhotel.exceptions.RoomExceptions.RoomNotFoundException;
import pl.grandhotel.grandhotel.model.Room;
import pl.grandhotel.grandhotel.repositories.RoomRepository;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) throws RoomException {
        var r = roomRepository.findById(id);
        if (r.isEmpty()) {
            throw new RoomNotFoundException();
        } else {
            return r.get();
        }
    }
}
