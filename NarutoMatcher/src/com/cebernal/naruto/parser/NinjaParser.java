/**
 * NinjaParser.java
 * 
 * Created on Oct 8, 2016, 10:28:26 PM
 *
 */
package com.cebernal.naruto.parser;

import java.util.HashMap;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.type.DamageType;
import com.cebernal.naruto.model.type.DebuffType;
import com.cebernal.naruto.model.type.ElementType;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 8, 2016
 */
public class NinjaParser {

	public static final String NINJA_SKILL = "Ninja Skills";
	public static final String MAIN_CHARACTER = "Main Character Skills";
	public static final String SUMMON = "Summon";

	public static void main(String[] args) {

	}

	/**
	 * @param skills
	 * @param ninja
	 * @return
	 */
	public static Ninja getNinja(JsonObject ninjaJson, HashMap<String, Skill> skills) {
		Ninja ninja = new Ninja();
		ninja.setName(ninjaJson.get("szName").getAsString());
		ninja.setIdNinja(ninjaJson.get("iNid").getAsString());
		ninja.setElement(ElementType.getType(ninjaJson.get("szAttr").getAsString()));

		String mystery = ninjaJson.get("iOySkill").getAsString();
		String standard = ninjaJson.get("iPgSkill").getAsString();
		String skill1 = ninjaJson.get("iBdSkill1").getAsString();
		String skill2 = ninjaJson.get("iBdSkill2").getAsString();
		String skill3 = ninjaJson.get("iBdSkill3").getAsString();

		ninja.setMistery(skills.get(mystery));
		ninja.setStandardAttack(skills.get(standard));
		ninja.setSkill1(skills.get(skill1));
		ninja.setSkill2(skills.get(skill2));
		ninja.setSkill3(skills.get(skill3));

		return ninja;
	}

	public static Skill parseSkill(String idSkill, JsonElement skillJson) {
		String titleSkill = skillJson.getAsJsonObject().get("szTitle").getAsString().replace("\n", " ");
		String characterSkill = skillJson.getAsJsonObject().get("szSkillAttr").getAsString();
		// for the summon and main ninjas
		String nameCharacter = skillJson.getAsJsonObject().get("szName").getAsString();
		String descriptionSkill = skillJson.getAsJsonObject().get("szDesc").getAsString().replace("\n", " ");
		String chaseSkill = skillJson.getAsJsonObject().get("szChaseStatus").getAsString().replace("\n", " ");
		String hurtSkill = skillJson.getAsJsonObject().get("szHurtStatus").getAsString().replace("\n", " ");
		String skillType = skillJson.getAsJsonObject().get("szType").getAsString().trim();
		String chakraSkill = skillJson.getAsJsonObject().get("iChakraUse").getAsString();
		String coolingTime = skillJson.getAsJsonObject().get("iChillTime").getAsString();
		int repetitions = Integer.parseInt(skillJson.getAsJsonObject().get("iTriggers").getAsString());
		// From the start of the match
		String battlefieldCooldown = skillJson.getAsJsonObject().get("iChill").getAsString();
		// Taijutsu ninjutsu
		String damageTypes = skillJson.getAsJsonObject().get("szHurtType").getAsString();
		// Fire ...s
		String damageElementTypes = skillJson.getAsJsonObject().get("szHurtType2").getAsString();

		Skill skill = new Skill();
		skill.setBattlefieldCooldown(battlefieldCooldown);
		skill.setChakraSkill(chakraSkill);
		skill.setChaseSkills(StatusType.getTypes(chaseSkill));
		skill.setCoolingTime(coolingTime);
		skill.setDamageElementTypes(ElementType.getTypes(damageElementTypes));
		skill.setDamageTypes(DamageType.getTypes(damageTypes));
		skill.setDescriptionSkill(descriptionSkill);
		skill.setHurtSkills(StatusType.getTypes(hurtSkill));
		skill.setDebuffs(DebuffType.getTypes(hurtSkill));
		skill.setIdSkill(idSkill);
		skill.setSkillType(SkillType.getType(skillType));
		skill.setTitleSkill(titleSkill);
		skill.setCharacterSkill(characterSkill);
		skill.setNameCharacter(nameCharacter);
		skill.setRepetitions(repetitions);

		return skill;
	}
}
