package br.com.lucanjos.maratonajsf.bean.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@Dependent
public class TesteDependent implements Serializable{
    private List<String> personagens = asList("Goku","Vegeta","Gohan");
    private List<String> personagemSelecionado = new ArrayList<>();
    private List<String> categoriasList = new ArrayList<>();

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }

    @PostConstruct
    public void init(){
        System.out.println("Entrou post construct view Dependent");
        personagens = asList("Naruto","Hinata","Yondaime");
    }

    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
