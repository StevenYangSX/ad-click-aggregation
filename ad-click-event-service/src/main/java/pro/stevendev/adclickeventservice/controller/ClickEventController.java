package pro.stevendev.adclickeventservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.stevendev.adclickeventservice.dto.AdClickEventReceiverDTO;
import pro.stevendev.adclickeventservice.service.KafkaProducerService;
import pro.stevendev.common.exceptions.BusinessException;
import pro.stevendev.common.utils.ErrorCode;
import pro.stevendev.common.utils.ResponseUtil;
import pro.stevendev.common.utils.dto.ResponseDTO;


@RestController
@RequestMapping("api")
public class ClickEventController {


    private final KafkaProducerService kafkaProducer;
    private final ObjectMapper objectMapper;

    public ClickEventController(KafkaProducerService kafkaProducerService, ObjectMapper objectMapper) {
        this.kafkaProducer = kafkaProducerService;
        this.objectMapper = objectMapper;
    }


    @PostMapping("clickEvent")
    public ResponseDTO adClickEventReceiver(@RequestBody AdClickEventReceiverDTO clickEventDTO) {

        try {
            // 将 DTO 转换为 JSON 格式
            String message = objectMapper.writeValueAsString(clickEventDTO);
            kafkaProducer.sendMessage("click-topic", message);
        } catch (JsonProcessingException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Failed to serialize message");
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, e.getMessage());
        }
        return ResponseUtil.success(200, "Message Sent");
    }
}
