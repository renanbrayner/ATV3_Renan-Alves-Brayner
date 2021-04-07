public class User {
	public String name;
	public int age;
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_RESET = "\u001B[0m";

	public User() {
		this.name = "Maria";
		this.age = 18;
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ANSI_CYAN + "Cliente: " + this.name + ANSI_RESET+ " - " + ANSI_GREEN + "Idade: " + this.age + ANSI_RESET;
	}
}
