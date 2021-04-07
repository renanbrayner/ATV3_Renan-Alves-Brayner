public class User {
	public String name;
	public int age;

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
		return "Cliente: " + this.name + " - Idade: " + this.age;
	}
}
