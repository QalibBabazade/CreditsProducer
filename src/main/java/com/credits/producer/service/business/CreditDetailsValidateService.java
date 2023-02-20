package com.credits.producer.service.business;

import com.credits.producer.dto.request.CreditDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditDetailsValidateService {

    public boolean checkCreditDetails(CreditDetails creditDetails) {
        boolean checkCredit = true;
        Double amount = creditDetails.getAmount().doubleValue();
        Double comission = creditDetails.getComission();
        Integer currencyId = creditDetails.getCurrencyId();
        Double interestRate = creditDetails.getInterestRate();
        Integer terms = creditDetails.getTerms();
        if(amount < 100 || amount == null){
            checkCredit = false;
        }
        if(comission == null || comission < 2){
            checkCredit = false;
        }
        if(currencyId == null){
            checkCredit = false;
        }
        if(interestRate == null || interestRate < 10){
            checkCredit = false;
        }
        if(terms == null || terms >120){
            checkCredit = false;
        }

        return checkCredit;
    }
}
