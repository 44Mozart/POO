package com.company;

import java.util.Objects;

public abstract class Veiculo implements Comparable<Veiculo> {
    private String matricula;
    private String marca;
    private String modelo;
    private int ano;
    private double velocidade_media;
    private double preco;
    private int soma_classificacoes; /* Soma todas as classificações feitas ao carro para depois calcular a média */
    private double classificacao_media; /* Média das classificações do carro */
    private int numCfs; /* Numero de classificações feitas ao carro */
    private int numKms;

    /* Construtores */

    /* Por omissão */

    public Veiculo() {
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.velocidade_media = 0.0;
        this.preco = 0.0;
        this.soma_classificacoes = 0;
        this.classificacao_media = 0.0;
        this.numCfs = 0;
        this.numKms = 0;
    }

    /* Parametrizado */

    public Veiculo(String matricula, String marca, String modelo, int ano, double velocidade_media, double preco,
                   int soma_classificacoes, double classificacao_media, int numCfs, int numKms) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade_media = velocidade_media;
        this.preco = preco;
        this.soma_classificacoes = soma_classificacoes;
        this.classificacao_media = classificacao_media;
        this.numCfs = numCfs;
        this.numKms = numKms;
    }

    /* De cópia */

    public Veiculo(Veiculo v){
        this.matricula = v.getMatricula();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.ano = v.getAno();
        this.velocidade_media = v.getVelocidade_media();
        this.preco = v.getPreco();
        this.soma_classificacoes = v.getSoma_classificacoes();
        this.classificacao_media = v.getClassificacao_media();
        this.numCfs = v.getNumCfs();
        this.numKms = v.getNumKms();
    }

     /* Getters */

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getVelocidade_media() {
        return velocidade_media;
    }

    public double getPreco() {
        return preco;
    }

    public int getSoma_classificacoes() {
        return soma_classificacoes;
    }

    public double getClassificacao_media() {
        return classificacao_media;
    }

    public int getNumCfs(){
        return this.numCfs;
    }

    public int getNumKms(){
        return this.numKms;
    }

    /* Setters */

    public void setNumCfs(int n){
        this.numCfs = n;
    }

    public void setNumKms(int numKms){
        this.numKms = numKms;
    }

    public void setClassificacao_media(double classificacaomed){
        this.classificacao_media = classificacaomed;
    }

    public void setSoma_classificacoes(int soma_classificacoes){
        this.soma_classificacoes = soma_classificacoes;
    }

    /* Método de instância */

    public double calculaCustoRealKm(){
        return (this.getPreco() + (0.1 * this.getPreco()));
    }

    /* Equals, toString e clone */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.getAno() &&
                Double.compare(veiculo.getVelocidade_media(), velocidade_media) == 0 &&
                Double.compare(veiculo.getPreco(), preco) == 0 &&
                soma_classificacoes == veiculo.getSoma_classificacoes() &&
                Double.compare(classificacao_media, veiculo.getClassificacao_media()) == 0 &&
                Objects.equals(matricula, veiculo.getMatricula()) &&
                Objects.equals(marca, veiculo.getMarca()) &&
                Objects.equals(modelo, veiculo.getModelo()) &&
                numCfs == veiculo.getNumCfs() &&
                Double.compare(veiculo.getNumKms(), numKms) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" Veiculo{");
        sb.append(" matricula = '").append(matricula).append('\'');
        sb.append(", marca = '").append(marca).append('\'');
        sb.append(", modelo = '").append(modelo).append('\'');
        sb.append(", ano = ").append(ano);
        sb.append(", velocidade_media = ").append(velocidade_media);
        sb.append(", preco = ").append(preco);
        sb.append(", soma_classificacoes = ").append(soma_classificacoes);
        sb.append(", classificacao_media = ").append(classificacao_media);
        sb.append(", numCfs = ").append(numCfs);
        sb.append(", numKms = ").append(numKms);
        sb.append('}');
        return sb.toString();
    }

    public int compareTo(Veiculo v){
        if(this.marca.equals(v.getMarca()))
            return  this.modelo.compareTo(v.getModelo());
        return this.marca.compareTo(v.getMarca());
    }

    public int comparePreco(Veiculo v){
        return Double.compare(this.preco,v.getPreco());
    }

    public int compareKm(Veiculo v){
        return Double.compare(this.numKms,v.getNumKms());
    }

    public abstract Veiculo clone();

    public abstract double custoRealKM();

}
