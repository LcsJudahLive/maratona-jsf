package br.com.lucanjos.maratonajsf.bean.estudante;

import br.com.lucanjos.maratonajsf.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable{
    private Estudante estudante = new Estudante();
    private List<String> nomesArray = asList("Lucas", "Santos", "Anjos");
    private Set<String> nomesSet = new HashSet<>(asList("Goku", "Naruto"));
    private Map<String,String> nomesMap = new HashMap<>();
    private boolean mostrarNotas = false;
    private boolean mostrarLink = false;

    public void setMostrarLink(boolean mostrarLink) {
        this.mostrarLink = mostrarLink;
    }

    public boolean isMostrarLink() {
        return mostrarLink;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    {

        nomesMap.put("Goku", "O mais forte");
        nomesMap.put("key1", "value1");
        nomesMap.put("key2","value2");

        for(Map.Entry<String,String> entry : nomesMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void executar(String param){
        System.out.println("Call to database with parameter " + param);
        System.out.println("getting data...");
        System.out.println("displaying data...");
    }

    public String irParaIndex2(){
        return "index2?faces-redirect=true";
    }

    public void exibirNotas(){
        this.mostrarNotas = true;
    }

    public void esconderNotas(){
        this.mostrarNotas = false;
    }

    public void exibirLink(){
        this.mostrarLink = true;
    }

    public void esconderLink(){
        this.mostrarLink = false;
    }

    public void calcularCubo(LambdaExpression le, long value){
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), value);
        System.out.println(result);
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public List<String> getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(List<String> nomesArray) {
        this.nomesArray = nomesArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
