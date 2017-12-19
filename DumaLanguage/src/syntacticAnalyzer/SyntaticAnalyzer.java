package syntacticAnalyzer;

import lexicalAnalyzer.LexicalAnalyzer;
import lexicalAnalyzer.Token;
import syntacticAnalyzer.PredictiveAnalyzer;
import syntacticAnalyzer.PredictiveTable;
import syntacticAnalyzer.grammar.Grammar;

public class SyntaticAnalyzer {

	private Grammar grammar;
	private PredictiveAnalyzer predictiveAnalyzer;
	private PredictiveTable predictiveTable;

	public SyntaticAnalyzer(LexicalAnalyzer lexicalAnalyzer) {
		grammar = Grammar.getInstance();
		predictiveTable = new PredictiveTable();
		predictiveAnalyzer = new PredictiveAnalyzer(grammar, predictiveTable, lexicalAnalyzer);
	}

	public void analyze() {
		predictiveAnalyzer.predictiveAnalyze();
	}

	public static void printError(Token token) {
		System.err.println("Erro no token " + token.getCategory() + "(" + token.getValue() + ")," + " na linha "
				+ token.getLine() + " e coluna " + token.getColumn() + ".");
	}

}
