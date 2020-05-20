package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {
    private Map<String, Veiculo> veiculos;

    /* Construtores */

    /* Por omissão */

    public DriveIt(){
        this.veiculos = new HashMap<>();
    }

    /* Parametrizado */

    public DriveIt(Map<String, Veiculo> veiculos){
        setVeiculos(veiculos);
    }

    /* De cópia */

    public DriveIt(DriveIt di){
        setVeiculos(di.getVeiculos());
    }

    /* Getter */

    public Map<String, Veiculo> getVeiculos(){
        Map<String, Veiculo> novo = new HashMap<>();

        this.veiculos.entrySet().forEach(v -> novo.putIfAbsent(v.getKey(), v.getValue().clone()));

        return novo;
    }

    /* Setter */

    public void setVeiculos(Map<String, Veiculo> veiculos) {
        this.veiculos = new HashMap<>();

        veiculos.entrySet().forEach(v -> this.veiculos.putIfAbsent(v.getKey(), v.getValue().clone()));
    }


    /* Métodos do exercício 1 da ficha 6 */

    /* 1.a) */
    public boolean existeVeiculo(String cod){
        return this.veiculos.containsKey(cod);
    }

    /* b) */
    public int quantos(){
        return this.veiculos.size();
    }

    /* c) */
    public int quantos(String marca){
        int sum = 0;

        for(Veiculo v : this.veiculos.values()){
            if(v.getMarca().equals(marca)) sum++;
        }

        return sum;
    }

    /* d) */
    public Veiculo getVeiculo(String cod){
        return this.veiculos.get(cod).clone();
    }

    /* e) */
    public void adiciona(Veiculo v){
        this.veiculos.putIfAbsent(v.getMatricula(), v.clone());
    }

    /* f) */
    public List<Veiculo> getVeiculosList(){
        return this.veiculos.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }

    /* g) */
    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v: vs) this.veiculos.putIfAbsent(v.getMatricula(), v.clone());
    }

    /* h) */
    public void registarAluguer(String codVeiculo, int numKms){
        Veiculo antigo = this.veiculos.get(codVeiculo);
        int kms = antigo.getNumKms();
        kms += numKms;
        antigo.setNumKms(kms);
    }

    /* i) */
    public void classificarVeiculo(String cod, int classificacao){
        Veiculo antigo = this.veiculos.get(cod);
        int somaCfs  = antigo.getSoma_classificacoes() + classificacao;
        int numCfs = antigo.getNumCfs() + 1;
        double novaClassificacao = (double) somaCfs / numCfs;
        antigo.setClassificacao_media(novaClassificacao);
        antigo.setNumCfs(numCfs);
        antigo.setSoma_classificacoes(somaCfs);
    }

    /* j) */
    public double custoRealKm(String cod){
        return (this.veiculos.get(cod).calculaCustoRealKm());
    }

    /* g) Veiculo Premium*/


    public List<Veiculo> veiculosOrdenadosCusto(){
        return this.veiculos.values().stream()
                            .map(Veiculo::clone)
                            .sorted(Veiculo::comparePreco)
                            .collect(Collectors.toList());
    }


    public Veiculo veiculoMaisBarato(){
        return this.veiculos.values().stream()
                .sorted(Veiculo::comparePreco)
                .collect(Collectors.toList()).get(0);
    }

    public Veiculo veiculoMenosUtilizado(){
        return this.veiculos.values().stream()
                            .sorted(Veiculo::compareKm)
                            .collect(Collectors.toList()).get(0);
    }

    /* Equals, toString e clone */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriveIt driveIt = (DriveIt) o;
        return Objects.equals(this.veiculos, driveIt.getVeiculos());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DriveIt{");
        sb.append("veiculos=").append(veiculos);
        sb.append('}');
        return sb.toString();
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

    public void entraEmPromocao(boolean p){
        for(Veiculo v: this.veiculos.values()){
            if( v instanceof VeiculoOcasiao) {
                VeiculoOcasiao vo = (VeiculoOcasiao) v;
                vo.setPromocao(true);
            }
        }
    }



    /* ------------------ FASE 2 --------------- */

    //a)
    public Set<Veiculo> ordenarVeiculos(){
        Set<Veiculo> aux = new TreeSet<>();
        for(Veiculo v: this.veiculos.values())
            aux.add(v.clone());
        return aux;
    }

    //b)
    public List<Veiculo> ordenarVeiculoList(){
        return this.veiculos.values().stream()
                            .sorted()
                            .map(v -> v.clone())
                            .collect(Collectors.toList());
    }

    //c)
    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        Set<Veiculo> s = new TreeSet<>(c);
        for(Veiculo v: this.veiculos.values())
            s.add(v.clone());
        return s;
    }

    //d)
    public static Map<String,Comparator<Veiculo>> ordem = new TreeMap<>();

    public void addCriterio(String c, Comparator<Veiculo> cp){
        ordem.put(c,cp);
    }

    //e)
    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Set<Veiculo> s = new TreeSet<>(ordem.get(criterio));
        for(Veiculo v: this.veiculos.values())
            s.add(v.clone());
        return s.iterator();
    }

    /* ------------------ FASE 2 --------------- */

    public List<BonificaKms> daoPontos(){
        List<BonificaKms> aux = new ArrayList<>();
        for(Veiculo v: this.veiculos.values()) {
            if (v instanceof VeiculoPremium || v instanceof AutocarroInteligente) {
                BonificaKms bk = (BonificaKms) v.clone();
                aux.add(bk);
            }
        }
        return aux;
    }




}
