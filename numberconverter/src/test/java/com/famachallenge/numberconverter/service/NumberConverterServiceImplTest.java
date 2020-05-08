package com.famachallenge.numberconverter.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class NumberConverterServiceImplTest {

    @TestConfiguration
    static class NumberConverterServiceImplTestContextConfiguration {

        @Bean
        public NumberConverterService numberConverterService() {
            return new NumberConverterServiceImpl();
        }
    }

    @Autowired
    NumberConverterService numberConverterService;

    @Test
    public void givenValidNumber_whenConvertNumberToEnglish_returnNumberInEnglish() throws Exception {
        // Given:
        Long number = 123456789L;
        String expectedNumberInEnglish = "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine";

        // When:
        String numberInEnglish = numberConverterService.convertNumToEnglish(number);

        // Then:
        Assert.assertEquals(expectedNumberInEnglish, numberInEnglish);
    }

    @Test
    public void givenMaxNumber_whenConvertNumberToEnglish_returnNumberInEnglish() throws Exception {
        // Given:
        Long number = Long.MAX_VALUE;
        String expectedNumberInEnglish = "nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred seven";

        // When:
        String numberInEnglish = numberConverterService.convertNumToEnglish(number);

        // Then:
        Assert.assertEquals(expectedNumberInEnglish, numberInEnglish);
    }

    @Test
    public void givenMinNumber_whenConvertNumberToEnglish_returnNumberInEnglish() throws Exception {
        // Given:
        Long number = Long.MIN_VALUE;
        String expectedNumberInEnglish = "negative nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred seven";

        // When:
        String numberInEnglish = numberConverterService.convertNumToEnglish(number);

        // Then:
        Assert.assertEquals(expectedNumberInEnglish, numberInEnglish);
    }

    @Test
    public void givenZero_whenConvertNumberToEnglish_returnZeroInEnglish() throws Exception {
        // Given:
        Long number = 0L;
        String expectedNumberInEnglish = "zero";

        // When:
        String numberInEnglish = numberConverterService.convertNumToEnglish(number);

        // Then:
        Assert.assertEquals(expectedNumberInEnglish, numberInEnglish);
    }

    @Test(expected = Exception.class)
    public void givenNull_whenConvertNumberToEnglish_returnException() throws Exception {
        // Given:
        Long number = null;

        // When:
        String numberInEnglish = numberConverterService.convertNumToEnglish(number);

        // Then:
        // Throw Exception

    }

}
