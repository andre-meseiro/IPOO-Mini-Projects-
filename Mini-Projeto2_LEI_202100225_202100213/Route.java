/**
 * Classe que representa um percurso efetuado por um passageiro, desde a estação de origem à estação de destino.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 19/12/2021
 */
public class Route{
    private Station[] stationsTraveled;
    private Trip numberOfZonesTraveled;
/**
 * Construtor da classe Route. Recebe as estações percorridas no percurso.
 * 
 * @param stationsTraveled - conjunto de estações percorridas no percurso
 */
public Route(Station[] stationsTraveled){
    if(stationsTraveled != null && stationsTraveled.length != 0){
        this.stationsTraveled = stationsTraveled;
    }
}

public int getNumberOfZonesTraveled(){
    int add =0;
    for(int i = 0 ; i<stationsTraveled.length; i++){
         int j = i+1;
    if(j >= stationsTraveled.length)
       break;
    if(stationsTraveled[i].getZone() != stationsTraveled[j].getZone())
       ++add;
}
    return add;
}

public Station getOriginStation(){
    return stationsTraveled[0];
}

public Station getDestinationStation(){
    return stationsTraveled[stationsTraveled.length-1];
}

/**
 * Mostra informação sobre o percurso efetuado.
 */
public void showRouteInfo(){
    for(int i=0; i<stationsTraveled.length; i++){
        stationsTraveled[i].showStationInfo();
    }
}
}