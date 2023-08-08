package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;
import pl.grandhotel.grandhotel.model.types.Discounts_types;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "discounts", schema = "public", catalog = "hotel")
public class Discount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_discount", nullable = false, updatable = false)
    private int idDiscount;
    @Basic
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = true)
    private Discounts_types discountType;
    @Basic
    @Column(name = "percents", nullable = false, precision = 2)
    private BigDecimal percents;

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discounts_types getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Discounts_types discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getPercents() {
        return percents;
    }

    public void setPercents(BigDecimal percents) {
        this.percents = percents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return idDiscount == discount.idDiscount && Objects.equals(description, discount.description) && Objects.equals(discountType, discount.discountType) && Objects.equals(percents, discount.percents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiscount, description, discountType, percents);
    }
}
