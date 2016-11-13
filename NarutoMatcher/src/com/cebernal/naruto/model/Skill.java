/**
 * Skill.java
 * 
 * Created on Oct 8, 2016, 11:08:23 PM
 *
 */
package com.cebernal.naruto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cebernal.naruto.model.type.DamageType;
import com.cebernal.naruto.model.type.DebuffType;
import com.cebernal.naruto.model.type.ElementType;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 8, 2016
 */
public class Skill {

	private String idSkill;
	private String titleSkill;
	private String descriptionSkill;
	private List<StatusType> chaseSkills = Arrays.asList(StatusType.NONE);
	private List<StatusType> hurtSkills = Arrays.asList(StatusType.NONE);
	private List<DebuffType> debuffs = Arrays.asList(DebuffType.NONE);
	private String chakraSkill;
	private String coolingTime;
	private String battlefieldCooldown;
	private String characterSkill;
	private String nameCharacter;
	private int repetitions = 1;
	private SkillType skillType = SkillType.PASSIVE;
	private List<DamageType> damageTypes = new ArrayList<DamageType>();
	private List<ElementType> damageElementTypes = new ArrayList<ElementType>();

	/**
	 * @return the idSkill
	 */
	public String getIdSkill() {
		return idSkill;
	}

	/**
	 * @param idSkill
	 *            the idSkill to set
	 */
	public void setIdSkill(String idSkill) {
		this.idSkill = idSkill;
	}

	/**
	 * @return the descriptionSkill
	 */
	public String getDescriptionSkill() {
		return descriptionSkill;
	}

	/**
	 * @param descriptionSkill
	 *            the descriptionSkill to set
	 */
	public void setDescriptionSkill(String descriptionSkill) {
		this.descriptionSkill = descriptionSkill;
	}

	/**
	 * @return the chakraSkill
	 */
	public String getChakraSkill() {
		return chakraSkill;
	}

	/**
	 * @param chakraSkill
	 *            the chakraSkill to set
	 */
	public void setChakraSkill(String chakraSkill) {
		this.chakraSkill = chakraSkill;
	}

	/**
	 * @return the coolingTime
	 */
	public String getCoolingTime() {
		return coolingTime;
	}

	/**
	 * @param coolingTime
	 *            the coolingTime to set
	 */
	public void setCoolingTime(String coolingTime) {
		this.coolingTime = coolingTime;
	}

	/**
	 * @return the battlefieldCooldown
	 */
	public String getBattlefieldCooldown() {
		return battlefieldCooldown;
	}

	/**
	 * @param battlefieldCooldown
	 *            the battlefieldCooldown to set
	 */
	public void setBattlefieldCooldown(String battlefieldCooldown) {
		this.battlefieldCooldown = battlefieldCooldown;
	}

	/**
	 * @return the skillType
	 */
	public SkillType getSkillType() {
		return skillType;
	}

	/**
	 * @param skillType
	 *            the skillType to set
	 */
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	/**
	 * @return the damageElementTypes
	 */
	public List<ElementType> getDamageElementTypes() {
		return damageElementTypes;
	}

	/**
	 * @param damageElementTypes
	 *            the damageElementTypes to set
	 */
	public void setDamageElementTypes(List<ElementType> damageElementTypes) {
		this.damageElementTypes = damageElementTypes;
	}

	/**
	 * @return the damageTypes
	 */
	public List<DamageType> getDamageTypes() {
		return damageTypes;
	}

	/**
	 * @param damageTypes
	 *            the damageTypes to set
	 */
	public void setDamageTypes(List<DamageType> damageTypes) {
		this.damageTypes = damageTypes;
	}

	@Override
	public String toString() {
		String temp = "";
		if (getHurtSkills().get(0) != StatusType.NONE) {
			temp = ": " + getChaseSkills() + " -> " + getHurtSkills() + " x" + getRepetitions();
		}
		return nameCharacter + temp;
	}

	public String toJson() {
		return "Skill [idSkill=" + idSkill + ", titleSkill=" + titleSkill + ", descriptionSkill=" + descriptionSkill
				+ ", chaseSkills=" + chaseSkills + ", hurtSkills=" + hurtSkills + ", debuffs=" + debuffs
				+ ", chakraSkill=" + chakraSkill + ", coolingTime=" + coolingTime + ", battlefieldCooldown="
				+ battlefieldCooldown + ", characterSkill=" + characterSkill + ", nameCharacter=" + nameCharacter
				+ ", repetitions=" + repetitions + ", skillType=" + skillType + ", damageTypes=" + damageTypes
				+ ", damageElementTypes=" + damageElementTypes + "]";
	}

	/**
	 * @return the titleSkill
	 */
	public String getTitleSkill() {
		return titleSkill;
	}

	/**
	 * @param titleSkill
	 *            the titleSkill to set
	 */
	public void setTitleSkill(String titleSkill) {
		this.titleSkill = titleSkill;
	}

	public String getCharacterSkill() {
		return characterSkill;
	}

	public void setCharacterSkill(String characterSkill) {
		this.characterSkill = characterSkill;
	}

	public String getNameCharacter() {
		return nameCharacter;
	}

	public void setNameCharacter(String nameCharacter) {
		this.nameCharacter = nameCharacter;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public List<StatusType> getChaseSkills() {
		return chaseSkills;
	}

	public void setChaseSkills(List<StatusType> chaseSkills) {
		this.chaseSkills = chaseSkills;
	}

	public List<StatusType> getHurtSkills() {
		return hurtSkills;
	}

	public void setHurtSkills(List<StatusType> hurtSkills) {
		this.hurtSkills = hurtSkills;
	}

	public List<DebuffType> getDebuffs() {
		return debuffs;
	}

	public void setDebuffs(List<DebuffType> debuffs) {
		this.debuffs = debuffs;
	}

}
