/**
 * DamageType.java
 * 
 * Created on Oct 9, 2016, 12:26:00 AM
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
public enum DamageType {
    NINJUTSU, TAIJUTSU;

    public static DamageType getType(String sDamage) {
        if (sDamage.equalsIgnoreCase("NINJUTSU")) {
            return DamageType.NINJUTSU;
        } else if (sDamage.equalsIgnoreCase("TAIJUTSU")) {
            return DamageType.TAIJUTSU;
        }
        return null;
    }

    public static List<DamageType> getTypes(String sDamages) {
        List<DamageType> damages = new ArrayList<DamageType>();

        String[] split = sDamages.split(" ");
        for (String damage : split) {
            damages.add(getType(damage.trim()));
        }
        return damages;
    }
}
