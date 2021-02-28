/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.service.FinalClaimableAmountService;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class FinalClaimableAmountFacade {
    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     */
    public boolean getAmount(JSPProfileUpdateTO jSPProfileUpdateTO){
        return getFinalAmount(jSPProfileUpdateTO);
    }

    private boolean getFinalAmount(JSPProfileUpdateTO jSPProfileUpdateTO) {
        return new FinalClaimableAmountService().getAmount(jSPProfileUpdateTO);
    }
}
