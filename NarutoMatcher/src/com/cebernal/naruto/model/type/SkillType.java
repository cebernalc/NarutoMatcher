/**
 * SkillType.java
 * 
 * Created on Oct 9, 2016, 12:25:13 AM
 *
 */
package com.cebernal.naruto.model.type;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 9, 2016
 */
public enum SkillType {

    PASSIVE, MYSTERY, STANDARD, CHASE;

    public static SkillType getType(String sElement) {
        if (sElement.equalsIgnoreCase("Normal Attack")) {
            return SkillType.STANDARD;
        } else if (sElement.equalsIgnoreCase("Mystery")) {
            return SkillType.MYSTERY;
        } else if (sElement.equalsIgnoreCase("Passive")) {
            return SkillType.PASSIVE;
        } else if (sElement.equalsIgnoreCase("Chase to attack")) {
            return SkillType.CHASE;
        }
        return null;
    }
}
