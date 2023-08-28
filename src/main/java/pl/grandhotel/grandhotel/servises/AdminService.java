package pl.grandhotel.grandhotel.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.exceptions.AccountExceptions.AccountException;
import pl.grandhotel.grandhotel.exceptions.AccountExceptions.AccountIllegalArgumentException;
import pl.grandhotel.grandhotel.exceptions.AccountExceptions.AccountNotFoundException;
import pl.grandhotel.grandhotel.model.Account;
import pl.grandhotel.grandhotel.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Account> getAccounts() {
        return adminRepository.findAll();
    }

    public Account createAccount(Account account) throws AccountException {
        if (!checkAccount(account)) {
            throw new AccountIllegalArgumentException();
        }
        if (adminRepository.exists(Example.of(account))) {
            throw new AccountException("Account is exists. If you want to create new account, enter another data");
        }
        return adminRepository.save(account);
    }

    public Account updateAccount(Account acount) throws AccountException {
        if (!checkAccount(acount)) throw new AccountIllegalArgumentException();
        var a = adminRepository.findById(acount.getAccountId());
        if (a.isEmpty()) {
            throw new AccountNotFoundException();
        } else {
            var toUpd = a.get();
            toUpd.setAccountLogin(acount.getAccountLogin());
            toUpd.setAccountPassword(acount.getAccountPassword());
            toUpd.setAccountRole(acount.getAccountRole());
            return adminRepository.save(toUpd);
        }
    }

    public Account getAccount(int id) throws AccountException {
        var a = adminRepository.findById(id);
        if (a.isEmpty()) throw new AccountNotFoundException();
        return a.get();
    }

    public void deleteAccount(int id) throws AccountException {
        if (id < 0) throw new AccountIllegalArgumentException("Wrong id");
        if (!adminRepository.existsById(id)) throw new AccountNotFoundException();
        else adminRepository.deleteById(id);
    }

    public void deleteAccount(Account account) throws AccountException {
        if (!checkAccount(account)) throw new AccountIllegalArgumentException();
        if (adminRepository.exists(Example.of(account))) {
            adminRepository.delete(account);
        } else {
            throw new AccountNotFoundException();
        }

    }

    private boolean checkAccount(Account account) {
        if (account == null) return false;
        if (account.getAccountLogin() == null || account.getAccountLogin().equals("")) return false;
        if (account.getAccountPassword() == null || account.getAccountPassword().equals("")) return false;
        if (account.getAccountRole() == null) return false;
        return true;
    }
}
