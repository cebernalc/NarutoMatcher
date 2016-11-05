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

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 31, 2016
 */
public class SimulatorHelper {

	public static void main(String[] args) {
		// Test
		// Main
		Ninja breezeDancer = new Ninja();
		Skill summon = new Skill();
		summon.setChaseSkills(Arrays.asList(StatusType.LOW_FLOAT));
		summon.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		summon.setSkillType(SkillType.CHASE);

		Skill mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		mistery.setSkillType(SkillType.MYSTERY);
		Skill standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		standardAttack.setSkillType(SkillType.STANDARD);
		Skill skill1 = new Skill();
		skill1.setSkillType(SkillType.CHASE);
		skill1.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		skill1.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		Skill skill2 = new Skill();
		Skill skill3 = new Skill();

		breezeDancer.setMistery(mistery);
		breezeDancer.setStandardAttack(standardAttack);
		breezeDancer.setSkill1(skill1);
		breezeDancer.setSkill2(skill2);
		breezeDancer.setSkill3(skill3);
		breezeDancer.setSummon(summon);
		breezeDancer.setName("Breeze Dancer");

		// Naruto
		Ninja naruto = new Ninja();

		mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill2 = new Skill();
		skill2.setHurtSkills(Arrays.asList(StatusType.LOW_FLOAT));
		skill3 = new Skill();

		naruto.setMistery(mistery);
		naruto.setStandardAttack(standardAttack);
		naruto.setSkill1(skill1);
		naruto.setSkill2(skill2);
		naruto.setSkill3(skill3);
		naruto.setName("Naruto");

		// Gaara
		Ninja gaara = new Ninja();

		mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill2 = new Skill();
		skill2.setHurtSkills(Arrays.asList(StatusType.LOW_FLOAT));
		skill3 = new Skill();
		skill3.setChaseSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		skill3.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill3.setSkillType(SkillType.CHASE);

		gaara.setMistery(mistery);
		gaara.setStandardAttack(standardAttack);
		gaara.setSkill1(skill1);
		gaara.setSkill2(skill2);
		gaara.setSkill3(skill3);
		gaara.setName("Gaara");

		// Kabuto
		Ninja kabuto = new Ninja();

		mistery = new Skill();
		standardAttack = new Skill();
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill3 = new Skill();

		kabuto.setMistery(mistery);
		kabuto.setStandardAttack(standardAttack);
		kabuto.setSkill1(skill1);
		kabuto.setSkill2(skill2);
		kabuto.setSkill3(skill3);
		kabuto.setName("Kabuto");

		Ninja[] team = { gaara, naruto, breezeDancer, kabuto };

		simulateTeam(team);

	}

	/**
	 * 
	 * @param team
	 *            Receives a formation of 4 ninjas
	 */
	public static void simulateTeam(Ninja[] team) {
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
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(availableSkills);
		System.out.println(prettyJson);
		// System.out.println(Arrays.toString(availableSkills));

		StatusType trigger = StatusType.REPULSED;

		boolean isCombo = false;
		do {
			// TODO: finish the alg.

		} while (!isEmptyList(availableSkills) && isCombo);

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
