/**
 * O endereço de um imóvel, caracterizado pela rua, 
 * o código postal e a cidade onde está localizado o imóvel.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 17/1/2022
 */
public class Address{
    private String street;
    private String zipCode;
    private String city;
    
    /**
     * Constrói um novo endereço usando a rua, o código postal e a cidade.
     * Quando a rua, o código postal ou a cidade fornecidos não são válidos,
     * o construtor usa Strings vazias.
     * 
     * @param street a informação da rua
     * @param zip o código postal
     * @param city o nome da cida
     */
    public Address(String street, String zip,String city){
        this.street = (street != null) ? street : "";
        this.zipCode = (zip != null) ? zip : "";
        this.city = (city != null) ? city : "";
    }
    
    /**
     * Constrói um novo endereço. Os dados da rua, do código postal e da cidade
     * são inicializados com Strings vazias.
     */
    public Address(){
        this("","","");   
    }
    
    public String getCity(){
        return city;                
    } 
    public void display(){
        System.out.println("" + street + ", " + zipCode + ", "+ city);
    }
    
    /**
     * Verifica se um imóvel está localizado numa determinada cidade.
     * @param city uma String que indica o nome da cidade procurada.
     * @return boolean o valor é verdadeiro se está localizado na cidade, false se não estiver.
     */
    public boolean isLocatedAt(String city){
        return this.city.equalsIgnoreCase(city);
    }
}