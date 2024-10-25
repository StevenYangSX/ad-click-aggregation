package pro.stevendev.rawdatawriterservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.stevendev.common.utils.ResponseUtil;
import pro.stevendev.common.utils.dto.ResponseDTO;
import pro.stevendev.rawdatawriterservice.dto.TestDto;
import pro.stevendev.rawdatawriterservice.service.RawDataWriterService;

@RestController
public class HealthController {


    @Autowired
    RawDataWriterService writerService;

    @RequestMapping("health")
    public ResponseDTO test() {
        return ResponseUtil.success(200, "Data Write Service Up...");
    }

    @PostMapping("test")
    public ResponseDTO test2(@RequestBody TestDto testDto) {
        writerService.testInsert(testDto.getMessage());
        return ResponseUtil.success(200, "SUCCESS");
    }
}
