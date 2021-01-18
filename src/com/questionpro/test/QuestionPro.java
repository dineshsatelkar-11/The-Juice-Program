package com.questionpro.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class QuestionPro {

	static Map<Character, Integer> cuboard = new LinkedHashMap<Character, Integer>();
	static Map<Integer, Map<Character, Integer>> listcupboard = new LinkedHashMap<Integer, Map<Character, Integer>>();
	static ArrayList<Integer> friendcaloryIntek = new ArrayList<Integer>();
	static String juicesincupboard = "";
	static List<String> bottlelist = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);

		System.out.println("Select Input Type");
		System.out.println("1 for File");
		System.out.println("2 for User Input");

		String inputType = myObj.nextLine();
		while (!Validator.isNumeric(inputType, Constant.CHECK_NO_ONLY)) {
			System.out.println("Select Correct Input Type");
			inputType = myObj.nextLine();
		}
		List<String> filedata = new ArrayList<String>();
		int totalNoofFriend = 0;
		if (inputType.equals("1")) {
			try {
				File fileobj = new File("SampleInputText.txt");
				Scanner myReader = new Scanner(fileobj);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					filedata.add(data);
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			if (filedata.size() % 3 == 1) {
				int j = 0;
				int x = 0;
				for (String c : filedata) {
					if (j == 0) {
						totalNoofFriend = Integer.parseInt(c);
					} else if (j == 1 || j % 3 == 1) {
						String[] s1 = c.split(" ");
						char juice = 'a';
						Map<Character, Integer> cuboard1 = new LinkedHashMap<Character, Integer>();
						for (int i = 1; i < s1.length; i++) {
							cuboard1.put(juice, Integer.parseInt(s1[i]));
							juice++;
						}
						listcupboard.put(x, cuboard1);
						x++;
					} else if (j == 2 || j % 3 == 2) {
						bottlelist.add(c);
					} else {
						friendcaloryIntek.add(Integer.parseInt(c));
					}
					j++;
				}
			} else {
				System.out.println("An error occurred in file data");
			}
		} else {
			System.out.println("Enter No of Friends");
			String nooffriends = myObj.nextLine();
			while (!Validator.isNumeric(nooffriends, Constant.NO_OF_FRIENDS)) {
				System.out.println("Enter Correct No of Friends");
				nooffriends = myObj.nextLine();
			}
			System.out.println("Enter No of unique fruit juices ");
			String noofuniquejuce = myObj.nextLine();
			while (!Validator.isNumeric(noofuniquejuce, Constant.NO_OF_UNIQUE_JUICE)) {
				System.out.println("Enter Correct No of unique fruit juices ");
				noofuniquejuce = myObj.nextLine();
			}
			System.out.println("Enter calorie content each unique fruit juices separated by comma");
			String calories = myObj.nextLine();
			String[] words = calories.split(",");
			while (!Validator.validateCalories(words, Integer.parseInt(noofuniquejuce))) {
				System.out.println("Enter Correct calorie content each unique fruit juices separated by comma");
				calories = myObj.nextLine();
				words = calories.split(",");
			}
			char juice = 'a';
			for (int i = 0; i < Integer.parseInt(noofuniquejuce); i++) {
				cuboard.put(juice, Integer.parseInt(words[i]));
				juice++;
			}
			System.out.println("Enter sequence for fruit juice in cupboard");
			juicesincupboard = myObj.nextLine();
			while (!Validator.validateJuices(juicesincupboard, Integer.parseInt(noofuniquejuce))) {
				System.out.println("Enter Correct sequence for fruit juice in cupboard");
				juicesincupboard = myObj.nextLine();
			}
			totalNoofFriend = Integer.parseInt(nooffriends);
		}

		System.out.println("***********************************");
		for (int j = 1; j < totalNoofFriend + 1; j++) {
			System.out.println("Friend No " + j + " Juice content:-");
			int cal = 0;
			if (inputType.equals("2")) {
				String noofcaloryrequired = myObj.nextLine();
				while (!Validator.isNumeric(noofcaloryrequired, Constant.CHECK_NO_ONLY)) {
					System.out.println("Enter correct friend no " + j + " Juice content:-");
					noofcaloryrequired = myObj.nextLine();
				}
				cal = Integer.parseInt(noofcaloryrequired);
			} else {
				cuboard = listcupboard.get(j - 1);
				juicesincupboard = bottlelist.get(j - 1);
				cal = friendcaloryIntek.get(j - 1);
			}
			finalCalculation(juicesincupboard, cuboard, cal);
		}
	}

	public static void finalCalculation(String juicesincupboard, Map<Character, Integer> outputMap, int caloriIntake) {
		String finalOutput = "";
		char[] ch = juicesincupboard.toCharArray();
		Arrays.sort(ch);
		Integer[] arr = new Integer[ch.length];
		int i = 0;
		for (char c : ch) {
			if (outputMap.get(c) == null) {
				arr[i] = 0;
			} else {
				arr[i] = outputMap.get(c);
			}
			i++;
		}
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(arr));
		List<Integer> local = new ArrayList<Integer>();
		ArrayList<Integer> test = unique_combination1(0, 0, caloriIntake, local, A);
		for (Integer value : test) {
			for (Entry<Character, Integer> entry : outputMap.entrySet()) {
				if (entry.getValue() == value) {
					finalOutput = finalOutput + entry.getKey().toString();
					break;
				}
			}
		}
		if (finalOutput.isEmpty()) {
			System.out.println("SORRY, YOU JUST HAVE WATER");
		} else {
			System.out.println("Fruit Combination : " + finalOutput);
		}
	}

	static ArrayList<Integer> result = new ArrayList<Integer>();

	static ArrayList<Integer> unique_combination1(int l, int sum, int K, List<Integer> local, List<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (sum == K) {
			System.out.print("{");
			for (int i = 0; i < local.size(); i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(local.get(i));
				result.add(local.get(i));
				if (i != local.size() - 1)
					System.out.print(", ");
			}
			System.out.println("}");
			return result;
		}

		for (int i = l; i < A.size(); i++) {
			if (sum + A.get(i) > K)
				continue;
			if (i == 1 && A.get(i) == A.get(i - 1) && i > l)
				continue;
			local.add(A.get(i));
			result = unique_combination1(i + 1, sum + A.get(i), K, local, A);
			if (!result.isEmpty())
				break;
			local.remove(local.size() - 1);
		}
		return result;
	}
}
