package choreography.axon.domain;

import choreography.axon.domain.*;
import choreography.axon.infra.AbstractEvent;
import java.util.Date;

public class PointUseFailed extends AbstractEvent {

    private Long id;
    private String reason;
    private Long orderId;

    public PointUseFailed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
