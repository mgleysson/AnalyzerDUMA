package main;

import lexicalAnalyzer.LexicalAnalyzer;
import syntacticAnalyzer.SyntaticAnalyzer;

public class AnalyzerDUMA {
	private static LexicalAnalyzer lexicalAnalyzer;
	private static SyntaticAnalyzer syntaticAnalyzer;

	private static String filePath = "files/input/shell.duma";

	public AnalyzerDUMA() {

	}

	public static void main(String[] args) {

		lexicalAnalyzer = new LexicalAnalyzer(filePath);
		lexicalAnalyzer.readFile();
		//LexicalPrinter.printTokens(lexicalAnalyzer);
		syntaticAnalyzer = new SyntaticAnalyzer(lexicalAnalyzer);
		syntaticAnalyzer.analyze();
	}
}