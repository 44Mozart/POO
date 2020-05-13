package com.company;

import java.time.LocalDate;

public class Youtube {

    private String nome;
    private int conteudo;
    private LocalDate data;
    private double resolucao;
    private double tempoM;
    private double tempoS;
    private int numCom;
    private String[] comentarios;
    private int likes;
    private int dislikes;

    public Youtube(){
        nome = new String();
        conteudo = 0;
        data = LocalDate.now();
        resolucao = 0;
        tempoM = 0;
        tempoS = 0;
        numCom = 0;
        comentarios = new String[numCom];
        likes = 0;
        dislikes = 0;
    }

    public Youtube(String nome, int conteudo, LocalDate data,
                   double resolucao, double tempoM, double tempoS,
                   int numCom, String[] comentarios, int likes,
                   int dislikes) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.data = data;
        this.resolucao = resolucao;
        this.tempoM = tempoM;
        this.tempoS = tempoS;
        this.numCom = numCom;
        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Youtube(Youtube y){
        nome = y.getNome();
        conteudo = y.getConteudo();
        data = y.getData();
        resolucao = y.getResolucao();
        tempoM = y.getTempoM();
        tempoS = y.getTempoS();
        numCom = y.getNumCom();
        comentarios = y.getComentarios();
        likes = y.getLikes();
        dislikes = y.getDislikes();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getResolucao() {
        return resolucao;
    }

    public void setResolucao(double resolucao) {
        this.resolucao = resolucao;
    }

    public double getTempoM() {
        return tempoM;
    }

    public void setTempoM(double tempoM) {
        this.tempoM = tempoM;
    }

    public double getTempoS() {
        return tempoS;
    }

    public void setTempoS(double tempoS) {
        this.tempoS = tempoS;
    }

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public String[] getComentarios() {
        String[] aux = new String[this.comentarios.length];
        for(int i = 0; i < this.comentarios.length; i++){
            aux[i] = this.comentarios[i];
        }
        return aux;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = new String[this.numCom];
        int i;
        for(i = 0; i < comentarios.length; i++){
            this.comentarios[i] = comentarios[i];
        }
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }



    public void insereComentario(String comentario){
        int i;
        String[] aux = new String[this.comentarios.length+1];
        for(i = 0; i < this.comentarios.length; i++){
            aux[i] = this.comentarios[i];
        }
        this.comentarios[i] = comentario;
        for(i = 0; i < this.comentarios.length +1; i++){
            this.comentarios[i] = aux[i];
        }
        this.numCom++;
    }
}
