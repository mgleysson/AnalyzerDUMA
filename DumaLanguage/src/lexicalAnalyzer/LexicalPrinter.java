package lexicalAnalyzer;

public class LexicalPrinter {

	public static void printTokens(LexicalAnalyzer lexicalAnalyzer) {
		Token token;
		while (lexicalAnalyzer.hasMoreTokens()) {
			token = lexicalAnalyzer.nextToken();
			System.out.println(token.toString());
		}
		System.out.println();
		System.out.println();
		lexicalAnalyzer.readFile();
	}

}
