
/**
 * Escreva a descrição da classe ComparatorAlunoNumero aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;

public class ComparatorAlunoNumero implements Comparator <Aluno>
{
    public int compare(Aluno a1, Aluno a2){
        if(a1.getNumero().compareTo(a2.getNumero()) < 0) return 1;
        if(a1.getNumero().compareTo(a2.getNumero()) > 0) return -1;
        return a1.getNome().compareTo(a2.getNome());
    }
    
}
