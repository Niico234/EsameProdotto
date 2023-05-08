package it.devlec.applicazionerestspring.persistenza;

import it.devlec.applicazionerestspring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Integer> {

 /*   List<Utente> findByDatadinascitaBetween(Date datada, Date dataa);
    List<Utente> findByDatadiregistrazioneBetween(Date datada, Date dataa);
    List<Utente> findByRankingBetween(float min, float max);
    List<Utente> findByRankingLessThan(float max );
    List<Utente> findByCognome(String cognome);*/

}
