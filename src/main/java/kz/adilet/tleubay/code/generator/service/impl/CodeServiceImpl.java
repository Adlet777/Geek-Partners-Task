package kz.adilet.tleubay.code.generator.service.impl;

import jakarta.transaction.Transactional;
import kz.adilet.tleubay.code.generator.entity.CodeEntity;
import kz.adilet.tleubay.code.generator.repository.CodeRepository;
import kz.adilet.tleubay.code.generator.service.CodeService;
import kz.adilet.tleubay.code.generator.service.GeneratorService;
import kz.adilet.tleubay.code.generator.exception.CodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository repository;
    private final GeneratorService generator;

    @Transactional
    public String generateNextCode() {
        CodeEntity currentCode = repository.findTopByOrderByCreatedAtDesc().orElseThrow(() ->
                new CodeException("Failed to retrieve current code from database"));

        String updatedCode = generator.generateFromPreviousCode(currentCode.getValue());

        repository.save(CodeEntity.builder()
                .id(null)
                .value(updatedCode)
                .createdAt(LocalDateTime.now()).build());

        return updatedCode;
    }
}
