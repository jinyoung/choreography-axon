package choreography.axon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.*;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;
import java.util.List;

import lombok.Data;
import lombok.ToString;



import choreography.axon.command.*;
import choreography.axon.event.*;


@Aggregate
@Data
@ToString
public class OrderAggregate {

    @AggregateIdentifier
    private Long id;
    private String currencyId;
    private Double amount;
    private String status;
    private String holderId;
    private String testId;

    public OrderAggregate(){}

    @CommandHandler
    public void handle(OrderCommand command){
        OrderCreatedEvent event = new OrderCreatedEvent();
        BeanUtils.copyProperties(command, event);     
        apply(event);

    }

    @CommandHandler
    public void handle(CancelCommand command){
    }

    @CommandHandler
    public void handle(RejectCommand command){
        OrderRejectedEvent event = new OrderRejectedEvent();
        BeanUtils.copyProperties(command, event);     
        apply(event);

    }

    @CommandHandler
    public void handle(ApproveCommand command){
        OrderPlacedEvent event = new OrderPlacedEvent();
        BeanUtils.copyProperties(command, event);     
        apply(event);

    }







    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    @EventSourcingHandler
    public void on(OrderPlacedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    @EventSourcingHandler
    public void on(OrderRejectedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


}
