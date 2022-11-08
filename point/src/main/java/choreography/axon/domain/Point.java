package choreography.axon.domain;

import choreography.axon.domain.PointUsed;
import choreography.axon.domain.PointUseFailed;
import choreography.axon.PointApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Point_table")

public class Point  {

    
    
    private Double point;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private String userId;

    @PostPersist
    public void onPostPersist(){
        PointUsed pointUsed = new PointUsed();
        BeanUtils.copyProperties(this, pointUsed);
        pointUsed.publishAfterCommit();

        PointUseFailed pointUseFailed = new PointUseFailed();
        BeanUtils.copyProperties(this, pointUseFailed);
        pointUseFailed.publishAfterCommit();

    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    



}
