import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Aluno here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Aluno implements Comparable<Aluno>,Classificacoes
{
    private String numero;
    private String nome;
    private List<Double> notas;
    
    public Aluno()
    { this.numero = new String();
      this.nome = new String();
      this.notas = new ArrayList<>();
    }
    
    public Aluno (String num, String nom, List<Double> nota)
    { this.numero = num;
      this.nome = nom;
      setNotas(nota);

    }
    
    public Aluno (Aluno al)
    { this.numero = al.getNumero();
      this.nome = al.getNome();
      setNotas(al.getNotas());
    }  
    
    public String getNome()
    { return this.nome; }
    
    public String getNumero()
    { return this.numero; }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        List<Double> aux = new ArrayList<>();
        for(Double a: this.notas)
            aux.add(a);
        return aux;
    }

    public void setNotas(List<Double> notas) {
        this.notas = new ArrayList<>();
        for(Double a: notas){
            this.notas.add(a);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getNumero(), aluno.getNumero()) &&
                Objects.equals(getNome(), aluno.getNome()) &&
                Objects.equals(getNotas(), aluno.getNotas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getNome(), getNotas());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aluno{");
        sb.append("numero='").append(numero).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", notas=").append(notas);
        sb.append('}');
        return sb.toString();
    }

    public Aluno clone()
    { return new Aluno(this); }
    
    public int compareTo(Aluno a)
    { return this.nome.compareTo(a.getNome());
    }

    public double mediaClassificacoes(){
        double res = 0;
        for(Double d: this.notas)
            res += d;
        return res/this.notas.size();
    }
     
}