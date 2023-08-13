package pl.grandhotel.grandhotel.servises;

import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.model.Account;
import pl.grandhotel.grandhotel.repositories.Adminrepository;

import java.util.List;

@Service
public class AdminService {
    final
    Adminrepository adminrepository;

    public AdminService(Adminrepository adminrepository) {
        this.adminrepository = adminrepository;
    }

    public List<Account> getAccounts(){
        return adminrepository.findAll();
    }
}
