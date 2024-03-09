package com.ecommerce.contentservice.model;

import com.ecommerce.contentservice.exception.EmptyComponentException;
import com.ecommerce.contentservice.exception.NoSuchComponentException;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Component {
    HEADER("header"),
    FOOTER("footer"),
    MAIN_PAGE("main-page"),
    ABOUT_US("about-us"),
    PRODUCTS("products"),
    PRODUCT("product"),
    CART("cart");

    private final String value;

    public static Component getComponentByValue(String value){
        if(Strings.isNullOrEmpty(value)) throw new EmptyComponentException("Component cannot be empty");
        return Arrays.stream(Component.values())
                .filter(component -> component.value.equals(value))
                .findFirst()
                .orElseThrow(()->new NoSuchComponentException("There is no such component as: " + value));
    }

    public static String getComponentValueAsStringInPascalNotation(Component component){
        String componentAsString = component.getValue();
        return componentAsString.toUpperCase().replace('-', '_');
    }
}
