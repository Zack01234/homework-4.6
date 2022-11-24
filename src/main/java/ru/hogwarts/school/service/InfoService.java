package ru.hogwarts.school.service;

import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Value("${local.server.port}")
    private String serverPort;

    public String getPort() {
        return serverPort;
    }
}
