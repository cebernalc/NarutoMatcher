/**
 * ElementType.java
 * 
 * Created on Oct 9, 2016, 2:53:34 AM
 *
 */
package com.cebernal.naruto.model.type;

import java.util.ArrayList;
import java.util.List;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 9, 2016
 */
public enum ElementType {

    NONE, WATER, EARTH, FIRE, LIGHTNING, WIND;

    public static ElementType getType(String sElement) {
        if (sElement.equalsIgnoreCase("wind")) {
            return ElementType.WIND;
        } else if (sElement.equalsIgnoreCase("fire")) {
            return ElementType.FIRE;
        } else if (sElement.equalsIgnoreCase("earth")) {
            return ElementType.EARTH;
        } else if (sElement.equalsIgnoreCase("lightning")) {
            return ElementType.LIGHTNING;
        } else if (sElement.equalsIgnoreCase("water")) {
            return ElementType.WATER;
        } else if (sElement.isEmpty()) {
            return ElementType.NONE;
        }
        // System.out.println(":::" + sElement + ":::");
        return null;
    }

    public static List<ElementType> getTypes(String sElements) {
        List<ElementType> elements = new ArrayList<ElementType>();

        String[] split = sElements.split("  ");
        for (String element : split) {
            elements.add(getType(element.trim()));
        }
        return elements;
    }
}
