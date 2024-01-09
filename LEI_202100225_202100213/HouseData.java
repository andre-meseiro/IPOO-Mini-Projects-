/**
 * Os detalhes de um imóvel a venda: endereço, área e indicação da existência de um quintal.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 17/1/2022
 */

public  class HouseData  {
    private Address  streetAddress;
    private int  squareMeters;
    private boolean hasAYard;

    /**
     * Constrói os detalhes de um imóvel com base no endereço.
     * O imóvel não tem quintal.
     * 
     * @param address o nome da rua, Lote,...
     * @param zipCode o Código Postal
     * @param city o nome da Cidade
     * @param squareMt a Área do imóvel
     */
    public HouseData(String address, String zipCode, String city, int squareMt) {
        streetAddress =  new Address(address, zipCode, city);
        squareMeters  = (squareMt > 0) ? squareMt : 0;
        hasAYard = false;
    }
    
    /**
     * Constrói os detalhes de um imóvel com base no endereço, na superfície e
     * a indicação da presença de um quintal.
     * 
     * @param address Rua, Lote,...
     * @param zipCode Código Postal
     * @param city Cidade
     * @param squareMt Área do imóvel
     * @param hasYard Existência de quintal
     */
    public HouseData(String address, String zipCode, String city, int squareMt, boolean hasYard) {
        this(address, zipCode, city, squareMt);
        this.hasAYard = hasAYard;
    }
    
    public Address getStreetAddress(){
        return streetAddress;
    }
    
    public boolean hasYard(){
        return hasAYard;
    }

    public int getSquareMeters(){
        return squareMeters;                
    }
    
    public String getCity(){
        return streetAddress.getCity();                
    }
    
    /**
     * Escreve o endereço no ecrã 
     */
    public void displayAddress(){
        streetAddress.display();
    }
    
    /**
     * Verifica se o imóvel está localizado numa determinada cidade
     * 
     * @param city Cidade
     * @return boolean Retorna verdadeiro se o imóvel está localizado nessa cidade
     */
    public boolean isLocatedAt(String city){
        return streetAddress.isLocatedAt(city);
    }

    public void setAddress(Address address){
        this.streetAddress = address;
    }
}