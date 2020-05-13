


/**
 * Escreva a descrição da classe Stack aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.ArrayList;

public class Stack
{
    private ArrayList<String> nomes;
    
    
    public Stack (){
        this.nomes = new ArrayList<>();
    }
    
    public Stack (ArrayList<String> nomes){
        this.setNomes(nomes);
    }
    
    public Stack (Stack st){
        this.setNomes(st.getNomes());
    }
    
    public void setNomes(ArrayList<String> nomes){
        this.nomes = new ArrayList<>();
        for (String s : nomes){
            this.nomes.add(s);
        }
    }
    
    public ArrayList<String> getNomes(){
        ArrayList <String> aux = new ArrayList<>();
        for(String s : this.nomes){
            aux.add(s);
        }
        return aux;
    }
    
    public String top (){
        return this.nomes.get(this.nomes.size()-1);
    }
    
    public void pop (){
        this.nomes.remove(this.nomes.size()-1);
    }
    
    public void push (String s){
        this.nomes.add(s);
    }
    
    public boolean empty (){
        return this.nomes.isEmpty();
    }
    
    public int lenght (){
        return this.nomes.size();
    }
    
}
