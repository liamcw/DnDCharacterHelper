import javax.swing.JOptionPane;

// User needs to be prompted to answer:
//Name of character > string JOption 
// Race > drop down 
// class > drop down 
// Background/ extra info > string JOPtion

// die function, that rolls and generates a random number. 
// array and while loops
// alternatively, hard-coded values that spit out at the end
// Option spits out a summary of what what chosen, the end.

// The above are the original notes I made to structure the app before beginning. It makes it much 
// easier to understand the structure and what to work on next.

// I believe this app has the opportunity to grow with further additions and I plan to turn it into a personal 
// project at a later date.


public class DnDCharacterSheetGenerator {
// this method kick starts the whole app, as we had seen in previous weeks
	public DnDCharacterSheetGenerator() {
		mainMenu();
	}

	// this method shows the menu - very similarly to the RenovationProjectManager,
	// I think this is the best
	// option for my app as I have two functions to choose from.
	public void mainMenu() {
		JOptionPane.showMessageDialog(null, "Welcome to Liam's Dungeon and \nDragon's Character Sheet Generator!\n");
		String menu = "Please choose a menu item.\n";
		menu += "1. Start character creation\n";
		menu += "2. Dice Roller";
		String tempInput = JOptionPane.showInputDialog(menu);
		// while loop that validates and loops back after the options have been run
		// through.
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

	// the first user input required for the first option "Start character
	// creation". I initially wanted two sub options
	// the other would have been a drop down containing names but i feel the whole
	// effort of character personalisation
	// wouldn't work as well if you couldn't type in your own name.

	public String userNameChoice() {
		String name = JOptionPane.showInputDialog("You want to be called:");
		int confirm = JOptionPane.showConfirmDialog(null, "You want to be called `" + name + "` is that correct?",
				"Name", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			return name;
		} else {// I initially had a whole block of code here (and in all methods below) in
				// nested else if statements
				// validating the selection, and writing out most of the code needed in the
				// first confirmation statement. I then realised I didn't need ANY of that, just
				// needed to run the method again if anything other than yes was selected.
			userNameChoice();
		}
		return name;
	}

	// the second and third user inputs look largely the same, just with different
	// options. I justified this to be a drop down with preset values as these
	// races and classes are more or less written in stone
	// as opposed to the infinite combinations
	// of a character name.
	// The same validation and returning is done here.

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

	// largely the same code, just a different set of options. Still hard-coded
	// values as these roles don't tend to change too much in the base game.

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

	// I wanted to include a little bit of user input 'flavour' by allowing them
	// to add any additional information they see fit

	public String extraInfo() {
		String extraInfo = JOptionPane.showInputDialog(
				"If you would like to enter any more information about your character, please enter it now.\nFor example, physical traits or personality.");
		return extraInfo;
	}

	// this then spits out all the returned data in a list-like format. It is easy
	// to read and to copy down and use for whatever the user desires. I chose to
	// output them all at the same time instead of drip feeding information to the
	// user as I believe this is a more logical and easily interpreted approach to
	// this problem.

	public void output() {
		String charName = userNameChoice();
		String raceChoice = raceDropDown(null);
		String classChoice = classDropDown(null);
		String extraInfo = extraInfo();
		JOptionPane.showMessageDialog(null, "Your character\nName: " + charName + "\nRace: " + raceChoice + "\nClass: "
				+ classChoice + "\nAdditional information: " + extraInfo);
	}

	// the rollDice method is included as in DnD character creation, there is a lot
	// of dice rolling. However, it's not just a standard 6 sided die in most
	// occasions. For this reason, I allow the user to input the number of sides
	// the die has. This determines the range of numbers available.
	// Along with number of sides, number of rolls is also determined through user
	// input.

	public void rollDice() {
		int numberOfRolls = Integer
				.parseInt(JOptionPane.showInputDialog("How many times will you like to roll the die?"));
		while (numberOfRolls < 0) {
			numberOfRolls = Integer.parseInt(JOptionPane.showInputDialog("Please enter a valid number."));
		}
		int sides = Integer.parseInt(JOptionPane.showInputDialog("How many sides does this die have?"));

		int i = 0;
		while (i < numberOfRolls) { // while loop that just runs through the random function of 'rolling'
									// a die until the amount of user input 'rolls'
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
