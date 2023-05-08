package it.devlec.applicazionerestspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prodotto {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descrizione;
    private String marca;
    private Date dataDiAcquisto;
    private Date dataDiProduzione;
    private Date dataDiScadenza;
    private double costo;
    private String valuta;
    private boolean riciclabile;
    private String numeroModello;
    private String numeroSerie;
    private String codiceBarre;

    public Prodotto(Integer id, String nome, String descrizione, String marca, Date dataDiAcquisto, Date dataDiProduzione, Date dataDiScadenza, double costo, String valuta, boolean riciclabile, String numeroModello, String numeroSerie, String codiceBarre) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.marca = marca;
        this.dataDiAcquisto = dataDiAcquisto;
        this.dataDiProduzione = dataDiProduzione;
        this.dataDiScadenza = dataDiScadenza;
        this.costo = costo;
        this.valuta = valuta;
        this.riciclabile = riciclabile;
        this.numeroModello = numeroModello;
        this.numeroSerie = numeroSerie;
        this.codiceBarre = codiceBarre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataDiAcquisto() {
        return dataDiAcquisto;
    }

    public void setDataDiAcquisto(Date dataDiAcquisto) {
        this.dataDiAcquisto = dataDiAcquisto;
    }

    public Date getDataDiProduzione() {
        return dataDiProduzione;
    }

    public void setDataDiProduzione(Date dataDiProduzione) {
        this.dataDiProduzione = dataDiProduzione;
    }

    public Date getDataDiScadenza() {
        return dataDiScadenza;
    }

    public void setDataDiScadenza(Date dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public boolean isRiciclabile() {
        return riciclabile;
    }

    public void setRiciclabile(boolean riciclabile) {
        this.riciclabile = riciclabile;
    }

    public String getNumeroModello() {
        return numeroModello;
    }

    public void setNumeroModello(String numeroModello) {
        this.numeroModello = numeroModello;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getCodiceBarre() {
        return codiceBarre;
    }

    public void setCodiceBarre(String codiceBarre) {
        this.codiceBarre = codiceBarre;
    }
}
