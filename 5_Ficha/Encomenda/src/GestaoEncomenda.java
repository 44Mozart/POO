
/**
 * Escreva a descrição da classe GestaoEncomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class GestaoEncomenda
{
    private Map<String, EncEficiente> gestao;
    
    public GestaoEncomenda (){
        this.gestao = new HashMap<>();
    }
    
    public GestaoEncomenda(Map<String,EncEficiente> g){
        setGestao(g);
    }
    
    public GestaoEncomenda (GestaoEncomenda g){
        setGestao(g.getGestao());
    }
    
    public void setGestao(Map<String,EncEficiente> g){
        this.gestao = new HashMap<>();
        g.entrySet()
         .forEach(e->this.gestao.put(e.getKey(),e.getValue().clone()));
    }
    
    public Map<String,EncEficiente> getGestao(){
        Map<String,EncEficiente> aux = new HashMap<>();
        for(Map.Entry<String,EncEficiente> e: this.gestao.entrySet())
            aux.put(e.getKey(),e.getValue().clone());
        return aux;
    }
    
    public GestaoEncomenda clone (){
        return (new GestaoEncomenda(this));
    }
    
    public boolean equals (Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        GestaoEncomenda g = (GestaoEncomenda) o;
        return (this.gestao.equals(g.getGestao()));
    }
    
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("Encomendas: \n").append(this.gestao);
        return sb.toString();
    }
    
    //B.i
    public Set<String> todosCodigosEnc(){
        return this.gestao.keySet();
    }
    
    //B.ii
    public void addEncomenda(EncEficiente enc){
        this.gestao.put(enc.getNumero(),enc.clone());
    }
    
    //B.iii
    public EncEficiente getEncomenda(String codEnc){
        return this.gestao.get(codEnc).clone();
    }
    
    //B.iv
    public void removeEncomenda (String codEnc){
        this.gestao.remove(codEnc);
    }
    
    //B.v
    public String enocmendaComMaisProdutos(){
        return this.gestao.values().stream()
                                   .map(EncEficiente :: clone)
                                   .sorted(new ComparatorQtsProdutos())
                                   .collect(Collectors.toList())
                                   .get(0).getNumero();
    }
    
    //B.vi
    public Set<String> encomendasComProduto (String codProd){
        return this.gestao.values()
                          .stream()
                          .map(EncEficiente:: clone)
                          .filter(l -> l.existeProdutoEncomenda(codProd))
                          .map(a -> a.getNumero())
                          .collect(Collectors.toSet());
    }
    
    //B.vii
    public Set<String> encomendasAposData (LocalDate d){
        TreeSet<String> aux = new TreeSet<>();
        for(EncEficiente e: this.gestao.values()){
            if(e.getData().isAfter(d))
                aux.add(e.getNumero());
        }
        return aux;
    }
    
    //B.viii
    public Set<EncEficiente> encomendasValorDecrescente(){
        TreeSet<EncEficiente> t = new TreeSet<>(new ComparatorValorEnc());
        for(EncEficiente e: this.gestao.values())
            t.add(e.clone());
        return t;
    }
    
    //B.iv
    public List<String> funcaoAux (String codProd){
        return this.gestao.values().stream()
                          .map(EncEficiente::clone)
                          .filter(a->a.existeProdutoEncomenda(codProd))
                          .map(a->a.getNumero())
                          .collect(Collectors.toList());
    }
                         
    
    public Map<String,List<String>> encomendasDeProduto(){
        HashMap<String,List<String>> aux = new HashMap<>();
        for(EncEficiente e: this.gestao.values()){
            aux.put(e.getNumero(),this.funcaoAux(e.getNumero()));
        }
        return aux;
    }
    
}
