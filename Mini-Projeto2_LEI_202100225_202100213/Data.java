/**
 * Classe que fornece um conjunto de dados da aplicação.
 *
 * @author Grupo3 (André Meseiro - 202100225 202100225@estudantes.ips.pt e Rodrigo Elias - 202100213 202100213@estudantes.ipt.pt)
 * @version 23/12/2021
 */
public class Data{
     private static Station st1, st2, st3, st4, st5, st6, st7, st8, st9, st10, st11, st12,
                            st13, st14, st15, st16, st17, st18, st19, st20, st21, st22, st23, st24,
                            st25, st26;

/**
 * Inicializa todas as estações
 */
private static void initializeStations(){
    // AZUL
    st1 = new Station("Senhor de Matosinhos", Zone.MTS1, false);
    st2 = new Station("Matosinhos Sul", Zone.MTS1, false);
    st3 = new Station("Senhora da Hora", Zone.PRT2, true);
    st4 = new Station("Ramalde", Zone.PRT2, true);
    st5 = new Station("Casa da Música", Zone.PRT1, true);
    st6 = new Station("Trindade", Zone.PRT1, true);
    st7 = new Station("Campanhã", Zone.PRT1, true);
    st8 = new Station("Estádio do Dragão", Zone.PRT1, true);

    // VERMELHA
    st9 = new Station("Póvoa de Varzim", Zone.PVVC1, false);
    st10 = new Station("Vila do Conde", Zone.PVVC1, false);
    st11 = new Station("Azurara", Zone.VCD1, false);
    st12 = new Station("Vilar de Pinheiro", Zone.VCD2, false);
    st13 = new Station("Fonte do Cuco", Zone.MAI2, true);
    st3 = new Station("Senhora da Hora", Zone.PRT2, true);
    st4 = new Station("Ramalde", Zone.PRT2, true);
    st5 = new Station("Casa da Música", Zone.PRT1, true);
    st6 = new Station("Trindade", Zone.PRT1, true);
    st7 = new Station("Campanhã", Zone.PRT1, true);
    st8 = new Station("Estádio do Dragão", Zone.PRT1, true);

    // VERDE
    st14 = new Station("ISMAI", Zone.MAI1, false);
    st15 = new Station("Parque Maia", Zone.MAI2, false);
    st13 = new Station("Fonte do Cuco", Zone.MAI2, true);
    st3 = new Station("Senhora da Hora", Zone.PRT2, true);
    st4 = new Station("Ramalde", Zone.PRT2, true);
    st6 = new Station("Trindade", Zone.PRT1, true);
    st7 = new Station("Campanhã", Zone.PRT1, true);

    // AMARELA
    st16 = new Station("Hospital São João", Zone.PRT3, false);
    st17 = new Station("Polo Universitário", Zone.PRT3, false);
    st18 = new Station("Marquês", Zone.PRT1, false);
    st6 = new Station("Trindade", Zone.PRT1, true);
    st19 = new Station("São Bento", Zone.PRT1, false);
    st20 = new Station("General Torres", Zone.VNG1, false);
    st21 = new Station("Santo Ovídio", Zone.VNG1, false);

    // ROXA
    st22 = new Station("Aeroporto", Zone.VCD2, false);
    st23 = new Station("Custóias", Zone.MAI2, false);
    st13 = new Station("Fonte do Cuco", Zone.MAI2, true);
    st3 = new Station("Senhora da Hora", Zone.PRT2, true);
    st4 = new Station("Ramalde", Zone.PRT2, true);
    st5 = new Station("Casa da Música", Zone.PRT1, true);
    st6 = new Station("Trindade", Zone.PRT1, true);

    //LARANJA
    st3 = new Station("Senhora da Hora", Zone.PRT2, true);
    st4 = new Station("Ramalde", Zone.PRT2, true);
    st5 = new Station("Casa da Música", Zone.PRT1, true);
    st6 = new Station("Trindade", Zone.PRT1, true);
    st7 = new Station("Campanhã", Zone.PRT1, true);
    st8 = new Station("Estádio do Dragão", Zone.PRT1, true);    
    st24 = new Station("Nasoni", Zone.PRT3, false);
    st25 = new Station("Rio Tinto", Zone.MAI3, false);
    st26 = new Station("Fânzeres", Zone.GDM1, false);
}

/**
 * Permite obter as linhas de metro com respetivas estações.
 *
 * @return um array de linhas de metro
 */
public static SubwayLine[] getLines(){
    initializeStations();
    
    SubwayLine[] lines = new SubwayLine[6];
    
    Station[] stations1 = {st1, st2, st3, st4, st5, st6, st7, st8};
    lines[0] = new SubwayLine('A', "Azul", stations1);
    
    Station[] stations2 = {st9, st10, st11, st12, st13, st3, st4, st5, st6, st7, st8};
    lines[1] = new SubwayLine('B', "Vermelha", stations2);

    Station[] stations3 = {st14, st15, st13, st3, st4, st6, st7};
    lines[2] = new SubwayLine('C', "Verde", stations3);

    Station[] stations4 = {st16, st17, st18, st6, st19, st20, st21};
    lines[3] = new SubwayLine('D', "Amarela", stations4);

    Station[] stations5 = {st22, st23, st13, st3, st4, st5, st6};
    lines[4] = new SubwayLine('E', "Roxa", stations5);

    Station[] stations6 = {st3, st4, st5, st6, st7, st8, st24, st25, st26};
    lines[5] = new SubwayLine('F', "Laranja", stations6);

    return lines;
}

/**
 * Permite obter os preços por zona.
 *
 * @return um array com os preços por zona
 */
public static double[] getPrices(){
    double[] prices = {0.80, 1.20, 1.60, 2.00, 2.40, 2.80, 3.20, 3.60, 4.00, 4.40};
    return prices;
}
}