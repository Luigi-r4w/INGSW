package com.backEnd.requester;

import com.backEnd.dto.Compratore;
import org.springframework.web.bind.annotation.*;

import com.backEnd.dto.Venditore;
import com.backEnd.dao.VenditoreDAO;

@RestController
@RequestMapping("/venditore")
public class VenditoreReq {
    VenditoreDAO venditore = new VenditoreDAO();

    @GetMapping("/{mail}/{pass}")
    public Boolean autenticazione(@PathVariable("mail") String mail, @PathVariable("pass") String pass) throws Exception {
        return venditore.Autenticazione(mail, pass);
    }

    @PostMapping("/")
    public void newVenditore(@RequestBody Venditore user) throws Exception {
        venditore.InserisciUtente(user);
    }
    @PostMapping("/link")
    public void link(@RequestBody Venditore user) throws Exception {
        venditore.AggiungiLink(user);
    }
    @PostMapping("/bio")
    public void bio(@RequestBody Venditore user) throws Exception {
        venditore.AggiungiBio(user);
    }
    @PostMapping("/posizione")
    public void posizione(@RequestBody Venditore user) throws Exception {
        venditore.AggiungiPosizione(user);
    }

    @GetMapping("/{mail}")
    public Venditore info(@PathVariable("mail") String mail) throws Exception{
        return venditore.InfoVenditore(mail);
    }

    @PostMapping("/update")
    public void update(@RequestBody Venditore user) throws Exception{
        venditore.AggiungiBio(user);
        venditore.AggiungiLink(user);
        venditore.AggiungiPosizione(user);
    }

}
