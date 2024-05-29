package com.backEnd.requester;

import com.backEnd.dto.Venditore;
import org.springframework.web.bind.annotation.*;

import com.backEnd.dto.Compratore;
import com.backEnd.dao.CompratoreDAO;

@RestController
@RequestMapping("/compratore")
public class CompratoreReq {
    CompratoreDAO compratoreDAO = new CompratoreDAO();

    @GetMapping("/{mail}/{pass}")
    public Boolean autenticazione(@PathVariable("mail") String mail, @PathVariable("pass") String pass) throws Exception {
        return compratoreDAO.Autenticazione(mail, pass);
    }

    @PostMapping("/")
    public void newCompratore(@RequestBody Compratore user) throws Exception {
        compratoreDAO.InserisciUtente(user);
    }
    @PostMapping("/link")
    public void link(@RequestBody Compratore user) throws Exception {
        compratoreDAO.AggiungiLink(user);
    }
    @PostMapping("/bio")
    public void bio(@RequestBody Compratore user) throws Exception {
        compratoreDAO.AggiungiBio(user);
    }
    @PostMapping("/posizione")
    public void posizione(@RequestBody Compratore user) throws Exception {
        compratoreDAO.AggiungiPosizione(user);
    }

    @GetMapping("/{mail}")
    public Compratore info(@PathVariable("mail") String mail) throws Exception{
        return compratoreDAO.Info(mail);
    }

    @PostMapping("/update")
    public void update(@RequestBody Compratore user) throws Exception{
        compratoreDAO.AggiungiBio(user);
        compratoreDAO.AggiungiLink(user);
        compratoreDAO.AggiungiPosizione(user);
    }
}
