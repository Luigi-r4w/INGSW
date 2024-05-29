package com.backEnd.requester;

import org.springframework.web.bind.annotation.*;

import com.backEnd.dto.Offerta;
import com.backEnd.dao.OffertaDAO;


@RestController
@RequestMapping("/offerta")
public class OffertaReq {
    OffertaDAO offertaDAO = new OffertaDAO();

    @PostMapping("/")
    public void newOfferta(@RequestBody Offerta offerta) throws Exception {
        offertaDAO.InserisciOfferta(offerta);
    }

    @GetMapping("/{id}")
    public  Offerta info(@PathVariable("id") Integer id) throws Exception{
        return  offertaDAO.MostraOffera(id);
    }
}