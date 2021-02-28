package com.cms.service;

import com.cms.exception.CMSBusinessException;
import com.cms.to.JSPProfileUpdateTO;

/**
 * @author Rishabh Gupta
 *
 */
public class InsuranceMaximumClaimableAmountService {

    /**
     * @param jSPProfileUpdateTO
     * @param insuranceType
     * @return boolean
     */
    public boolean getMaximumClaimabeAmount(JSPProfileUpdateTO jSPProfileUpdateTO, String insuranceType) {
        return calculateMaximumClaimableAmount(jSPProfileUpdateTO, insuranceType);
    }

    private boolean calculateMaximumClaimableAmount(JSPProfileUpdateTO jSPProfileUpdateTO, String insuranceType) {
        boolean status = false;
        Double value = (Double) jSPProfileUpdateTO.getInsuranceTypeMap().get(insuranceType);

        if (insuranceType.equalsIgnoreCase("Home")) {
            jSPProfileUpdateTO.setMaximumClaimableAmount((value * 91) / 100);
            status = true;
        } else if (insuranceType.equalsIgnoreCase("Life")) {
            jSPProfileUpdateTO.setMaximumClaimableAmount(value);
            status = true;
        } else if (insuranceType.equalsIgnoreCase("Vechile")) {
            jSPProfileUpdateTO.setMaximumClaimableAmount((value * 80) / 100);
            status = true;
        }
        return status;
    }
}
