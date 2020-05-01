package com.company;

import java.util.Arrays;

public class Turma {

    private int[][] notasTurma;

    public Turma(){
        this.notasTurma = new int[5][5];
    }

    public Turma(int[][] notasTurma) {
        this.notasTurma = notasTurma;
    }


    public int[][] atualiza (int aluno,int unidade, int nota){
        this.notasTurma[aluno][unidade] = nota;
        return this.notasTurma;
    }

    public int somaUC (int UC){
        int i,soma = 0;
        for(i = 0; i < 5; i++){
            soma += this.notasTurma[i][UC];
        }
        return soma;
    }

    public double mediaA (int aluno){
        int i;
        int somaA = 0;
        int mA = 0;
        double media;
        for(i = 0; i < 5; i++){
            mA++;
            somaA += this.notasTurma[aluno][i];
        }
        media = somaA/mA;
        return media;
    }

    public double mediaUC (int UC) {
        int i, soma = 0;
        double media;
        soma = somaUC(UC);
        media = soma /5;
        return media;
    }

    public int maiorN (){
        int i, j, maior = this.notasTurma[0][0];
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if( this.notasTurma[i][j] > maior)
                    maior = this.notasTurma[i][j];
            }
        }
        return maior;
    }

    public int menorN(){
        int i, j, menor = this.notasTurma[0][0];
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if(this.notasTurma[i][j] < menor){
                    menor = this.notasTurma[i][j];
                }
            }
        }
        return menor;
    }

    public int[] acimaN(int a){
        int i,j,m = 0;
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if(this.notasTurma[i][j] >= a){
                    m++;
                }
            }
        }
        int[] aux = new int[m];
        m = 0;
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if(this.notasTurma[i][j] >= a){
                    aux[m] = this.notasTurma[i][j];
                    m++;
                }
            }
        }
        return aux;
    }

    public double mediaMUC(){
        int i;
        double maior = mediaUC(0);
        for(i = 0; i < 5; i++){
            if(mediaUC(i) > maior){
                maior = mediaUC(i);
            }
        }
        return maior;
    }



}
