package kz.adilet.tleubay.code.generator.service.impl;

import kz.adilet.tleubay.code.generator.service.GeneratorService;
import kz.adilet.tleubay.code.generator.exception.CodeException;
import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    private char[] chars;

    public String generateFromPreviousCode(String code) {
        chars = code.toCharArray();

        for (int i = chars.length - 1; i >= 0; i = i - 2) {
            char number = chars[i];
            char letter = chars[i - 1];

            if ((number >= '0' && number <= '9') && (letter >= 'a' && letter <= 'z')) {

                if (number == '9') {
                    if (letter == 'z') {
                        if ((i - 1) == 0) {
                            return increaseCodeSize();
                        } else {
                            refreshCharsAtIndex(i);
                        }
                    } else {
                        return increaseLetterAtIndex(i);
                    }
                } else {
                    return increaseNumberAtIndex(i);
                }
            } else {
                throw new CodeException("The format of a previous code is incorrect");
            }
        }
        throw new CodeException("The format of a previous code is incorrect");
    }

    private void refreshCharsAtIndex(int i) {
        chars[i] = '0';
        chars[i - 1] = 'a';
    }

    private String increaseLetterAtIndex(int i) {
        chars[i - 1] = (char) (chars[i - 1] + 1);
        chars[i] = '0';
        return new String(chars);
    }

    private String increaseNumberAtIndex(int i) {
        chars[i] = (char) (chars[i] + 1);
        return new String(chars);
    }

    private String increaseCodeSize() {
        String code = "";
        int newLength = (chars.length / 2) + 1;

        for (int i = 0; i < newLength; i++) {
            code = code.concat("a0");
        }
        return code;
    }
}
