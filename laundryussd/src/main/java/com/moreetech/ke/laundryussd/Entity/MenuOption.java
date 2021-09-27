package com.moreetech.ke.laundryussd.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moreetech.ke.laundryussd.Utils.MenuOptionAction;
import lombok.Data;

/**
 * @author momondi  on 9/26/2021
 **/
@Data
public class MenuOption {

    private String type;// helps to determine if the next step should return a response or serve a different menu

    private String response;// response text to be returned

    @JsonProperty("next_menu_level")
    private String nextMenuLevel;// next Menu to be displayed if  the type should return a menu

    private MenuOptionAction action;// action router .i.e. What process should be performed to retrieve the correct set of data for display
}