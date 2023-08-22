package pl.grandhotel.grandhotel.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.exceptions.RoomExceptions.RoomException;
import pl.grandhotel.grandhotel.exceptions.RoomExceptions.RoomIllegalArgumentException;
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

    public Room createRoom(Room room) throws RoomIllegalArgumentException {
        if (!isValid(room)) {
            throw new RoomIllegalArgumentException();
        }
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) throws RoomException {
        if (room.getRoomId() < 0) throw new RoomException("Id was wrong");
        var res = roomRepository.findById(room.getRoomId());
        Room r;
        if (!res.isEmpty()) {
            r = res.get();
        } else throw new RoomNotFoundException();
        if (isValid(room)) {
            r.setLuxury(room.getLuxury());
            r.setPrice(room.getPrice());
            r.setAmountOfPlaces(room.getAmountOfPlaces());
            r.setReferenceWww(room.getReferenceWww());
            return roomRepository.save(r);
        } else throw new RoomIllegalArgumentException();
    }

    public void deleteRoom(int roomId) throws RoomNotFoundException{
        var opt = roomRepository.findById(roomId);
        if(opt.isEmpty()) throw new RoomNotFoundException();
        roomRepository.deleteById(roomId);
    }

    private boolean isValid(Room room) {
        if (room == null) {
            return false;
        }
        if (room.getLuxury() == null ||
                room.getPrice() == null ||
                room.getAmountOfPlaces() < 1 ||
                room.getReferenceWww() == null ||
                room.getPrice().doubleValue() <= 0 ||
                room.getAmountOfPlaces() < 1 ||
                room.getReferenceWww().equals("")) return false;
        else return true;
    }
}
