package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rooms", schema = "public", catalog = "hotel")
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id", nullable = false, updatable = false)
    private int roomId;
    @Basic
    @Column(name = "amount_of_places", nullable = false)
    private int amountOfPlaces;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "luxury", nullable = true)
    private Boolean luxury;
    @Basic
    @Column(name = "reference_www", nullable = false, length = 100)
    private String referenceWww;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getAmountOfPlaces() {
        return amountOfPlaces;
    }

    public void setAmountOfPlaces(int amountOfPlaces) {
        this.amountOfPlaces = amountOfPlaces;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getLuxury() {
        return luxury;
    }

    public void setLuxury(Boolean luxury) {
        this.luxury = luxury;
    }

    public String getReferenceWww() {
        return referenceWww;
    }

    public void setReferenceWww(String referenceWww) {
        this.referenceWww = referenceWww;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId && amountOfPlaces == room.amountOfPlaces && Objects.equals(price, room.price) && Objects.equals(luxury, room.luxury) && Objects.equals(referenceWww, room.referenceWww);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, amountOfPlaces, price, luxury, referenceWww);
    }
}
