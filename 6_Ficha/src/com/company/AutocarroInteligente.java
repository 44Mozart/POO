package com.company;

import java.util.Objects;

public class AutocarroInteligente extends Veiculo implements BonificaKms{
    private int ocupacao;
    private int lotacao;
    private int pontos;


    public AutocarroInteligente() {
        super();
        this.ocupacao = 0;
        this.lotacao = 0;
        this.pontos = 0;
    }

    public AutocarroInteligente(String matricula, String marca, String modelo, int ano, double velocidade_media, double preco, int soma_classificacoes, double classificacao_media, int numCfs, int numKms, int ocupacao,int lotacao,int pontos) {
        super(matricula, marca, modelo, ano, velocidade_media, preco, soma_classificacoes, classificacao_media, numCfs, numKms);
        this.ocupacao = ocupacao;
        this.lotacao = lotacao;
        this.pontos = pontos;
    }

    public AutocarroInteligente(AutocarroInteligente v) {
        super(v);
        this.ocupacao = v.getOcupacao();
        this.lotacao = v.getLotacao();
        this.pontos = v.getPtsPorKm();
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
                getLotacao() == that.getLotacao() &&
                pontos == that.pontos;
    }

    public int hashCode() {
        return Objects.hash(getOcupacao(), getLotacao(), pontos);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("AutocarroInteligente{");
        sb.append("ocupacao=").append(ocupacao);
        sb.append(", lotacao=").append(lotacao);
        sb.append(", pontos=").append(pontos);
        sb.append('}');
        return sb.toString();
    }

    public AutocarroInteligente clone(){
        return new AutocarroInteligente(this);
    }

    public double custoRealKM(){
        double percentagem = ocupacao/lotacao;
        if(percentagem <= 0.6) return getNumKms() * getPreco() * 1.5;
        return getNumKms() * getPreco() * 1.75;
    }

    public void definirPtsPorKm(int pts) {
        this.pontos = pts;
    }

    public int getPtsPorKm() {
        return this.pontos;
    }
}
