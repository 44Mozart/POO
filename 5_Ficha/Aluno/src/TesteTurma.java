import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Escreva a descrição da classe TesteTurma aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteTurma
{
    public static void main(String[] opts){
        Aluno a1 = new Aluno("1","Ze", Arrays.asList(1.0,2.0,3.0));
        Aluno a2 = new Aluno("2","Ana",Arrays.asList(2.0,3.2,1.0));
        Aluno a3 = new Aluno("3","To",Arrays.asList(2.0,2.0,2.2));
        AlunoTE a4 = new AlunoTE("4","Mar",Arrays.asList(2.1,2.3,3.2),"Mc");
        TurmaAlunos t = new TurmaAlunos();
        try {
            t.insereAluno(a1);
            t.insereAluno(a2);
            t.removeAluno("5");
            t.insereAluno(a3);
            t.insereAluno(a1);
            t.insereAluno(a4);
        } catch (ExisteAlunoException e) {
            System.out.println("Já existe o aluno " + e.getMessage());
        } catch (NaoExisteAlunoException e){
            System.out.println("Não existe o aluno com numero " + e.getMessage());
        }




        System.out.println("Turma:");
        System.out.println(t.toString());
        
        System.out.println("Alfabetica");
        System.out.println(t.alunosOrdemAlfabetica());
        
        System.out.println("Numerica:");
        System.out.println(t.alunosOrdemDecrescenteNumero());

        try{
            t.gravaBinario("PL5.obj");
        }catch (IOException e) {
            System.out.println("Erro a gravar!");
        }

        TurmaAlunos t2 = new TurmaAlunos();
        try{
            t2 = t2.lerObj("PL5.obj");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro a ler!");
        }
        System.out.println(t2);
    }
    
}
