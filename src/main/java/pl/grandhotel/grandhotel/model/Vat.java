package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Vat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vat", nullable = false, updatable = false)
    private int idVat;
    @Basic
    @Column(name = "vat", nullable = false, precision = 2)
    private BigDecimal vat;

    public int getIdVat() {
        return idVat;
    }

    public void setIdVat(int idVat) {
        this.idVat = idVat;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vat vat1 = (Vat) o;
        return idVat == vat1.idVat && Objects.equals(vat, vat1.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVat, vat);
    }
}
