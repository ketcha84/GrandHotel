package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "invoices", schema = "public", catalog = "hotel")
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "invoice_date", nullable = true)
    private Timestamp invoiceDate;
    @Basic
    @Column(name = "topay", nullable = false, precision = 2)
    private BigDecimal topay;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getTopay() {
        return topay;
    }

    public void setTopay(BigDecimal topay) {
        this.topay = topay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId && orderId == invoice.orderId && Objects.equals(invoiceDate, invoice.invoiceDate) && Objects.equals(topay, invoice.topay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, orderId, invoiceDate, topay);
    }
}
