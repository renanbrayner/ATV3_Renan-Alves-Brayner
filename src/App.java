import java.util.ArrayList;
import java.util.Scanner;

public class App {
	ArrayList<User> users;

	public App() {
		this.users = new ArrayList<User>();
		this.users.add(new User());
		this.users.add(new User("João", 15));
		this.users.add(new User("Pedro", 21));
		this.users.add(new User("Carlos", 43));
		this.users.add(new User("Cristina", 20));
	}

	public void run() {
		Scanner scan = new Scanner(System.in); // This may cause memory leak... too bad!

		System.out.println("*****Bem-vindo ao Sistema de cadastro de Clientes*****");
		System.out.println("1- Cadastrar cliente");
		System.out.println("2- Apagar cliente");
		System.out.println("3- Modificar cliente");
		System.out.println("4- Listar clientes");
		System.out.println("5- Sair");
		System.out.println("Digite uma opção:");

		String option = scan.nextLine();
		System.out.println(option);
	}
}
