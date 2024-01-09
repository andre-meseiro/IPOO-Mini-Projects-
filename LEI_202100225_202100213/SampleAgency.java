/**
 * Um exemplo de imobiliária com dois agentes e três imóveis.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 17/1/2022
 */
public class SampleAgency{
    private RealEstateAgency agency;

    /**
     * Construtor da classeSampleAgency. Inicializa um novo exemplo.
     */
    public SampleAgency(){
        Agent agent1 = new Agent("João Silva");
        Agent agent2 = new Agent("Ana Casaco");
        Agents[] list = new Agents[2];
        //list.addAgent(agent1);
        //list.addAgent(agent2);
        agency = new RealEstateAgency("Casa de Sonho", list);
        double price1 = 500000.0;
        int squareMeters1 = 100;
        double price2 = 287600.0;
        int squareMeters2 = 48;
        double price3 = 548600.0;
        int squareMeters3 = 85;        
        Listing listing1 = null;
        Listing listing2 = null;
        Listing listing3 = null;
        if(Listing.isLuxuary(price1,squareMeters1)){
            listing1 = new Listing(price1,"Alto do minho","2925-430","Lisboa",squareMeters1);
        }
        if(Listing.isLuxuary(price2,squareMeters2)){
        listing2 = new Listing(price2,"Baixa","3600-000","Faro",squareMeters2,true);
        }
        if(Listing.isLuxuary(price3,squareMeters3)){
        listing3 = new Listing(price3,new HouseData("Rua das Amoreiras","1600-000","Lisboa",squareMeters3),false);
        }
        agency.addListing(listing1);
        agency.addListing(listing2);
        agency.addListing(listing3);
        agency.displayListingsByAgent();
    }

    /**
     * Retorna uma imobiliária com alguns dados (2 agentes e 3 imóveis)
     *
     * @return RealEstateAgency o exemplo de imobiliária com 2 agentes e 3 imóveis
     */
    public RealEstateAgency getAgency(){
        return agency;
    }
}