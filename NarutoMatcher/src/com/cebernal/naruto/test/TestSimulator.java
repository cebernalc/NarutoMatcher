/**
 * TestSimulator.java
 * 
 * Created on Nov 6, 2016, 4:51:39 PM
 * 
 */
package com.cebernal.naruto.test;

import java.util.Arrays;

import com.cebernal.naruto.helper.SimulatorHelper;
import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.Solution;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 6, 2016
 */
public class TestSimulator {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		StatusType trigger = StatusType.KNOCKDOWN;
		Solution solution = SimulatorHelper.simulateTeam(getEasyTeam(), trigger);
		System.out.println(solution);
		solution = SimulatorHelper.simulateTeam(getPvpWindTeam(), trigger);
		System.out.println(solution);
		solution = SimulatorHelper.simulateTeam(getComboWindTeam(), trigger);
		System.out.println(solution);
		System.out.println("Milliseconds:" + ((System.currentTimeMillis() - time)));

	}

	public static Ninja[] getEasyTeam() {
		// Test
		// Main
		Ninja breezeDancer = new Ninja();
		Skill summon = new Skill();
		summon.setChaseSkills(Arrays.asList(StatusType.LOW_FLOAT));
		summon.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
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
		breezeDancer.getSkills().put(0, skill1);
		breezeDancer.getSkills().put(1, skill2);
		breezeDancer.getSkills().put(2, skill3);
		breezeDancer.setSummon(summon);
		breezeDancer.setName("Breeze Dancer");
		breezeDancer.setMain(true);

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
		naruto.getSkills().put(0, skill1);
		naruto.getSkills().put(1, skill2);
		naruto.getSkills().put(2, skill3);
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
		gaara.getSkills().put(0, skill1);
		gaara.getSkills().put(1, skill2);
		gaara.getSkills().put(2, skill3);
		gaara.setName("Gaara");

		// Kankuro
		Ninja kankuro = new Ninja();

		mistery = new Skill();
		standardAttack = new Skill();
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setHurtSkills(Arrays.asList(StatusType.LOW_FLOAT));
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill3 = new Skill();

		kankuro.setMistery(mistery);
		kankuro.setStandardAttack(standardAttack);
		kankuro.getSkills().put(0, skill1);
		kankuro.getSkills().put(1, skill2);
		kankuro.getSkills().put(2, skill3);
		kankuro.setName("Kankuro");

		Ninja[] team = { gaara, naruto, breezeDancer, kankuro };
		return team;
	}

	/**
	 * Pvp team breeze, hinata, karin, kurenai, lighting tiger
	 * 
	 * @return
	 */
	public static Ninja[] getPvpWindTeam() {
		// Test
		// Main
		Ninja breezeDancer = new Ninja();
		Skill summon = new Skill();
		summon.setChaseSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		summon.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		summon.setSkillType(SkillType.CHASE);
		summon.setRepetitions(2);

		Skill mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		mistery.setSkillType(SkillType.MYSTERY);
		Skill standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		standardAttack.setSkillType(SkillType.STANDARD);
		Skill skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		skill1.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setSkillType(SkillType.CHASE);
		Skill skill2 = new Skill();
		Skill skill3 = new Skill();

		breezeDancer.setMistery(mistery);
		breezeDancer.setStandardAttack(standardAttack);
		breezeDancer.getSkills().put(0, skill1);
		breezeDancer.getSkills().put(1, skill2);
		breezeDancer.getSkills().put(2, skill3);
		breezeDancer.setSummon(summon);
		breezeDancer.setName("Breeze Dancer");
		breezeDancer.setMain(true);

		// Hinata
		Ninja hinata = new Ninja();

		mistery = new Skill();
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		skill1.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill2.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill2.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill2.setSkillType(SkillType.CHASE);
		skill3 = new Skill();

		hinata.setMistery(mistery);
		hinata.setStandardAttack(standardAttack);
		hinata.getSkills().put(0, skill1);
		hinata.getSkills().put(1, skill2);
		hinata.getSkills().put(2, skill3);
		hinata.setName("Hinata");

		// Karin
		Ninja karin = new Ninja();

		mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill2 = new Skill();
		skill2.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill2.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		skill2.setSkillType(SkillType.CHASE);
		skill3 = new Skill();
		skill3.setChaseSkills(Arrays.asList(StatusType.HIGH_COMBO));
		skill3.setSkillType(SkillType.CHASE);

		karin.setMistery(mistery);
		karin.setStandardAttack(standardAttack);
		karin.getSkills().put(0, skill1);
		karin.getSkills().put(1, skill2);
		karin.getSkills().put(2, skill3);
		karin.setName("Karin");

		// kurenai
		Ninja kurenai = new Ninja();

		mistery = new Skill();
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1 = new Skill();
		skill2 = new Skill();
		skill2.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill2.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		skill2.setSkillType(SkillType.CHASE);
		skill3 = new Skill();

		kurenai.setMistery(mistery);
		kurenai.setStandardAttack(standardAttack);
		kurenai.getSkills().put(0, skill1);
		kurenai.getSkills().put(1, skill2);
		kurenai.getSkills().put(2, skill3);
		kurenai.setName("Kurenai");

		Ninja[] team = { breezeDancer, hinata, karin, kurenai };
		return team;
	}

	public static Ninja[] getComboWindTeam() {
		// Test
		// Main
		Ninja fire = new Ninja();
		Skill summon = new Skill();
		summon.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		summon.setHurtSkills(Arrays.asList(StatusType.LOW_FLOAT));
		summon.setSkillType(SkillType.CHASE);
		summon.setRepetitions(2);

		Skill mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		mistery.setSkillType(SkillType.MYSTERY);
		Skill standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		standardAttack.setSkillType(SkillType.STANDARD);
		Skill skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.LOW_FLOAT));
		skill1.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		skill1.setSkillType(SkillType.CHASE);
		Skill skill2 = new Skill();
		Skill skill3 = new Skill();

		fire.setMistery(mistery);
		fire.setStandardAttack(standardAttack);
		fire.getSkills().put(0, skill1);
		fire.getSkills().put(1, skill2);
		fire.getSkills().put(2, skill3);
		fire.setSummon(summon);
		fire.setName("Fire main");
		fire.setMain(true);

		// Ningendo
		Ninja ningendo = new Ninja();

		mistery = new Skill();
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		skill1.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setRepetitions(2);
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill3 = new Skill();

		ningendo.setMistery(mistery);
		ningendo.setStandardAttack(standardAttack);
		ningendo.getSkills().put(0, skill1);
		ningendo.getSkills().put(1, skill2);
		ningendo.getSkills().put(2, skill3);
		ningendo.setName("Ningendo");

		// Tendo
		Ninja tendo = new Ninja();

		mistery = new Skill();
		mistery.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		mistery.setSkillType(SkillType.MYSTERY);
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		standardAttack.setSkillType(SkillType.STANDARD);
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill3 = new Skill();
		skill3.setChaseSkills(Arrays.asList(StatusType.REPULSED));
		skill3.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill3.setRepetitions(2);
		skill3.setSkillType(SkillType.CHASE);

		tendo.setMistery(mistery);
		tendo.setStandardAttack(standardAttack);
		tendo.getSkills().put(0, skill1);
		tendo.getSkills().put(1, skill2);
		tendo.getSkills().put(2, skill3);
		tendo.setName("Tendo");

		// Chiyo
		Ninja chiyo = new Ninja();

		mistery = new Skill();
		standardAttack = new Skill();
		standardAttack.setHurtSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1 = new Skill();
		skill1.setChaseSkills(Arrays.asList(StatusType.KNOCKDOWN));
		skill1.setHurtSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		skill1.setRepetitions(5);
		skill1.setSkillType(SkillType.CHASE);
		skill2 = new Skill();
		skill2.setChaseSkills(Arrays.asList(StatusType.HIGH_FLOAT));
		skill2.setHurtSkills(Arrays.asList(StatusType.REPULSED));
		skill2.setRepetitions(5);
		skill2.setSkillType(SkillType.CHASE);
		skill3 = new Skill();

		chiyo.setMistery(mistery);
		chiyo.setStandardAttack(standardAttack);
		chiyo.getSkills().put(0, skill1);
		chiyo.getSkills().put(1, skill2);
		chiyo.getSkills().put(2, skill3);
		chiyo.setName("Chiyo ten puppets");

		Ninja[] team = { ningendo, tendo, chiyo, fire };
		return team;
	}
}
