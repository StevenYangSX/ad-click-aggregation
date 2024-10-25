package pro.stevendev.adclickeventservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.stevendev.common.utils.ResponseUtil;
import pro.stevendev.common.utils.dto.ResponseDTO;
import pro.stevendev.kafkautils.service.KafkaProducerService;

@RestController
public class HealthTestController {


    @RequestMapping("health")
    public ResponseDTO health() {
        return ResponseUtil.success(200,"OK");
    }
}
