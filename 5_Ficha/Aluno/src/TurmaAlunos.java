
/**
 * Escreva a descrição da classe TurmaAlunos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TurmaAlunos implements Classificacoes
{
    private String nome;
    private String codigo;
    private Map<String,Aluno> alunos;
    
    
    public TurmaAlunos(){
        this.nome = new String();
        this.codigo = new String();
        this.alunos = new HashMap<>();
    }
    
    public TurmaAlunos (String n, String c, Map<String,Aluno> als){
        this.nome = n;
        this.codigo = c;
        setAlunos(als);
    }
    
    public TurmaAlunos(TurmaAlunos t){
        this.nome = t.getNome();
        this.codigo = t.getCodigo();
        setAlunos(t.getAlunos());
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public Map<String,Aluno> getAlunos(){
        Map<String,Aluno> aux = new HashMap<>();
        for(Map.Entry<String,Aluno> e: this.alunos.entrySet())
          aux.put(e.getKey(),e.getValue().clone());
        return aux;
    }
    
    public void setAlunos(Map<String,Aluno> als){
        this.alunos = new HashMap<>();
        als.entrySet().forEach(e -> this.alunos.put(e.getKey()
                                                   ,e.getValue().clone()));
    }
    // B.ii
    public void insereAluno(Aluno a) throws ExisteAlunoException {
        if(this.alunos.containsKey(a.getNumero()))
            throw new ExisteAlunoException(a.getNumero());
        else
            this.alunos.put(a.getNumero(),a.clone());
    }
    
    //B.iii
    public Aluno getAluno (String codAluno){
        return this.alunos.get(codAluno).clone();
    }
    
    //B.iv
    public void removeAluno (String codAluno) throws  NaoExisteAlunoException{
        if(!this.alunos.containsKey(codAluno)){
            throw new NaoExisteAlunoException(codAluno);
        }
        this.alunos.remove(codAluno);
    }

    //B.v
    public Set<String> todosOsCodigos(){
        return this.alunos.keySet();
    }
    
    //B.vi
    public int qtsAlunos(){
        return this.alunos.size();
    }
    
    //B.vii
    public Set<Aluno> alunosOrdemAlfabetica(){
        Set<Aluno> s = new TreeSet<>();
        for(Aluno a:this.alunos.values())
            s.add(a.clone());
        return s;
    }
    
    public Set<Aluno> alunosOrdemAlfabeticaStream(){
        return this.alunos.values()
                          .stream()
                          .map(a->a.clone())
                          .collect(Collectors.toCollection(TreeSet::new));
    }
    //B.viii
    
    public Set<Aluno> alunosOrdemDecrescenteNumero(){
        Set<Aluno> s = new TreeSet<>(new ComparatorAlunoNumero());
        for (Aluno a: this.alunos.values())
            s.add(a.clone());
            return s;
    }
      
  
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null ||o.getClass() != this.getClass()) return false;
        TurmaAlunos t = (TurmaAlunos) o;
        return this.nome.equals(t.getNome()) &&
               this.codigo.equals(t.getCodigo()) &&
               this.alunos.equals(t.getAlunos());
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Turma: "). append(this.nome)  . append("\n")
                           . append(this.codigo).append("\n")
                           . append(this.alunos);
        return s.toString();                
    }
    
    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }
    
    public int compareTo(TurmaAlunos t){
        return this.nome.compareTo(t.getNome());
    }

    public double mediaClassificacoes(){
        return this.alunos.values().stream()
                          .mapToDouble(a -> a.mediaClassificacoes())
                          .sum()/this.alunos.size();
    }
    
    
    
    
}
