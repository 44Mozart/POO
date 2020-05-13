package com.company;

public class VeiculoNormal extends Veiculo {


    public VeiculoNormal(){
        super();
    }

    public VeiculoNormal(String matricula, String marca, String modelo,
                          int ano, double velocidade_media, double preco,
                          int soma_classificacoes, double classificacao_media,
                          int numCfs, int numKms){
        super(matricula, marca, modelo, ano, velocidade_media, preco, soma_classificacoes,
                classificacao_media, numCfs, numKms);
    }

    public VeiculoNormal(VeiculoNormal v){
        super(v);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("\n");
        return s.toString();
    }

    public VeiculoNormal clone(){
        return new VeiculoNormal(this);
    }

    public double custoRealKM(){
        return getNumKms() * getPreco() * 1.10;
    }


}
