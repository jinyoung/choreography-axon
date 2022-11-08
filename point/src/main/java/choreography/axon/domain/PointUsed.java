package choreography.axon.domain;

import choreography.axon.domain.*;
import choreography.axon.infra.AbstractEvent;
import java.util.Date;

public class PointUsed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Double point;
    private Long orderId;

    public PointUsed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
