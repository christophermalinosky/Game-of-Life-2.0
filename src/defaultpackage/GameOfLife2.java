package defaultpackage;

import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GameOfLife2 extends JComponent {
	private static ArrayList<Person> people = new ArrayList<Person>();

	public void stuff() {
		for (int i = 0; i < 50; i++) {
			Person adam = new Person();
			Person eve = new Person();
			people.add(adam);
			people.add(eve);
		}
	}

	public static Person getChild(Person mom, Person dad) {
		Gene hairGene = Gene.combineGenes(mom.getHairGene(), dad.getHairGene());
		Gene eyeGene = Gene.combineGenes(mom.getEyeGene(), dad.getEyeGene());
		return new Person(hairGene, eyeGene, 0, mom.getPosX(),
				mom.getPosY() + 1);
	}

	public static boolean areCompatable(Person a, Person b) {
		if (a.getSex().equals(b.getSex())) {
			return false;
		}

		if (a.getSex().equals("Male") && (a.getAge() < 12)) {
			return false;
		} else if (a.getSex().equals("Female")
				&& ((a.getAge() < 13) || (a.getAge() > 50))) {
			return false;
		}
		if (b.getSex().equals("Male") && (a.getAge() < 12)) {
			return false;
		} else if (b.getSex().equals("Female")
				&& ((a.getAge() < 13) || (a.getAge() > 50))) {
			return false;
		}

		if (Math.abs(a.getAge() - b.getAge()) > 10) {
			return false;
		}

		int numSimilarTraits = 0;
		for (int i = 0; i < a.getAttributeList().length; i++) {
			if (a.getAttributeList()[i] == b.getAttributeList()[i]) {
				numSimilarTraits++;
			}
		}
		if (numSimilarTraits < 6) {
			return false;
		}

		return true;
	}

	public void tick() {
		for (int i = 0; i < people.size(); i++) {
			Person mainPerson = people.get(i);
			int lastX = mainPerson.getPosX();
			int lastY = mainPerson.getPosY();
			mainPerson.move();
			for (int j = 0; j < people.size(); j++) {
				if (i != j) {
					Person otherPerson = people.get(j);
					if ((mainPerson.getPosX() == otherPerson.getPosX())
							&& (mainPerson.getPosY() == otherPerson.getPosY())) {
						mainPerson.setPosX(lastX);
						mainPerson.setPosY(lastY);
						if (areCompatable(mainPerson, otherPerson)) {
							Person baby = getChild(mainPerson, otherPerson);
							people.add(baby);
						}
					}
				}
			}
			mainPerson.setAge(mainPerson.getAge() + 1);
			if (mainPerson.getAge() > 100) {
				people.remove(i);
			}
		}
		for (int i = 0; i < people.size(); i++) {
			if ((people.get(i).getPosX() < 0) || (people.get(i).getPosX() > 28)
					|| (people.get(i).getPosY() < 0)
					|| (people.get(i).getPosY() > 17)) {
				people.remove(i);
			}
		}
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
}
