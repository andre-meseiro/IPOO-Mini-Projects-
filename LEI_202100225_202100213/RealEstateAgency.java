/**
 * Um imobiliária constituída que comercializa imóveis. Os vendedores só podem ter no
 * máximo 10 imóveis à venda em simultâneo. Os imóveis vendidos produzem
 * lucro para a imobiliária e os vendedores. A taxa de lucro da imobiliária é 3%.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 17/1/2022
 */
public class RealEstateAgency{
    private Agents[] agentsList;
    private String name;
    private double profit;
    private Listings listings;
    private static final double AGENCY_COMISSION = 0.03;

    /**
     * Constrói uma imobiliária com base no nome da imobiliária e com os vendedores.
     * 
     * @param name o nome da imobiliária
     * @param agents os agentes
     */
    public RealEstateAgency(String name, Agents[] agentsList){
        this.name = name;
        this.listings = new Listings();
        profit = 0.0;
    }

    public Agents getAgents(){
        Agents agents = null;
        for(int i = 0; i < agentsList.length; i++){
            agents = agentsList[i];
        }
        return agents;
    }

    public double getProfit(){
        return profit;
    }

    /**
     * Adiciona um imóvel à listagem da imobiliária, se este for considerado de luxo.
     * 
     * @param listing o imóvel a inserir
     */
    public void addListing(Listing listing){
        boolean isFree = false;
        if(listing != null){
           boolean isLuxuary = listing.isLuxuary(listing.getPrice(),listing.getSquareMeters());
           for(int i = 0; i < agentsList.length; i++){
                if(agentsList[i].getAgent(i).isAcceptListings()){
                    isFree = true;
                }
           }
                if(isLuxuary && isFree == true){
                   listings.addListing(listing);
                   Agent agent = selectAgent();
                   agent.addListing(listing);
                }
        }
    }

    /**
     * Seleciona o agente a quem atribuir um novo imóvel, com base na disponibilidade
     * da listagem do agente e o total das comissões dos vendedores. O vendedor com menos 
     * comissões recebe o imóvel se todos os agentes tiverem o mesmo número de imóveis.
     */
    public Agent selectAgent(){
        Agent selected = null;
        for(int i = 0; i < agentsList.length; i++){
            if(agentsList[i].getAgent(i).isAcceptListings() && agentsList[i+1].getAgent(i+1).isAcceptListings()){
               if(agentsList[i].getAgent(i).getSells() < agentsList[i+1].getAgent(i+1).getSells()){
                   selected = agentsList[i].getAgent(i);
               }
               else{
                    selected = agentsList[i+1].getAgent(i+1);
                   }
            }
        }
        return selected;
    }

    /**
     * Escreve no ecrã a informação dos imóveis na listagem da imobiliária.
     */
    public void displayListings(){
        listings.display();
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis na listagem da imobiliária, organizada por vendedor.
     */
    public void displayListingsByAgent(){
        for(int i = 0; i < agentsList.length; i++){
            if(agentsList[i].getAgent(i).hasNoListing()){
                System.out.println("Não existem imóveis em carteira\n");
            }
            else{
                  agentsList[i].getAgent(i).displayListings();
            }
    }
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis localizados numa determinada cidade.
     * 
     * @param city o nome da cidade procurada.
     */
    public void displayListingsLocatedAt(String city){
        System.out.println("\n..................");
        System.out.println("\nImóveis localizados em " + city);
        listings.displayListingsLocatedAt(city);
        System.out.println("\n..................");
    }

    /**
     * Escreve no ecrã a informação dos imóveis a venda cujo preço está num determinado intervalo.
     * 
     * @param limiteInf o limite inferior do intervalo de preços.
     * @param limiteSup o limite superior do intervalo de preços.
     */
    public void displayListingsBetween(double limiteInf, double limiteSup){
        System.out.println("\n____________________________");
        System.out.println("Imóveis com valores entre " + limiteInf + " e " + limiteSup);
        listings.displayListingsBetween(limiteInf, limiteSup);
        System.out.println("\n____________________________");
    }
    
    /**
     * Escreve no ecrã a informação dos imóveis com um quintal.
     */
    public void displayListingsWithYard(){
        System.out.println("\n****************************");
        System.out.println("Imóveis com quintal ");
        listings.displayListingsWithYard();
        System.out.println("\n****************************");
    }

    /**
     * Regista a venda de um imóvel. As comissões da venda são atribuidas à imobiliária
     * e ao vendedor e o imóvel é retirado das respetivas listagens.
     * 
     * @param listing o listing vendido.
     */
    public void sellListing(Listing listing){
        Agent agent = getAgent(listing);
        if(agent != null){
           agent.markAsSold(listing);
           profit += getAgencyComission(listing);
           listings.removeListing(listing);
        }
    }

    /**
     * Calcula a comissão da imobiliária relativa a uma venda.
     * 
     * @param listing o listing vendido.
     * @return o valor da comissão
     */
    private double getAgencyComission(Listing listing){
        double comission = listing.getPrice() * AGENCY_COMISSION;
        return comission;
    }
    
    /**
     * Retorna o agente responsável por um determinado imóvel.
     * 
     * @param listing o listing listado.
     * @return o agente responsável que possuí o imóvel na sua listagem.
     */
    public Agent getAgent(Listing listing){
        Agent agent = null;
        for(int i = 0; i < agentsList.length; i++){
            if(agentsList[i].getAgent(i).hasListing(listing)){
                agent = agentsList[i].getAgent(i);
            }
        }
        return agent;
    }
    
    /**
     * Retorna um determinado imóvel, com base no seu número.
     * 
     * @return o listing listado com o imóvel procurado.
     */
    public Listing getListing(int number){
        return listings.getListing(number);
    }
    
    /**
     * Escreve na consola a informação da imobiliária: nome e volume de negócio.
     */
    public void display(){
        System.out.println("\n+++++++++ " + name + " ++++++++++");
        System.out.println("+");
        System.out.println("+ Volume de negócio: " + getProfit());
        System.out.println("+");
        System.out.println("++++++++++++++++++++++++++++++++++\n");
    }
}