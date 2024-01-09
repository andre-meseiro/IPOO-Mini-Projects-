/**
 * Representa a venda de um imóvel
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022)
 */
public class Sell{
    private Agent agent;
    private Listing listing;

    /**
      * Constrói uma venda, associada a um vendedor e um imóvel.
      * 
      * @param agent o agente que efetuou a venda.
      * @param listing o imóvel vendido.
      */
    public Sell(Agent agent, Listing listing){
        this.agent = agent;
        this.listing = listing;
    }
    
    /**
     * Efetua a venda de um imóvel.
     */
    public void makeSell(){
        agent.markAsSold(listing);
    }
    
    public double getSells(){
        return agent.getSells();
    }
    
    public int getNumberOfSells(){
        return agent.getNumberOfSells();
    }
    
    public String getName(){
        return agent.getName();
    }
    
    /**
     * Escreve no ecrã a informação sobre a venda.
     */
    public void display(){
        agent.display();
        listing.display();
    }
    
    @Override
    public String toString(){
        return "\n Vendedor: " + agent + "\nImóvel: " + listing; 
    }
}