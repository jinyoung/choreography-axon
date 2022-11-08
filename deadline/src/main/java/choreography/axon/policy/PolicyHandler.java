package choreography.axon.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.gateway.CommandGateway;

import choreography.axon.command.*;
import choreography.axon.event.*;
import choreography.axon.aggregate.*;

@Service
@ProcessingGroup("deadline_Policy")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;

    @EventHandler
    public void wheneverOrderCreated_Schedule(OrderCreatedEvent orderCreated){
        System.out.println(orderCreated.toString());

        ScheduleCommand command = new ScheduleCommand();
        commandGateway.send(command);
    }
    @EventHandler
    public void wheneverOrderPlaced_RemoveDeadline(OrderPlacedEvent orderPlaced){
        System.out.println(orderPlaced.toString());

        RemoveDeadlineCommand command = new RemoveDeadlineCommand();
        commandGateway.send(command);
    }

}
