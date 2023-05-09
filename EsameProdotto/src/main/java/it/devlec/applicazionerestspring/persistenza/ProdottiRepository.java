package it.devlec.applicazionerestspring.persistenza;

import it.devlec.applicazionerestspring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Integer> {


    List<Prodotto> findByNome(String nome);
    List<Prodotto> findByDescrizione(String descrizione);
    List<Prodotto> findByDataDiAcquistoBetween(Date datada, Date dataa);
    List<Prodotto> findByDataDiProduzioneBetween(Date datada, Date dataa);
    List<Prodotto> findByDataDiPrenotazioneBetween(Date datada, Date dataa);
    List<Prodotto> findByDataDiScadenzaBetween(Date datada, Date dataa);
    List<Prodotto> findByCostoBetween(double dacosto, double acosto);
    List<Prodotto> findByValuta(String valuta);

    List<Prodotto> findByRiciclabile(boolean riciclabile);

    List<Prodotto> findByNumeroModello(String numeroModello);

    List<Prodotto> findByNumeroVersione(String numeroVersione);
    List<Prodotto> findByCodiceBarre(String codiceBarre);
    List<Prodotto> findByNumeroSerie(String numeroSerie);



}
