/**
 * SimulatorHelper.java
 * 
 * Created on Oct 31, 2016, 1:49:21 AM
 * 
 */
package com.cebernal.naruto.helper;

import java.util.Arrays;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.type.StatusType;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 31, 2016
 */
public class SimulatorHelper {

	public static void main(String[] args) {
		// Test
		Ninja breezeDancer = new Ninja();
		Skill summon = new Skill();
		summon.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		summon.setChaseSkills(Arrays.asList(StatusType.LOW_FLOAT));
		breezeDancer.setSummon(summon);

	}

	/**
	 * 
	 * @param team Receives a formation of 4 ninjas
	 */
	public static void simulateTeam(Ninja[] team) {

	}
}
