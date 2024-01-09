/**
 * Um imóvel à venda. O imóvel é caracterizado por um número autoincremenetado,
 * por um preço de venda em Euros e os seus detalhes. Para ser considerado de luxo,
 * o preço ao metro quadrado do imóvel deve ser superior a 4000.0 Euros.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022
 */
public class Listing{  
    private int number; 
    private double price; 
    private HouseData houseData;
    private static int numberOfListings = 0;
    private static final double MINIMUM_SQUARE_PRICE = 4000.0;
    
    /**
     * Constrói um novo imóvel com base na informação do preço, do endereço,
     * do código postal, da cidade e da superficie. 
     * 
     * @param price o preço do imóvel
     * @param street a informação da rua
     * @param zip o código postal
     * @param city o nome da cidade
     * @param squareMt a superfície do imóvel
     */
    public Listing(double price, String street, String zipCode, String city, int squareMt){
        number =  ++numberOfListings;
        this.price  = price;
        houseData  =   new HouseData(street,zipCode,city,squareMt); 
    }

    /**
     * Constrói um novo imóvel com base na informação do preço, do endereço,
     * do código postal, da cidade e da superficie.
     * 
     * @param price o preço do imóvel
     * @param street a informação da rua
     * @param zip o código postal
     * @param city o nome da cidade
     * @param squareMt a superfície do imóvel
     */
    public Listing(double price, String street, String zipCode, String city, int squareMt,boolean hasYard){
        number =  ++numberOfListings;
        this.price  = price;
        houseData  =   new HouseData(street,zipCode,city,squareMt,hasYard); 
    }

    public Listing(double price, HouseData houseData, boolean hasYard){
        number =  ++numberOfListings;
        this.price  = price;
        this.houseData  = houseData; 
    }
    
    public double getPrice(){
        return price;
    }

    public int getNumber(){
        return number;
    }
    public double getSquareMeters(){
        return houseData.getSquareMeters();
    } 
    
    public boolean hasAYard(){
        return houseData.hasYard();
    }
    
    public String getCity(){
        return houseData.getCity();
    }
    
    /**
     * Escreve no ecrã a informação do imóvel
     */
    public void display(){
        System.out.println("#"  + number  +  " - preço de EUR "  + price);
        System.out.print("Endereço: ");
        houseData.displayAddress();
        System.out.println(houseData.getSquareMeters()  +  "  m2");  
    }
    
    /**
     * Permite verificar se um imóvel está localizado numa determinada cidade
     * 
     * @param city o nome da cidade procurada
     * 
     * @return booleano o valor verdeiro indica que o imóvel é localizado na cidade procurada
     */
    public boolean isLocatedAt(String city){
        return houseData.isLocatedAt(city);
    }
    
    /**
     * Permite verificar se um imóvel é de luxo.
     * 
     * @return booleano o valor verdeiro indica que o imóvel é considerado de luxo.
     */      
    public static boolean isLuxuary(double price, double squareMeters){
        double SquareMeterPrice = price / squareMeters;
        return SquareMeterPrice >= MINIMUM_SQUARE_PRICE;
    }
    
    @Override
    public String toString(){
        return "\n Número do Imóvel: " + number + "Preço do Imóvel: " + price + "\n Info do imóvel: " + houseData;
    }
}