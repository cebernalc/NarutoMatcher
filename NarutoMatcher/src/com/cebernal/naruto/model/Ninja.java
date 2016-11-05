/**
 * Ninja.java
 * 
 * Created on Oct 8, 2016, 11:07:54 PM
 *
 */
package com.cebernal.naruto.model;

import java.util.ArrayList;
import java.util.List;

import com.cebernal.naruto.model.type.ElementType;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 8, 2016
 */
public class Ninja {

	private String name;
	private ElementType element;
	private Skill mistery;
	private Skill standardAttack;
	private Skill skill1;
	private Skill skill2;
	private Skill skill3;
	private Skill summon;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the element
	 */
	public ElementType getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(ElementType element) {
		this.element = element;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ninja [name=" + name + ", element=" + element + ", mistery=" + mistery + ", standardAttack="
				+ standardAttack + ", skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3 + ", summon="
				+ summon + "]";
	}

	public Skill getSummon() {
		return summon;
	}

	public void setSummon(Skill summon) {
		this.summon = summon;
	}

	public Skill getMistery() {
		return mistery;
	}

	public void setMistery(Skill mistery) {
		this.mistery = mistery;
	}

	public Skill getStandardAttack() {
		return standardAttack;
	}

	public void setStandardAttack(Skill standardAttack) {
		this.standardAttack = standardAttack;
	}

	public Skill getSkill1() {
		return skill1;
	}

	public void setSkill1(Skill skill1) {
		this.skill1 = skill1;
	}

	public Skill getSkill2() {
		return skill2;
	}

	public void setSkill2(Skill skill2) {
		this.skill2 = skill2;
	}

	public Skill getSkill3() {
		return skill3;
	}

	public void setSkill3(Skill skill3) {
		this.skill3 = skill3;
	}

}
