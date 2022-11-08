package choreography.axon.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import choreography.axon.command.*;
import choreography.axon.event.*;
import choreography.axon.aggregate.*;

@Service
@ProcessingGroup("exchange_Policy")
public class PolicyHandler{

    @EventHandler
    public void wheneverOrderCreated_(OrderCreatedEvent orderCreated){
        System.out.println(orderCreated.toString());
    }
    @EventHandler
    public void wheneverOrderRejected_(OrderRejectedEvent orderRejected){
        System.out.println(orderRejected.toString());
    }

}
