/**
 * Classe que representa uma viagem.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 19/12/2021
 */
public class Trip{
    private Route route;
    private int startDay;
    private int startMonth;
    private int startYear;
    private String startDate;
    private String startTime;
    private int startHours;
    private int startMinutes;
    private int startSeconds;
    private int finishDay;
    private int finishMonth;
    private int finishYear;
    private String finishDate;
    private String finishTime;
    private int finishHours;
    private int finishMinutes;
    private int finishSeconds;
    private int numberOfZonesTraveled;
    private double price;
    private String tripTime;

/**
 * Construtor da classe Trip. Recebe um percurso, uma data de início, uma data de fim, uma hora de início, uma hora de fim e o preço da viagem. Calcula também o tempo da viagem.
 * 
 * @param route - percurso
 * @param startDay e finishDay- dias de início e fim da viagem
 * @param startMonth e finishMonth - mêses de início e fim da viagem
 * @param startYear e finishYear - anos de início e fim da viagem
 * @param startHours e finishHours - horas de início e fim da viagem
 * @param startMinutes e finishMinutes - minutos de início e fim da viagem
 * @param startSeconds e finishSeconds - segundos de início e fim da viagem
 * @param price - preço da viagem
 */
public Trip(Route route, int startDay, int startMonth, int startYear, int startHours, int startMinutes, int startSeconds, int finishDay, int finishMonth, int finishYear, int finishHours, int finishMinutes, int finishSeconds, double price){
    if(route != null && startDay > 0 && startDay <= 31 && startMonth > 0 && startMonth <= 12 && startYear >= 2021 && startHours >= 0 && startHours <= 24 && startMinutes >= 0 && startMinutes < 60 && startSeconds >= 0 && startSeconds < 60 && finishDay > 0 && finishDay <= 31 && finishMonth > 0 && finishMonth <= 12 && finishYear >= 2021 && finishHours >= 0 && finishHours <= 24 && finishMinutes >= 0 && finishMinutes < 60 && finishSeconds >= 0 && finishSeconds < 60 && price > 0){
        this.route = route;
        this.startDate = startDate;
        this.startHours = startHours;
        this.startMinutes = startMinutes;
        this.startSeconds = startSeconds;
        this.finishDate = finishDate;
        this.finishHours = finishHours;
        this.finishMinutes = finishMinutes;
        this.finishSeconds = finishSeconds;
        this.price = price;
        startTime = startHours + ":" + startMinutes + ":" + startSeconds;
        finishTime = finishHours + ":" + finishMinutes + ":" + finishSeconds;
        startDate = startDay + "/" + startMonth + "/" + startYear;
        finishDate = finishDay + "/" + finishMonth + "/" + finishYear;
        tripTime = (startHours - finishHours) + ":" + (startMinutes - finishMinutes) + ":" + (startSeconds - finishSeconds);
    }
    else{
        System.out.println("Introduza informações válidas sobre a viagem.");
    }
}

public Route getRoute(){
    return route;
}

public String getStartDate(){
    return startDate;
}

public String getStartTime(){
    return startTime;
}

public String getFinishDate(){
    return finishDate;
}

public String getFinishTime(){
    return finishTime;
}

public double getPrice(){
    return price;
}

public int getNumberOfZonesTraveled(){
    int numberOfZonesTraveled = route.getNumberOfZonesTraveled();
    return numberOfZonesTraveled;
}

public String getTripTime(){
    return tripTime;
}

/**
 * Mostra informação sobre a viagem.
 */
public void showTripInfo(){
    route.showRouteInfo();
    System.out.println("Hora de início: " + startTime);
    System.out.println("Hora de fim: " + finishTime);
    System.out.println("Número de zonas percorridas: " + numberOfZonesTraveled);
    System.out.println("Duração total da viagem: " + tripTime);
    System.out.println("Custo da viagem: " + price);
}

/**
 * Mostra informação resumida sobre a viagem.
 */
public void showTripSummary(){
    System.out.println("Estação de origem: " + route.getOriginStation());
    System.out.println("Estação de destino: " + route.getDestinationStation());
    System.out.println("Duração: " + tripTime);
    System.out.println("Total de zonas percorridas: " + numberOfZonesTraveled);
    System.out.println("Preço: " + price);
}
}