/**
 * Classe que representa uma linha de metro.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 18/12/2021
 */
public class SubwayLine{
    private char code;
    private String color;
    private Station[] stations;

/**
 * Construtor da classe SubwayLine. Recebe o código, a cor de designação da linha e o conjunto de estações que fazem parte da mesma.
 *
 * @param code - código identificativo da linha
 * @param color - cor representante da linha
 * @param stations - estações que compõem a linha
 */
public SubwayLine(char code, String color, Station[] stations){
    if(code == 'A' && color.equalsIgnoreCase("Azul") && stations != null){
       this.code = code;
       this.color = color;
       this.stations = stations;
    }
    else if(code == 'B' && color.equalsIgnoreCase("Vermelha") && stations != null){
         this.code = code;
         this.color = color;
         this.stations = stations;
    }
    
    else if(code == 'C' && color.equalsIgnoreCase("Verde") && stations != null){
         this.code = code;
         this.color = color;
         this.stations = stations;
    }
    
    else if(code == 'D' && color.equalsIgnoreCase("Amarela") && stations != null){
         this.code = code;
         this.color = color;
         this.stations = stations;
    }
    else if(code == 'E' && color.equalsIgnoreCase("Roxa") && stations != null){
         this.code = code;
         this.color = color;
         this.stations = stations;
    }
    else if(code == 'F' && color.equalsIgnoreCase("Laranja") && stations != null){
         this.code = code;
         this.color = color;
         this.stations = stations;
    }
    else{ 
        System.out.println("Introduza informações válidas.");
    }
}

public char getCode(){
    return code;
}

public String getColor(){
    return color;
}

public Station[] getStations(){
    return stations;
}

public void setCode(char newCode){
    newCode = code;
}

public void setColor(String newColor){
    newColor = color;
}
 
/**
 * Verifica se determinada estação pertence a esta linha.
 *
 * @param stationName - nome da estação a verificar
 * @return o sucesso da operação. true caso pertença, false caso contrário.
 *
 */
public boolean haveStation(String stationName){
    for(int i=0; i<stations.length; i++){
    if(stations[i].getName().equals(stationName)){
        return true;
    }
    }
    return false;
}

/**
 * Verifica se duas estações pertencem a esta linha.
 *
 * @param firstStation - nome da primeira estação a verificar
 * @param secondStation - nome da segunda estação a verificar
 * @return o sucesso da operação. true caso pertençam, false caso contrário
 */
public boolean haveTwoStations(String firstStation, String secondStation){
    for(int i=0; i<stations.length; i++){
        if(stations[i].getName().equals(firstStation) && stations[i].getName().equals(secondStation)){
            return true;
        }
    }
    return false;
}

/**
 * Determina, caso exista, em que posição se encontra determinada estação nesta linha.
 *
 * @param stationName - nome da estação a determinar posição
 * @return a posição em que a estação se encontra
 */
public int stationPositionInLine(String stationName){
    boolean exists = false;
    int index = -1;
    while(!exists && index<stations.length && stationName!=null){
        index++;
        if(stations[index].getName().equals(stationName)){
            exists=true;
        }
    }
    if(!exists){
        index=-1;
    }
    return index;
}

/**
 * Devolve uma estação existente nesta linha, a partir do seu nome.
 * 
 * @param stationName - nome da estação
 * @return estação, caso exista
 */
public Station getStationInLine(String stationName){
    for(int i=0; i<stations.length; i++){
        if(stations[i].getName().equals(stationName)){
            return stations[i];
        }
    }
    
    return null;
}

/**
 * Devolve uma estação existente nesta linha, a partir da sua posição.
 * 
 * @param position - posição da estação
 * @return estação localizada nessa posição
 */
public Station getStationInPosition(int position){
    for(int i=0; i<stations.length; i++){
        System.out.println("Estação localizada na posição " + position + " : " + stations[i].getName());
    }
    return null;
}


/**
 * Mostra informação sobre a linha de metro.
 */
public void showSubwayLineInfo(){
    System.out.println("Linha de metro: " + code + "" + (color));
    System.out.println("Estações que fazem parte da linha:");
    for(int i=0; i<stations.length; i++){
        stations[i].showStationInfo();
    }
}

@Override
public String toString(){
    return "";
}
}