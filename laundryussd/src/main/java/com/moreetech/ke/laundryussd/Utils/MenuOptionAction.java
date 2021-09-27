package com.moreetech.ke.laundryussd.Utils;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author momondi  on 9/26/2021
 **/
public enum MenuOptionAction {

    PROCESS_ACC_BALANCE("PROCESS_ACC_BALANCE"),
    PROCESS_ACC_PHONE_NUMBER("PROCESS_ACC_PHONE_NUMBER"),
    PROCESS_ACC_NUMBER("PROCESS_ACC_NUMBER");

    private String action;

    MenuOptionAction(String action) {
        this.action = action;
    }

    @JsonValue
    private String getAction() {
        return action;
    }
}