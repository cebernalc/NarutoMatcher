/**
 * DebuffType.java
 * 
 * Created on Nov 4, 2016, 11:41:12 PM
 * 
 */
package com.cebernal.naruto.model.type;

import java.util.ArrayList;
import java.util.List;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 4, 2016
 */
public enum DebuffType {

	NONE, POISON, IGNITE, TAG;

	public static DebuffType getType(String sDebuff) {
		if (sDebuff.equalsIgnoreCase("Poison")) {
			return POISON;
		} else if (sDebuff.equalsIgnoreCase("Ignite")) {
			return IGNITE;
		} else if (sDebuff.equalsIgnoreCase("Tag")) {
			return TAG;
		} else {
			// System.out.println("::::" + sDebuff + "::::");
			return NONE;
		}
	}

	public static List<DebuffType> getTypes(String sDebuff) {
		List<DebuffType> debuffs = new ArrayList<DebuffType>();

		String[] split = sDebuff.split("  ");
		for (String chase : split) {
			DebuffType type = getType(chase.trim());
			if (type != NONE) {
				debuffs.add(type);
			}
		}
		return debuffs;
	}
}
