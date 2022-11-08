package choreography.axon.domain.usecase;

import choreography.axon.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PointPolicy{
    @Autowired
    PointRepository pointRepository;

    public void usePoint(ExchangeSucceeded exchangeSucceeded){

        Point point = new Point();
        /*
        LOGIC GOES HERE
        */
        // pointRepository.save(point);

        // PointUsed pointUsed = new PointUsed();
        /*
        Input Event Content
        */
        // pointUsed.publishAfterCommit();

        // PointUseFailed pointUseFailed = new PointUseFailed();
        /*
        Input Event Content
        */
        // pointUseFailed.publishAfterCommit();


    }
    public void compensate(OrderRejected orderRejected){

        Point point = new Point();
        /*
        LOGIC GOES HERE
        */
        // pointRepository.save(point);


    }
}