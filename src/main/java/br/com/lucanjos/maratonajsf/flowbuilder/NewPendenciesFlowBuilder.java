package br.com.lucanjos.maratonajsf.flowbuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;


public class NewPendenciesFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newpendencies";
        flowBuilder.id("",flowId);
        flowBuilder.viewNode(flowId,"/newpendencies/newpendencies.xhtml").markAsStartNode();
        flowBuilder.returnNode("proceedToNewRegistration3")
                .fromOutcome("/newregistration/newregistration3.xhtml");
        flowBuilder.returnNode("exitToInicio")
                .fromOutcome("/newregistration/newregistration1.xhtml");
        flowBuilder.inboundParameter("userName", "#{testeFlowNestedBuilderBean.userName}");
        flowBuilder.inboundParameter("userSurname", "#{testeFlowNestedBuilderBean.userSurname}");
        return flowBuilder.getFlow();
    }

}