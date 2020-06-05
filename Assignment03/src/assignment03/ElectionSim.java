package assignment03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ElectionSim {

	private String outputFile;
	private int population;
	private Candidate[] candidates;
	private Region[] regions;

	public ElectionSim(String inputFile, String outputFile) {
		this.outputFile = outputFile;
		Scanner scanner = null;

		try {
			File inFile = new File(inputFile);
			scanner = new Scanner(new FileInputStream(inFile));
		}
		catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist.");
			System.exit(0);
		}

		String s;
		s = scanner.next(); // POPULATION
		this.population = scanner.nextInt();
		s = scanner.nextLine(); // to handle the "\n"

		s = scanner.next(); // CANDIDATES
		int cnum = scanner.nextInt(); // Candidate의 수
		this.candidates = new Candidate[cnum];	// Candidate Array : candidates 생성
		s = scanner.nextLine(); // to handle the "\n"

		for (int i = 0; i < cnum; i++) {
			s = scanner.next();
			this.candidates[i] = new Candidate(s, this.population);
			s = scanner.nextLine();
		}

		s = scanner.next(); // REGIONS
		int rnum = scanner.nextInt(); // Region의 수
		this.regions = new Region[rnum];		// Region Array: regions 생성
		s = scanner.nextLine();

		for (int i = 0; i < rnum; i++) {
			String r_name = scanner.next();
			int r_num = scanner.nextInt();
			int r_pop = scanner.nextInt();
			this.regions[i] = new Region(r_name, r_num, r_pop, this.candidates);
			if (i != rnum - 1)	// for handling the last line of this file
				s = scanner.nextLine();
		}
	}

	public void saveData() {
		// candidates 배열을 정렬
		Arrays.sort(candidates);
		try {
			File outFile = new File(this.outputFile);
			PrintWriter writer = new PrintWriter(new FileOutputStream(outFile));
			for (int i = 0; i < candidates.length; i++) {
				writer.println(candidates[i]);
				for (int j = 0; j < regions.length; j++) {
					writer.println(regions[j].getRegionName() + ": " + candidates[i].toRegionString(j + 1));
				}
				writer.println();
				writer.println("=================================");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open the file!");
			System.exit(0);
		}
	}

	public void runSimulation() {
		/* your code */
		for (int i = 0; i < this.regions.length; i++) {
			this.regions[i].start();	// 스레드 시작
			try {
				this.regions[i].join();
			}
			catch (Exception e) {
				// Do Nothing.
			}
		}
		for(int i = 0; i < this.regions.length; i++) {

		}
		saveData();
	}
}
