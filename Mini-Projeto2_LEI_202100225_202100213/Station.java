/**
 * Classe que representa uma estação.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 18/12/2021
 */
public class Station{
    private String name;
    private Zone zone;
    private boolean correspondence;

/**
 * Construtor da classe Station. Recebe o nome, a zona metropolitana a que pertence e se a estação tem correspondência com mais de uma linha de metro.
 *
 * @param name - nome da estação
 * @param zone - zona metropolitana a que pertence a estação
 * @param correspondence - se a estação tem ou não correspondência com outras linhas
 */
public Station(String name, Zone zone, boolean correspondence){
    this.name = name;
    this.zone = zone;
    this.correspondence = correspondence;
}

public String getName(){
    return name;
}

public Zone getZone(){
    return zone;
}

public boolean doCorrespondence(){
    return correspondence;
}
    
public void setName(String newName){
    newName = name;
}
    
public void setZone(Zone newZone){
    newZone = zone;
}
    
public void setCorrespondence(boolean newCorrespondence){
    newCorrespondence = correspondence;
}
    
@Override
public String toString(){
    return "Nome" + name + ", " + zone;
}


/**
 * Mostra informação sobre a estação.
 */
public void showStationInfo(){
    System.out.println("Nome da estação: " + name);
    System.out.println("Zona metropolitana: " + zone);
    if(correspondence == true){
        System.out.println("Tem correspondência com outras linhas?  Sim");
    }
    else{ 
        System.out.println("Tem correspondência com outras linhas?  Não");
    }
}
}