/**
 * Mini-Projeto1 (IPOO)
 * Empresa de venda de imóveis de luxo (efetuar a gestão das vendas dos imóveis).
 * 
 * A classe RealEstateAgency identifica os vendedores e guarda detalhes sobre a agência.
 * 
 * @author  André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt)
 * @version 27-11-2021
 */

public class RealEstateAgency{
    private String agencyName;
    private Agent name;
    private Listing list;
    private double profit;
    private double minPrice;
    private double maxPrice;
    private String city;
    
/**
* Serve para recolher informações sobre a agência imobiliária.
* @param newAgencyName Nome da agência imobiliária.
* @param newName       Nome do agente.
* @param newProfit     O lucro que a agência fez com os imóveis vendidos.
* @param newList       Informações sobre os imóveis.
* 
*/
public RealEstateAgency(String newAgencyName, Agent newName, double newProfit, Listing newList){
    agencyName = newAgencyName;
    name = newName;
    profit = newProfit;
    list = newList;
}

public String getAgencyName(){
    return this.agencyName;
}

public double getProfit(){
    return this.profit;
}

/**
 * Registar um novo imóvel para venda.
 * @param . . .
 * @param . . .
 */
public void addListing(){
    
}

/**
 * Vender um imóvel.
 * @param  ..........
 * @param  ..........
 */
public void sellListing(Listing list, double price){
    profit = profit + (price*0.03);
}

/**
 * Mostra os imóveis a venda numa cidade especifica.
 * @param city Cidade específica.
 */
public void displayListingsLocatedAt(String city){
    if(this.city == this.list.getData().getAddress().getCity()){
    System.out.println("Imóveis localizados em "+ this.city + ":");
    System.out.println("list.display()");
}
}

/**
 * Mostrar a lista de imóveis a venda.
 * 
 */
public void displayListings(){
    this.list.display();
}

/**
 * Mostra as informações da agência imobiliária.
 */
public void display(){
    System.out.println("Nome da agência: " + this.agencyName);
    System.out.println("Nome dos agentes: " + this.name);
    System.out.println("Imóveis à venda: " + this.list);
    System.out.println("Lucro: " + this.profit);
}

/**
 *Mostrar os imóveis à venda, com base num preço dentro de uma dado intervalo.
 *@param minPrice Preço mínimo para o intervalo.
 *@param maxPrice Preço máximo para o intervalo.
 */
public void displayListingsBetween(double minPrice, double maxPrice){
    if(list.getPrice() >= this.minPrice && list.getPrice() <= this.maxPrice){
        System.out.println("list.display()");
}
}

/**
 *Mostrar os imóveis com quintal à venda
 *@param list O imóvel em questão.
 */
public void displayListingsWithYard(Listing list){
    if(list.getYard() == true){
        System.out.println("list.display()");
    }
}
}