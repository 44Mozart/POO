
/**
 * Escreva a descrição da classe TesteTurma aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteTurma
{
    public static void main(String[] opts){
        Aluno a1 = new Aluno("1","Ze");
        Aluno a2 = new Aluno("2","Ana");
        Aluno a3 = new Aluno("3","To");
        
        TurmaAlunos t = new TurmaAlunos();
        
        t.insereAluno(a1);
        t.insereAluno(a2);
        t.insereAluno(a3);
        
        System.out.println("Turma:");
        System.out.println(t.toString());
        
        System.out.println("Alfabetica");
        System.out.println(t.alunosOrdemAlfabetica());
        
        System.out.println("Numerica:");
        System.out.println(t.alunosOrdemDecrescenteNumero());
    }
    
}
