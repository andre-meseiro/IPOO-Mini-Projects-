import java.time.LocalDate;

/**
 * Classe que representa um passageiro de metro
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 21/12/2021
 */
public class Passenger{
    private String name;
    private String nif;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String birthDate;
    private Trip[] tripsLog;
    private boolean student;
    private int age;
    private int numberOfTrips;

/**
 * Construtor da classe Passenger. Inicializa também o histórico de viagens, limitado a dez elementos.
 *
 * @param name - nome do passageiro
 * @param nif - NIF do passageiro
 * @param birthYear - ano de nascimento do passageiro
 * @param birthMonth - mês de nascimento do passageiro
 * @param birthDay - dia de nascimento do passageiro
 */
public Passenger(String name, String nif, String birthDate){
    if(name != "" && name != null && nif.length() == 9 && birthYear >= 1920 && birthYear <= 2022 && birthMonth > 0 && birthMonth <= 12 && birthDay > 0 && birthDay <= 31){
        this.name = name;
        this.nif = nif;
        birthDate = birthYear + "-" + birthMonth + "-" + birthDay;
        tripsLog = new Trip[10];
    }
    else{
        System.out.println("Introduza informações válidas.");
    }
}

/**
 * Adiciona uma viagem ao histórico de viagens do passageiro. A viagem deverá ser adicionada na primeira posição do respetivo array, limitado a dez elementos. As mais antigas serão eliminadas.
 *
 * @param trip - viagem efetuada
 */
public void addTripLog(Trip trip){
    Trip[] tripsLog2 = new Trip[tripsLog.length +1];
    if(tripsLog.length < numberOfTrips && trip != null){
        System.arraycopy(tripsLog, 0, tripsLog2, 0, tripsLog.length);
        tripsLog2[tripsLog.length] = trip;
        tripsLog = tripsLog2;
    }
    else if(numberOfTrips == tripsLog.length && trip != null){
        tripsLog[tripsLog.length-1] = null;
        System.arraycopy(tripsLog, 0, tripsLog2, 0, tripsLog.length);
        tripsLog2[tripsLog.length] = trip;
        tripsLog = tripsLog2;
    }
}

/**
 * Apresenta o histórico das viagens efetuadas.
 */
public void showTripLog(){
    for(int i=0; i<tripsLog.length; i++){
        tripsLog[i].showTripInfo();
    }  
}

/**
 * Calcula o desconto do passageiro mediante a sua idade ou condição.
 *
 * @return o valor de desconto (em percentagem)
 */
public int getDiscount(){
    int discount = 0;
    if(age < 10){
        discount = 90;
    }
    else if(student == false && age >= 10 && age <= 25){
        discount = 18;
    }
    else if(student == true){
        discount = 36;   
    }
    else if(age >= 65){
        discount = 55;
    }
    return discount;
}

/**
 * Marca o passageiro como estudante, caso ainda não tenha sido assinalado e esteja compreendido no intervalo de idades para o efeito.
 *
 * @return o sucesso da operação. true caso sucesso, false caso contrário.
 */
public boolean markAsStudent(){
    if(age >= 10 && age <= 30){
        student = true;
        return true;
    }
    else{
        return false;
    }
}    

private int getCurrentYear(){
    return LocalDate.now().getYear();
}

private int getCurrentMonth(){
    return LocalDate.now().getMonthValue();
}

private int getCurrentDay(){
    return LocalDate.now().getDayOfMonth();
}

/**
 * Calcula a idade a partir da data de nascimento
 *
 * @return valor da idade
 */
public int getAge(){
    if(getCurrentMonth() < birthMonth){
        age = getCurrentYear() - birthYear -1;
    }
    else if(getCurrentMonth() > birthMonth){
        age = getCurrentYear() - birthYear;
    }
    else if(getCurrentMonth() == birthMonth && getCurrentDay() < birthDay){
        age = getCurrentYear() - birthYear -1;
    }
    else if(getCurrentMonth() == birthMonth && getCurrentDay() >= birthDay){
        age = getCurrentYear() - birthYear;
    }
    return age;
}

/**
 * Apresenta a informação do passageiro.
 */
public void showInfo(){
    System.out.println("Nome do passageiro: " + name);
    System.out.println("Idade do passageiro: " + age);
    System.out.println("NIF: " + nif);
    System.out.println("Data de nascimento: " + birthDate);
    if(student == true){
        System.out.println("É Estudante.");
    }
    else{
        System.out.println("Não é estudante.");
    }
}

public String getName(){
    return name;
}

public String getNif(){
    return nif;
}

public Trip[] getTripsLog(){
    return tripsLog;
}

public boolean isStudent(){
    return student;
}

public void setName(String newName){
    newName = name;
}

public void setNif(String newNif){
    newNif = nif;
}
}