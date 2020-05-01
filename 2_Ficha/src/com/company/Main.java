package com.company;

public class Main {

    public static void main(String[] args) {
        Inteiros a,b,c;
        int[] a1 = {3,2,1,4};
        int[] b1 = {100,2,23,0,3};
        int[] c1 = {1,2,3,4,5,-1};
        a = new Inteiros(a1);
        b = new Inteiros(b1);
        c = new Inteiros(c1);

        // ----------------- 1 -------------
        System.out.println("----------- EXERCICIO 1 ------------");
        //a
        System.out.print("Exercicio 1a): ");
        System.out.println("O menor de A e: " + a.minimo());

        //b
        int[] auxb = b.array2indices(0,2);
        System.out.print("Exercicio 1b): ");
        for(int i = 0; i < auxb.length; i++){
            System.out.print(auxb[i] + " ");
        }
        System.out.print("\n");

        //c
        int[] auxc = c.comuns(a);
        System.out.print("Exercicio 1c): ");
        for(int i = 0; i < auxc.length; i++){
            System.out.print(auxc[i] + " ");
        }
        System.out.print("\n");
        System.out.println();


        // ----------------- 2 -------------
        System.out.println("----------- EXERCICIO 2 ------------");

        Turma t1;
        int i;
        int[][] n1 = new int[5][5];
        for(i = 0; i < 5; i++){
            n1[0][i] = 30;
            n1[1][i] = 100;
            n1[2][i] = 20;
            n1[3][i] = 75;
            n1[4][i] = 20;
        }
        t1 = new Turma(n1);


        //a
        int[][] aux2a = t1.atualiza(2,1,75);
        System.out.print("Exercicio 2a): ");
        System.out.print("Aluno: 2, UC: 1, Nota: " + aux2a[2][1]);
        System.out.print("\n");

        //b
        double somaUC = t1.somaUC(2);
        System.out.print("Exercicio 2b): Soma: " + somaUC);
        System.out.print("\n");

        //c
        double mediaA = t1.mediaA(2);
        System.out.print("Exercicio 2c): Media: " + mediaA);
        System.out.print("\n");

        //d
        double mediaUC = t1.mediaUC(2);
        System.out.print("Exercicio 2d): Media: " + mediaUC);
        System.out.print("\n");

        //e
        int maiorN = t1.maiorN();
        System.out.print("Exercicio 2e): Nota maior: " + maiorN);
        System.out.print("\n");

        //f
        int menorN = t1.menorN();
        System.out.print("Exercicio 2f): Nota menor: " + menorN);
        System.out.print("\n");

        //g
        int[] acimaN = t1.acimaN(50);
        System.out.print("Exercicio 2g): ");
        for(i = 0; i < acimaN.length; i++){
            System.out.print(acimaN[i] + " ");
        }
        System.out.print("\n");

        //i
        double maiorMUC = t1.mediaMUC();
        System.out.print("Exercicio 2i): Media maior de todas as UC: " + maiorMUC);
        System.out.print("\n");

        System.out.println();


        // ----------------- 4 -------------
        System.out.println("----------- EXERCICIO 4 ------------");

        int[] aux4a = c.ordena();
        System.out.print("Exercicio 4a): ");
        for(i = 0; i < aux4a.length; i++){
            System.out.print(aux4a[i] + " ");
        }
        System.out.print("\n");

        int aux4b = b.procura(100);
        System.out.print("Exercicio 4b): " + aux4b);
        System.out.print("\n");

    }
}
