package flowerdelivery;

import flowerdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_PaymentCancelRequest(@Payload OrderCancelled orderCancelled){

        if(orderCancelled.isMe()){
            System.out.println("##### listener PaymentCancelRequest : " + orderCancelled.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_OrderReject(@Payload Rejected rejected){

        if(rejected.isMe()){
            System.out.println("##### listener OrderReject : " + rejected.toJson());
            System.out.println();
            System.out.println();
        }
    }

}
