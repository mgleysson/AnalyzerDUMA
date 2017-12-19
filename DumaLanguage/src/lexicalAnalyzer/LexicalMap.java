package lexicalAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicalMap {

	public static Map<String, TokenCategory> lexemMap = new HashMap<>();
	public static Map<String, TokenCategory> delimitadorMap = new HashMap<>();
	public static List<Character> symbolList = new ArrayList<>();

	static {

		/* Operadores */

		// Aritméticos
		lexemMap.put("+", TokenCategory.OPARITAD);
		lexemMap.put("-", TokenCategory.OPARITAD);
		lexemMap.put("*", TokenCategory.OPARITMUL);
		lexemMap.put("/", TokenCategory.OPARITMUL);

		// Relacionais
		lexemMap.put("<", TokenCategory.OPREL1);
		lexemMap.put(">", TokenCategory.OPREL1);
		lexemMap.put("<=", TokenCategory.OPREL1);
		lexemMap.put(">=", TokenCategory.OPREL1);
		lexemMap.put("==", TokenCategory.OPREL2);
		lexemMap.put("!=", TokenCategory.OPREL2);
		lexemMap.put("=", TokenCategory.INSTATRIB);

		// Lógicos
		lexemMap.put("!", TokenCategory.OPLOGNEG);
		lexemMap.put("&&", TokenCategory.OPLOGAND);
		lexemMap.put("||", TokenCategory.OPLOGOR);

		// Concatenação
		lexemMap.put(".", TokenCategory.OPCON);

		/* Delimitadores */

		// Parâmetros
		lexemMap.put("(", TokenCategory.PARAMBEGIN);
		lexemMap.put(")", TokenCategory.PARAMEND);

		// Escopo
		lexemMap.put("{", TokenCategory.ESCBEGIN);
		lexemMap.put("}", TokenCategory.ESCEND);

		// Arrays
		lexemMap.put("[", TokenCategory.VETBEGIN);
		lexemMap.put("]", TokenCategory.VETEND);

		// Comentário
		lexemMap.put("/#", TokenCategory.COMMENT);

		// Terminador
		lexemMap.put(";", TokenCategory.TERMCMD);

		// Separador
		lexemMap.put(",", TokenCategory.SEPVIRG);

		/* Palavras reservadas */

		// Tipos primitivos
		lexemMap.put("litterae", TokenCategory.TDLIT);
		lexemMap.put("sermo", TokenCategory.TDSERMO);
		lexemMap.put("inanis", TokenCategory.TDINANIS);
		lexemMap.put("integer", TokenCategory.TDINT);
		lexemMap.put("realem", TokenCategory.TDREAL);
		lexemMap.put("boolean", TokenCategory.TDBOOL);

		// Comandos de seleção
		lexemMap.put("si", TokenCategory.SELSI);
		lexemMap.put("aliud", TokenCategory.SELALIUD);
		lexemMap.put("sialiud", TokenCategory.SELSIALIUD);

		// Comandos de repetição
		lexemMap.put("quia", TokenCategory.REPQUIA);
		lexemMap.put("dum", TokenCategory.REPDUM);
		lexemMap.put("in", TokenCategory.REPIN);
		lexemMap.put("facite", TokenCategory.REPFACITE);
		lexemMap.put("spatium", TokenCategory.REPSPATIUM);

		// Constantes booleanas
		lexemMap.put("true", TokenCategory.CTEBOOL);
		lexemMap.put("false", TokenCategory.CTEBOOL);

		// Outras palavras reservadas
		lexemMap.put("duma", TokenCategory.PRDUMA);
		lexemMap.put("initials", TokenCategory.PRINITIALS);
		lexemMap.put("initium", TokenCategory.PRINITIUM);
		lexemMap.put("reditus", TokenCategory.PRREDITUS);
		lexemMap.put("matrix", TokenCategory.PRMATRIX);
		lexemMap.put("scribo", TokenCategory.PRSCRIBO);
		lexemMap.put("lectio", TokenCategory.PRLECTIO);

		// Símbolos que podem indicador próximo token
		
		symbolList.add(' ');
		symbolList.add(',');
		symbolList.add(';');
		symbolList.add('+');
		symbolList.add('-');
		symbolList.add('*');
		symbolList.add('\\');
		symbolList.add('/');
		symbolList.add('#');
		symbolList.add('$');
		symbolList.add('<');
		symbolList.add('>');
		symbolList.add('=');
		symbolList.add('~');
		symbolList.add('(');
		symbolList.add(')');
		symbolList.add('[');
		symbolList.add(']');
		symbolList.add('{');
		symbolList.add('}');
		symbolList.add('\'');
		symbolList.add('"');

	}

}
