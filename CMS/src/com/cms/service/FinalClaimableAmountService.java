/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class FinalClaimableAmountService {

    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     */
    public boolean getAmount(JSPProfileUpdateTO jSPProfileUpdateTO) {
        return amount(jSPProfileUpdateTO);
    }

    private boolean amount(JSPProfileUpdateTO jSPProfileUpdateTO) {
        boolean status = false;

        switch (jSPProfileUpdateTO.getInsuranceType()) {
            case "Home":
                switch (jSPProfileUpdateTO.getSubInsuranceType()) {
                    case "Renovate":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount() * 0.5);
                        status = true;
                        break;
                    case "Destroyed":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount() * 0.7);
                        status = true;
                        break;
                }
                break;
            case "Life":
                switch (jSPProfileUpdateTO.getSubInsuranceType()) {
                    case "Treatment":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount() - (jSPProfileUpdateTO.getMaximumClaimableAmount() * 0.05));
                        status = true;
                        break;
                    case "Death":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount());
                        status = true;
                        break;
                }
                break;
            case "Vechile":
                switch (jSPProfileUpdateTO.getSubInsuranceType()) {
                    case "Repair":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount() * 0.4);
                        status = true;
                        break;
                    case "Stolen":
                        jSPProfileUpdateTO.setFinalClaimableAmount(jSPProfileUpdateTO.getMaximumClaimableAmount() * 0.7);
                        status = true;
                        break;
                }
                break;
        }
        return status;
    }

}
