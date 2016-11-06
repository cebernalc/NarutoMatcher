/**
 * SimulatorHelper.java
 * 
 * Created on Oct 31, 2016, 1:49:21 AM
 * 
 */
package com.cebernal.naruto.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.soap.SOAPBinding.Style;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.util.Pair;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 31, 2016
 */
public class SimulatorHelper {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * @param team
	 *            Receives a formation of 4 ninjas
	 * @param trigger
	 */
	public static void simulateTeam(Ninja[] team, StatusType trigger) {
		// Ninja first = team[0];
		// Ninja second = team[1];
		// Ninja third = team[2];
		// Ninja fourth = team[3];

		ArrayList<Skill> availableSkills[] = new ArrayList[4];
		// Populate chases
		for (int i = 0; i < team.length; i++) {
			List<Skill> temp = new ArrayList<Skill>();
			availableSkills[i] = new ArrayList<Skill>();

			if (team[i].getSkill1().getSkillType() == SkillType.CHASE) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSkill1().getChaseSkills());
				chase.setHurtSkills(team[i].getSkill1().getHurtSkills());
				chase.setRepetitions(team[i].getSkill1().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
			if (team[i].getSkill2().getSkillType() == SkillType.CHASE) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSkill2().getChaseSkills());
				chase.setHurtSkills(team[i].getSkill2().getHurtSkills());
				chase.setRepetitions(team[i].getSkill2().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
			if (team[i].getSkill3().getSkillType() == SkillType.CHASE) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSkill3().getChaseSkills());
				chase.setHurtSkills(team[i].getSkill3().getHurtSkills());
				chase.setRepetitions(team[i].getSkill3().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
			if (team[i].getSummon() != null) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSummon().getChaseSkills());
				chase.setHurtSkills(team[i].getSummon().getHurtSkills());
				chase.setRepetitions(team[i].getSummon().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
		}
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// String prettyJson = gson.toJson(availableSkills);
		// System.out.println(prettyJson);
		// System.out.println(Arrays.toString(availableSkills));

		boolean isCombo;
		boolean isHighCombo = false;
		System.out.println(trigger);
		do {
			isCombo = false;
			// TODO: finish the algorithm
			for (ArrayList<Skill> ninja : availableSkills) {
				ArrayList<Integer> remove = new ArrayList<Integer>();
				for (int i = 0; i < ninja.size(); i++) {
					Skill chase = ninja.get(i);
					if (chase.getChaseSkills().contains(trigger)) {
						StatusType oldTrigger = trigger;
						isCombo = true;
						chase.setRepetitions(chase.getRepetitions() - 1);
						List<StatusType> filter = filterStatus(chase.getHurtSkills());
						// find the nearest ninja that will chase
						int nearestIndex = findNearestNinja2Combo(availableSkills, filter);
						if (nearestIndex != -1) {
							trigger = filter.get(nearestIndex);
						} else {
							// No more combos
							trigger = filter.get(0);
							isCombo = false;
						}
						System.out.println(oldTrigger + " -> " + trigger + " : " + ninja.get(i).getChakraSkill());

						// validate repetitions with zero
						if (chase.getRepetitions() == 0) {
							remove.add(i);
						}
						// is high combo?
						if (chase.getHurtSkills().contains(StatusType.HIGH_COMBO)) {
							isHighCombo = true;
						}

						break;
					}
				}
				// remove all chases in zero
				for (Integer integer : remove) {
					ninja.remove(integer.intValue());
				}
				if (isCombo) {
					break;
				}
			}

		} while (!isEmptyList(availableSkills) && isCombo);

		// TODO: add high combo check, for loop

	}

	private static int nearestCombo(ArrayList<Skill>[] availableSkills, StatusType status) {
		int nearest = -1;

		for (int i = 0; i < availableSkills.length; i++) {
			for (int j = 0; j < availableSkills[i].size(); j++) {
				if (availableSkills[i].get(j).getChaseSkills().contains(status)) {
					return i;
				}
			}
		}

		return nearest;
	}

	private static int findNearestNinja2Combo(ArrayList<Skill>[] availableSkills, List<StatusType> filter) {
		// min, index
		int min = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;
		boolean flag = false;
		for (int i = 0; i < filter.size(); i++) {
			StatusType statusType = filter.get(i);
			int temp = nearestCombo(availableSkills, statusType);
			if (temp < min && temp != -1) {
				min = temp;
				index = i;
				flag = true;
			}
		}
		if (flag) {
			return index;
		} else {
			return -1;
		}
	}

	/**
	 * @param chaseSkills
	 * @return
	 */
	private static List<StatusType> filterStatus(List<StatusType> chaseSkills) {
		List<StatusType> filter = new ArrayList<StatusType>();
		for (StatusType statusType : chaseSkills) {
			if (statusType == StatusType.LOW_FLOAT || statusType == StatusType.HIGH_FLOAT
					|| statusType == StatusType.REPULSED || statusType == StatusType.KNOCKDOWN
					|| statusType == StatusType.IMMOBILE || statusType == StatusType.SLEEP) {
				filter.add(statusType);
			}
		}
		return filter;
	}

	/**
	 * @param availableSkills
	 * @return
	 */
	private static boolean isEmptyList(ArrayList<Skill>[] availableSkills) {
		boolean isEmpty = true;
		for (ArrayList<Skill> arrayList : availableSkills) {
			isEmpty &= arrayList.isEmpty();
		}
		return isEmpty;
	}
}
