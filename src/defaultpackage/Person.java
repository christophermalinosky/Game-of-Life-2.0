package defaultpackage;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Creates a person object with all their attributes.
 * 
 * @author malinocr
 *
 */
public class Person {
	private final int NUMBER_OF_ATTRIBUTES = 10;
	private final int FACE_RADIUS = 20;

	private String name;
	private Gene hairGene;
	private Color hairColor;
	private Gene eyeGene;
	private Color eyeColor;
	private int age;
	private String sex;
	private boolean[] attributeList;
	private int posX;
	private int posY;
	private Face face;
	private Random randomGenerator = new Random();

	public Person() {
		setRandomSex();
		setRandomName();
		setRandomHairGene();
		setRandomEyeGene();
		setRandomAge();
		setRandomAttributeList();
		setRandomPosX();
		setRandomPosY();
		setFace();
	}

	public Person(String name, Gene hairGene, Gene eyeGene, int age, int posX,
			int posY) {
		this.name = name;
		this.hairGene = hairGene;
		setHairColor();
		this.eyeGene = eyeGene;
		setEyeColor();
		this.age = age;
		setRandomSex();
		setRandomAttributeList();
		this.posX = posX;
		this.posY = posY;
		setFace();
	}
	
	public Person(Gene hairGene, Gene eyeGene, int age, int posX,
			int posY) {
		this.hairGene = hairGene;
		setHairColor();
		this.eyeGene = eyeGene;
		setEyeColor();
		this.age = age;
		setRandomSex();
		setRandomName();
		setRandomAttributeList();
		this.posX = posX;
		this.posY = posY;
		setFace();
	}

