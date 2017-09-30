package br.com.lucanjos.maratonajsf.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {
    private List<String> personagens = asList("Goku","Vegeta","Gohan");
    private List<String> personagemSelecionado = new ArrayList<>();
    @Inject private Conversation conversation;

    @PostConstruct
    public void init(){
        System.out.println("Entrou post construct conversation ");
        personagens = asList("Luffy","Zoro","Sanji");
        if(conversation.isTransient()){
            conversation.begin();
            System.out.println("Iniciando conversation scoped, ID= " + conversation.getId());
        }
    }

    public String endConversation(){
        if(!conversation.isTransient()){
            conversation.end();
        }else{
            System.out.println("transient");
        }

        return "conversation2?faces-redirect=true";
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
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
