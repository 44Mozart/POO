
/**
 * Escreva a descrição da classe Grafo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Grafo
{
    private Map<Integer,Set<Integer>> adj;
    
    public Grafo(){
        this.adj = new HashMap<>(); 
    }
    
    public void addArco(Integer vOrig, Integer vDest){
        this.adj.putIfAbsent(vOrig,new HashSet<>());
        this.adj.putIfAbsent (vDest,new HashSet<>());
        this.adj.get(vOrig).add(vDest);
    }
    
    public boolean isSynk(Integer v){
        return this.adj.get(v).isEmpty();
    }
    
    public boolean isSource(Integer v){
        boolean source = this.adj.containsKey(v);
        Iterator<Set<Integer>> it = this.adj.values().iterator();
        while(it.hasNext() && source)
            source = !it.next().contains(v);
        return source;
    }
    
    public boolean haCaminho (Integer vOrig,Integer vDest){
        return haCaminho(vOrig,vDest,new HashSet<>());
    }
    
    public boolean haCaminho(Integer vOrig, Integer vDest,Set<Integer> visitados){
        if (vOrig == vDest) return true;
        if (!(this.adj.containsKey(vOrig)) || visitados.contains(vOrig)) 
            return false;
        Iterator<Integer> it = this.adj.get(vOrig).iterator();
        boolean haC = false;
        visitados.add(vOrig);
        while(it.hasNext() && !haC)
            haC = haCaminho(it.next(),vDest,visitados);
        return haC;
    }
}
