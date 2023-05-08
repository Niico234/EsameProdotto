package it.devlec.applicazionerestspring.controller;
import it.devlec.applicazionerestspring.avviso.UtenteNonTrovato;
import it.devlec.applicazionerestspring.model.Prodotto;
import it.devlec.applicazionerestspring.model.Utente;
import it.devlec.applicazionerestspring.persistenza.ProdottiRepository;
import it.devlec.applicazionerestspring.persistenza.UtentiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoRestController {
    private static Logger logger =
            LoggerFactory.getLogger(ProdottoRestController.class);
    private ProdottiRepository repository;

    ProdottoRestController(ProdottiRepository repository){
        this.repository = repository;
    }

    @GetMapping("/prodotti")
    public List<Prodotto> leggiTuttiProdotti(){
        logger.info("Prendo tutti i prodotti");
        return repository.findAll();
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto){
        return repository.save(nuovoProdotto);
    }



}
