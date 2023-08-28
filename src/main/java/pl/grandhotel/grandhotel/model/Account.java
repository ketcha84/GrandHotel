package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;
import pl.grandhotel.grandhotel.model.types.Roles;

import java.util.Objects;

@Entity
@Table(name = "accounts", schema = "public", catalog = "hotel")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id", nullable = false, updatable = false)
    private int accountId;
    @Basic
    @Column(name = "account_login", nullable = false, length = 50)
    private String accountLogin;
    @Basic
    @Column(name = "account_password", nullable = false, length = 50)
    private String accountPassword;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_role", nullable = false)
    private Roles accountRole;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountLogin() {
        return accountLogin;
    }

    public void setAccountLogin(String accountLogin) {
        this.accountLogin = accountLogin;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Roles getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(Roles accountRole) {
        this.accountRole = accountRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return  Objects.equals(accountLogin, account.accountLogin)
                && Objects.equals(accountPassword, account.accountPassword)
                && Objects.equals(accountRole, account.accountRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountLogin, accountPassword, accountRole);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountLogin='" + accountLogin + '\'' +
                ", accountRole=" + accountRole +
                '}';
    }
}
