package choreography.axon.infra;

import javax.naming.NameParser;

import choreography.axon.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import choreography.axon.domain.*;
import choreography.axon.domain.usecase.*;

@Service
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    @Autowired PointPolicy pointPolicy;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverExchangeSucceeded_UsePoint(@Payload ExchangeSucceeded exchangeSucceeded){

        if(!exchangeSucceeded.validate()) return;
        ExchangeSucceeded event = exchangeSucceeded;
        System.out.println("\n\n##### listener UsePoint : " + exchangeSucceeded.toJson() + "\n\n");


        

        // Sample Logic //
        pointPolicy.usePoint(event);
        

        

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderRejected_Compensate(@Payload OrderRejected orderRejected){

        if(!orderRejected.validate()) return;
        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener Compensate : " + orderRejected.toJson() + "\n\n");


        

        // Sample Logic //
        pointPolicy.compensate(event);
        

        

    }


}


