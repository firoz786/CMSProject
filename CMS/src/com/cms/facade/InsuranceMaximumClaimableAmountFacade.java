package com.cms.facade;

import com.cms.exception.CMSBusinessException;
import com.cms.service.InsuranceMaximumClaimableAmountService;
import com.cms.to.JSPProfileUpdateTO;

/**
 * @author Rishabh Gupta
 *
 */
public class InsuranceMaximumClaimableAmountFacade {

    /**
     * @param jSPProfileUpdateTO
     * @param insuranceType
     * @return boolean
     * @throws CMSBusinessException
     */
    public boolean getMaximumClaimableAmount(JSPProfileUpdateTO jSPProfileUpdateTO, String insuranceType) throws CMSBusinessException {

        return getAmount(jSPProfileUpdateTO, insuranceType);
    }

    private boolean getAmount(JSPProfileUpdateTO jSPProfileUpdateTO, String insuranceType) {
        return new InsuranceMaximumClaimableAmountService().getMaximumClaimabeAmount(jSPProfileUpdateTO, insuranceType);
    }
}
