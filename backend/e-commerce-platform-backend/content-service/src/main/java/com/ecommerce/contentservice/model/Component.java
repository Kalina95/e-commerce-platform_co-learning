package com.ecommerce.contentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        return Arrays.stream(Component.values())
                .filter(component -> component.value.equals(value))
                .findFirst()
                .orElseThrow(()->new RuntimeException("there is no such component as: " + value));
    }

    public static String getComponentValueAsStringInPascalNotation(Component component){
        String componentAsString = component.getValue();
        return componentAsString.toUpperCase().replace('-', '_');
    }
}
