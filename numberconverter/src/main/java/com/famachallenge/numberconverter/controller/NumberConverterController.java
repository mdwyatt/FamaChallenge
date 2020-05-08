package com.famachallenge.numberconverter.controller;

import com.famachallenge.numberconverter.bean.NumberConverterResponseBean;
import com.famachallenge.numberconverter.service.NumberConverterServiceImpl;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("num_converter")
public class NumberConverterController {

    @Autowired
    NumberConverterServiceImpl numberConverterService;

    /**
     * The Get endpoint to return the number converted into English.
     * @param number
     * @return numberConverterResponseBean - The bean containing the status code as a string and converted number as a string.
     * @NotNull
     */
    @NotNull
    @GetMapping("/num_to_english")
    public NumberConverterResponseBean numToEnglish(@RequestParam("number") Long number) {
        NumberConverterResponseBean numberConverterResponseBean = new NumberConverterResponseBean();
        numberConverterResponseBean.setStatus("Ok");

        try {
            numberConverterResponseBean.setNumInEnglish(numberConverterService.convertNumToEnglish(number));
        } catch (Exception e) {
            numberConverterResponseBean.setStatus("Request Failed");
            numberConverterResponseBean.setNumInEnglish(e.getMessage());
        }

        return numberConverterResponseBean;
    }
}