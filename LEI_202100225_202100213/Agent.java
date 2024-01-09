/**
 * Um agente de uma imobiliária, responsável por vender imóveis.
 * Um agente só pode ter 10 imóveis a venda em qualquer altura.
 * Para cada imóvel vendido, o agente recebe uma comissão de 2%.
 * É contabilizado o número de vendas efetuadas pelo vendedor.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022
 */
public class Agent{
    private String name;
    private Listing[] listings;
    private int numberOfListings;
    private double sells;
    private int numberOfSells;
    private static final double AGENT_COMISSION = 0.02;

    /**
     * Constrói um agente da imobiliária, com base no seu nome.
     * Os listings do agente têm o valor null, até serem inicializados com o método addListing.
     * O valor das vendas e o número de vendas têm o valor zero.
     * A taxa da comissão do agente sobre as vendas tem o valor de 2%. 
     * 
     * @param name o nome do agente
     */
    public Agent(String name){
        this.name = name;
        listings = new Listing[10];
        sells = 0;
        numberOfSells = 0;
    }

    /**
     * Atribuí um imóvel ao vendedor
     * 
     * @param listing o imóvel a atribuir.
     * @param number o número do imóvel para o vendedor, de 1 a 10.
     */
    public void setlisting(Listing listing, int number){
        for(int i = 0; i < listings.length; i++){
            if(number-1 == i){
                listings[i] = listing;
            }
        }
    }
    
    /**
     * Verifica se o agente pode aceitar um novo imóvel
     * 
     * @return booleano o valor verdeiro indica que o vendedor pode aceitar um novo imóvel.
     */
    public boolean isAvailable(){
        for(int i= 0; i < listings.length; i++){
            if(listings[i] == null){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna o número de imóveis do agente .
     * 
     * @return o número de imóveis do agente.
     */
    public int getNumberOfListings(){
        for(int i = 0; i < listings.length; i++){
            if(listings[i] != null){
                numberOfListings++;
            }
        }
        return numberOfListings;
    }

    public double getSells(){
        return sells;
    }
    
    public int getNumberOfSells(){
        return numberOfSells;
    }
    
    
    public String getName(){
        return name;
    }
    
    public boolean isAcceptListings(){
        return isAvailable();
    }

    public boolean hasNoListing(){
        return getNumberOfListings() == 0;
    }
    
    /**
     * Verifica se o agente possuí um determinado imóvel
     * 
     * @param listing o listing procurado.
     * @return booleano o valor verdeiro indica que o vendedor tem o imóvel procurado.
     */
    public boolean hasListing(Listing listing){
        boolean hasListing = false;
        for(int i = 0; i < listings.length; i++){
            if(listings[i] == listing){
                hasListing = true;
            }
        }
        return hasListing;
    }

    /**
     * Adiciona um novo imóvel ao vendedor
     * 
     * @param listing o listing a adicionar.
     */
    public void addListing(Listing listing){
        if(isAcceptListings()){
            listings[numberOfListings++] = listing;
        }
        else{ 
            System.out.println("O vendedor não está a aceitar mais imóveis de momento.");
        }
    }
    
    /**
     * Escreve na consola a informação dos imóveis do vendedor.
     */
    public void displayListings(){
        System.out.println("------ Imóveis de " + name + " ------");        
        if(getNumberOfListings() == 0){
            System.out.println("Não tem imóveis em carteira.");
        }
        else{
            for(int i = 0; i < listings.length; i++){
                listings[i].display();
            }
        }
    }

    /**
     * Regista a venda de um imóvel pelo vendedor. As comissões da venda são atribuidas ao vendedor
     * e o imóvel é lhe retirado.
     * 
     * @param listing o listing vendido.
     */   
    public void markAsSold(Listing listing){
        for(int i = 0; i < listings.length; i++){
            if(listings[i] == listing){
                listings[i] = null;
            }
        }
        sells += computeComission(listing);
        numberOfSells++;
    }

    /**
     * Calcula a comissão do vendedor em relação à venda de um imóvel. 
     * 
     * @param listing o listing vendido.
     * @return o valor da comissão
     */
    private double computeComission(Listing listing){
        return listing.getPrice() * AGENT_COMISSION;
    }
    
    /**
     * Escreve na consola a informação do vendedor: nome, número de vendas realizadas, valor das comissões ganhas.
     */
    public void display(){
        System.out.println("\n---- Vendedor: " + name + " ----");
        System.out.println("Total de comissões: EUR " + sells);
        System.out.println("Número de edifícios vendidos: " + numberOfSells +"\n");
    }
    
    /**
     * Retorna a informação do vendedor: nome, número de vendas realizadas, valor das comissões ganhas.. 
     * 
     * @return a informação do vendedor.
     */
    @Override
    public String toString(){
        return name + "\nTotal de comissões: EUR " + sells + "\nNumero de vendas: " + numberOfSells; 
    }
}
