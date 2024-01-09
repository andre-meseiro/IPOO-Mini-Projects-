/**
 * Classe que representa o menu da aplicação. Responsável por toda a interação com o utilizador.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 23/12/2021
 */
public class Menu{
    private final InputReader reader;
    private final SubwayManager manager;

/**
 * Construtor da classe Menu
 *
 * @param manager - gestor da aplicação, responsável pela parte funcional
 */
public Menu(SubwayManager manager){
    this.reader = new InputReader();
    this.manager = manager;
}

/**
 * Apresenta o menu principal da aplicação e a respetiva interação.
 */
public void mainMenu(){
    int option;
    do{
        System.out.println("\n\tMENU PRINCIPAL");
        System.out.println("1. Gestão de Passageiros"); // DONE
        System.out.println("2. Gestão de Viagens");
        System.out.println("0. Sair");
        System.out.println("Escolha a sua opção:");

        option = readOption(0, 2);

        switch(option){
            case 1:
                displaySubMenuPassenger();
                break;
            case 2:
                displaySubMenuTrip();
                break;
            case 3:
                return;
        }
    } 
        while(option != 0);
}

/**
 * Apresenta o submenu de gestão de passageiros e a respetiva interação com o utilizador.
 */
private void displaySubMenuPassenger(){
    int option;
    do{
        System.out.println("\n\tMENU GESTAO DE PASSAGEIROS");
        System.out.println("1. Criar");
        System.out.println("2. Eliminar");
        System.out.println("3. Mostrar");
        System.out.println("4. Associar estatuto de estudante");
        System.out.println("0. Regressar ao Menu Anterior");
        System.out.println("Escolha a sua opção:");
        option = readOption(0, 4);

        switch (option){
            case 1:
                String nif = getNif();
                String name = getName();
                String birthDate = getBirthDate();
                if(manager.createPassenger(name, nif, birthDate)){
                    System.out.println("Passageiro criado com sucesso!");
                }
                break;
            case 2:
                nif = getNif();
                if(manager.deletePassenger(nif)){
                    System.out.println("Passageiro eliminado com sucesso!");
                }
                break;
            case 3:
                nif = getNif();
                manager.showPassenger(nif);
                break;
            case 4:
                nif = getNif();
                if(manager.addStudentStatus(nif)){
                    System.out.println("Registado com sucesso!");
                } 
                else{
                    System.out.println("Ocorreu um erro no registo!");
                }            
                break;
            case 5:
                mainMenu();
                break;
        }
    } 
        while(option != 0);
}

/**
 * Apresenta o submenu de gestão de viagens e a respetiva interação com o utilizador.
 */
private void displaySubMenuTrip(){
    int option;
    do{
        System.out.println("\n\tMENU GESTÃO DE VIAGENS");
        System.out.println("1. Simular Percurso");
        System.out.println("2. Viajar");
        System.out.println("3. Histórico de Viagens");
        System.out.println("0. Regressar ao Menu Anterior");
        System.out.println("Escolha a sua opção:");

        option = readOption(0, 3);

        switch(option){
            case 1:
                System.out.println("Percurso: ");
                // System.out.println(manager.traceRoute(origin, destination));
                System.out.println("Número de zonas percorridas :");
                // System.out.println(manager.route.getNumberOfZones());
                System.out.println("Custo da viagem :");
                // System.out.println(manager.route.trip.getPrice());
                break;
            case 2:
                String nif = getNif();
                displayTripMenu(nif);
                break;
            case 3:
                nif = getNif();
                manager.showTripHistory(nif);
                break;
            case 4:
                mainMenu();
                break;
            }
        } 
        while(option != 0);
}

/**
 * Apresenta o menu respetivo à funcionalidade de efetuar uma viagem.
 *
 * @param nif - NIF do passageiro
 */
private void displayTripMenu(String nif){
    System.out.println("Percurso :");
    // System.out.println(manager.makeTrip(origin, destination, startDay, startMonth, startYear, startHours, startMinutes, startSeconds, finishDay, finishMonth, finishYear, finishHours, finishMinutes, finishSeconds, nif);
}

/**
 * Solicita ao utilizador a inserção de um NIF válido
 *
 * @return NIF introduzido
 */
private String getNif(){
    boolean valid = false;
    String nif = "";
    do{
        System.out.println("Introduza o NIF do passageiro:");
        nif = reader.getText("NIF");
        valid = validNif(nif);
    } 
    while(!valid);
    return nif;
}

/**
 * Solicita ao utilizador a inserção de um nome de passageiro
 *
 * @return nome introduzido
 */
private String getName(){
    boolean valid = false;
    String name = "";
    do{
        System.out.println("Introduza o nome do passageiro:");
        name = reader.getText("Nome");
        valid = isValidString(name);
    } 
    while(!valid);
    return name;
}

/**
 * Solicita ao utilizador a inserção de uma data de nascimento no formato "AAAA-MM-DD".
 *
 * @return data de nascimento inserida
 */
private String getBirthDate(){
    boolean valid = false;
    String birthDate = "";
    do{
        System.out.println("Introduza a data de nascimento do passageiro no formato AAAA-MM-DD:");
        birthDate = reader.getText("Data de Nascimento");
        valid = validBirthDate(birthDate);
    } 
    while(!valid);
    return birthDate;
}

/**
 * Responsável pela leitura de uma opção introduzida
 *
 * @param minor
 * @param major
 * @return
 */
private int readOption(int minor, int major){
    int option;
    do{
        option = reader.getIntegerNumber("opção");
        if(option < minor || option > major){
            System.out.println(" Escolha uma opção correta (" + minor + " a " + major + ")");
        }
    } 
    while(option < minor || option > major);
    return option;
}

/**
 * Recebe uma String e valida se é composta por digitos.
 *
 * @param text - Texto a validar
 * @return true se for digitos, false caso pelo menos um dos caracteres não seja
 */
private boolean isDigit(String text){
  String str = "";
  boolean isDigit = true;
  for(int i = 0; i<str.length(); i++){
  if(!Character.isDigit(str.charAt(i))){
    isDigit = false;
    return false;
  }
  }
    System.out.println(isDigit);
    return true;
}

/**
 * Recebe uma string e valida se a mesma tem conteúdo
 *
 * @param st - texto a validar
 * @return true se não for vazia ou nula, false caso contrário
 */
private boolean isValidString(String st){
  if(st == "" || st == null){
    System.out.println("Por favor introduza uma string válida.");
    return false;
  }
    return true;
}

/**
 * Valida um NIF. Um NIF válido deverá ser composto por 9 digitos.
 *
 * @param nif - NIF a validar
 * @return true se for valido, false caso contrário
 */
private boolean validNif(String nif){
  if(nif.length() != 9){
    System.out.println("Por favor introduza um NIF com 9 digitos.");
    return false;
  }
    return true;
}

/**
 * Valida uma data de nascimento, recebida como texto no formato 'AAAA-MM-DD'
 *
 * @param birthDate - data a validar
 * @return true se for valida, false caso contrario
 */
private boolean validBirthDate(String birthDate){
  String dateFormat = "AAAA-MM-DD";
  if(dateFormat != "AAAA-MM-DD"){
    System.out.println("Por favor introduza uma data de nascimento válida");
    return false;
  }
    return true;
}
}
