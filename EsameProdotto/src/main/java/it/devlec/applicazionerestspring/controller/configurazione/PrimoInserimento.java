package it.devlec.applicazionerestspring.controller.configurazione;

import it.devlec.applicazionerestspring.model.Prodotto;
import it.devlec.applicazionerestspring.persistenza.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);
    @Bean
    CommandLineRunner inserisciElementi(ProdottiRepository repository){
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Prodotto p1 = new Prodotto(null, "penna","penna", "bic", sdf.parse("10-10-2020"), sdf.parse("10-10-2020"),
                                        sdf.parse("10-10-2020"), sdf.parse("10-10-2020"), 2, "€", true,
                                        "s","s","s","2");

            Prodotto p2 = new Prodotto(null, "Quaderno","quaderno", "giocagio", sdf.parse("10-09-2019"), sdf.parse("10-10-2020"),
                                        sdf.parse("09-10-2020"), sdf.parse("10-10-1999"), 4, "€", true,
                                        "q","adasd3242","a3ex","23");

            Prodotto p3 = new Prodotto(null, "Matita","matita", "graf", sdf.parse("01-10-1992"),  sdf.parse("10-10-2020"),
                                        sdf.parse("02-10-1993"), sdf.parse("10-10-9999"), 1, "€", true,
                                        "asd","111","a","3");

            Prodotto p4 = new Prodotto(null, "Lampadina","lampadina", "luc", sdf.parse("08-11-2001"), sdf.parse("10-10-2020"),
                                        sdf.parse("09-10-2003"), sdf.parse("10-10-2026"), 1.20, "€", false,
                                        "l","aa3242","a45","45");


            List<Prodotto> prodotti = new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);
            prodotti.add(p3);
            prodotti.add(p4);

            repository.save(p1);
            repository.save(p2);
            repository.save(p3);
            repository.save(p4);

            repository.saveAll(prodotti);
            List<Prodotto> prodottiDalDb = repository.findAll();


            int indice = 0;
            for (Prodotto p: prodottiDalDb){
                logger.warn("Elemento numero " + indice);
                logger.warn(p.toString());
                indice++;
            }

            /*
            Prodotto prodottoConId1 = repository.findById(1L).get();
            logger.info("Prodotto con id 1: "+prodottoConId1.getNome());
            p1DelDB.setCognome("Nuovo Cognome");
            repository.save(p1DelDB);
            logger.error("Sto per fare una delete");
            repository.delete(u2);
            prodottiDalDb = repository.findAll();
            for (Prodotto p: prodottiDalDb){
                logger.error("Dopo delete");
                logger.warn(p.toString());
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date datadinascita = dateFormat.parse("25-12-2021");
            Utente utenteConDatadinascita = new Utente("marco", "dell'anna",
                    datadinascita);
            repository.save(utenteConDatadinascita);

            SimpleDateFormat dataNascita = new SimpleDateFormat("yyyy-MM-dd");
            Date dataDiDavide = dataNascita.parse("2005-05-22");
            Utente utenteConTuttiGliAttribuiti = new Utente("Davide", "xxxx", dataDiDavide,
                    new Date(), 2.3f);
            repository.save(utenteConTuttiGliAttribuiti);

              */
        };
    }

}
