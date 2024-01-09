import java.util.Arrays;

/**
 * Classe responsável pelo armazenamento e manipulação de dados da aplicação.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 23/12/2021
 */
public class DataBase{
    private SubwayLine[] lines;
    private double[] prices;
    private Data data;
    private Passenger[] passengers;
    private int numOfPassengers;

/**
 * Construtor da classe DataBase. Deverá inicializar os arrays responsáveis por armazenar os dados da aplicação.
 */
public DataBase(){
    passengers = new Passenger[5];
    numOfPassengers = 0;
    SubwayLine[] lines  = data.getLines();
    double[] prices = data.getPrices();
}

/**
 * Adiciona um novo passageiro ao array. Não poderá existir passageiros com NIFs iguais.
 *
 * @param passenger - passageiro a adicionar ao array
 * @return o sucesso da operação. True caso sucesso, false caso contrário.
 */
public boolean addPassenger(Passenger passenger){
    for(int i = 0; i < passengers.length ; i++){
    if(numOfPassengers < passengers.length && passengers[i].getNif() != passenger.getNif() && passenger != null){
        passengers[numOfPassengers++] = passenger;
        return true;
    }
    else if(numOfPassengers == passengers.length && passengers[i].getNif() != passenger.getNif() && passenger != null){ 
        passengers = new Passenger[10];
        passengers[numOfPassengers++] = passenger;
        return true;
    }
    }
    return false;
}

/**
 * Elimina um passageiro do array de passageiros. Todas as posições do array deverão ser ajustadas, de forma a não haver elementos vazios entre os passageiros existentes no array,
 *
 * @param nif - o passageiro a eliminar
 * @return o sucesso da operação. True caso sucesso, false caso contrário.
 */
public boolean deletePassenger(String nif){
    for(int i = 0; i < passengers.length; i++){
    if(nif != null && passengers[i].getNif().equals(nif)){ 
        passengers[i]=null;
        passengers[i] = passengers[passengers.length-1];
        passengers[passengers.length-1] = null;
        return true;
    }
    }
    return false;
}

/**
 * Valida a existência de um passageiro com o NIF igual.
 *
 * @param nif - NIF a validar
 * @return true caso exista, false caso contrário
 */
private boolean existPassenger(String nif){
    boolean exists = false;
    for(int i = 0 ; i < passengers.length ; i++){
    if(passengers[i].getNif().equals(nif) && nif !=null){
        exists = true;
        return exists;
    }
    }
    return exists;
}

/**
 * Indica a posição que um passageiro ocupa no array
 *
 * @param nif - NIF do passageiro
 * @return posicao no array. -1 caso não exista.
 */
private int getPositionOfPassenger(String nif){
   int index = -1;
   while(index < passengers.length){
       index++;
       if(passengers[index].getNif().equals(nif) && nif != null){
         return index;
       }
   }
   return index;
}

/**
 * Retorna o preço correspondente ao nº de zonas percorridas.
 *
 * @param zone - numero de zonas percorridas
 * @return preço correspondente, -1 caso não exista
 */
public double getPriceOfZone(int zone){
    double price = -1;
    if(zone == 1){
       price = 0.80;
    }
    else if(zone==2){
       price = 1.20;
    }
    else if(zone==3){
       price = 1.60;
    }
    else if(zone==4){
       price = 2.00;
    }
    else if(zone==5){
       price = 2.60;
    }
    else if(zone==6){
       price = 2.80;
    }
    else if(zone==7){
       price = 3.20;
    }
    else if(zone==8){
       price = 3.60;
    }
    else if(zone==9){
       price = 4.00;
    }
    else if(zone==10){
       price = 4.40;
    }
    return price;
}

/**
 * Duplica o array caso este esteja cheio. O tamanho do array deverá ser o dobro do tamanho atual. Deverá passar todos os elementos existentes no array para o novo array criado.
*/
private void increasePassengers(){
  for(int i=0; i<passengers.length; i++){
    if(numOfPassengers == passengers.length){
       passengers = Arrays.copyOf(passengers, passengers.length*2);
    }
  }
}

/**
 * Retorna um passageiro registado na aplicação, pelo seu NIF.
 *
 * @param nif - NIF do passageiro
 * @return passageiro caso exista
 */
public Passenger getPassengerByNIF(String nif){
  for(int i = 0 ; i < passengers.length ; i++){
  if(nif !=null && passengers[i].getNif().equals(nif)){
     return passengers[i];
  }
  }
  return null;
}

/**
 * Retorna a linha de metro onde exista determinada estação.
 *
 * @param station - estação a procurar
 * @return a linha, caso exista
 */
public SubwayLine lineWithStation(String station){
    SubwayLine line = null;
    for(int i = 0; i < lines.length; i++){
    if(station != null && lines[i].haveStation(station) == true){
       line=lines[i];
       break;
    }
    }
    return line;
}

/**
 * Retorna a linha de metro onde exista duas estações específicas.
 *
 * @param origin - estação de origem a procurar
 * @param destination - estação de destino a procurar
 * @return a linha, caso exista
 */
public SubwayLine lineWithBothStations(String origin, String destination){
    SubwayLine line = null;
    for(int i = 0; i < lines.length; i++){
    if(origin!=null && destination!=null && lines[i].haveTwoStations(origin, destination) == true){
        line=lines[i];
        break;
    }
    }
    return line;
}
}