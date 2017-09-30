package br.com.lucanjos.maratonajsf.bean.application;

import br.com.lucanjos.maratonajsf.bean.dependent.TesteDependent;
import br.com.lucanjos.maratonajsf.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> list;
    private final TesteDependent testeDependentBean;
    private final TesteSessionBean testeSessionBean;

    @Inject
    public TesteApplicationBean(TesteDependent testeDependentBean, TesteSessionBean testeSessionBean) {
        this.testeDependentBean = testeDependentBean;
        this.testeSessionBean = testeSessionBean;
    }

    public TesteDependent getTesteDependentBean() {
        return testeDependentBean;
    }

    public TesteSessionBean getTesteSessionBean() {
        return testeSessionBean;
    }

    @PostConstruct
    public void init(){
        list = asList("RPG","Scifi","Terror");
        testeDependentBean.getCategoriasList().addAll(asList("Comedia","Romance"));
        testeSessionBean.selecionarPersonagem();
    }

    public void mudarLista(){
        list = asList("RPG","Scifi","Terror", "Porn");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
