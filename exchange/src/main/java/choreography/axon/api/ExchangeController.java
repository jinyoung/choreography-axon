package choreography.axon.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import choreography.axon.aggregate.*;
import choreography.axon.command.*;

@RestController
public class ExchangeController {

  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  public ExchangeController(CommandGateway commandGateway, QueryGateway queryGateway) {
      this.commandGateway = commandGateway;
      this.queryGateway = queryGateway;
  }

  @RequestMapping(value = "/exchange/exchange",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")
  public void exchange(@RequestBody ExchangeCommand exchangeCommand)
        throws Exception {
      System.out.println("##### /exchange/exchange  called #####");

      // send command
      commandGateway.send(exchangeCommand);
  }


  @RequestMapping(value = "/exchange/compensate",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")
  public void compensate(@RequestBody CompensateCommand compensateCommand)
        throws Exception {
      System.out.println("##### /exchange/compensate  called #####");

      // send command
      commandGateway.send(compensateCommand);
  }

}
