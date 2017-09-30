package br.com.lucanjos.maratonajsf.bean.flowbuilder;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "newpendencies")
public class TesteFlowNestedBuilderBean implements Serializable {
    private String userName;
    private String userSurname;

    public String validarUser(){
        System.out.println("Spc");
        System.out.println("Serasa");
        System.out.println("Deus...");
        /*if(true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "User nao passou na validacao","some thing..."));
            return null;
        }*/
        return "proceedToNewRegistration3";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
