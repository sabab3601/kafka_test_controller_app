package com.samsclub.spirebatch.testapp.kafka;

import com.samsclub.spirebatch.slip.feeder.kafka.message.SpireEngineSlipFeederMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate spireEngineTemplate;

    @PostMapping("/message")
    public String sendMessage(@RequestBody SpireEngineSlipFeederMessage message) throws Exception{
        spireEngineTemplate.send("spire_batch_slip_relay", message);
        System.out.print("Published spire engine message:>>>>>>>>>>>>>>>>:"+message);
        return "success";
    }
}
