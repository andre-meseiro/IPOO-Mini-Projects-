/**
 * A classe HouseData serve para recolher e mostrar os detalhes de um imóvel.
 * 
 * @author  André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt)
 * @version 13-11-2021
 */

public class HouseData{
    private Address address;
    private double area;
    private boolean yard;
    
/**
 * Recolhe as informações sobre a área da casa e sobre o quintal.
 * @param area A área por m2 da casa.
 * @param yard Se a casa tem quintal ou não.
 */
public HouseData(Address address, double area, boolean yard){
    this.address = address;
    this.area = area;
    this.yard = yard;
}

/**
 * Mostra no ecrã as informações disponíveis sobre o imóvel.
 */
public void displayAddress(){
    this.address.display();
}

public boolean getYard(){
    return this.yard;
}

public Address getAddress(){
    return this.address;
}
    
public double getArea(){
    return this.area;
}
}