/**
 * Um programa de gestão de imóveis de luxo a venda, com alguns testes
 * às funcionalidades principais.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 17/1/2022
 */
public class AppStart{
    public static void main(String[] args){     
        SampleAgency sample = new SampleAgency();
        RealEstateAgency century = sample.getAgency();

        century.displayListingsByAgent();
        //century.displayListings();

        // System.out.println(century.getAgent(listing2));
        // System.out.println(century.getAgent2().hasListing(listing2));
        Listing listing = century.getListing(2);
        // System.out.println(century.getAgent1().hasListing(listing));

        //listing.display();
        // Agent agent = century.getAgent(listing);
        // if (agent != null)
            // agent.display();
        // else
            // System.out.println("Agente não encontrado");
        century.sellListing(listing);
        century.display();
        century.displayListings();
        System.out.println(century.getAgents().toString());
        // century.display();
        // century.displayListingsLocatedAt("Lisboa");
    }
}