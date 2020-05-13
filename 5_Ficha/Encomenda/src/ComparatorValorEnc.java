
/**
 * Escreva a descrição da classe ComparatorValorEnc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.Comparator;
public class ComparatorValorEnc implements Comparator <EncEficiente>
{
    public int compare(EncEficiente e1, EncEficiente e2){
        return ((int)(e2.calculaValorTotal() - e1.calculaValorTotal()));
    }
}
