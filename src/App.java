import java.util.*;

public class App {
	ArrayList<User> users;
	Scanner scan = new Scanner(System.in); // This may cause memory leak... too bad!
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	public App() {
		this.users = new ArrayList<User>();
		this.users.add(new User());
		this.users.add(new User("João", 15));
		this.users.add(new User("Pedro", 21));
		this.users.add(new User("Carlos", 43));
		this.users.add(new User("Cristina", 20));
	}

	public void run() {

		System.out.println("\n");
		System.out.println("1- Cadastrar cliente");
		System.out.println("2- Apagar cliente");
		System.out.println("3- Modificar cliente");
		System.out.println("4- Listar clientes");
		System.out.println("5- Sair");
		System.out.println(ANSI_YELLOW + "Digite uma opção:" + ANSI_RESET);
	
		String option = scan.nextLine();
		System.out.println("\n");

		switch (option) {
			case "1":
				createUser();
				run();
				break;
			case "2":
				deleteUser();
				run();
				break;
			case "3":
				modifyUser();
				run();
				break;
			case "4":
				listUsers();
				run();
				break;
			case "5":
				exit();
				break;
			default:
				System.out.println("Opção inválida");
				run();
				break;
		}
	}

	public void createUser() {
		System.out.println(ANSI_YELLOW + "Digite o nome do cliente:" + ANSI_RESET);
		String name = scan.nextLine();
		System.out.println(ANSI_YELLOW + "Digite a idade do cliente:" + ANSI_RESET);
		String ageNumber = scan.nextLine();
		int age = Integer.parseInt(ageNumber);
		User newUser = new User(name, age);
		this.users.add(newUser);
		System.out.println(newUser.toString());
	}

	public void deleteUser() {
		listUsers();

		System.out.println(ANSI_YELLOW + "Escolha um cliente para deletar: " + ANSI_RESET);
		String userIndex = scan.nextLine();

		System.out.println(
				ANSI_YELLOW +
				"Tem certeza que quer deletar o cliente " +
				userIndex +
				" ? (s/n)" +
				ANSI_RESET
		);

		String confirmation = scan.nextLine();
		switch(confirmation) {
			case "Sim":
			case "sim":
			case "S":
			case "s":
				users.remove(Integer.parseInt(userIndex));
				System.out.println("Usuário " + userIndex + " removido");
				break;
			case "Não":
			case "não":
			case "N":
			case "n":
				break;
			default:
				System.out.println("Opção inválida, retornando ao menu principal.");
				break;
		}
	}

	public void modifyUser() {
		UserModifier modifyUser = new UserModifier() {
			@Override
			public void changeName(int index) {
				System.out.println(ANSI_YELLOW + "Digite o novo nome:" + ANSI_RESET);
				String newName = scan.nextLine();
				users.get(index).setName(newName);
			}
			public void changeAge(int index) {
				System.out.println(ANSI_YELLOW + "Digite a nova idade:" + ANSI_RESET);
				String newAgeTyped = scan.nextLine();
				int newAge = Integer.parseInt(newAgeTyped);
				users.get(index).setAge(newAge);
			}
		};

		listUsers();
		System.out.println(ANSI_YELLOW + "Escolha um cliente para editar:" + ANSI_RESET);
		String costumerIndexTyped = scan.nextLine();
		int costumerIndex = Integer.parseInt(costumerIndexTyped);

		System.out.println("O que você deseja editar?");
		System.out.println("1- Nome");
		System.out.println("2- Idade");
		System.out.println("3- Nome e Idade");
		System.out.println("4- Cancelar");
		System.out.println(ANSI_YELLOW + "Digite uma opção:" + ANSI_RESET);
		String option = scan.nextLine();
		
		switch (option) {
			case "1":
				modifyUser.changeName(costumerIndex);
				break;
			case "2":
				modifyUser.changeAge(costumerIndex);
				break;
			case "3":
				modifyUser.changeName(costumerIndex);
				modifyUser.changeAge(costumerIndex);
				break;
			case "4":
				break;
		}

		System.out.println(users.get(costumerIndex).toString());
	}

	public void listUsers() {
		int index = 0;
		for (User user : users) {
			System.out.println((index++) + " - " + user.toString());
		}
	}

	public void exit() {
		System.out.println(ANSI_YELLOW + "tem certea que deseja sair? (s/n)" + ANSI_RESET);
		String confirmation = scan.nextLine();

		switch(confirmation) {
			case "não":
			case "Não":
			case "N":
			case "n":
				run();
				break;
			case "sim":
			case "Sim":
			case "s":
			case "S":
				break;
			default:
				System.out.println("Opção inválida.");
				exit();
				break;
		}
	}

	private interface UserModifier {
		public void changeName(int index);
		public void changeAge(int index);
	}
}
