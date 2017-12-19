package syntacticAnalyzer;

import java.util.Stack;

import lexicalAnalyzer.Token;
import lexicalAnalyzer.LexicalAnalyzer;
import syntacticAnalyzer.SyntaticAnalyzer;
import syntacticAnalyzer.grammar.NonTerminal;
import syntacticAnalyzer.grammar.NonTerminalName;
import syntacticAnalyzer.grammar.Terminal;
import syntacticAnalyzer.PredictiveTable;
import syntacticAnalyzer.grammar.Derivation;
import syntacticAnalyzer.grammar.Grammar;
import syntacticAnalyzer.grammar.Symbol;

public class PredictiveAnalyzer {

	private Grammar grammar;
	private PredictiveTable predictiveTable;
	private LexicalAnalyzer lexicalAnalyzer;

	private Stack<Symbol> stack;
	private Derivation derivation;

	public PredictiveAnalyzer(Grammar grammar, PredictiveTable predictiveTable, LexicalAnalyzer lexicalAnalyzer) {

		this.grammar = grammar;
		this.predictiveTable = predictiveTable;
		this.lexicalAnalyzer = lexicalAnalyzer;

		stack = new Stack<Symbol>();
		derivation = new Derivation();
	}

	public void predictiveAnalyze() {

		Symbol topSymbol;
		Token token = new Token();
		Terminal terminal;
		NonTerminal topNonTerminal;
		Integer derivationNumber;
		Stack<Integer> prodCount = new Stack<Integer>();
		int leftCount = 0;
		int rightCount = 1;
		int rightCountAux = 0;

		if (lexicalAnalyzer.hasMoreTokens()) {

			token = lexicalAnalyzer.nextToken();

			terminal = new Terminal(token);
			stack.push(new NonTerminal(NonTerminalName.PROGRAM));
			prodCount.push(1);

			while (!stack.isEmpty()) {

				topSymbol = stack.peek();

				if (topSymbol.isTerminal()) {

					if (topSymbol.getValue() == terminal.getValue()) {
						stack.pop();
						listaToken(terminal);
						if (lexicalAnalyzer.hasMoreTokens()) {
							token = lexicalAnalyzer.nextToken();
							terminal = new Terminal(token);
						}

					} else {
						SyntaticAnalyzer.printError(token);
						System.exit(1);
					}

				} else {

					topNonTerminal = (NonTerminal) topSymbol;

					derivationNumber = null;

					derivationNumber = predictiveTable.getDerivationNumber(topNonTerminal.getName(),
							terminal.getCategory());

					if (derivationNumber != null) {
						leftCount = prodCount.pop();
						rightCountAux = rightCount;

						derivation = grammar.getGrammarMap().get(derivationNumber);

						if (derivation != null) {
							System.out.print(topNonTerminal.getName() + "(" + leftCount + ")" + " = ");
							stack.pop();
							// TO REMOVE
							Symbol symb;
							Terminal term;
							NonTerminal nonTerm;

							for (int i = derivation.getSymbolsList().size() - 1; i >= 0; i--) {

								symb = derivation.getSymbolsList().get(i);
								if (symb.isTerminal()) {
									term = (Terminal) symb;
								} else {
									nonTerm = (NonTerminal) symb;
								}

								stack.push(symb);
							}

							for (int i = 0; i < derivation.getSymbolsList().size(); i++) {
								symb = derivation.getSymbolsList().get(i);
								if (symb.isTerminal()) {
									term = (Terminal) symb;
									System.out.print("'" + term.getCategory().toString().toLowerCase() + "'" + " ");
								} else {
									nonTerm = (NonTerminal) symb;
									System.out.print(nonTerm.getName() + "(" + ++rightCount + ")" + " ");

								}
							}
							System.out.println();
						} else {
							System.out.println(topNonTerminal.getName() + "(" + leftCount + ")" + " = epsilon");
							stack.pop();
						}

						if (rightCount > rightCountAux) {
							int aux = rightCount;
							while (aux > rightCountAux) {
								prodCount.push(aux--);
							}
						}

					} else {
						SyntaticAnalyzer.printError(terminal.getTerminalToken());
						System.exit(1);
					}

				}
			}
		}
	}

	private void listaToken(Terminal terminal) {

		System.out.println(
				"	" + terminal.getCategory().name().toLowerCase() + " = " + "[" + terminal.getValue() + ", "
						+ "'" + terminal.getTerminalToken().getValue()+ "'" + ", " +
				terminal.getTerminalToken().getLine()+ ", " + terminal.getTerminalToken().getColumn() + "]");

	}

}
