/**
 * NinjaHelper.java
 * 
 * Created on Nov 19, 2016, 10:30:38 PM
 * 
 */
package com.cebernal.naruto.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;
import com.cebernal.naruto.parser.DatabaseParser;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 19, 2016
 */
public class NinjaHelper {

	public static TreeSet<StatusType> getAttacksMain(Ninja main) {
		List<Skill> skill4Main = getSkill4Main(main, SkillType.STANDARD);
		TreeSet<StatusType> types = new TreeSet<StatusType>();
		for (Skill standardAttack : skill4Main) {
			types.addAll(standardAttack.getHurtSkills());
		}
		return types;
	}

	public static List<StatusType> getAttacksTeam(List<Ninja> ninjas, List<StatusType> main) {
		TreeSet<StatusType> standarAttacks = new TreeSet<StatusType>();
		for (Ninja ninja : ninjas) {
			if (!ninja.isMain()) {
				// System.out.println(ninja.getName());
				// System.out.println(ninja.getStandardAttack());
				standarAttacks.addAll(ninja.getStandardAttack().getHurtSkills());
			}
		}
		standarAttacks.addAll(main);
		return filterStatus(new ArrayList<StatusType>(standarAttacks));
	}

	public static List<Skill> getChassesMain(Ninja main) {
		return getSkill4Main(main, SkillType.CHASE);
	}

	private static List<Skill> getSkill4Main(Ninja main, SkillType chase) {
		List<Skill> skills = new ArrayList<Skill>();
		for (Skill skill : DatabaseParser.getInstance().getMainSkills().values()) {
			if (chase == skill.getSkillType() && skill.getNameCharacter().contains(main.getName())
					&& ((chase == SkillType.STANDARD && !skill.getHurtSkills().isEmpty())
							|| (chase == SkillType.CHASE && !skill.getChaseSkills().isEmpty()
									&& !skill.getChaseSkills().contains(StatusType.HIGH_COMBO)))) {
				System.out.println(skill);
				skills.add(skill);
			}
		}
		return skills;
	}

	/**
	 * @param chaseSkills
	 * @return
	 */
	public static List<StatusType> filterStatus(List<StatusType> chaseSkills) {
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
	 * @param lockedNinjas
	 * @return
	 */
	public static List<Ninja> getNinjas(String... lockedNinjas) {
		List<Ninja> ninjas = new ArrayList<Ninja>();
		for (String ninja : lockedNinjas) {
			ninjas.add(DatabaseParser.getInstance().getNinjas().get(ninja));
		}
		return ninjas;
	}

	public static void main(String[] args) {
		Ninja main = new Ninja();
		main.setName("Scarlet Blaze");
		NinjaHelper.getChassesMain(main);
		NinjaHelper.getAttacksMain(main);
	}

	/**
	 * @param summon
	 * @return
	 */
	public static Skill getSkill(String summon) {
		return DatabaseParser.getInstance().getSkills().get(summon);
	}

	public static Skill getSummonSkill(String summon) {
		return DatabaseParser.getInstance().getSummons().get(summon);
	}

	public static Skill getMainSkill(String summon) {
		return DatabaseParser.getInstance().getMainSkills().get(summon);
	}
}
