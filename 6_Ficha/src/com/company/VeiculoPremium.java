package com.company;

import java.util.Objects;

public class VeiculoPremium extends Veiculo {

    private double taxa;


    public VeiculoPremium(){
        super();
        taxa = 0;
    }

    public VeiculoPremium(String matricula, String marca, String modelo, int ano, double velocidade_media, double preco, int soma_classificacoes, double classificacao_media, int numCfs, int numKms, double taxa) {
        super(matricula, marca, modelo, ano, velocidade_media, preco, soma_classificacoes, classificacao_media, numCfs, numKms);
        this.taxa = taxa;
    }

    public VeiculoPremium(VeiculoPremium v) {
        super(v);
        this.taxa = v.getTaxa();
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getPreco(){
        return taxa * super.getPreco();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VeiculoPremium)) return false;
        if (!super.equals(o)) return false;
        VeiculoPremium that = (VeiculoPremium) o;
        return Double.compare(that.getTaxa(), getTaxa()) == 0;
    }

    public int hashCode() {
        return Objects.hash(getTaxa());
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append(" Taxa: ").append(taxa);
        s.append("\n");
        return s.toString();
    }

    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }

    public double custoRealKM(){
        return getNumKms() * getPreco() * taxa;
    }

}
