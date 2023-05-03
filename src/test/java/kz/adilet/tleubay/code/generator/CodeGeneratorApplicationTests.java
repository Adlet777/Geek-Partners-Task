package kz.adilet.tleubay.code.generator;

import kz.adilet.tleubay.code.generator.exception.CodeException;
import kz.adilet.tleubay.code.generator.service.impl.GeneratorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
@Slf4j
class CodeGeneratorApplicationTests {

    @InjectMocks
    private GeneratorServiceImpl generator;

    private final String INPUT_VALUE_1 = "z9z9";
    private final String EXPECTED_OUTPUT_VALUE_1 = "a0a0a0";
    private final String INPUT_VALUE_2 = "z9z9z9z9z9z9z9z9z9";
    private final String EXPECTED_OUTPUT_VALUE_2 = "a0a0a0a0a0a0a0a0a0a0";
    private final String INPUT_VALUE_3 = "a0a0";
    private final String EXPECTED_OUTPUT_VALUE_3 = "a0a1";
    private final String INPUT_VALUE_4 = "a0a9";
    private final String EXPECTED_OUTPUT_VALUE_4 = "a0b0";
    private final String INPUT_VALUE_5 = "a0z9";
    private final String EXPECTED_OUTPUT_VALUE_5 = "a1a0";
    private final String INPUT_VALUE_6 = "AAAAA";
    private final String INPUT_VALUE_7 = "00000";
    private final String EXCEPTION = "The format of a previous code is incorrect";


    @DisplayName("Testing case when code = 'z9z9'")
    @Test
    void test_first_case() {
        Assertions.assertEquals(EXPECTED_OUTPUT_VALUE_1, generator.generateFromPreviousCode(INPUT_VALUE_1));
        log.info("Test 1: Success");
    }

    @DisplayName("Testing case when code = 'z9z9z9z9z9z9z9z9z9'")
    @Test
    void test_second_case() {
        Assertions.assertEquals(EXPECTED_OUTPUT_VALUE_2, generator.generateFromPreviousCode(INPUT_VALUE_2));
        log.info("Test 2: Success");
    }

    @DisplayName("Testing case when code = 'a0a0'")
    @Test
    void test_third_case() {
        Assertions.assertEquals(EXPECTED_OUTPUT_VALUE_3, generator.generateFromPreviousCode(INPUT_VALUE_3));
        log.info("Test 3: Success");
    }

    @DisplayName("Testing case when code = 'a0a9'")
    @Test
    void test_fourth_case() {
        Assertions.assertEquals(EXPECTED_OUTPUT_VALUE_4, generator.generateFromPreviousCode(INPUT_VALUE_4));
        log.info("Test 4: Success");
    }

    @DisplayName("Testing case when code = 'a0z9'")
    @Test
    void test_fifth_case() {
        Assertions.assertEquals(EXPECTED_OUTPUT_VALUE_5, generator.generateFromPreviousCode(INPUT_VALUE_5));
        log.info("Test 5: Success");
    }

    @DisplayName("Testing case when code = 'AAAAA'")
    @Test
    void test_sixth_case() {
        CodeException exception = Assertions.assertThrows(CodeException.class, () -> generator.generateFromPreviousCode(INPUT_VALUE_6), "Test failed: Exception was not thrown");

        assertTrue(exception.getMessage().contentEquals(EXCEPTION));
        log.info("Test 6: Success");
    }

    @DisplayName("Testing case when code = '00000'")
    @Test
    void test_seventh_case() {
        CodeException exception = Assertions.assertThrows(CodeException.class, () -> generator.generateFromPreviousCode(INPUT_VALUE_7), "Test failed: Exception was not thrown");

        assertTrue(exception.getMessage().contentEquals(EXCEPTION));
        log.info("Test 7: Success");
    }
}
