/**
 * A classe Agent serve para recolher e mostrar as informações referentes aos vendedores.
 * 
 * @author  André Meseiro 202100225 (202100225@estudantes.ips.pt) e Rodrigo Elias 202100213 (202100213@estudantes.ips.pt) 
 * @version 27-11-2021
 */

public class Agent{
    private String name;
    private double commissionsValue;
    private int propertiesSold;
    private int numberOfProperties;
    private Listing list;

/**
 * Recolhe informações sobre o vendedor.
 * @param name               O nome do vendedor.
 * @param commissionsValue   O valor das comissões recebidas.
 * @param propertiesSold     O número de imóveis vendidos.
 * @param numberOfProperties O número de imóveis que o vendedor dispõe para venda. 
*/
public Agent(String newName, double newCommissionsValue, int newPropertiesSold, int newNumberOfProperties){
    name = newName;
    commissionsValue = newCommissionsValue;
    propertiesSold = newPropertiesSold;
    numberOfProperties = newNumberOfProperties;
}

public String getName(){
    return this.name;
}

public double getCommissionsValue(){
    return this.commissionsValue;
}

public int getPropertiesSold(){
    return this.propertiesSold;
}

public int getnumberOfProperties(){
    return this.numberOfProperties;
}

/**
 * Mostra no ecrã as informações sobre o vendedor.
*/
public void display(){
    System.out.println("\t Nome: " + this.name);
    System.out.println("\t Imóveis: " + this.numberOfProperties);
    System.out.println("\t Comissões: " + this.commissionsValue);
    System.out.println("\t Imóveis vendidos: " + this.propertiesSold);
}

/**
 * Mostra no ecrã as informações sobre os imóveis que o vendedor dispõe para venda.
*/
public void displayListings(){
    this.list.display();
}

/**
 * Serve para saber se o vendedor pode ou não aceitar novos imóveis para venda.
 * @param numberOfProperties O número de imóveis que o vendedor dispõe para venda.
*/
public boolean isAcceptingListings(int numberOfProperties){
    if(numberOfProperties < 2){
        return true;
    }
    else{
        return false;
    }
}


/**
 * Serve para adicionar um novo imóvel para venda.
 * @param numberOfProperties O número de imóveis para venda.
*/
public void addListing(int numberOfProperties){
    this.numberOfProperties +=1;
    if(numberOfProperties >= 2){
        System.out.println("Não é possível adicionar o imóvel para venda.");
    }
}

/**
 * Serve para marcar um imóvel como vendido.
 * @param numberOfProperties O número de imóveis que o vendedor dispõe venda.
 * @param propertiesSold     O número de imóveis vendidos.
 * @param commissionsValue   O valor das comissões recebidas.
*/
public void markAsSold(int numberOfProperties, int propertiesSold, double commissionsValue, double price){
    this.numberOfProperties -= 1;
    this.propertiesSold += 1;
    this.commissionsValue = commissionsValue + (0.02*price);
    
}
}
