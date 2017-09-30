package br.com.lucanjos.maratonajsf.bean.view;

import br.com.lucanjos.maratonajsf.bean.dependent.TesteDependent;
import br.com.lucanjos.maratonajsf.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {

    private List<String> personagens = asList("Goku","Vegeta","Gohan");
    private List<String> personagemSelecionado = new ArrayList<>();
    private TesteDependent testeDependentBean;
    private final TesteSessionBean sessionBean;


    @Inject
    public TesteViewBean(TesteDependent testeDependentBean, TesteSessionBean sessionBean) {
        this.testeDependentBean = testeDependentBean;
        this.sessionBean = sessionBean;
    }

    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }

    public TesteDependent getTesteDependentBean() {
        return testeDependentBean;
    }

    public void setTesteDependentBean(TesteDependent testeDependentBean) {
        this.testeDependentBean = testeDependentBean;
    }

    @PostConstruct
    public void init(){
        System.out.println("Entrou post construct view");
        personagens = asList("Naruto","Hinata","Yondaime");
    }

    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
        testeDependentBean.getPersonagemSelecionado().add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }


}
