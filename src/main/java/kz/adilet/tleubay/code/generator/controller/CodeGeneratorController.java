package kz.adilet.tleubay.code.generator.controller;

import kz.adilet.tleubay.code.generator.service.CodeService;
import kz.adilet.tleubay.code.generator.service.impl.GeneratorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/codes")
@RequiredArgsConstructor
@ComponentScan(basePackageClasses = GeneratorServiceImpl.class)
public class CodeGeneratorController {
    private final CodeService service;

    @GetMapping
    public String generateNextCode() {
        return service.generateNextCode();
    }
}
