package com.famachallenge.numberconverter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {

    private Logger LOG = LoggerFactory.getLogger("numberConverterServiceLogger");
    private Map<Long, String> numMap = new HashMap<>();
    private final Long QUINTILLION = 1000000000000000000L;
    private final Long QUADRILLION = 1000000000000000L;
    private final Long TRILLION = 1000000000000L;
    private final Long BILLION = 1000000000L;
    private final Long MILLION = 1000000L;
    private final Long THOUSAND = 1000L;
    private final Long ZERO = 0L;

    /**
     * Breaks down the number into the three comma separated categories, converts each category individually.
     * @param number
     * @return the fully converted number string
     */
    public String convertNumToEnglish(Long number) throws Exception {
        if (number == null) {
            String errorMessage = "Number cannot be null. Please enter a valid number.";
            LOG.debug("NumberConverterService.convertNumToEnglish(Integer number) :: " + errorMessage);
            throw new Exception(errorMessage);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String currentConvertedNum;

        populateNumberMap();

        if (number < ZERO) {
            stringBuilder.append("negative ");

            // Quick workaround for Math.abs() two's compliment error for minimum long value.
            if (number.equals(Long.MIN_VALUE)) {
                number++;
            }

            number = Math.abs(number);
        }

        if (ZERO.equals(number)) {
            stringBuilder.append(numMap.get(number));
        }

        if (number >= QUINTILLION) {
            currentConvertedNum = convertNumber(number / QUINTILLION);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" quintillion ");
            number = number % QUINTILLION;
        }

        if (number >= QUADRILLION) {
            currentConvertedNum = convertNumber(number / QUADRILLION);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" quadrillion ");
            number = number % QUADRILLION;
        }

        if (number >= TRILLION) {
            currentConvertedNum = convertNumber(number / TRILLION);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" trillion ");
            number = number % TRILLION;
        }

        if (number >= BILLION) {
            currentConvertedNum = convertNumber(number / BILLION);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" billion ");
            number = number % BILLION;
        }

        if (number >= MILLION) {
            currentConvertedNum = convertNumber(number / MILLION);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" million ");
            number = number % MILLION;
        }

        if (number >= THOUSAND) {
            currentConvertedNum = convertNumber(number / THOUSAND);
            stringBuilder.append(currentConvertedNum);
            stringBuilder.append(" thousand ");
            number = number % THOUSAND;
        }

        if (number > ZERO) {
            currentConvertedNum = convertNumber(number);
            stringBuilder.append(currentConvertedNum);
        }

        return stringBuilder.toString();
    }

    /**
     * Converts the number broken down into 3 digits. Will be called for all comma separated categories in the number.
     * @param number
     * @return the partial converted number as a string.
     */
    private String convertNumber(Long number) {
        StringBuilder stringBuilder = new StringBuilder();

        if (number >= 100){
            stringBuilder.append(numMap.get(number / 100));
            stringBuilder.append(" hundred ");
            number = number % 100;
        }

        if (number > ZERO){
            if (number > ZERO && number <= 20) {
                stringBuilder.append(numMap.get(number));
            } else {
                Long firstDigit = (number / 10) * 10;
                stringBuilder.append(numMap.get(firstDigit));

                Long secondDigit = number % 10;
                if (secondDigit > ZERO) {
                    stringBuilder.append(" ");
                    stringBuilder.append(numMap.get(secondDigit));
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Populate the number map with all of the unique values.
     */
    private void populateNumberMap() {
        numMap.put(0L, "zero");
        numMap.put(1L, "one");
        numMap.put(2L, "two");
        numMap.put(3L, "three");
        numMap.put(4L, "four");
        numMap.put(5L, "five");
        numMap.put(6L, "six");
        numMap.put(7L, "seven");
        numMap.put(8L, "eight");
        numMap.put(9L, "nine");
        numMap.put(10L, "ten");
        numMap.put(11L, "eleven");
        numMap.put(12L, "twelve");
        numMap.put(13L, "thirteen");
        numMap.put(14L, "fourteen");
        numMap.put(15L, "fifteen");
        numMap.put(16L, "sixteen");
        numMap.put(17L, "seventeen");
        numMap.put(18L, "eighteen");
        numMap.put(19L, "nineteen");

        numMap.put(20L, "twenty");
        numMap.put(30L, "thirty");
        numMap.put(40L, "forty");
        numMap.put(50L, "fifty");
        numMap.put(60L, "sixty");
        numMap.put(70L, "seventy");
        numMap.put(80L, "eighty");
        numMap.put(90L, "ninety");
    }

}