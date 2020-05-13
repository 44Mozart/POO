
/**
 * Escreva a descrição da classe TesteEncomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.time.LocalDate;
public class TesteEncomenda
{
    public static void main(String[] args){
        LinhaEncomenda l1 = new LinhaEncomenda("M44","Caderno",2.3, 10, 0.23, 0.3);
        LinhaEncomenda l2 = new LinhaEncomenda("A83","Caneta",2.7, 17, 0.23, 0.1);
        LinhaEncomenda l3 = new LinhaEncomenda("D57","Lapis",1.3, 7, 0.23, 0.35);
        LinhaEncomenda l4 = new LinhaEncomenda("E81","Capa",1.2, 20, 0.23, 0.2);
        LinhaEncomenda l5 = new LinhaEncomenda("N10","Agenda",23.7, 5, 0.23, 0.25);
        LinhaEncomenda l6 = new LinhaEncomenda("R01","Borracha",254.3, 1, 0.23, 0.5);
        
        EncEficiente e1 = new EncEficiente(); 
        EncEficiente e2 = new EncEficiente(); 
        EncEficiente e3 = new EncEficiente(); 
   
        e1.adicionaEncomendas(l1);
        e1.adicionaEncomendas(l2);
        
        e2.adicionaEncomendas(l3);
        e2.adicionaEncomendas(l4);
        
        e3.adicionaEncomendas(l5);
        e3.adicionaEncomendas(l6);
        
        e1.setCliente("Maria");
        e1.setNIF("505137275");
        e1.setMorada("Braga");
        e1.setNumero("EncM1324");
        e1.setData();
        
        System.out.println(e1.toString());
        
        e2.setCliente("Francisco");
        e2.setNIF("789456123");
        e2.setMorada("Viana do Castelo");
        e2.setNumero("EncX8967");
        e2.setData();
        
        System.out.println(e1.toString());
        
        e1.setCliente("Barbara");
        e1.setNIF("536273890");
        e1.setMorada("Barcelos");
        e1.setNumero("EncD3456");
        e1.setData();
        
        System.out.println(e1.toString());
        
        GestaoEncomenda gestor = new GestaoEncomenda();
        
        gestor.addEncomenda(e1);
        gestor.addEncomenda(e2);
        gestor.addEncomenda(e3);
        
        //Verificar se o gestor tem as encomendas incorporadas
        System.out.println("\n" + gestor.toString());
        
        //Verificar com a encomenda com maior quantidade de produtos
        System.out.println("\n" + gestor.enocmendaComMaisProdutos());
        
        //Verificar qual a encomenda que possui um produto especificado
        System.out.println("\n" + gestor.encomendasComProduto("R01"));
        
        //Verficar as encomendas por decrescente do seu valor
        System.out.println("\n" + gestor.encomendasValorDecrescente());

        //Verificar as encomendas associadas a um produto
        System.out.println("\n" + gestor.encomendasDeProduto());

        System.out.println("\n" + gestor.funcaoAux("M44"));

        //Verificar se existe encomenda e devolver
        System.out.println("\n" + gestor.getEncomenda("EncM1324").toString());

        //Verificar quais as encomendas após certa data
        System.out.println("\n" + gestor.encomendasAposData(LocalDate.now()));

        //Verificar se remove uma encomenda especifica
        gestor.removeEncomenda("EncM1324");

        System.out.println("\n" + gestor.toString());

        //Verificar todos os codigos de encomendas
        System.out.println("\n" + gestor.todosCodigosEnc());
    }

}
        
