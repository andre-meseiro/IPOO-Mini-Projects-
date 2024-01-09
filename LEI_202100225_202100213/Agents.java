import java.util.ArrayList;

/**
 * Armazena todos os agentes pertencentes à imobiliária.
 * Não tem limite de agentes, e se não existir nenhum agente com disponibilidade
 * para aceitar uma nova casa para vender, a agência deverá contratar um novo.
 *
 * @author Grupo 3 (André Meseiro 202100225 202100225@estudantes.ips.pt e Rodrigo Elias 202100213 202100213@estudantes.ips.pt)
 * @version 12/1/2022
 */
public class Agents{
    private ArrayList <Agent> agents;

    /**
     * Constrói uma nova lista de agentes. Todos os agentes têm o valor null
     * até estarem inicializados com o método addAgent.
     */
    public Agents(){
        agents = new ArrayList <> ();
    }

    /**
     * Adiciona um novo agente na listagem.
     * 
     * @param agent o agent a adicionar.
     */
    public void addAgent(Agent agent){
        if(agent != null){
            agents.add(agent);
        }
    }
    
    /**
     * Retorna um agente da listagem, com base no seu número.
     * 
     * @return o agente procurado.
     */    
    public Agent getAgent(int number){
        if(number > 0){
            return agents.get(number-1);
        }
        return null;
    }
    
    /**
     * Remove um agente da listagem.
     * 
     * @param agent o agente a remover.
     */  
    public void removeAgent(Agent agent){
        if(agent != null){
            agents.remove(agent);
        }
    }
    
    /**
     * Cria um novo agente, caso nenhum dos agentes existentes se encontre disponível.
     * 
     * @param name o nome do novo agente.
     */
    public void hireNewAgent(String name){
        Agent newAgent = null;
        for(int i = 0; i < agents.size(); i++){
            if(agents.get(i).isAvailable() == false){
                newAgent = new Agent(name);
            }
        }
    }
    
    /**
     *  Escreve no ecrã a informação dos agentes da listagem por ordem crescente de comissões.
     */
    public void displayAgentsByComissions(){
        for(int i = 0; i < agents.size(); i++){
            if(agents.get(i).getSells() > agents.get(i+1).getSells()){
                agents.get(i).display();
            }
            else{
                  agents.get(i+1).display();
            }
        }
    }
    
    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < agents.size(); i++){
            output = agents.get(i).toString();
        }
        return output;
    }
}