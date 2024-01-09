/**
 * A classe Listing serve para representar o imóvel.
 * 
 * @author André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt)
 * @version 13-11-2021
 */

public class Listing{
    private int propNumber;
    private static int NUMBER;
    private double price;
    private Address address;
    private boolean yard;
    private HouseData data;
    private double pricePerM2;

/**
 * Recolhe informações sobre os detalhes do imóvel e do preço pelo qual será vendido.
 * @param newPrice O preço do imóvel.
 * @param newData  Escolher o imóvel em questão.
*/
public Listing(HouseData newData, double newPrice){
    propNumber = 0;
    NUMBER++;
    propNumber = propNumber + NUMBER;
    data = newData;
    price = newPrice;
}

/**
 * Primeiro método para adicionar um imóvel novo para venda, que recolhe as informações do preço do imóvel e a casa em questão.
 * @param price      Preço a que o imóvel será vendido.
 * @param data       Escolher o imóvel em questão.
 * @param pricePerM2 Preço por metro quadrado do imóvel.
*/
public void addListingMethod1(int price, HouseData data, double pricePerM2){
    this.price = price;
    if(pricePerM2 <= 4000){
        System.out.println("O imóvel não pode ser colocado à venda.");
    }
}

public double getPrice(){
    return this.price;
}

public int getPropNumber(){
    return this.propNumber;
}

public boolean getYard(){
    return this.yard;
}

public HouseData getData(){
    return this.data;
}
/**
 * Segundo método para adicionar um imóvel novo para venda, que recolhe as informações do preço do imóvel e a casa em questão.
 * @param price      Preço a que o imóvel será vendido.
 * @param data       Escolher o imóvel em questão.
 * @param yard       Escolher se o imóvel tem quintal ou não.
 * @param pricePerM2 Preço por metro quadrado do imóvel.
*/
public void addListingMethod2(int price, HouseData data, boolean yard, double pricePerM2){
    this.price = price;
    this.yard = data.getYard();
    if(pricePerM2 <= 4000) {
            System.out.println("O imóvel não pode ser colocado à venda.");
    }
}

/**
 * Serve para confirmar a cidade onde o imóvel está localizado.
 * @param city A cidade onde o imóvel está localizado.
*/
public boolean isLocatedAt(String city){
    this.data.getAddress().getCity();

    if(this.data.getAddress().getCity().equals(city)){
        return true;
    } else{
        return false;
    }
    }

/**
 * Mostra no ecrã as informações sobre o imóvel à venda.
*/
public void display(){
    System.out.println("\t#" + this.propNumber);
    System.out.println("\tPreço: " + this.price + " EUR");
    System.out.println("\tMorada: " + this.data.getAddress().getAddress() + " " + this.data.getAddress().getZipCode() + " " + this.data.getAddress().getCity());
    System.out.println("\tDetalhes da Casa");
    System.out.println("\tÁrea: " + this.data.getArea() + " m2");
    if(data.getYard() == true){
        System.out.println("\tQuintal: Sim");
    } else{
        System.out.println("\tQuintal: Não");
    }
    }
}