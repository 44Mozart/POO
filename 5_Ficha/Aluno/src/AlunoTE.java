import java.util.List;

/**
 * Escreva a descrição da classe AlunoTE aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class AlunoTE extends Aluno
{
    private String empresa;
    //estudante trabalhador tem tudo o que os alunos têm + empresa 
    
    //constructors
    public AlunoTE(){
        super(); //invoca o construtor da superclasse
                 //neste caso invoca contrutor de Aluno sem args(omissão)
        this.empresa = new String();
    }
    
    public AlunoTE(String numero, String nome, List<Double> notas, String empresa){
       super(numero, nome,notas); //aqui invoca construtor da classe Aluno(parametrizado)
       this.empresa = empresa;
    }
    
    public AlunoTE(AlunoTE a){
        //super(a); nao posso invocar assim, porque a classe aluno recebe um Aluno
                    //aqui a não é do tipo Aluno, é AlunoTE
                    //Solução:
       super(a.getNumero(),a.getNome(),a.getNotas());//os gets são publicos
       this.empresa = a.getEmpresa();
    }
    
    public String getEmpresa(){
       return this.empresa;
    }
    
  
    //se nao escrever um toString, herda o da classe Aluno(que não imprime info da empresa)
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(super.toString()); //invoca toString da superclasse(aluno) para obter numero e nome
      sb.append("empresa: ").append(this.empresa).append("\n");
      return sb.toString();
    }
    
    //isto faz com que mesmo ao imprimir a turma, apareça a empresa
    public AlunoTE clone(){
        return new AlunoTE(this);
    }
}
