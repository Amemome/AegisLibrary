package Libro.Library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // 모든 엔드포인트에 /api 경로가 추가됩니다.
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/message")
    public String logMessage() {
        logger.info("Button was clicked!");
        return "Log message was printed!";
    }
}