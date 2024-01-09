/**
 * A classe Listings serve para aceder a uma certa listing com um imóvel de forma rápida, sem ter de passar pelo vendedor.
 * 
 * @author  André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt) 
 * @version 27-11-2021
 */

public class Listings{
    private Listing list;
/**
 * Recolhe informações sobre os imóveis.
 */
public Listings(Listing newList){
    list = newList;
}

/**
 * Mostra no ecrã as informações dos imóveis.
 */
public void displayListings(){
    this.list.display();
}
}