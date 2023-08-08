package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;
import pl.grandhotel.grandhotel.model.types.Status;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "hotel")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false, updatable = false)
    private int orderId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "room_id", nullable = false)
    private int roomId;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "amount_normal", nullable = false)
    private int amountNormal;
    @Basic
    @Column(name = "amount_child", nullable = true)
    private Integer amountChild;
    @Basic
    @Column(name = "amount_pensioner", nullable = true)
    private Integer amountPensioner;
    @Basic
    @Column(name = "amount_baby", nullable = true)
    private Integer amountBaby;
    @Basic
    @Column(name = "append_food", nullable = true)
    private Boolean appendFood;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "penalty", nullable = true, precision = 2)
    private BigDecimal penalty;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private Status orderStatus;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmountNormal() {
        return amountNormal;
    }

    public void setAmountNormal(int amountNormal) {
        this.amountNormal = amountNormal;
    }

    public Integer getAmountChild() {
        return amountChild;
    }

    public void setAmountChild(Integer amountChild) {
        this.amountChild = amountChild;
    }

    public Integer getAmountPensioner() {
        return amountPensioner;
    }

    public void setAmountPensioner(Integer amountPensioner) {
        this.amountPensioner = amountPensioner;
    }

    public Integer getAmountBaby() {
        return amountBaby;
    }

    public void setAmountBaby(Integer amountBaby) {
        this.amountBaby = amountBaby;
    }

    public Boolean getAppendFood() {
        return appendFood;
    }

    public void setAppendFood(Boolean appendFood) {
        this.appendFood = appendFood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && userId == order.userId && roomId == order.roomId && amountNormal == order.amountNormal && Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate) && Objects.equals(amountChild, order.amountChild) && Objects.equals(amountPensioner, order.amountPensioner) && Objects.equals(amountBaby, order.amountBaby) && Objects.equals(appendFood, order.appendFood) && Objects.equals(description, order.description) && Objects.equals(penalty, order.penalty) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, roomId, startDate, endDate, amountNormal, amountChild, amountPensioner, amountBaby, appendFood, description, penalty, orderStatus);
    }
}
