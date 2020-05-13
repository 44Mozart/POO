package com.company;

import java.util.Objects;

public class AutocarroInteligente extends Veiculo{
    private int ocupacao;
    private int lotacao;


    public AutocarroInteligente() {
        super();
        this.ocupacao = 0;
        this.lotacao = 0;
    }

    public AutocarroInteligente(String matricula, String marca, String modelo, int ano, double velocidade_media, double preco, int soma_classificacoes, double classificacao_media, int numCfs, int numKms, int ocupacao,int lotacao) {
        super(matricula, marca, modelo, ano, velocidade_media, preco, soma_classificacoes, classificacao_media, numCfs, numKms);
        this.ocupacao = ocupacao;
        this.lotacao = lotacao;
    }

    public AutocarroInteligente(AutocarroInteligente v) {
        super(v);
        this.ocupacao = v.getOcupacao();
        this.lotacao = v.getLotacao();
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutocarroInteligente)) return false;
        if (!super.equals(o)) return false;
        AutocarroInteligente that = (AutocarroInteligente) o;
        return getOcupacao() == that.getOcupacao() &&
                getLotacao() == that.getLotacao();
    }

    public int hashCode() {
        return Objects.hash(getOcupacao(), getLotacao());
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append(" Ocupacao: ").append(ocupacao);
        s.append(" Lotacao Maxima: ").append(lotacao);
        s.append("\n");
        return s.toString();
    }

    public AutocarroInteligente clone(){
        return new AutocarroInteligente(this);
    }

    public double custoRealKM(){
        double percentagem = ocupacao/lotacao;
        if(percentagem <= 0.6) return getNumKms() * getPreco() * 1.5;
        return getNumKms() * getPreco() * 1.75;
    }
}
