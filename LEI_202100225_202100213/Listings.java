import java.util.ArrayList;

/**
 * A listagem dos imóveis à venda numa imobiliária.
 * A listagem não tem limite de imóveis á venda.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022
 */
public class Listings{
    private ArrayList <Listing> list;

    /**
     * Constrói uma nova lista de imóveis. Todos os imóveis têm o valor null
     * até estarem inicializados com o método addListing. 
     */
    public Listings(){
        list = new ArrayList <> ();
    }
    
    /**
     * Adiciona um novo imóvel na listagem.
     * 
     * @param listing o listing a adicionar.
     */
    public void addListing(Listing listing){
        if(listing != null){
           list.add(listing);
        }
    }
    
    /**
     * Retorna um imóvel da listagem, com base no seu número.
     * 
     * @return o listing procurado.
     */    
    public Listing getListing(int number){
        if(number > 0){
           return list.get(number-1);
        }
        return null;
    }
    
    /**
     * Remove um imóvel da listagem.
     * 
     * @param listing o listing a remover.
     */  
    public void removeListing(Listing listing){
        if(listing != null){
           list.remove(listing);
        }
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis da listagem cujo preço está num determinado intervalo.
     * 
     * @param inferiorLimit o limite inferior do intervalo de preços.
     * @param superiorLimit o limite superior do intervalo de preços.
     */
    public void displayListingsBetween(double inferiorLimit, double superiorLimit){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getPrice() >= inferiorLimit && list.get(i).getPrice() <= superiorLimit){
                list.get(i).display();
            }
        }
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis da listagem com um quintal.
     */    
    public void displayListingsWithYard(){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).hasAYard()){
                list.get(i).display();
            }
        }
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis da listagem localizados numa determinada cidade.
     * 
     * @param city o nome da cidade procurada.
     */
    public void displayListingsLocatedAt(String city){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCity().equals(city)){
                list.get(i).display();
            }
        }
    }
    
    /**
     *  Escreve no ecrã a informação dos imóveis da listagem.
     */
    public void display(){
        for(int i = 0; i < list.size(); i++){
            list.get(i).display();
        }
    }
    
    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < list.size(); i++){
            output = list.get(i).toString();
        }
        return output;
    }
}