package com.backend.requester;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.backend.dao.AstaIngleseDAO;
import com.backend.dto.AstaInglese;

@RestController
@RequestMapping("/asta")
public class AstaIngleseReq {
    AstaIngleseDAO astaIngleseDAO = new AstaIngleseDAO();

    @PostMapping("/")
    public void newAsta(@RequestBody AstaInglese astaInglese) {
        astaIngleseDAO.inserisciAsta(astaInglese);
    }

    @GetMapping("/")
    public ArrayList<AstaInglese> aste()  {
        return astaIngleseDAO.listaAste();
    }

    @GetMapping("/lista/{email}")
    public ArrayList<AstaInglese> aste(@PathVariable("email") String email)  {
        return astaIngleseDAO.listaAsteUtente(email);
    }

    @GetMapping("/info/{id}")
    public AstaInglese aste(@PathVariable("id") Integer id) {
        return astaIngleseDAO.mostraAsta(id);
    }

    @GetMapping("/{categoria}/{parola}")
    public ArrayList<AstaInglese> aste(@PathVariable("categoria") String categoria, @PathVariable("parola") String parola) {
        return astaIngleseDAO.listaAsteRicercaAvanzata(categoria, parola);
    }

}
