package choreography.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ApproveCommand {

    @TargetAggregateIdentifier
    private Long id;
    private String currencyId;
    private Double amount;
    private String status;
    private String holderId;
    private String testId;

}
