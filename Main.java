import java.util.Scanner;

public class Main
{
	public static final String[] STATEMENTS = {
		"English is my native language.",
		"My parents graduated college.",
		"I have never wondered where my next meal will come from.",
		"I have no disabilities.",
		"My work and school holidays coincide with the religious holidays I celebrate.",
		"I studied the culture and history of my ancestors in elementary school.",
		"I have never been bullied or been made fun of based on something I could not change (ie. race, ethnicity, sexual orientation, disabilities.)",
		"I have never been stopped by law enforcement due to mere suspicion as opposed to legitimate wrongdoing.",
		"I or my parents have inherited money or property.",
		"I am a US citizen.",
		"I feel safe going for a walk alone.",
		"I go by the same name I was given at birth.",
		"I am comfortable presenting my ID because it properly identifies me.",
		"My ancestors were not forced to come to the United States against their will to be enslaved.",
		"I have family or friends that can give me employment if I need it.",
		"I have never been told my natural hair looks dirty or unprofessional.",
		"I have gone to private school.",
		"I can easily find souvenirs with my name on them."
	};
	public static final int PTS_PER_ANSWER = 10, TOTAL_PTS_POSSIBLE = PTS_PER_ANSWER * STATEMENTS.length,
		MAX = Person.DEFAULT_PRIVILEGE + TOTAL_PTS_POSSIBLE,
		MIN = Person.DEFAULT_PRIVILEGE - TOTAL_PTS_POSSIBLE,
		LEFT_WIDTH = Math.abs(MIN)/PTS_PER_ANSWER,
		RIGHT_WIDTH = MAX/PTS_PER_ANSWER,
		NAME_WIDTH = 20;

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		// DECLARATION + INITIALIZATION
		Person p1 = new Person("Amira", "I am a Syrian refugee.", "She/Her", 40);
		Person p2 = new Person("D'Andra", "I am an African-American trans woman.", "She/Her", -20);
		Person p3 = new Person("Jennifer", "I am a New Yorker", "She/Her", 140);
		Person p4 = new Person("Pete", "I am a guy from Pennsylvania", "He/Him", 200);
		Person self = new Person();
		Person[] people = {p1, p2, p3, p4, self};
		boolean done = false;
		int input;
		
		// WELCOME + INTRO
		System.out.println("Welcome to the Privilege Calculator.\n\n"
				+ "This is a small exercise that gives us a glimpse at how "
				+ "fortunate we have been in life.\n");

		Main.fillInfo(self);
		
		// INPUT + CALCULATION + OUTPUT
		do{
			System.out.println("\n~~~Main Menu~~~\n");
			System.out.println("1. Take questionnaire to calculate privilege estimate.");
			System.out.println("2. Check my estimate. (Defaults to " + Person.DEFAULT_PRIVILEGE + " if questionnaire has not been taken.)");
			System.out.println("3. Compare my estimate with others'.");
			System.out.println("4. Exit program.");
			System.out.print("What would you like to do?\nEnter choice: ");
			
			input = keyboard.nextInt();
			System.out.println();

			switch(input)
			{
				case 1:
					self.setPrivilege( Main.doPrivilegeQuestionnaire() );
					System.out.println("Your privilege estimate is: " + self.getPrivilege());
					System.out.println("\nReturning to main menu...\n");
					break;
				case 2:
					System.out.println(self);
					break;
				case 3:
					/***** TODO: (Part 1) implement a comparison case using the comparable method on the Person class to compare self to p1-p4*****/
					for (Person p : people) {
						if (p != self) {
							System.out.println(self.getName() + " compared to " + p.getName() + ": " + self.compareTo(p));
						}
					}
					break;
				case 4:
					System.out.println("Exiting Program...\n");
					keyboard.close(); //housekeeping
					done = true;
					break;
				default:
					System.out.println("Invalid input, please enter a valid choice."
							+ "\nReturning to main menu...\n");
					break;				
			}
		}while(!done);

		System.out.println("Thank you for exploring your privilege, it can be uncomfortable but it's a crucial step" +
			"in our own growth and self-reflection. We appreciate you taking that journey with us! :D");
	}

	/***** TODO: (Part 2) upgrade method to ask user for pronouns and background info *****/
	public static void fillInfo(Person person){
		//sets default privilege prior to questionnaire to 100
		String name, story, pronouns;
		
		System.out.println("What is your name? ");
		name = keyboard.nextLine(); // consume newline
		
		System.out.println("\nWhat are your preferred pronouns? (ex: he/him, she/her, they/them)");
		pronouns = keyboard.nextLine();
		
		System.out.println("Tell us about yourself: ");
		story = keyboard.nextLine();

		person.setName(name);
		person.setIdentity(pronouns, story);
				
	}

	public static int doPrivilegeQuestionnaire() {
		int privilegeEstimate = Person.DEFAULT_PRIVILEGE;
		int choice;

		for (String statement : STATEMENTS) {
			System.out.println(statement);
			System.out.print("1. True \n2. False\nEnter choice: ");
			choice = keyboard.nextInt();
			privilegeEstimate += (choice == 1) ? PTS_PER_ANSWER : -PTS_PER_ANSWER;
		}
		return privilegeEstimate;
	}

}
