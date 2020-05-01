package com.company;

import java.util.Arrays;

public class Inteiros {
    private int[] inteiros;

    public Inteiros(int[] inteiros) {
        this.inteiros = inteiros;
    }

    public int minimo (){
        int menor = this.inteiros[0];
        for(int i = 0; i < this.inteiros.length;i++){
            if(this.inteiros[i] < menor){
                menor = this.inteiros[i];
            }
        }
        return menor;
    }

    public int[] array2indices(int a, int b){
        int[] aux = new int[(b-a)];
        int j = 0;
        for(int i = a; i < b; i++){
            aux[j] = this.inteiros[i];
            j++;
        }
        return aux;
    }

    public int[] comuns(Inteiros a){
        int i,j,m = 0;
        for( i = 0; i < this.inteiros.length ; i++) {
            for (j = 0; j < a.inteiros.length; j++) {
                if (this.inteiros[i] == a.inteiros[j]) {
                    m++;
                }
            }
        }
        int[] aux = new int[m];
        m = 0;
        for( i = 0; i < this.inteiros.length ; i++){
            for(j = 0; j < a.inteiros.length; j++){
                if(this.inteiros[i] == a.inteiros[j]) {
                    aux[m] = this.inteiros[i];
                    m++;
                }
            }
        }
        return aux;
    }

    public int[] ordena(){
        Arrays.sort(this.inteiros);
        return this.inteiros;
    }

    public int procura(int a){
        return Arrays.binarySearch(this.inteiros,a);
    }
}
