package it.devlec.applicazionerestspring.controller;

import it.devlec.applicazionerestspring.avviso.ProdottoNonTrovato;
import it.devlec.applicazionerestspring.model.Prodotto;
import it.devlec.applicazionerestspring.persistenza.ProdottiRepository;
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
        logger.info("Prendo i prodotti");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }


    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto){
        return repository.save(nuovoProdotto);
    }
    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@RequestBody Prodotto prodotto, @PathVariable Integer id)
    {
               return repository.findById(id).map(
                //creare nuovo
                nuovoProdotto-> {
                    if(prodotto.getNome()!=null) nuovoProdotto.setNome(prodotto.getNome());
                    if(prodotto.getDescrizione()!=null) nuovoProdotto.setDescrizione(prodotto.getDescrizione());
                    if(prodotto.getMarca()!=null) nuovoProdotto.setMarca(prodotto.getMarca());
                    if(prodotto.getDataDiAcquisto()!=null) nuovoProdotto.setDataDiAcquisto(prodotto.getDataDiAcquisto());
                    if(prodotto.getDataDiPrenotazione()!=null) nuovoProdotto.setDataDiPrenotazione(prodotto.getDataDiPrenotazione());
                    if(prodotto.getDataDiProduzione()!=null) nuovoProdotto.setDataDiProduzione(prodotto.getDataDiProduzione());
                    if(prodotto.getDataDiScadenza()!=null) nuovoProdotto.setDataDiScadenza(prodotto.getDataDiScadenza());
                    if(prodotto.getCosto()!=0) nuovoProdotto.setCosto(prodotto.getCosto());
                    if(prodotto.getValuta()!=null) nuovoProdotto.setValuta(prodotto.getValuta());
                    if(prodotto.isRiciclabile()!=null) nuovoProdotto.setRiciclabile(prodotto.isRiciclabile());
                    if(prodotto.getNumeroSerie()!=null) nuovoProdotto.setNumeroSerie(prodotto.getNumeroSerie());
                    if(prodotto.getNumeroModello()!=null) nuovoProdotto.setNumeroModello(prodotto.getNumeroModello());
                    if(prodotto.getNumeroVersione()!=null) nuovoProdotto.setNumeroVersione(prodotto.getNumeroVersione());
                    if(prodotto.getCodiceBarre()!=null) nuovoProdotto.setCodiceBarre(prodotto.getCodiceBarre());
                    if(prodotto.getNumeroSerie()!=null) nuovoProdotto.setNumeroSerie(prodotto.getNumeroSerie());
                    return repository.save(nuovoProdotto);
                }
        ).orElseGet(
                () -> {
                    //l'prodotto esiste
                    prodotto.setId(id);
                    return repository.save(prodotto);
                }
        );

    }


    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/prodotto/ricercaPerNome")
    public List<Prodotto> ricercaPerNome(
            @RequestParam(name="nome")
            String nome
    ){
        return repository.findByNome(nome);
    }

    @GetMapping("/prodotto/ricercaDescrizione")
    public List<Prodotto> ricercaPerDescrizione(
            @RequestParam(name="descrizione")
            String descrizione
    ){
        return repository.findByDescrizione(descrizione);
    }

    @GetMapping("/prodotto/ricercaDataAcquisto")
    public List<Prodotto> ricercaDataAcquisto(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date dataa
    ){
        return repository.findByDataDiAcquistoBetween(datada, dataa);
    }

    @GetMapping("/prodotto/ricercaDataPrenotazione")
    public List<Prodotto> ricercaDataPrenotazione(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date dataa
    ){
        return repository.findByDataDiPrenotazioneBetween(datada, dataa);
    }

    @GetMapping("/prodotto/ricercaDataScadenza")
    public List<Prodotto> ricercaDataScadenza(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date dataa
    ){
        return repository.findByDataDiScadenzaBetween(datada, dataa);
    }

    @GetMapping("/prodotto/ricercaDataProduzione")
    public List<Prodotto> ricercaDataProduzione(
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
            Date dataa
    ){
        return repository.findByDataDiProduzioneBetween(datada, dataa);
    }

    @GetMapping("/prodotto/ricercaCosto")
    public List<Prodotto> ricercaPerCosto(
            @RequestParam(name="dacosto")
            double dacosto,
            @RequestParam(name="acosto")
            double acosto

            ){
        return repository.findByCostoBetween(dacosto, acosto);
    }

    @GetMapping("/prodotto/ricercaValuta")
    public List<Prodotto> ricercaPerValuta(
            @RequestParam(name="valuta")
            String valuta
    ){
        return repository.findByValuta(valuta);
    }

    @GetMapping("/prodotto/ricercaRiciclabile")
    public List<Prodotto> ricercaPerStatoRiciclabile(
            @RequestParam(name="riciclabile")
            Boolean riciclabile
    ){
        return repository.findByRiciclabile(riciclabile);
    }

    @GetMapping("/prodotto/ricercaNumeroModello")
    public List<Prodotto> ricercaPerNumeroModello(
            @RequestParam(name="modello")
            String modello
    ){
        return repository.findByNumeroModello(modello);
    }

    @GetMapping("/prodotto/ricercaNumeroSerie")
    public List<Prodotto> ricercaPerNumeroSerie(
            @RequestParam(name="serie")
            String serie
    ){
        return repository.findByNumeroSerie(serie);
    }

    @GetMapping("/prodotto/ricercaNumeroVersione")
    public List<Prodotto> ricercaPerNumeroVersione(
            @RequestParam(name="versione")
            String versione
    ){
        return repository.findByNumeroVersione(versione);
    }

    @GetMapping("/prodotto/ricercaCodiceBarre")
    public List<Prodotto> ricercaPerCodiceBarre(
            @RequestParam(name="codiceB")
            String codiceB
    ){
        return repository.findByCodiceBarre(codiceB);
    }


}