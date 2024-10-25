package pro.stevendev.adplacementservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.stevendev.common.utils.ResponseUtil;
import pro.stevendev.common.utils.dto.ResponseDTO;

@RestController
public class HealthController {
    @RequestMapping("/health")
    public ResponseDTO healthCheck() {
        return ResponseUtil.success(200,"OK");
    }
}
