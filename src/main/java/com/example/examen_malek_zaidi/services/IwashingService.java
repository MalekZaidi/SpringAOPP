package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.WashingService;
import com.example.examen_malek_zaidi.repositories.IwashingServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IwashingService implements iwachingService{
    private final IwashingServiceRepository iwashingServiceRepository;
    @Override
    public void addWashingService(List<WashingService> washingServices) {
     iwashingServiceRepository.saveAll(washingServices);
    }
}
