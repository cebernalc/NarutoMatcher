/**
 * DatabaseParser.java
 * 
 * Created on Oct 29, 2016, 6:36:36 PM
 *
 */
package com.cebernal.naruto.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Oct 29, 2016
 */
public class DatabaseParser {

	private HashMap<String, Skill> skills = new HashMap<String, Skill>();
	private HashMap<String, Skill> summons = new HashMap<String, Skill>();
	private HashMap<String, Skill> mainSkills = new HashMap<String, Skill>();
	private List<String> mains = new ArrayList<String>();
	private HashMap<String, Ninja> ninjas = new HashMap<String, Ninja>();
	private static DatabaseParser INSTANCE = null;

	public static void main(String[] args) {
		DatabaseParser.getInstance().buildDatabase();
	}

	private DatabaseParser() {
		buildDatabase();
	}

	public static DatabaseParser getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseParser();
		}
		return INSTANCE;
	}

	public void buildDatabase() {

	public static DatabaseParser getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseParser();
		}
		return INSTANCE;
	}

	public void buildDatabase() {

		String fileName = "naruto_data/data.txt";
		JsonObject database = fileToJSON(fileName).getAsJsonObject("data");

		// Getting skills from json
		JsonArray listSkills = database.get("skills").getAsJsonArray();

		List<String> mainNames = new ArrayList<String>();

		// int count = 0;
		// Parsing skills
		for (JsonElement skillJson : listSkills.getAsJsonArray()) {
			String idSkill = skillJson.getAsJsonObject().get("iSkillId").getAsString();
			// Parse if it is not already in the map
			if (!getSkills().containsKey(idSkill) && !getMainSkills().containsKey(idSkill)
					&& !getSummons().containsKey(idSkill)) {
				Skill skill = NinjaParser.parseSkill(idSkill, skillJson);

				// Validate the type
				if (skill.getCharacterSkill().equalsIgnoreCase(NinjaParser.NINJA_SKILL)) {
					getSkills().put(idSkill, skill);
				} else if (skill.getCharacterSkill().equalsIgnoreCase(NinjaParser.MAIN_CHARACTER)) {
					getMainSkills().put(idSkill, skill);
					String name = skill.getNameCharacter().replace("[", "").replace("]", "");
					// Update list of mains
					if (!mainNames.contains(name)) {
						mainNames.add(name);
					}
				} else if (skill.getCharacterSkill().equalsIgnoreCase(NinjaParser.SUMMON)) {
					getSummons().put(idSkill, skill);
//					System.out.println(skill.toJson());
				}
			}
			// count++;
		}

		for (JsonElement ninjaJson : database.get("ninjas").getAsJsonArray()) {
			JsonObject ninja = ninjaJson.getAsJsonObject();
			// Parsing ninja
			Ninja ninjaPojo = NinjaParser.getNinja(ninja, getSkills());
			if (mainNames.contains(ninjaPojo.getName())) {
				mains.add(ninjaPojo.getIdNinja());
			}
			ninjas.put(ninjaPojo.getIdNinja(), ninjaPojo);
			// Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// String prettyJson = gson.toJson(ninjaPojo);
			// System.out.println(ninjaPojo);
			// System.out.println(prettyJson);
			// break;
		}

		// for (Entry<String, Skill> string : skills.entrySet()) {
		// Skill skill = string.getValue();
		// if (skill.getSkillType() == SkillType.CHASE) {
		// System.out.println(skill.getIdSkill());
		// System.out.println(skill.getDescriptionSkill());
		// System.out.println(skill.getChaseSkills() + " : " +
		// skill.getHurtSkills());
		// System.out.println(skill.getDebuffs());
		// System.out.println("-------------------------\n");
		// }
		// }

		// System.out.println("--------");
		// for (Skill string : summons.values()) {
		// System.out.println(string.getNameCharacter());
		// }
		// System.out.println("--------");
		// System.out.println(prettyJson);

	}

	private JsonObject fileToJSON(String fileName) {
		JsonObject jsonObject = new JsonObject();
		try {
			JsonParser parser = new JsonParser();
			// Read from File to String
			jsonObject = parser.parse(new FileReader(fileName)).getAsJsonObject();
		} catch (FileNotFoundException e) {
			return null;
		}
		return jsonObject;
	}

	public HashMap<String, Skill> getSkills() {
		return skills;
	}

	public void setSkills(HashMap<String, Skill> skills) {
		this.skills = skills;
	}

	public HashMap<String, Skill> getSummons() {
		return summons;
	}

	public void setSummons(HashMap<String, Skill> summons) {
		this.summons = summons;
	}

	public HashMap<String, Skill> getMainSkills() {
		return mainSkills;
	}

	public void setMainSkills(HashMap<String, Skill> mainSkills) {
		this.mainSkills = mainSkills;
	}

	public HashMap<String, Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(HashMap<String, Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	public List<String> getMains() {
		return mains;
	}

	public void setMains(List<String> mains) {
		this.mains = mains;
	}

}
