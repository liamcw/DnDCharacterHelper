import javax.swing.JOptionPane;

// User needs to be prompted to answer:
//Name of character > string JOption DONE
// Race > drop down DONE0
// class > drop down 
// Background/ extra info > string JOPtion

// roll 4 6-sided die and record the cumulative total of the highest 3 dice 6 times (6 Ability scores)
// die function, that rolls and generates a random number. 
// record cumulative total of highest 3
// array and while loops
// or take the “standard set” which is 15,14,13,12,10,8.
// alternatively, hard-coded values that spit out at the end

// JOption spits out a summary of what what chosen, the end.


//change message top

public class DnDCharacterSheetGenerator {

	public DnDCharacterSheetGenerator() {
		mainMenu();
	}

	public void mainMenu() {
		JOptionPane.showMessageDialog(null, "Welcome to Liam's Dungeon and \nDragon's Character Sheet Generator!\n");
		String menu = "Please choose a menu item.\n";
		menu += "1. Start character creation\n";
		menu += "2. Dice Roller";
		String tempInput = JOptionPane.showInputDialog(menu);
		while (tempInput != null) {
			int selection = Integer.parseInt(tempInput);
			if (selection == 1) {
				this.output();
			} else if (selection == 2) {
				this.rollDice();
			} else {
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}
			tempInput = JOptionPane.showInputDialog(menu);
		}
	}

	public String userNameChoice() {
		String name = JOptionPane.showInputDialog("You want to be called:");
		int confirm = JOptionPane.showConfirmDialog(null, "You want to be called `" + name + "` is that correct?",
				"Name", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			return name;
		} else {
			userNameChoice();
		}
		return name;
	}

	public String raceDropDown(String[] race) {
		String[] raceChoices = { "Human", "Dragonborn", "Elf", "Dwarf", "Gnome", "Halfling", "Orc", "Halfling",
				"Half-Orc", "Tiefling" };

		String input = (String) JOptionPane.showInputDialog(null, "Choose your race", "The Choice of a Lifetime",
				JOptionPane.QUESTION_MESSAGE, null, raceChoices, raceChoices[0]);

		int confirm = JOptionPane.showConfirmDialog(null, "You have chosen `" + input + "` is this correct?", "Race",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			return input;
		} else {
			raceDropDown(null);
		}
		return input;
	}

	public String classDropDown(String[] race) {
		String[] classChoices = { "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger",
				"Rogue", "Sorcerer", "Warlock", "Wizard" };

		String input = (String) JOptionPane.showInputDialog(null, "Choose your class", "The Choice of a Lifetime",
				JOptionPane.QUESTION_MESSAGE, null, classChoices, classChoices[0]);

		int confirm = JOptionPane.showConfirmDialog(null, "You have chosen " + input + " is this correct?", "Class",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			return input;
		} else
			classDropDown(null);
		return input;
	}

	public String extraInfo() {
		String extraInfo = JOptionPane.showInputDialog(
				"If you would like to enter any more information about your character, please enter it now.\nFor example, physical traits or personality.");
		return extraInfo;
	}

	public void output() {
		String charName = userNameChoice();
		String raceChoice = raceDropDown(null);
		String classChoice = classDropDown(null);
		String extraInfo = extraInfo();
		JOptionPane.showMessageDialog(null, "Your character\nName: " + charName + "\nRace: " + raceChoice
				+ "\nClass: " + classChoice + "\nAdditional information: " + extraInfo);
	}

	public void rollDice() {
		int numberOfRolls = Integer
				.parseInt(JOptionPane.showInputDialog("How many times will you like to roll the die?"));
		while (numberOfRolls < 0) {
			numberOfRolls = Integer.parseInt(JOptionPane.showInputDialog("Please enter a valid number."));
		}
		int sides = Integer.parseInt(JOptionPane.showInputDialog("How many sides does this die have?"));

		int i = 0;
		while (i < numberOfRolls) {
			i++;
			int roll = (int) (Math.random() * sides) + 1;
			JOptionPane.showMessageDialog(null, roll, "Your dice roll", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		DnDCharacterSheetGenerator obj = new DnDCharacterSheetGenerator();
		// TODO Auto-generated method stub
	}

}
