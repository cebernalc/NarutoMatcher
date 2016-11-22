/**
 * SimulatorHelper.java
 * 
 * Created on Oct 31, 2016, 1:49:21 AM
 * 
 */
package com.cebernal.naruto.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.Solution;
import com.cebernal.naruto.model.type.SkillType;
import com.cebernal.naruto.model.type.StatusType;
import com.cebernal.naruto.parser.DatabaseParser;
import com.google.common.collect.Collections2;

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
	public static Solution simulateTeam(Ninja[] team, StatusType trigger) {
		// Ninja first = team[0];
		// Ninja second = team[1];
		// Ninja third = team[2];
		// Ninja fourth = team[3];
		ArrayList<Skill> availableSkills[] = new ArrayList[4];
		int mainIndex = 0;
		// Populate chases
		for (int i = 0; i < team.length; i++) {
			List<Skill> temp = new ArrayList<Skill>();
			availableSkills[i] = new ArrayList<Skill>();
			if (team[i].isMain()) {
				mainIndex = i;
			}
			if (team[i].getSkill1().getSkillType() == SkillType.CHASE) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSkill1().getChaseSkills());
				chase.setHurtSkills(team[i].getSkill1().getHurtSkills());
				chase.setRepetitions(team[i].getSkill1().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
			if (team[i].getSkill2() != null && team[i].getSkill2().getSkillType() == SkillType.CHASE) {
				Skill chase = new Skill();
				chase.setChaseSkills(team[i].getSkill2().getChaseSkills());
				chase.setHurtSkills(team[i].getSkill2().getHurtSkills());
				chase.setRepetitions(team[i].getSkill2().getRepetitions());
				chase.setChakraSkill(team[i].getName());
				availableSkills[i].add(chase);
			}
			if (team[i].getSkill3() != null && team[i].getSkill3().getSkillType() == SkillType.CHASE) {
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
				String tempName = team[i].getName();
				if (team[i].isMain()) {
					tempName += " [Summon]";
				}
				chase.setChakraSkill(tempName);
				availableSkills[i].add(chase);
			}
		}
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// String prettyJson = gson.toJson(availableSkills);
		// System.out.println(prettyJson);
		// System.out.println(Arrays.toString(availableSkills));

		boolean isCombo;
		boolean isHighCombo = false;
		int combo = 1;
		StringBuffer buffer = new StringBuffer(trigger + "\n");
		// System.out.println(trigger);
		do {
			isCombo = false;
			for (ArrayList<Skill> ninja : availableSkills) {
				ArrayList<Integer> remove = new ArrayList<Integer>();
				for (int i = 0; i < ninja.size(); i++) {
					Skill chase = ninja.get(i);
					if (chase.getChaseSkills().contains(trigger)) {
						StatusType oldTrigger = trigger;
						isCombo = true;
						chase.setRepetitions(chase.getRepetitions() - 1);
						List<StatusType> filter = NinjaHelper.filterStatus(chase.getHurtSkills());
						// find the nearest ninja that will chase
						int nearestIndex = findNearestNinja2Combo(availableSkills, filter);
						if (nearestIndex != -1) {
							trigger = filter.get(nearestIndex);
						} else {
							// No more combos
							trigger = filter.get(0);
							isCombo = false;
						}
						// System.out.println(oldTrigger + " -> " + trigger + "
						// : " + ninja.get(i).getChakraSkill());
						buffer.append(oldTrigger + " -> " + trigger + " : " + ninja.get(i).getChakraSkill() + "\n");
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
			combo++;
		} while (!isEmptyList(availableSkills) && isCombo);
		// System.out.println("Combo: " + combo);
		// TODO: add high combo check, for loop
		Solution solution = new Solution();
		solution.setNinja1(team[0].getIdNinja());
		solution.setNinja2(team[1].getIdNinja());
		solution.setNinja3(team[2].getIdNinja());
		solution.setNinja4(team[3].getIdNinja());
		solution.setMaxCombo(combo);
		solution.setSummon(team[mainIndex].getSummon().getIdSkill());
		solution.setChase(team[mainIndex].getSkill1().getIdSkill());
		solution.setComboString(buffer.toString());
		return solution;
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

	/**
	 * @param main
	 * @param summon
	 * @param lockedNinjas
	 * @param activeNinjas
	 * @param targetCombo
	 * @return
	 */
	public static List<Solution> generateTeams(Ninja main, Skill summon, List<String> lockedNinjas,
			List<String> activeNinjas, int targetCombo) {

		List<Solution> solutions = new ArrayList<Solution>();
		List<Skill> summons = new ArrayList<Skill>();
		List<List<String>> combinations = null;
		List<List<String>> allCombinations = new ArrayList<>();

		int count = 3 - lockedNinjas.size();
		combinations = generateGroup(activeNinjas, count);
		for (List<String> list : combinations) {
			// Add locked ninja and main
			list.add(main.getIdNinja());
			for (String lockedNinjaId : lockedNinjas) {
				list.add(lockedNinjaId);
			}
			// System.out.println(list);
			// System.out.println("-------");
			List<List<String>> generateCombinations = generatePermutations(list, 4);
			allCombinations.addAll(generateCombinations);
			// for (List<String> simulation : generateCombinations) {
			//
			// System.out.println(simulation);
			// }
			// System.out.println("-------");
		}

		// Add all yellow summons
		if (summon.getNameCharacter().contains("all")) {
			for (Skill summonDb : DatabaseParser.getInstance().getSummons().values()) {
				if (summonDb.getRepetitions() > 1) {
					summons.add(summonDb);
				}
			}
		} else {
			summons.add(summon);
		}
		//
		ArrayList<StatusType> attacksMain = new ArrayList<StatusType>(NinjaHelper.getAttacksMain(main));
		List<Skill> chassesMain = NinjaHelper.getChassesMain(main);
		// Iterate through all summons
		for (Skill summonIterator : summons) {
			for (List<String> teamToSimulate : allCombinations) {
				List<Ninja> ninjas = NinjaHelper.getNinjas(teamToSimulate.toArray(new String[0]));
				List<StatusType> attacksTeam = NinjaHelper.getAttacksTeam(ninjas, attacksMain);
				// Each standard attack of the team
				for (StatusType statusType : attacksTeam) {
					// Each chase of the main ninja
					for (Skill chaseMain : chassesMain) {
						// Identify main ninja
						for (Ninja ninja : ninjas) {
							if (ninja.getIdNinja().equals(main.getIdNinja())) {
								main.setSummon(summonIterator);
								main.setSkill1(chaseMain);
								main.setSkill2(new Skill());
								main.setSkill3(new Skill());
							}
						}

						// Simulate!
						// simulationTeam[0] = teamToSimulate.get(0);
						// simulationTeam[1] = teamToSimulate.get(1);
						// simulationTeam[2] = teamToSimulate.get(2);
						// simulationTeam[3] = teamToSimulate.get(3);
						Solution solution = simulateTeam(ninjas.toArray(new Ninja[0]), statusType);
						if (solution.getMaxCombo() >= targetCombo) {
							solutions.add(solution);
						}
					}
				}
			}
		}

		return solutions;
	}

	/**
	 * @param list
	 * @param i
	 * @return
	 */
	private static List<List<String>> generatePermutations(List<String> list, int i) {
		List<List<String>> permutation = new ArrayList<>();
		Collection<List<String>> result = Collections2.orderedPermutations(list);
		for (List<String> team : result) {
			permutation.add(team);
		}
		return permutation;
	}

	private static List<List<String>> generateGroup(List<String> activeNinjas, int howMany) {
		List<List<String>> combinations = new ArrayList<>();
		choose(activeNinjas, howMany, new ArrayList<String>(), 0, combinations, false);
		return combinations;
	}

	/**
	 * n choose k
	 * 
	 * @param activeNinjas
	 * @param howMany
	 * @param stringBuffer
	 * @param i
	 * @param combination
	 */
	private static void choose(List<String> data, int k, List<String> result, int startIndex,
			List<List<String>> combination, boolean distinct) {
		if (result.size() == k) {
			// System.out.println(result.toString());
			HashSet<String> subList = new HashSet<String>();
			for (String ninja : result) {
				subList.add(ninja);
			}
			if (distinct || (!containsHash(combination, subList) && !distinct)) {
				combination.add(new ArrayList<String>(subList));
			}
			// result.clear();
			return;
		}

		for (int i = startIndex; i < data.size(); i++) {
			result.add(data.get(i));
			choose(data, k, result, i + 1, combination, distinct);
			result.remove(result.size() - 1);
		}
	}

	private static boolean containsHash(List<List<String>> combination, HashSet<String> subList) {
		boolean contains = false;
		for (List<String> string : combination) {
			if (new HashSet<>(string).hashCode() == subList.hashCode()) {
				contains = true;
				break;
			}
		}
		return contains;
	}

}
