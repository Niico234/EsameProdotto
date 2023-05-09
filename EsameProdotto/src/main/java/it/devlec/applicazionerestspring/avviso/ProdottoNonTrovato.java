package it.devlec.applicazionerestspring.avviso;

public class ProdottoNonTrovato extends RuntimeException{
    public ProdottoNonTrovato(Integer id){
        super("Non esiste un prodotto con id = " + id);
    }
}
