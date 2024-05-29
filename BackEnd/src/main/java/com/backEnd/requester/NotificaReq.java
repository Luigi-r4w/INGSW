package com.backEnd.requester;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.backEnd.dto.Notifica;
import com.backEnd.dao.NotificaDAO;

@RestController
@RequestMapping("/notifica")
public class NotificaReq {
    NotificaDAO notificaDAO = new NotificaDAO();
    
    @PostMapping("/")
    public void newNotifica(@RequestBody Notifica notifica) throws Exception {
        notificaDAO.InserisciNotifica(notifica);
    }

    @GetMapping("/venditore/{mail}")
    public ArrayList<Notifica> venditore(@PathVariable("mail") String mail) throws Exception {
        return notificaDAO.VenditoreNotifiche(mail);
    }

    @GetMapping("/compratore/{mail}")
    public ArrayList<Notifica> compratore(@PathVariable("mail") String mail) throws Exception {
        return notificaDAO.CompratoreNotifiche(mail);
    }
}
