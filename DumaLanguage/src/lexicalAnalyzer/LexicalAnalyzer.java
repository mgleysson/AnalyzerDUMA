package lexicalAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale.Category;

import lexicalAnalyzer.LexicalMap;
import lexicalAnalyzer.Token;
import lexicalAnalyzer.TokenCategory;

public class LexicalAnalyzer {

	private List<String> linesList;
	private int currentLine, currentColumn, tkBeginColumn = 0, tkBeginLine = 0;
	private String line;
	private String filePath;

	private final char LINE_BREAK = '\n';

	//
	public LexicalAnalyzer(String filePath) {
		linesList = new ArrayList<>();
		this.filePath = filePath;
	}

	public void readFile() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String brLine = br.readLine();

			while (brLine != null) {
				linesList.add(brLine);
				brLine = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Token nextToken() {

		Token token;

		char currentChar;
		String tkValue = "";

		tkBeginColumn = currentColumn;
		tkBeginLine = currentLine;

		currentChar = line.charAt(currentColumn);

		// Ignora sequ�ncia de espa�os vazios
		while (currentChar == ' ' || currentChar == '\t') {
			currentChar = nextChar();
			tkBeginColumn++;
		}

		if (Character.toString(currentChar).matches("\\d")) {
			tkValue += currentChar;
			currentChar = nextChar();
			while (Character.toString(currentChar).matches("\\d")) {
				tkValue += currentChar;
				currentChar = nextChar();
			}
			if (currentChar == '.') {
				tkValue += currentChar;
				currentChar = nextChar();
				while (Character.toString(currentChar).matches("\\d")) {
					tkValue += currentChar;
					currentChar = nextChar();
				}
			}

			if (currentChar != ' ') {
				while (!LexicalMap.symbolList.contains(currentChar)) {
					tkValue += currentChar;

					// Vai para o proximo
					currentChar = nextChar();
					if (currentChar == LINE_BREAK) {
						break;
					}
				}
			}
		} else {

			// Enquanto nao for encontrado um simbolo especial, os
			// caracteres
			// serao concatenados em uma string que devera ser um token
			// identificador ou palavra chave.
			while (!LexicalMap.symbolList.contains(currentChar)) {
				tkValue += currentChar;

				// Vai para o proximo
				currentChar = nextChar();
				if (currentChar == LINE_BREAK) {
					break;
				}
			}
		}

		if (tkValue == "") {
			// Verifica��o de constantes inteiras ou decimais

			switch (currentChar) {

			case '"': // Compondo um token que possivelmente � uma string

				tkValue += currentChar;
				currentChar = nextChar();

				if (currentChar == '"') {
					tkValue += currentChar;
					currentColumn++;
					break;
				}

				// Buscar os pr�ximos caracteres at� que encontre uma ", ou
				// acabe a linha
				while (currentChar != LINE_BREAK) {
					tkValue += currentChar;
					currentChar = nextChar();

					if (currentChar == '"') {
						tkValue += currentChar;
						currentColumn++;
						break;
					}
				}
				break;

			// TODO Verifica��o de coment�rios
			case '/':
				tkValue += currentChar;
				currentChar = nextChar();

				if (currentChar == '#') {
					tkValue += currentChar;
					currentLine++;
					currentColumn = 0;
				}
				break;

			// TODO AJEITAR -> Verificar se tem abre comentario antes;
			case '#':
				tkValue += currentChar;
				currentChar = nextChar();
				if (currentChar == '/') {
					tkValue += currentChar;
					currentChar = nextChar();
				}
				break;

			case '\'': // Compondo um token que possivelmente � um char

				tkValue += currentChar;

				// Buscar os pr�ximos dois caracteres
				currentChar = nextChar();
				if (currentChar != LINE_BREAK) {
					tkValue += currentChar;
				}
				currentChar = nextChar();
				if (currentChar == '\'') {
					tkValue += currentChar;
					currentColumn++;
				}
				break;

			// TODO TRATAR N COISAS.... (=)...
			case '<':
			case '>':
			case '!':
			case '=': // Compondo um token que pode ser <=, >=, ~= ou ==

				tkValue += currentChar;
				currentChar = nextChar();
				if (currentChar == '=') {
					tkValue += currentChar;
					currentColumn++;
				}
				break;

			case '+': // Compondo um token que pode ser operador aditivo, de
						// concatena��o ou constante num�rica
				tkValue += currentChar;
				currentChar = nextChar();

				if (currentChar == '+') {
					tkValue += currentChar;
					currentChar = nextChar();
				}

				break;

			default:
				tkValue += currentChar;
				currentColumn++;
				break;
			}
		}

		tkValue = tkValue.trim();

		token = new Token();

		token.setValue(tkValue);
		token.setLine(tkBeginLine);
		token.setColumn(tkBeginColumn);
		token.setCategory(analyzeCategory(tkValue));

		if (token.getCategory().equals(TokenCategory.COMMENT)) {
			if (hasMoreTokens()) {
				return nextToken();
			}
		}
		return token;

	}

	public boolean hasMoreTokens() {

		if (!linesList.isEmpty()) {
			if (currentLine < linesList.size()) {

				line = linesList.get(currentLine);
				line = line.replace('\t', ' ');

				if (line.substring(currentColumn).matches("\\s*")) {
					currentLine++;
					currentColumn = 0;
					while (currentLine < linesList.size()) {
						line = linesList.get(currentLine);
						if (line.matches("\\s*")) {
							currentLine++;
						} else {
							return true;
						}
					}
				} else if (currentColumn < line.length()) {
					return true;
				} else {
					currentLine++;
					currentColumn = 0;
					while (currentLine < linesList.size()) {
						line = linesList.get(currentLine);
						if (line.matches("\\s*")) {
							currentLine++;
						} else {
							return true;
						}
					}
				}
			}
		}

		return false;

	}

	private TokenCategory analyzeCategory(String tkValue) {

		if (isOpNegUnary(tkValue)) {
			return TokenCategory.OPARITUN;

		} else if (LexicalMap.lexemMap.containsKey(tkValue)) {
			return LexicalMap.lexemMap.get(tkValue);

		} else if (isCchar(tkValue)) {
			return TokenCategory.CTESERMO;

		} else if (isChar(tkValue)) {
			return TokenCategory.CTELIT;

		} else if (isConstInt(tkValue)) {
			return TokenCategory.CTENUMINT;

		} else if (isConstDec(tkValue)) {
			return TokenCategory.CTENUMREAL;

		} else if (isIdentifier(tkValue)) {
			return TokenCategory.ID;
		}

		return TokenCategory.UNKNOWN;
	}

	private Character nextChar() {

		currentColumn++;

		if (currentColumn < line.length()) {
			return line.charAt(currentColumn);
		} else {
			return LINE_BREAK;
		}

	}

	private boolean isOpNegUnary(String tkValue) {

		if (tkValue.equals("-")) { // Decide se o - � o operador aditivo ou se �
									// o un�rio negativo

			Character previousChar = previousNotBlankChar();
			if ((previousChar != null) && Character.toString(previousChar).matches("[_a-zA-Z0-9]")) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private Character previousNotBlankChar() {

		int previousColumn = tkBeginColumn - 1;
		char previousChar;

		while (previousColumn >= 0) {
			previousChar = line.charAt(previousColumn);
			if (previousChar != ' ' && previousChar != '\t') {
				return previousChar;
			}
			previousColumn--;
		}
		return null;
	}

	private boolean isConstDec(String tkValue) {
		if (tkValue.matches("(\\d)+\\.(\\d)+")) {
			return true;
		} else if (tkValue.matches("(\\d)+\\.")) {
			printError("constante decimal em formato errado.", tkValue);
		}
		return false;
	}

	private boolean isConstInt(String tkValue) {
		if (tkValue.matches("(\\d)+")) {
			return true;
		}
		return false;
	}

	private boolean isCchar(String tkValue) {
		if (tkValue.startsWith("\"") && tkValue.endsWith("\"")) {
			return true;
		} else if (tkValue.startsWith("\"")) {
			printError("cadeia de caracteres n�o fechada corretamente com '\"'.", tkValue);
		}
		return false;
	}

	private boolean isChar(String tkValue) {
		if (tkValue.matches("'(.?)'")) {
			return true;
		} else if (tkValue.startsWith("'")) {
			printError("caracter n�o fechado corretamente com '.", tkValue);
		}
		return false;
	}

	private boolean isIdentifier(String tkValue) {

		if (tkValue.matches("[_a-zA-Z][_a-zA-Z0-9]*")) {
			if (tkValue.length() < 16) {
				return true;
			} else {
				printError("identificador muito longo.", tkValue);
			}

			// Caso em que o identificador n�o come�a com o caractere esperado.
			// Tamb�m n�o considera tkValue que come�a com ", ' ou n�mero pois
			// caso
			// algum tkValue nessa condi��o chegue at� aqui, � um cchar ou um
			// char que
			// n�o foi propriamente fechado, ou uma constante decimal em formato
			// errado.
		} else if (tkValue.matches("[^_a-zA-Z\"'].*")) {
			printError("identificador n�o iniciado com letra ou '_'.", tkValue);

			// Caso em que o identificador come�a com o caracter esperado, mas
			// cont�m algum caracter inv�lido,
		} else if (tkValue.matches("[_a-zA-Z].*")) {
			printError("identificador cont�m caracter inv�lido.", tkValue);

		}
		return false;
	}

	private void printError(String string, String token) {
		System.err.println("Erro na <linha, coluna> " + "= <" + currentLine + "," + currentColumn + ">. " + "'" + token
				+ "'" + " " + string);
		System.exit(1);
	}
}