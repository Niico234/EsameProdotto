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
    private Date dataDiPrenotazione;
    private Date dataDiProduzione;
    private Date dataDiScadenza;
    private double costo;
    private String valuta;
    private Boolean riciclabile;
    private String numeroModello;
    private String codiceBarre;
    private String numeroSerie;
    private String numeroVersione;


    public Prodotto( Integer id, String nome, String descrizione, String marca, Date dataDiAcquisto, Date dataDiPrenotazione, Date dataDiProduzione, Date dataDiScadenza, double costo, String valuta, Boolean riciclabile, String numeroModello, String codiceBarre, String numeroSerie, String numeroVersione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.marca = marca;
        this.dataDiAcquisto = dataDiAcquisto;
        this.dataDiPrenotazione = dataDiPrenotazione;
        this.dataDiProduzione = dataDiProduzione;
        this.dataDiScadenza = dataDiScadenza;
        this.costo = costo;
        this.valuta = valuta;
        this.riciclabile = riciclabile;
        this.numeroModello = numeroModello;
        this.codiceBarre = codiceBarre;
        this.numeroSerie = numeroSerie;
        this.numeroVersione = numeroVersione;
    }

    public Prodotto(){

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

    public Date getDataDiPrenotazione() {
        return dataDiPrenotazione;
    }

    public void setDataDiPrenotazione(Date dataDiPrenotazione) {
        this.dataDiPrenotazione = dataDiPrenotazione;
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

    public Boolean isRiciclabile() {
        return riciclabile;
    }

    public void setRiciclabile(Boolean riciclabile) {
        this.riciclabile = riciclabile;
    }

    public String getNumeroModello() {
        return numeroModello;
    }

    public void setNumeroModello(String numeroModello) {
        this.numeroModello = numeroModello;
    }

    public String getCodiceBarre() {
        return codiceBarre;
    }

    public void setCodiceBarre(String codiceBarre) {
        this.codiceBarre = codiceBarre;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroVersione() {
        return numeroVersione;
    }

    public void setNumeroVersione(String numeroVersione) {
        this.numeroVersione = numeroVersione;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", marca='" + marca + '\'' +
                ", dataDiAcquisto=" + dataDiAcquisto +
                ", dataDiPrenotazione=" + dataDiPrenotazione +
                ", dataDiProduzione=" + dataDiProduzione +
                ", dataDiScadenza=" + dataDiScadenza +
                ", costo=" + costo +
                ", valuta='" + valuta + '\'' +
                ", riciclabile=" + riciclabile +
                ", numeroModello='" + numeroModello + '\'' +
                ", codiceBarre='" + codiceBarre + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", numeroVersione='" + numeroVersione + '\'' +
                '}';
    }
}

