package com.company;
/**
 * Escreva a descrição da classe VeiculoOcasiao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class VeiculoOcasiao extends Veiculo{
    private boolean promocao;
    
    public VeiculoOcasiao(){
        super();
        this.promocao = false;
    }
    
    public VeiculoOcasiao(String matricula, String marca, String modelo,
                   int ano, double velocidade_media, double preco,
                   int soma_classificacoes, double classificacao_media,
                   int numCfs, int numKms, boolean p){
        super(matricula, marca, modelo, ano, velocidade_media, preco, soma_classificacoes,
        classificacao_media, numCfs, numKms);
        this.promocao = p;
    }
    
    public VeiculoOcasiao(VeiculoOcasiao v){
        super(v);
        this.promocao = v.getPromocao();
    }
    
    public boolean getPromocao(){
        return this.promocao;
    }
    
    public double getPreco(){
        return this.promocao ? 0.75 * super.getPreco() : super.getPreco();
    }
    
    public void setPromocao(boolean p){
        this.promocao = p;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        if(this.promocao) s.append(" Em Promocao ->").append(getPreco());
        else s.append(" Sem Promocao!");
        s.append("\n");
        return s.toString();
    }
    
    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }

    public double custoRealKM(){
        return getNumKms() * getPreco() * 1.10;
    }


}
