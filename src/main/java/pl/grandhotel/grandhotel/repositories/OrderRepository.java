package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Order;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    todo write query with returnet type not List but Order,
//            must be returned last order with max end Date!
    @Query("SELECT o FROM Order o WHERE o.roomId = :roomId AND o.endDate <= :endDate")
    List<Order> findByRoomIdAndMaxEndDate(@Param("roomId") Integer roomId, @Param("endDate") Date end_date);
}
