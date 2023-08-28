package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Order;
import pl.grandhotel.grandhotel.model.types.Status;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.roomId = :roomId AND (o.startDate BETWEEN :startDate AND :endDate) AND (o.endDate BETWEEN :startDate AND :endDate)")
    List<Order> findByRoomIdAndMaxEndDate(@Param("roomId") Integer roomId, @Param("startDate") Date start_date, @Param("endDate") Date end_date);

    @Query("SELECT o FROM Order o WHERE o.userId= :userId")
    List<Order> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT o FROM Order o WHERE o.orderStatus= :status ")
    List<Order> findByOrderStatus(@Param("status") Status status);

    @Query("SELECT o FROM Order o WHERE (o.startDate BETWEEN :startDate AND :endDate) AND (o.endDate BETWEEN :startDate AND :endDate)")
    List<Order> findByStartDateAndEndDate(@Param("start") Date start, @Param("end") Date end);
}
