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
		SimulatorHelper.simulateTeam(getEasyTeam(), trigger);
		SimulatorHelper.simulateTeam(getPvpWindTeam(), trigger);
		SimulatorHelper.simulateTeam(getComboWindTeam(), trigger);
		System.out.println(((System.currentTimeMillis() - time)));

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
		kankuro.setSkill1(skill1);
		kankuro.setSkill2(skill2);
		kankuro.setSkill3(skill3);
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
		breezeDancer.setSkill1(skill1);
		breezeDancer.setSkill2(skill2);
		breezeDancer.setSkill3(skill3);
		breezeDancer.setSummon(summon);
		breezeDancer.setName("Breeze Dancer");

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
		hinata.setSkill1(skill1);
		hinata.setSkill2(skill2);
		hinata.setSkill3(skill3);
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
		karin.setSkill1(skill1);
		karin.setSkill2(skill2);
		karin.setSkill3(skill3);
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
		kurenai.setSkill1(skill1);
		kurenai.setSkill2(skill2);
		kurenai.setSkill3(skill3);
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
		fire.setSkill1(skill1);
		fire.setSkill2(skill2);
		fire.setSkill3(skill3);
		fire.setSummon(summon);
		fire.setName("Fire main");

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
		ningendo.setSkill1(skill1);
		ningendo.setSkill2(skill2);
		ningendo.setSkill3(skill3);
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
		tendo.setSkill1(skill1);
		tendo.setSkill2(skill2);
		tendo.setSkill3(skill3);
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
		chiyo.setSkill1(skill1);
		chiyo.setSkill2(skill2);
		chiyo.setSkill3(skill3);
		chiyo.setName("Chiyo ten puppets");

		Ninja[] team = { ningendo, tendo, chiyo, fire };
		return team;
	}
}
