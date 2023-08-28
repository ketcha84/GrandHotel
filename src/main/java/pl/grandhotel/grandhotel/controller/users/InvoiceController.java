package pl.grandhotel.grandhotel.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.grandhotel.grandhotel.model.Invoice;
import pl.grandhotel.grandhotel.servises.InvoiceService;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService service;

    @GetMapping()
    @ResponseBody
    public List<Invoice> getInvoices(){
        return service.getInvoices();
    }

}
