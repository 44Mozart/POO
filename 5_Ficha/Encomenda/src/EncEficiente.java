
/**
 * Escreva a descrição da classe EncomendaEfi aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;


public class EncEficiente
{
    private ArrayList<LinhaEncomenda> encomendas;
    private String cliente;
    private String nif;
    private String morada;
    private String numero;
    private LocalDate data;
    
    public EncEficiente(){
        this.encomendas = new ArrayList<LinhaEncomenda>();
        this.cliente = "";
        this.nif = "";
        this.morada = "";
        this.numero = "";
        this.data = LocalDate.now();
    }
    
    public EncEficiente(ArrayList<LinhaEncomenda> encomendas, String c, String n, String m, String num){
        setEncomendas(encomendas);
        this.cliente = c;
        this.nif = n;
        this.morada = m;
        this.numero = num;
        this.data = LocalDate.now();
    }
    
    public EncEficiente(EncEficiente e){
        this.encomendas = e.getEncomendas();
        this.cliente = e.getCliente();
        this.nif = e.getNIF();
        this.morada = e.getMorada();
        this.numero = e.getNumero();
        this.data = e.getData();
    }

    //Getters

    public ArrayList<LinhaEncomenda> getEncomendas(){
        ArrayList<LinhaEncomenda> l = new ArrayList<>();
        
        for(LinhaEncomenda li : encomendas){
            l.add(li.clone());
        }
        return l;
    }
    
    public String getCliente(){
        return this.cliente;
    }
    public String getNIF(){
        return this.nif;
    }
    public String getMorada(){
        return this.morada;
    }
    public String getNumero(){
        return this.numero;
    }
    public LocalDate getData(){
        return this.data;
    }

    //Setters

    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas){
        this.encomendas = new ArrayList<LinhaEncomenda>(encomendas.size());
        for(LinhaEncomenda li : encomendas) this.encomendas.add(li.clone());
    }
    public void setCliente(String c){
        this.cliente = c;
    }
    public void setNIF(String NIF){
        this.nif = NIF;
    }
    public void setMorada(String add){
        this.morada = add;
    }
    public void setNumero(String num){
        this.numero = num;
    }
    public void setData(){
        this.data = LocalDate.now();
    }
    
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        EncEficiente aux = (EncEficiente) obj;
        if (aux.encomendas.size() != this.encomendas.size())
            return false;

        for(int i = 0; i < this.encomendas.size(); i++){
            if (!(this.encomendas.get(i).equals(aux.encomendas.get(i))))
                return false;
        }
        
        return (this.cliente.equals(aux.getCliente()) 
                && this.morada.equals(aux.getMorada()) 
                && (this.nif == aux.getNIF()) 
                && (this.numero == aux.getNumero()));
    }

    public EncEficiente clone(){
        return (new EncEficiente(this));
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ");
        sb.append(this.cliente+"\n");
        sb.append("N fiscal: ");
        sb.append(this.nif+"\n");
        sb.append("Morada: ");
        sb.append(this.morada+"\n");
        sb.append("ID: ");
        sb.append(this.numero+"\n");
        sb.append("Data: ");
        sb.append(this.data+"\n");
        this.encomendas.forEach( a -> sb.append(a.toString()+"\n"));

        return sb.toString();

    }
    
    //B)
    
    //ii.)
    
    public double calculaValorTotal(){
        double total = 0;
        for(LinhaEncomenda l : encomendas){
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }
    
    //iii.)
    public double calculaValorDescontoEnc(){
        double desconto=0;
        for(LinhaEncomenda l : encomendas){
            desconto += l.calculaValorDesconto();
        }
        return desconto;
    }
    
    //iv.)
    public int numeroTotalProdutos(){
        int totalProdutos = 0;
        for(LinhaEncomenda l : encomendas){
            totalProdutos += l.getQuantidade();
        }
        return totalProdutos;
    }
    
    //v.)
    public boolean existeProdutoEncomenda(String refProduto){
        boolean flag = false;
        while(!flag){
            for(LinhaEncomenda l : encomendas){
                if(l.getReferencia().equals(refProduto)) flag = true;
            }
        }
        return flag;
    }
    
    //vi.)
    public void adicionaEncomendas(LinhaEncomenda encomendas){
        this.encomendas.add(encomendas);
    }
    
    //vii.)
    public void removeProduto(String codProd){
        boolean flag = false;
        Iterator<LinhaEncomenda> it = encomendas.iterator();
        LinhaEncomenda l;

        while(it.hasNext() && !flag){
            l = it.next();
            if(l.getReferencia().equals(codProd)){
                it.remove();
                flag=true;
            }
        }
    }

}
