public class Person implements Comparable<Person>
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/
	//inner class
	public class Identity {
		private String background;
		private String pronouns;

		// Constructor for Identity class
		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;

		}

		public Identity() {
			this("The/Them", "Unknown");
		}

		//getters
		public String getPronouns() {
			return pronouns;
		}

		public String getBackground() {
			return background;
		}

		//setters
		public void setPronouns(String pronouns) {
			this.pronouns = pronouns;
		}

		public void setBackground(String background) {
			this.background = background;
		}

		@Override
		public String toString() {
			return "Pronouns: " + "\nBackground: " + background;
		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_STORY =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private int privilege;
	private Identity identity; // Change story to use Identity class

	// CONSTRUCTORS	
	public Person(String name, String background, String pronouns, int privilege) {
		this.name = name;
		this.privilege = privilege;
		this.identity = new Identity(pronouns, background);
	}
	
	// default constructor initializes with generic values
	public Person() {
		this(DEFAULT_NAME, "Unknown", "They/Them", DEFAULT_PRIVILEGE);
	}
	
	// copy constructor to ensure deep copy of Identity
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.name = original.name;
			this.privilege = original.privilege;
			this.identity = new Identity(original.identity.getPronouns(), original.identity.getBackground());
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setIdentity(String pronouns, String background) {
		this.identity.setPronouns(pronouns);
		this.identity. setBackground(background);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is " + this.name + " and here is some info about me:\n" + this.identity + "\n" + "According to this calculator, I ended up with " + this.privilege + " estimated privilege points.";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.identity.getBackground().equals(otherPerson.identity.getBackground()) && this.identity.getPronouns().equals(otherPerson.identity.getPronouns()) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/
	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.privilege, other.privilege);

		
		
	}
}
