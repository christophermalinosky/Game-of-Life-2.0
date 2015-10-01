package defaultpackage;

import java.util.Random;

public enum Gene {
	AABB("AABB"),
	AABb("AABb"),
	AAbb("AAbb"),
	AaBB("AaBB"),
	AaBb("AaBb"),
	Aabb("Aabb"),
	aaBB("aaBB"),
	aaBb("aaBb"),
	aabb("aabb");

	private String str;
	Gene(String str){
		this.str = str;
	}
	
	@Override
	public String toString(){
		return str;
	}
	
	public static Gene convertString(String str){
		switch(str){
		case "AABB": return AABB;
		case "AABb": return AABb;
		case "AAbb": return AAbb;
		case "AaBB": return AaBB;
		case "AaBb": return AaBb;
		case "Aabb": return Aabb;
		case "aaBB": return aaBB;
		case "aaBb": return aaBb;
		case "aabb": return aabb;
		default: return null;
		}
	}
	
	public static Gene combineGenes(Gene gene1, Gene gene2){
		Random randomGenerator = new Random();
		String newGeneStr = "";
		String gene1Str = gene1.toString();
		String gene2Str = gene2.toString();
		for (int i = 0; i < 4; i = i + 2) {
			int randomNum1 = randomGenerator.nextInt(2);
			int randomNum2 = randomGenerator.nextInt(2);
			if(Character.isLowerCase(gene1Str.charAt(i + randomNum1)) && Character.isUpperCase(gene2Str.charAt(i + randomNum2))){
				newGeneStr += Character.toString(gene2Str.charAt(i + randomNum2)) + Character.toString(gene1Str.charAt(i + randomNum1));
			} else {
				newGeneStr += Character.toString(gene1Str.charAt(i + randomNum1)) + Character.toString(gene2Str.charAt(i + randomNum2));
			}
		}
		return convertString(newGeneStr);
	}
}
