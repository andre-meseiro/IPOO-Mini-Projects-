import java.util.ArrayList;

/**
 * Armazena as vendas realizadas pela imobiliária numa listagem.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022
 */
public class Sells{
    private ArrayList <Sell> sells;
    
    /**
     * Constrói uma nova lista de vendas. Todas as vendas têm o valor null
     * até estarem inicializadas com o método addSell.
     */
    public Sells(){
        sells = new ArrayList <> ();
    }
    
    /**
     * Adiciona uma nova venda na listagem.
     * 
     * @param sell a venda a adicionar.
     */
    public void addSell(Sell sell){
        if(sell != null){
            sells.add(sell);
        }
    }
    
    /**
     * Remove uma venda da listagem.
     * 
     * @param sell a venda a remover.
     */
    public void removeSell(Sell sell){
        if(sell != null){
            sells.remove(sell);
        }
    }
    
    /**
     * Escreve no ecrã as vendas por vendedor.
     */
    public void displaySellsByAgent(){
        for(int i = 0; i < sells.size(); i++){
            if(sells.get(i).getName().compareTo(sells.get(i+1).getName()) > 0){
                sells.get(i).display();
            }
            else{
                  sells.get(i+1).display();
            }
    }
    }
    
    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < sells.size(); i++){
            output = sells.get(i).toString();
        }
        return output;
    }
}