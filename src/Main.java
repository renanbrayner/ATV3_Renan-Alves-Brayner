public class Main{
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		System.out.println(ANSI_BLUE + "*****Bem-vindo ao Sistema de cadastro de Clientes*****" + ANSI_RESET);
		App app = new App();
		app.run();
	}
}