	public void printFeatures() {
		StringBuilder message = new StringBuilder();
		message.append("Name: " + this.name + '\n');
		message.append("Hair Gene: " + this.hairGene.toString() + '\n');
		message.append("Hair Color: " + this.hairColor + '\n');
		message.append("Eye Gene: " + this.eyeGene.toString() + '\n');
		message.append("Eye Color: " + this.eyeColor + '\n');
		message.append("Age: " + this.age + '\n');
		message.append("Sex: " + this.sex + '\n');
		message.append("Attributes: ");
		for (int i = 0; i < this.NUMBER_OF_ATTRIBUTES; i++) {
			if (i != this.NUMBER_OF_ATTRIBUTES - 1) {
				message.append(this.attributeList[i] + ", ");
			} else {
				message.append(this.attributeList[i]);
				message.append('\n');
			}
		}
		message.append("Position X: " + this.posX + '\n');
		message.append("Position Y: " + this.posY);
		JOptionPane.showMessageDialog(null, message, name + "'s Statistics",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Face getFace() {
		return this.face;
	}

	public void setFace() {
		if (this.age == 0) {
			this.face = new Face(posX * FACE_RADIUS * 2 + FACE_RADIUS, posY
					* FACE_RADIUS * 2 + FACE_RADIUS, FACE_RADIUS, 0,
					Color.black, Color.black, Color.black, Color.black);
		} else if (this.sex.equals("Male")) {
			this.face = new Face(posX * FACE_RADIUS * 2 + FACE_RADIUS, posY
					* FACE_RADIUS * 2 + FACE_RADIUS, FACE_RADIUS, 0, new Color(
					255, 220, 178), this.hairColor, this.eyeColor, Color.blue);
		} else {
			this.face = new Face(posX * FACE_RADIUS * 2 + FACE_RADIUS, posY
					* FACE_RADIUS * 2 + FACE_RADIUS, FACE_RADIUS, 0, new Color(
					255, 220, 178), this.hairColor, this.eyeColor, Color.pink);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gene getHairGene() {
		return hairGene;
	}

	public Color getHairColor() {
		return hairColor;
	}

	public Gene getEyeGene() {
		return eyeGene;
	}

	public Color getEyeColor() {
		return eyeColor;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public boolean[] getAttributeList() {
		return attributeList;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setHairGene(Gene hairGene) {
		this.hairGene = hairGene;
		setHairColor();
		setFace();
	}

	public void setEyeGene(Gene eyeGene) {
		this.eyeGene = eyeGene;
		setEyeColor();
		setFace();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAttributeList(boolean[] attributeList) {
		this.attributeList = attributeList;
	}

	public void setPosX(int posX) {
		this.posX = posX;
		setFace();
	}

	public void setPosY(int posY) {
		this.posY = posY;
		setFace();
	}

	public void setRandomName(){
		try{
			String path = "";
			if(this.sex == "Male"){
				path = "C:/Users/malinocr/Documents/CSSE Fun/Male Baby Names.txt";
			} else {
				path = "C:/Users/malinocr/Documents/CSSE Fun/Female Baby Names.txt";
			}
			
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			
			String line = "";
			int numLines = 0;
			
			while(line != null){
				line = textReader.readLine();
				if(line != null){
					numLines++;
				}
			}
			textReader.close( );
			
			FileReader fr2 = new FileReader(path);
			BufferedReader textReader2 = new BufferedReader(fr2);
			String[ ] textData = new String[numLines];

			for (int i=0; i < numLines; i++) {
				textData[i] = textReader2.readLine();
			}
			textReader2.close( );
			int randomNumber = randomGenerator.nextInt(numLines);
			this.name = textData[randomNumber];
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void setRandomHairGene() {
		int randomNumber = randomGenerator.nextInt(16);
		switch (randomNumber) {
		case 0:
			this.hairGene = Gene.AABB;
			break;
		case 1:
		case 2:
			this.hairGene = Gene.AABb;
			break;
		case 3:
			this.hairGene = Gene.AAbb;
			break;
		case 4:
		case 5:
			this.hairGene = Gene.AaBB;
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			this.hairGene = Gene.AaBb;
			break;
		case 10:
		case 11:
			this.hairGene = Gene.Aabb;
			break;
		case 12:
			this.hairGene = Gene.aaBB;
			break;
		case 13:
		case 14:
			this.hairGene = Gene.aaBb;
			break;
		case 15:
			this.hairGene = Gene.aabb;
			break;
		default:
			this.hairGene = null;
			break;
		}
		setHairColor();
	}

	public void setHairColor() {
		switch (this.hairGene) {
		case AABB:
		case AABb:
		case AaBB:
		case AaBb:
			this.hairColor = new Color(139, 69, 19);
			break;
		case AAbb:
		case Aabb:
			this.hairColor = new Color(210, 105, 30);
			break;
		case aaBB:
		case aaBb:
			this.hairColor = Color.yellow;
			break;
		case aabb:
			this.hairColor = Color.red;
			break;
		default:
			this.hairColor = null;
			break;
		}
	}

	public void setRandomEyeGene() {
		int randomNumber = randomGenerator.nextInt(16);
		switch (randomNumber) {
		case 0:
			this.eyeGene = Gene.AABB;
			break;
		case 1:
		case 2:
			this.eyeGene = Gene.AABb;
			break;
		case 3:
			this.eyeGene = Gene.AAbb;
			break;
		case 4:
		case 5:
			this.eyeGene = Gene.AaBB;
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			this.eyeGene = Gene.AaBb;
			break;
		case 10:
		case 11:
			this.eyeGene = Gene.Aabb;
			break;
		case 12:
			this.eyeGene = Gene.aaBB;
			break;
		case 13:
		case 14:
			this.eyeGene = Gene.aaBb;
			break;
		case 15:
			this.eyeGene = Gene.aabb;
			break;
		default:
			this.eyeGene = null;
			break;
		}
		setEyeColor();
	}

	public void setEyeColor() {
		switch (this.eyeGene) {
		case AABB:
		case AABb:
		case AaBB:
		case AaBb:
		case AAbb:
		case Aabb:
			this.eyeColor = new Color(139, 69, 19);
			break;
		case aaBB:
		case aaBb:
			this.eyeColor = Color.green;
			break;
		case aabb:
			this.eyeColor = Color.blue;
			break;
		default:
			this.eyeColor = null;
			break;
		}
	}

	public void setRandomAge() {
		int randomNumber = randomGenerator.nextInt(12) + 18;
		this.age = randomNumber;
	}

	public void setRandomSex() {
		int randomNumber = randomGenerator.nextInt(2);
		if (randomNumber == 1) {
			this.sex = "Male";
		} else {
			this.sex = "Female";
		}
	}

	public void setRandomAttributeList() {
		boolean[] newAttributeList = new boolean[this.NUMBER_OF_ATTRIBUTES];
		for (int i = 0; i < this.NUMBER_OF_ATTRIBUTES; i++) {
			int randomNumber = randomGenerator.nextInt(2);
			if (randomNumber == 1) {
				newAttributeList[i] = true;
			} else {
				newAttributeList[i] = false;
			}
		}
		this.attributeList = newAttributeList;
	}

	public void setRandomPosX() {
		int randomNumber = randomGenerator.nextInt(29);
		this.posX = randomNumber;
	}

	public void setRandomPosY() {
		int randomNumber = randomGenerator.nextInt(18);
		this.posY = randomNumber;
	}

	public void move() {
		if (this.age < 10) {
			int randomNumber = randomGenerator.nextInt(11) - 5;
			this.posX += randomNumber;
			randomNumber = randomGenerator.nextInt(11) - 5;
			this.posY += randomNumber;
		} else if (this.age < 25) {
			int randomNumber = randomGenerator.nextInt(7) - 3;
			this.posX += randomNumber;
			randomNumber = randomGenerator.nextInt(7) - 3;
			this.posY += randomNumber;
		} else if (this.age < 80) {
			int randomNumber = randomGenerator.nextInt(3) - 1;
			this.posX += randomNumber;
			randomNumber = randomGenerator.nextInt(3) - 1;
			this.posY += randomNumber;
		}
		if (this.posX >= 28) {
			this.posX = 28;
		}
		if (this.posY >= 17) {
			this.posY = 17;
		}
		if (this.posX <= 0) {
			this.posX = 0;
		}
		if (this.posY <= 0) {
			this.posY = 0;
		}
		setFace();
	}
}
