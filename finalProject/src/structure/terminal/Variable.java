package structure.terminal;

import structure.SimpleNodeA;

public class Variable extends Terminal{
	private String name;
	private String typeDef;
	
	public Variable(String name,float[] range,String typeDef) {
		super(range);
		this.name = name;
		this.typeDef = typeDef;
	}	

	public Variable(String name,float[] range) {
		super(range);
		this.name = name;
	}

	public Variable(float[] range){
		super(range);
		this.name = "Noname";
	}

	@Override
	public boolean equal(SimpleNodeA term){
		boolean retour = super.equals(term);
		if (this.type() != term.type()) {
			retour=false;
		}else{
			if(this.name != ((Variable)term).name){
				retour=false;
			}
		}
		
		return retour;
	}
	// Getters and Setters
	public String getTypeDef() {
		return typeDef;
	}

	public void setTypeDef(String typeDef) {
		this.typeDef = typeDef;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// Inherit function
	@Override
	public String type() {
		return "Variable";
	}
	@Override
	public String toString() {
		return this.name;
	}
	@Override
	public SimpleNodeA clone() {
		return new Variable(this.getName(),this.getRange());
	}
}
