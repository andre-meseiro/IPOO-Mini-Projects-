import java.util.Arrays;

/**
 * Classe responsável pelo funcionamento da aplicação. Centraliza a informação e interação com o utilizador.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 23/12/2021
 */
public class SubwayManager{
    private DataBase db;
    private Menu menu;
    private Passenger passenger;
    private Route route;
    private Trip trip;

/**
 * Construtor da classe SubwayManager. Inicializa a base de dados com informação da aplicação e o menu de interação com o utilizador.
 */
public SubwayManager(){
    this.db = new DataBase();
    this.menu = new Menu(this);
}

/**
 * Cria um passageiro na base de dados.
 *
 * @param name - nome do passageiro
 * @param nif - nif do passageiro
 * @param birthdate - data de nascimento do passageiro
 */
public boolean createPassenger(String name, String nif, String birthDate){
     if(name != null && nif != null && birthDate != null){
     db.addPassenger(passenger);
     return true;
     }
     return false;
}

/**
 * Elimina um passageiro existente na base de dados, caso exista
 *
 * @param nif - nif do passageiro
 * @return o sucesso da operação. True caso sucesso, false caso contrário.
 */
public boolean deletePassenger(String nif){
      if(nif != null){
      db.deletePassenger(nif);
      return true;
      }
      return false;
}

/**
 * Apresenta informação de um passageiro existente.
 *
 * @param nif - nif do passageiro
 */
public void showPassenger(String nif){
    if(passenger.getNif().equals(nif)){
        passenger.showInfo();
    }
}

/**
 * Marca um passageiro com estatuto de estudante.
 *
 * @param nif - nif do passageiro
 * @return o sucesso da operação. True caso sucesso, false caso contrário.
 */
public boolean addStudentStatus(String nif){
    if(nif != null){
        passenger.markAsStudent();
        return true;
    }
    return false;
}

/**
 * Traça um percurso que permite determinar todas as estações percorridas, da estação de inicio á estação de destino. Deverá considerar as situações da estação de origem e de destino encontrarem-se na mesma linha, ou em linhas diferentes. Neste caso, deverá considerar a mudança entre linhas.
 *
 * @param origin - estação de origem
 * @param destination - estação de destino
 * @return rota criada com base nas estações de origem e de destino
 */
public Route traceRoute(String origin, String destination){
    if(origin != null && destination != null){
        SubwayLine line = db.lineWithBothStations(origin, destination);
        // Station[] stations  = createRoute(origin, destination, line);
        // Route route = new Route(stations);
    }
    return route;
}

/**
 * Permite efetuar uma viagem. A viagem é efetuada com base na estação de origem e destino, recebe também a hora e data de inicio e de fim. esta viagem ficará associada a um passageiro. Após a viagem, o histórico da mesma deverá ser associada ao passageiro, bem como o custo asssociado debitado do seu cartão de viagem.
 *
 * @param origin - nome da estação de origem
 * @param destination - nome da estação de destino
 * @param initialTime - data e hora do início da viagem
 * @param finalTime - data e hora do final da viagem
 * @param nif - NIF do passageiro
 * @return a viagem realizada
 */
public Trip makeTrip(String origin, String destination, int startDay, int startMonth, int startYear, int startHours, int startMinutes, int startSeconds, int finishDay, int finishMonth, int finishYear, int finishHours, int finishMinutes, int finishSeconds, String nif){
    if(origin != null && destination != null && startDay > 0 && startDay <= 31 && startMonth > 0 && startMonth <= 12 && startYear >= 2021 && startHours >= 0 && startHours <= 24 && startMinutes >= 0 && startMinutes < 60 && startSeconds >= 0 && startSeconds < 60 && finishDay > 0 && finishDay <= 31 && finishMonth > 0 && finishMonth <= 12 && finishYear >= 2021 && finishHours >= 0 && finishHours <= 24 && finishMinutes >= 0 && finishMinutes < 60 && finishSeconds >= 0 && finishSeconds < 60){
    Route route = traceRoute(origin, destination);
    Passenger passenger = db.getPassengerByNIF(nif);
    int zones = route.getNumberOfZonesTraveled();
    double price = db.getPriceOfZone(zones);
    Trip trip = new Trip(route, startDay, startMonth, startYear, startHours, startMinutes, startSeconds, finishDay, finishMonth, finishYear, finishHours, finishMinutes, finishSeconds, price);
    passenger.addTripLog(trip);
    }
    return trip;
}

/**
 * Apresenta o histórico de viagens de um determinado passageiro.
 *
 * @param nif - NIF do passageiro
 */
public void showTripHistory(String nif){
    if(nif != null){
        passenger.showTripLog();
    }
}

/**
 * Método auxiliar que concatena dois arrays de estações num array único.
 *
 * @param st1 -primeiro array de estações
 * @param st2 - segundo array de estações
 * @return array resultante da concatenação dos dois arrays recebidos
 */
private Station[] concatStations(Station[] st1, Station[] st2){
    Station[] concatStations = Arrays.copyOf(st1, st1.length + st2.length);
    System.arraycopy(st2, 0, concatStations, st1.length, st2.length);
    return concatStations;
}

/**
 * Obtém uma estação em determinada linha que contém ligação com a outra estação de destino.
 *
 * @param originLine - linha de origem onde deverá existir uma estação de ligação
 * @param destination - estação de destino
 * @return estação de correspondência, que efetua a ligação entre a linha de origem e a estação de destino
 */
private Station getStationLinkedToDestination(SubwayLine originLine, String destination){
     Station[] station = originLine.getStations();
     Station[] stdn = db.lineWithStation(destination).getStations();
     for(int i=0; i<station.length; i++){
     for(int j=0;j<stdn.length;j++){
     if(station[i].getName() == stdn[j].getName()){
         return station[i];
     }
     }
     }
     return null;
}

/**
 * Traça um percurso entre a estação de origem e a estação de destino
 *
 * @param originPosition - estação onde inicia o percurso
 * @param destinationPosition - estação onde finaliza o percurso
 * @param line - linha onde o percurso deverá ser efetuado
 * @return array de estações com todas as estações percorridas, da estação de origem à estação de destino
 */
private Station[] createRoute(int originPosition, int destinationPosition, SubwayLine line){
    int position = destinationPosition - originPosition;
    int initial = originPosition;
    Station[] stations = new Station[initial];
    for(int i=0;i<position;++i){
        stations[i] = line.getStationInPosition(initial);
        initial++;
    }
    return stations;
}
}