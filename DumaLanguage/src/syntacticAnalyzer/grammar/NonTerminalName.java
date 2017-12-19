package syntacticAnalyzer.grammar;

public enum NonTerminalName {

	
	PROGRAM(1), BEGIN(2), INITIUM(3), SCOPE(4), FUNCTIONS(5),
	RETURNTYPE(6), PARAMS(7), PARAMSFAT(8), LISTPARAMS(9),
	TYPE(10), NAME(11), LISTPARAMSFAT(12), CONSTANT(13),
	NAMEFAT(14), COMMANDS(15), CMD(16), DECLARATION(17),
	CMDFAT(18), WRITE(19), READ(20), IFELSE(21), WHILE(22),
	DOWHILE(23), FOR(24), RETURN(25), ATTRIBUTION(26), FUNCCALL(27),
	VALUE(28), ARRAY(29), Eb(30), ARRAYFAT(31), ELEMENTS(32),
	ELEMENTSFAT(33), LISTPARAMSCALL(34), LISTPARAMSCALLFAT(35),
	ITEMPARAM(36), MESSAGE(37), MESSAGEFAT(38), IF(39), ELSEIF(40),
	ELSE(41), RETURNFAT(42), Ebr(43), Tb(44), Tbr(45), Fb(46),
	Fbr(47), Erel1(48), Erel1r(49), Erel2(50), Erel2r(51),
	Ea(52) , Ear(53), Ta(54), Fa(55), Far(56);
	
	private int nonTerminalValue;

	private NonTerminalName(int value) {
		this.nonTerminalValue = value;
	}

	public int getNonTerminalValue() {
		return nonTerminalValue;
	}

}
