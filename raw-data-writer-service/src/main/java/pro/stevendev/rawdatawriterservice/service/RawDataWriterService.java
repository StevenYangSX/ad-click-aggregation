package pro.stevendev.rawdatawriterservice.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pro.stevendev.rawdatawriterservice.model.AdClickEventModel;
import pro.stevendev.rawdatawriterservice.repository.AdClickEventRepository;

@Service
public class RawDataWriterService {
    private final AdClickEventRepository clickEventRepository;
    private final ObjectMapper objectMapper;




    public RawDataWriterService(AdClickEventRepository clickEventRepository, ObjectMapper objectMapper) {
        this.clickEventRepository = clickEventRepository;
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = "click-topic", groupId = "kafka-service-group")
    public void consumeMessage(String message) {
        System.out.println("Received message in raw data service: " + message);
        testInsert(message);
    }


    public void testInsert(String message) {

        try {
            // 将 JSON 消息解析为 AdClickEventModel 对象
            AdClickEventModel event = objectMapper.readValue(message, AdClickEventModel.class);

            AdClickEventModel save = clickEventRepository.save(event);

            System.out.println("Inserted into Cassandra: " + save);
        } catch (Exception e) {
            System.err.println("Failed to process message: " + e.getMessage());
        }


    }


}
