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
    @Column(name = "amount_normal")
    private int amountNormal;

    @Basic
    @Column(name = "amount_pensioner")
    private int amountPensioner;

    @Basic
    @Column(name = "amount_invalid")
    private int amountInvalid;

    @Basic
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private Status orderStatus;

    @Column(name = "toPay", nullable = false)
    private BigDecimal toPay;

    public BigDecimal getToPay() {
        return toPay;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

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

    public Integer getAmountPensioner() {
        return amountPensioner;
    }

    public void setAmountPensioner(Integer amountPensioner) {
        this.amountPensioner = amountPensioner;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setAmountPensioner(int amountPensioner) {
        this.amountPensioner = amountPensioner;
    }

    public int getAmountInvalid() {
        return amountInvalid;
    }

    public void setAmountInvalid(int amountInvalid) {
        this.amountInvalid = amountInvalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getUserId() == order.getUserId()
                && getRoomId() == order.getRoomId()
                && getAmountNormal() == order.getAmountNormal()
                && getAmountPensioner() == order.getAmountPensioner()
                && getAmountInvalid() == order.getAmountInvalid()
                && Objects.equals(getStartDate(), order.getStartDate())
                && Objects.equals(getEndDate(), order.getEndDate())
                && Objects.equals(getToPay(), order.getToPay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getRoomId(), getStartDate(), getEndDate(), getAmountNormal(), getAmountPensioner(), getAmountInvalid(), getToPay());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amountNormal=" + amountNormal +
                ", amountPensioner=" + amountPensioner +
                ", amountInvalid=" + amountInvalid +
                ", description='" + description + '\'' +
                ", orderStatus=" + orderStatus +
                ", toPay=" + toPay +
                '}';
    }
}
