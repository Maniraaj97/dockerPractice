package testUtils;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("browser","firefox");
		Config.initialise();
		System.out.println(Config.get("selenium.grid.hubHost"));

	}

}
