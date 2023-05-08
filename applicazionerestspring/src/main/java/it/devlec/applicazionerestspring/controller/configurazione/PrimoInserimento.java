package it.devlec.applicazionerestspring.controller.configurazione;

import it.devlec.applicazionerestspring.model.Utente;
import it.devlec.applicazionerestspring.persistenza.UtentiRepository;
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
    CommandLineRunner inserisciElementi(UtentiRepository repository){
        return args -> {
          Utente u1 = new Utente("Daniele", "Carratta" );
          Utente u2 = new Utente("Maddalena", "Corvaglia");
          Utente u3 = new Utente("Enrico", "Michele");

          List<Utente> utenti = new ArrayList<>();
          utenti.add(u2);
          utenti.add(u3);
          repository.save(u1);
          repository.saveAll(utenti);
          List<Utente> utentiDalDb = repository.findAll();
          Utente u1DelDB = new Utente();
          int indice = 0;
          for (Utente u: utentiDalDb){
              if(indice == 0){
                  logger.error("Prendo il primo elemento del DB");
                  u1DelDB = u;
                  indice++;
              }
              logger.info("Nome: "+u.getNome());
              logger.info("Cognome: "+u.getCognome());
              logger.warn(u.toString());
          }
          Utente utenteConId1 = repository.findById(1L).get();
          logger.info("Utente con id 1: "+utenteConId1.getNome());
          u1DelDB.setCognome("Nuovo Cognome");
          repository.save(u1DelDB);
          logger.error("Sto per fare una delete");
          repository.delete(u2);
          utentiDalDb = repository.findAll();
          for (Utente u: utentiDalDb){
              logger.error("Dopo delete");
            logger.info("Nome: "+u.getNome());
            logger.info("Cognome: "+u.getCognome());
            logger.warn(u.toString());
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


        };
    }

}
