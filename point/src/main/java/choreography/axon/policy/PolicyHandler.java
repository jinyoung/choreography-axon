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
@ProcessingGroup("point_Policy")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;

    @EventHandler
    public void wheneverExchangeSucceeded_UsePoint(ExchangeSucceededEvent exchangeSucceeded){
        System.out.println(exchangeSucceeded.toString());

        UsePointCommand command = new UsePointCommand();
        commandGateway.send(command);
    }
    @EventHandler
    public void wheneverOrderRejected_Compensate(OrderRejectedEvent orderRejected){
        System.out.println(orderRejected.toString());

        CompensateCommand command = new CompensateCommand();
        commandGateway.send(command);
    }

}
