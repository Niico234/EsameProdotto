package it.devlec.applicazionerestspring.avviso;

public class UtenteNonTrovato extends RuntimeException{
    public UtenteNonTrovato(Long id){
        super("Utente non trovato "+id);
    }
}
