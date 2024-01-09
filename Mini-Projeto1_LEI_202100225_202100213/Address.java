/**
 * A classe Address serve para recolher e armazenar informações sobre o imóvel.
 * 
 * @author  André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt)
 * @version 13-11-2021
 */

public class Address{
    private String address;
    private String zipCode;
    private String city;

/**
 * Recolhe as informações sobre a localização da casa.
 * @param city    A cidade onde o imóvel está localizado.
 * @param zipCode O codigo postal do imóvel.
 * @param address A morada(nome da rua etc.) do imóvel.
 */
public Address(String city, String zipCode, String address){
    this.city = city;
    this.zipCode = zipCode;
    this.address = address;
}

public String getZipCode(){
    return this.zipCode;
}

public String getCity(){
    return this.city;
}

public String getAddress(){
    return this.address;
}

/**
* Mostra no ecrã as informações disponíveis sobre a localização do imóvel.
*/
public void display(){
    System.out.println("Morada: " + this.address);
    System.out.println("Código Postal: " + this.zipCode);
    System.out.println("Cidade: " + this.city);
}
}