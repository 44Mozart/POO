
/**
 * Escreva a descrição da classe CasaInteligente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class CasaInteligente
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private List<Lampada> lampadas;
    
    public CasaInteligente() {
        this.nome = new String();
        this.lampadas = new ArrayList<>();
    }
    
    public CasaInteligente (String nome, List<Lampada> lampadas){
        this.nome = nome;
        setLampadas(lampadas);
    } 
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public void setLampadas(List<Lampada> lampadas){
        this.lampadas = new ArrayList<>();
        for(Lampada l: lampadas)
            this.lampadas.add(l.clone());
    }
    
    public CasaInteligente(CasaInteligente c){
        this.nome = c.getNome();
        setLampadas(c.getLampadas());
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public ArrayList<Lampada> getLampadas(){
        ArrayList<Lampada> aux = new ArrayList<>();
        for(Lampada l: this.lampadas)
            aux.add(l);
        return aux;
    }
    
    public boolean equals (Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        CasaInteligente ci = (CasaInteligente) o;
        return this.nome.equals(ci.getNome()) &&
               this.lampadas.equals(ci.getLampadas());
        
    }
    
    public void addLampada (Lampada l){
        this.lampadas.add(l.clone());
    }
        
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }
    
    public void ligaLampadaNormal (int index){
        this.lampadas.get(index).lampON();
    }
    
    public void ligaLampadaEco (int index){
        this.lampadas.get(index).lampECO();
    }
    
    public int qtEmEco () {
        int c = 0;
        for(Lampada l: this.lampadas){
            if(l.getModo() == 2)
                c++;
        }
        return c;
    }
    
    public int qtEmEcoIT (){
        int c = 0;
        Iterator<Lampada> it = this.lampadas.iterator();
        while(it.hasNext()){
            Lampada l = it.next();
            if(l.getModo() == 2)
                c++;
        }
        return c;
    }
    
    public int qtEmEcoStreams(){
        return (int) this.lampadas.stream()
                                  .filter(l ->l.getModo() == 2)
                                  .count();
    }
    
    public void removeLampada(int index){
        this.lampadas.remove(index);
    }
    
    /*
    public void  ligaTodasEco(){
        for(Lampada l: this.lampadas){
            l.lampECO();
        }
    }
    */
    public void ligaTodasEco(){
        this.lampadas.stream()
                     .forEach(l -> l.lampECO());
    }
    
    /*
    public void  ligaTodasMax(){
        for(Lampada l: this.lampadas){
            l.lampON();
        }
    }   
    */
   
    public void ligaTodasMax(){
        this.lampadas.stream()
                     .forEach(l-> l.lampON());
    }
    
    /*public double consumoTotal(){
        double total = 0;
        for(Lampada l: this.lampadas){
            total += l.periodoConsumo();
        }
        return total;
    }
    */
   
    public double consumoTotal(){
        return (double) this.lampadas.stream()
                                     .mapToLong(Lampada :: getTotal)
                                     .sum();
    }
                            
    public void reset(){
        for(Lampada l: this.lampadas){
            l.setTotal(0);
        }
    }
    
    public Lampada lampadaMaisGastadora(){
        TreeSet<Lampada> ts = new TreeSet<>();
            // usa ordem natural dado pelo compareTo (da lampada)
        for(Lampada l: this.lampadas)
            ts.add(l);
        return ts.first().clone();
    }
}
