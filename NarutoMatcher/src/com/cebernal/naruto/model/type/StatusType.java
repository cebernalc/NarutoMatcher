/**
 * java
 * 
 * Created on Oct 30, 2016, 1:18:04 AM
 *
 */
package com.cebernal.naruto.model.type;

import java.util.ArrayList;
import java.util.List;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 30, 2016
 */
public enum StatusType {

	NONE, HIGH_FLOAT, KNOCKDOWN, LOW_FLOAT, REPULSED, HIGH_COMBO, IMMOBILE, SLEEP, PARALYZE, CHAOS, ACUPUNCTURE, BLIND, INTERRUPTION;

	public static StatusType getType(String sStatus) {
		if (sStatus.equalsIgnoreCase("High Float")) {
			return HIGH_FLOAT;
		} else if (sStatus.equalsIgnoreCase("Knockdown")) {
			return KNOCKDOWN;
		} else if (sStatus.equalsIgnoreCase("Low Float")) {
			return LOW_FLOAT;
		} else if (sStatus.equalsIgnoreCase("Repel")) {
			return REPULSED;
		} else if (sStatus.equalsIgnoreCase("7 Combos") || sStatus.equalsIgnoreCase("High Combo")
				|| sStatus.equalsIgnoreCase("-") || sStatus.equalsIgnoreCase("10 Combos")) {
			return HIGH_COMBO;
		}
		if (sStatus.equalsIgnoreCase("Immobile")) {
			return IMMOBILE;
		} else if (sStatus.equalsIgnoreCase("Sleep")) {
			return SLEEP;
		} else if (sStatus.equalsIgnoreCase("Paralyze")) {
			return PARALYZE;
		} else if (sStatus.equalsIgnoreCase("Chaos")) {
			return CHAOS;
		} else if (sStatus.equalsIgnoreCase("Blind")) {
			return BLIND;
		} else if (sStatus.equalsIgnoreCase("Acupoint Sealing")) {
			return ACUPUNCTURE;
		} else if (sStatus.equalsIgnoreCase("Interruption")) {
			return INTERRUPTION;
		} else {
			// System.out.println("::::" + sChase + "::::");
			return NONE;
		}
	}

	public static List<StatusType> getTypes(String sStatus) {
		List<StatusType> status = new ArrayList<StatusType>();

		String[] split = sStatus.split("  ");
		for (String chase : split) {
			StatusType type = getType(chase.trim());
			if (type != NONE) {
				status.add(type);
			}
		}
		return status;
	}
}
