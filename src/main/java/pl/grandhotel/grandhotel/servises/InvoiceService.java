package pl.grandhotel.grandhotel.servises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grandhotel.grandhotel.model.Invoice;
import pl.grandhotel.grandhotel.repositories.InvoiceRepository;

import java.util.List;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;

    public List<Invoice> getInvoices(){
        return repository.findAll();
    }
}
