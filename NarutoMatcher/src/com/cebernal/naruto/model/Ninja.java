/**
 * Ninja.java
 * 
 * Created on Oct 8, 2016, 11:07:54 PM
 *
 */
package com.cebernal.naruto.model;

import java.util.SortedMap;
import java.util.TreeMap;

import com.cebernal.naruto.model.type.ElementType;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 8, 2016
 */
public class Ninja implements Comparable<Ninja> {

	private String idNinja;
	private String name;
	private ElementType element;
	private Skill mistery;
	private Skill standardAttack;
	private SortedMap<Integer, Skill> skills = new TreeMap<Integer, Skill>();
	private Skill summon = null;
	private String image;
	private boolean isMain = false;

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
		return name + ": [" + getElement() + "]";
	}

	public String toJson() {
		return "Ninja [name=" + name + ", element=" + element + ", mistery=" + mistery + ", standardAttack="
				+ standardAttack + ", skills=" + getSkills().toString() + ", summon=" + summon + "]";
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

	public String getIdNinja() {
		return idNinja;
	}

	public void setIdNinja(String idNinja) {
		this.idNinja = idNinja;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Ninja o) {
		return getName().compareTo(o.getName());
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

	public SortedMap<Integer, Skill> getSkills() {
		return skills;
	}

	public void setSkills(SortedMap<Integer, Skill> skills) {
		this.skills = skills;
	}

}
