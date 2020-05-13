
/**
 * Escreva a descrição da classe ComparatorQtsProdutos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;
public class ComparatorQtsProdutos implements Comparator <EncEficiente>
{
   public int compare(EncEficiente e1, EncEficiente e2){
       return (e2.numeroTotalProdutos() - e1.numeroTotalProdutos());
   }
}

