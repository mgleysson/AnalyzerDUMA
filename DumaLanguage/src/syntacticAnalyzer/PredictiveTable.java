package syntacticAnalyzer;

import java.util.HashMap;
import lexicalAnalyzer.TokenCategory;
import syntacticAnalyzer.grammar.NonTerminalName;

public class PredictiveTable {

	private HashMap<NonTerminalName, HashMap<TokenCategory, Integer>> predectiveTableMap;
	private HashMap<TokenCategory, Integer> terminaisMap;

	public PredictiveTable() {
		terminaisMap = new HashMap<TokenCategory, Integer>();
		predectiveTableMap = new HashMap<NonTerminalName, HashMap<TokenCategory, Integer>>();

		loadPredectiveTableMap();
	}

	public Integer getDerivationNumber(NonTerminalName nonTerminal, TokenCategory terminal) {
		return predectiveTableMap.get(nonTerminal).get(terminal);
	}

	// Tabela preditiva
	private void loadPredectiveTableMap() {

		terminaisMap.put(TokenCategory.PRDUMA, 0);
		predectiveTableMap.put(NonTerminalName.PROGRAM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 1);
		terminaisMap.put(TokenCategory.TDINT, 1);
		terminaisMap.put(TokenCategory.TDREAL, 1);
		terminaisMap.put(TokenCategory.TDLIT, 1);
		terminaisMap.put(TokenCategory.TDBOOL, 1);
		terminaisMap.put(TokenCategory.TDSERMO, 1);
		terminaisMap.put(TokenCategory.PRINITIALS, 1);
		predectiveTableMap.put(NonTerminalName.BEGIN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.TDINANIS, 2);
		terminaisMap.put(TokenCategory.TDINT, 2);
		terminaisMap.put(TokenCategory.TDREAL, 2);
		terminaisMap.put(TokenCategory.TDLIT, 2);
		terminaisMap.put(TokenCategory.TDBOOL, 2);
		terminaisMap.put(TokenCategory.TDSERMO, 2);
		terminaisMap.put(TokenCategory.PRINITIALS, 3);
		predectiveTableMap.put(NonTerminalName.FUNCTIONS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PRINITIALS, 4);
		predectiveTableMap.put(NonTerminalName.INITIUM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();
		
		terminaisMap.put(TokenCategory.PARAMBEGIN, 5);
		predectiveTableMap.put(NonTerminalName.PARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PARAMEND, 6);
		terminaisMap.put(TokenCategory.TDINANIS, 7);
		terminaisMap.put(TokenCategory.TDINT, 7);
		terminaisMap.put(TokenCategory.TDREAL, 7);
		terminaisMap.put(TokenCategory.TDLIT, 7);
		terminaisMap.put(TokenCategory.TDBOOL, 7);
		terminaisMap.put(TokenCategory.TDSERMO, 7);
		terminaisMap.put(TokenCategory.PRMATRIX, 7);
		predectiveTableMap.put(NonTerminalName.PARAMSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 8);
		terminaisMap.put(TokenCategory.TDINT, 8);
		terminaisMap.put(TokenCategory.TDREAL, 8);
		terminaisMap.put(TokenCategory.TDLIT, 8);
		terminaisMap.put(TokenCategory.TDBOOL, 8);
		terminaisMap.put(TokenCategory.TDSERMO, 8);
		terminaisMap.put(TokenCategory.PRMATRIX, 9);
		predectiveTableMap.put(NonTerminalName.LISTPARAMS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SEPVIRG, 10);
		terminaisMap.put(TokenCategory.PARAMEND, 11);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 12);
		terminaisMap.put(TokenCategory.TDINT, 12);
		terminaisMap.put(TokenCategory.TDREAL, 12);
		terminaisMap.put(TokenCategory.TDLIT, 12);
		terminaisMap.put(TokenCategory.TDBOOL, 12);
		terminaisMap.put(TokenCategory.TDSERMO, 12);
		terminaisMap.put(TokenCategory.PRMATRIX, 13);
		predectiveTableMap.put(NonTerminalName.RETURNTYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		
		terminaisMap.put(TokenCategory.TDINANIS, 14);
		terminaisMap.put(TokenCategory.TDINT, 15);
		terminaisMap.put(TokenCategory.TDREAL, 16);
		terminaisMap.put(TokenCategory.TDLIT, 17);
		terminaisMap.put(TokenCategory.TDBOOL, 18);
		terminaisMap.put(TokenCategory.TDSERMO, 19);
		predectiveTableMap.put(NonTerminalName.TYPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.CTENUMINT, 20);
		terminaisMap.put(TokenCategory.CTENUMREAL, 21);
		terminaisMap.put(TokenCategory.CTELIT, 22);
		terminaisMap.put(TokenCategory.CTESERMO, 23);
		terminaisMap.put(TokenCategory.CTEBOOL, 24);
		predectiveTableMap.put(NonTerminalName.CONSTANT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.ID, 25);
		predectiveTableMap.put(NonTerminalName.NAME, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 26);
		terminaisMap.put(TokenCategory.SEPVIRG, 27);
		terminaisMap.put(TokenCategory.TERMCMD, 27);
		terminaisMap.put(TokenCategory.OPCON, 27);
		terminaisMap.put(TokenCategory.PARAMEND, 27);
		terminaisMap.put(TokenCategory.INSTATRIB, 27);
		predectiveTableMap.put(NonTerminalName.NAMEFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.ESCBEGIN, 28);
		predectiveTableMap.put(NonTerminalName.SCOPE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 29);
		terminaisMap.put(TokenCategory.TDINT, 29);
		terminaisMap.put(TokenCategory.TDREAL, 29);
		terminaisMap.put(TokenCategory.TDLIT, 29);
		terminaisMap.put(TokenCategory.TDBOOL, 29);
		terminaisMap.put(TokenCategory.TDSERMO, 29);
		terminaisMap.put(TokenCategory.PRMATRIX, 29);
		terminaisMap.put(TokenCategory.ID, 29);
		terminaisMap.put(TokenCategory.PRSCRIBO, 29);
		terminaisMap.put(TokenCategory.PRLECTIO, 29);
		terminaisMap.put(TokenCategory.SELSI, 29);
		terminaisMap.put(TokenCategory.REPDUM, 29);
		terminaisMap.put(TokenCategory.REPFACITE, 29);
		terminaisMap.put(TokenCategory.REPQUIA, 29);
		terminaisMap.put(TokenCategory.PRREDITUS, 29);
		terminaisMap.put(TokenCategory.ESCEND, 30);
		predectiveTableMap.put(NonTerminalName.COMMANDS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 31);
		terminaisMap.put(TokenCategory.TDINT, 31);
		terminaisMap.put(TokenCategory.TDREAL, 31);
		terminaisMap.put(TokenCategory.TDLIT, 31);
		terminaisMap.put(TokenCategory.TDBOOL, 31);
		terminaisMap.put(TokenCategory.TDSERMO, 31);
		terminaisMap.put(TokenCategory.PRMATRIX, 31);
		terminaisMap.put(TokenCategory.ID, 32);
		terminaisMap.put(TokenCategory.PRSCRIBO, 33);
		terminaisMap.put(TokenCategory.PRLECTIO, 34);
		terminaisMap.put(TokenCategory.SELSI, 35);
		terminaisMap.put(TokenCategory.REPDUM, 36);
		terminaisMap.put(TokenCategory.REPFACITE, 37);
		terminaisMap.put(TokenCategory.REPQUIA, 38);
		terminaisMap.put(TokenCategory.PRREDITUS, 39);
		predectiveTableMap.put(NonTerminalName.CMD, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TDINANIS, 40);
		terminaisMap.put(TokenCategory.TDINT, 40);
		terminaisMap.put(TokenCategory.TDREAL, 40);
		terminaisMap.put(TokenCategory.TDLIT, 40);
		terminaisMap.put(TokenCategory.TDBOOL, 40);
		terminaisMap.put(TokenCategory.TDSERMO, 40);
		terminaisMap.put(TokenCategory.PRMATRIX, 41);
		predectiveTableMap.put(NonTerminalName.DECLARATION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 42);
		terminaisMap.put(TokenCategory.SEPVIRG, 42);
		terminaisMap.put(TokenCategory.ID, 42);
		terminaisMap.put(TokenCategory.INSTATRIB, 42);
		terminaisMap.put(TokenCategory.TERMCMD, 42);
		terminaisMap.put(TokenCategory.OPCON, 42);
		terminaisMap.put(TokenCategory.PARAMEND, 42);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 43);
		predectiveTableMap.put(NonTerminalName.CMDFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 44);
		terminaisMap.put(TokenCategory.SEPVIRG, 44);
		terminaisMap.put(TokenCategory.TERMCMD, 44);
		terminaisMap.put(TokenCategory.OPCON, 44);
		terminaisMap.put(TokenCategory.PARAMEND, 44);
		terminaisMap.put(TokenCategory.INSTATRIB, 44);
		predectiveTableMap.put(NonTerminalName.ATTRIBUTION, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 45);
		terminaisMap.put(TokenCategory.OPLOGNEG, 46);
		terminaisMap.put(TokenCategory.OPARITUN, 46);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 46);
		terminaisMap.put(TokenCategory.CTENUMINT, 46);
		terminaisMap.put(TokenCategory.CTENUMREAL, 46);
		terminaisMap.put(TokenCategory.CTEBOOL, 46);
		terminaisMap.put(TokenCategory.CTESERMO, 46);
		terminaisMap.put(TokenCategory.CTELIT, 46);
		terminaisMap.put(TokenCategory.ID, 46);
		predectiveTableMap.put(NonTerminalName.VALUE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 47);
		predectiveTableMap.put(NonTerminalName.ARRAY, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.CTENUMINT, 48);
		terminaisMap.put(TokenCategory.CTENUMREAL, 48);
		terminaisMap.put(TokenCategory.CTEBOOL, 48);
		terminaisMap.put(TokenCategory.CTESERMO, 48);
		terminaisMap.put(TokenCategory.CTELIT, 48);
		terminaisMap.put(TokenCategory.VETEND, 49);
		predectiveTableMap.put(NonTerminalName.ARRAYFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.CTENUMINT, 50);
		terminaisMap.put(TokenCategory.CTENUMREAL, 50);
		terminaisMap.put(TokenCategory.CTEBOOL, 50);
		terminaisMap.put(TokenCategory.CTESERMO, 50);
		terminaisMap.put(TokenCategory.CTELIT, 50);
		predectiveTableMap.put(NonTerminalName.ELEMENTS, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SEPVIRG, 51);
		terminaisMap.put(TokenCategory.VETEND, 52);
		predectiveTableMap.put(NonTerminalName.ELEMENTSFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PARAMBEGIN, 53);
		predectiveTableMap.put(NonTerminalName.FUNCCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.TERMCMD, 54);
		terminaisMap.put(TokenCategory.CTENUMINT, 54);
		terminaisMap.put(TokenCategory.CTENUMREAL, 54);
		terminaisMap.put(TokenCategory.CTEBOOL, 54);
		terminaisMap.put(TokenCategory.CTESERMO, 54);
		terminaisMap.put(TokenCategory.CTELIT, 54);
		terminaisMap.put(TokenCategory.ID, 54);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALL, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SEPVIRG, 55);
		terminaisMap.put(TokenCategory.PARAMEND, 56);
		predectiveTableMap.put(NonTerminalName.LISTPARAMSCALLFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		
		terminaisMap.put(TokenCategory.CTENUMINT, 57);
		terminaisMap.put(TokenCategory.CTENUMREAL, 57);
		terminaisMap.put(TokenCategory.CTEBOOL, 57);
		terminaisMap.put(TokenCategory.CTESERMO, 57);
		terminaisMap.put(TokenCategory.CTELIT, 57);
		terminaisMap.put(TokenCategory.ID, 58);
		predectiveTableMap.put(NonTerminalName.ITEMPARAM, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PRSCRIBO, 59);
		predectiveTableMap.put(NonTerminalName.WRITE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.CTESERMO, 60);
		terminaisMap.put(TokenCategory.TERMCMD, 61);
		terminaisMap.put(TokenCategory.ID, 61);
		predectiveTableMap.put(NonTerminalName.MESSAGE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPCON, 62);
		terminaisMap.put(TokenCategory.PARAMEND, 63);
		predectiveTableMap.put(NonTerminalName.MESSAGEFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PRLECTIO, 64);
		predectiveTableMap.put(NonTerminalName.READ, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SELSI, 65);
		predectiveTableMap.put(NonTerminalName.IFELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SELSI, 66);
		predectiveTableMap.put(NonTerminalName.IF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SELSIALIUD, 67);
		terminaisMap.put(TokenCategory.SELALIUD, 68);
		terminaisMap.put(TokenCategory.TERMCMD, 68);
		predectiveTableMap.put(NonTerminalName.ELSEIF, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.SELALIUD, 69);
		terminaisMap.put(TokenCategory.TERMCMD, 70);
		predectiveTableMap.put(NonTerminalName.ELSE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.REPDUM, 71);
		predectiveTableMap.put(NonTerminalName.WHILE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.REPFACITE, 72);
		predectiveTableMap.put(NonTerminalName.DOWHILE, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.REPQUIA, 73);
		predectiveTableMap.put(NonTerminalName.FOR, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PRREDITUS, 74);
		predectiveTableMap.put(NonTerminalName.RETURN, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

	
		terminaisMap.put(TokenCategory.CTENUMINT, 75);
		terminaisMap.put(TokenCategory.CTENUMREAL, 75);
		terminaisMap.put(TokenCategory.CTEBOOL, 75);
		terminaisMap.put(TokenCategory.CTESERMO, 75);
		terminaisMap.put(TokenCategory.CTELIT, 75);
		terminaisMap.put(TokenCategory.ID, 76);
		predectiveTableMap.put(NonTerminalName.RETURNFAT, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 77);
		terminaisMap.put(TokenCategory.OPARITUN, 77);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 77);
		terminaisMap.put(TokenCategory.CTENUMINT, 77);
		terminaisMap.put(TokenCategory.CTENUMREAL, 77);
		terminaisMap.put(TokenCategory.CTEBOOL, 77);
		terminaisMap.put(TokenCategory.CTESERMO, 77);
		terminaisMap.put(TokenCategory.CTELIT, 77);
		terminaisMap.put(TokenCategory.ID, 77);
		predectiveTableMap.put(NonTerminalName.Eb, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGOR, 78);
		terminaisMap.put(TokenCategory.PARAMEND, 79);
		terminaisMap.put(TokenCategory.TERMCMD, 79);
		terminaisMap.put(TokenCategory.VETEND, 79);
		predectiveTableMap.put(NonTerminalName.Ebr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 80);
		terminaisMap.put(TokenCategory.OPARITUN, 80);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 80);
		terminaisMap.put(TokenCategory.CTENUMINT, 80);
		terminaisMap.put(TokenCategory.CTENUMREAL, 80);
		terminaisMap.put(TokenCategory.CTEBOOL, 80);
		terminaisMap.put(TokenCategory.CTESERMO, 80);
		terminaisMap.put(TokenCategory.CTELIT, 80);
		terminaisMap.put(TokenCategory.ID, 80);
		predectiveTableMap.put(NonTerminalName.Tb, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGAND, 81);
		terminaisMap.put(TokenCategory.OPLOGOR, 82);
		terminaisMap.put(TokenCategory.PARAMEND, 82);
		terminaisMap.put(TokenCategory.TERMCMD, 82);
		terminaisMap.put(TokenCategory.VETEND, 82);
		predectiveTableMap.put(NonTerminalName.Tbr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 83);
		terminaisMap.put(TokenCategory.OPARITUN, 83);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 83);
		terminaisMap.put(TokenCategory.CTENUMINT, 83);
		terminaisMap.put(TokenCategory.CTENUMREAL, 83);
		terminaisMap.put(TokenCategory.CTEBOOL, 83);
		terminaisMap.put(TokenCategory.CTESERMO, 83);
		terminaisMap.put(TokenCategory.CTELIT, 83);
		terminaisMap.put(TokenCategory.ID, 83);
		predectiveTableMap.put(NonTerminalName.Fb, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPREL2, 84);
		terminaisMap.put(TokenCategory.OPLOGAND, 85);
		terminaisMap.put(TokenCategory.OPLOGOR, 85);
		terminaisMap.put(TokenCategory.PARAMEND, 85);
		terminaisMap.put(TokenCategory.TERMCMD, 85);
		terminaisMap.put(TokenCategory.VETEND, 85);
		predectiveTableMap.put(NonTerminalName.Fbr, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 86);
		terminaisMap.put(TokenCategory.OPARITUN, 86);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 86);
		terminaisMap.put(TokenCategory.CTENUMINT, 86);
		terminaisMap.put(TokenCategory.CTENUMREAL, 86);
		terminaisMap.put(TokenCategory.CTEBOOL, 86);
		terminaisMap.put(TokenCategory.CTESERMO, 86);
		terminaisMap.put(TokenCategory.CTELIT, 86);
		terminaisMap.put(TokenCategory.ID, 86);
		predectiveTableMap.put(NonTerminalName.Erel2, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPREL1, 87);
		terminaisMap.put(TokenCategory.OPREL2, 88);
		terminaisMap.put(TokenCategory.OPLOGAND, 88);
		terminaisMap.put(TokenCategory.OPLOGOR, 88);
		terminaisMap.put(TokenCategory.PARAMEND, 88);
		terminaisMap.put(TokenCategory.TERMCMD, 88);
		terminaisMap.put(TokenCategory.VETEND, 88);
		predectiveTableMap.put(NonTerminalName.Erel2r, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 89);
		terminaisMap.put(TokenCategory.OPARITUN, 89);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 89);
		terminaisMap.put(TokenCategory.CTENUMINT, 89);
		terminaisMap.put(TokenCategory.CTENUMREAL, 89);
		terminaisMap.put(TokenCategory.CTEBOOL, 89);
		terminaisMap.put(TokenCategory.CTESERMO, 89);
		terminaisMap.put(TokenCategory.CTELIT, 89);
		terminaisMap.put(TokenCategory.ID, 89);
		predectiveTableMap.put(NonTerminalName.Erel1, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPARITAD, 90);
		terminaisMap.put(TokenCategory.OPREL1, 91);
		terminaisMap.put(TokenCategory.OPREL2, 91);
		terminaisMap.put(TokenCategory.OPLOGAND, 91);
		terminaisMap.put(TokenCategory.OPLOGOR, 91);
		terminaisMap.put(TokenCategory.PARAMEND, 91);
		terminaisMap.put(TokenCategory.TERMCMD, 91);
		terminaisMap.put(TokenCategory.VETEND, 91);
		predectiveTableMap.put(NonTerminalName.Erel1r, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPLOGNEG, 92);
		terminaisMap.put(TokenCategory.OPARITUN, 92);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 92);
		terminaisMap.put(TokenCategory.CTENUMINT, 92);
		terminaisMap.put(TokenCategory.CTENUMREAL, 92);
		terminaisMap.put(TokenCategory.CTEBOOL, 92);
		terminaisMap.put(TokenCategory.CTESERMO, 92);
		terminaisMap.put(TokenCategory.CTELIT, 92);
		terminaisMap.put(TokenCategory.ID, 92);
		predectiveTableMap.put(NonTerminalName.Ea, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPARITMUL, 93);
		terminaisMap.put(TokenCategory.OPARITAD, 94);
		terminaisMap.put(TokenCategory.OPREL1, 94);
		terminaisMap.put(TokenCategory.OPREL2, 94);
		terminaisMap.put(TokenCategory.OPLOGAND, 94);
		terminaisMap.put(TokenCategory.OPLOGOR, 94);
		terminaisMap.put(TokenCategory.PARAMEND, 94);
		terminaisMap.put(TokenCategory.TERMCMD, 94);
		terminaisMap.put(TokenCategory.VETEND, 94);
		predectiveTableMap.put(NonTerminalName.Ear, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.OPARITUN, 95);
		terminaisMap.put(TokenCategory.OPLOGNEG, 96);
		terminaisMap.put(TokenCategory.PARAMBEGIN, 97);
		terminaisMap.put(TokenCategory.CTENUMINT, 97);
		terminaisMap.put(TokenCategory.CTENUMREAL, 97);
		terminaisMap.put(TokenCategory.CTEBOOL, 97);
		terminaisMap.put(TokenCategory.CTESERMO, 97);
		terminaisMap.put(TokenCategory.CTELIT, 97);
		terminaisMap.put(TokenCategory.ID, 97);
		predectiveTableMap.put(NonTerminalName.Ta, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.PARAMBEGIN, 98);
		terminaisMap.put(TokenCategory.CTENUMINT, 99);
		terminaisMap.put(TokenCategory.CTENUMREAL, 99);
		terminaisMap.put(TokenCategory.CTEBOOL, 99);
		terminaisMap.put(TokenCategory.CTESERMO, 99);
		terminaisMap.put(TokenCategory.CTELIT, 99);
		terminaisMap.put(TokenCategory.ID, 100);
		predectiveTableMap.put(NonTerminalName.Fa, terminaisMap);
		terminaisMap = new HashMap<TokenCategory, Integer>();

		terminaisMap.put(TokenCategory.VETBEGIN, 101);
		terminaisMap.put(TokenCategory.OPARITMUL, 102);
		terminaisMap.put(TokenCategory.OPARITAD, 102);
		terminaisMap.put(TokenCategory.OPREL1, 102);
		terminaisMap.put(TokenCategory.OPREL2, 102);
		terminaisMap.put(TokenCategory.OPLOGAND, 102);
		terminaisMap.put(TokenCategory.OPLOGOR, 102);
		terminaisMap.put(TokenCategory.PARAMEND, 102);
		terminaisMap.put(TokenCategory.TERMCMD, 102);
		terminaisMap.put(TokenCategory.VETEND, 102);
		predectiveTableMap.put(NonTerminalName.Far, terminaisMap);
		

	}

}
