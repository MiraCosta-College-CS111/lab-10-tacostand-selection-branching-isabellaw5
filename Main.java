// PROGRAMMER NAME: Isabella Watson
// PARTNER NAME: None
// CS111 SECTION #: 1602
// DATE: 7/3/2025

public class Main
{
	public static final int minOrderOption = 1;
	public static final int maxOrderOption = 4;
	public static final int minNumTacos = 1;
	public static final int maxNumTacos = 50;
	public static final int startingFunds = 20;
	public static final double startingBudget = 15;
	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		//DECLARATION + INITIALIZATION SECTION
		TacoStand.initialize();

		//INPUT + CALCULATION + OUTPUT SECTION
		TacoStand.addTotalFunds(startingFunds);
		TacoStand.orderSupplies(startingBudget);

		System.out.println("OPENING UP THE STAND...");
		System.out.println( TacoStand.getStatus() +"\n\n");

		Main.printWelcome();
		System.out.println("\n");
		
		Main.takeOrder();
		//call takeOrder more times if you'd like! (once everything works once though!)

		System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
	}

	/**
	 * Outputs welcome message to start program that user sees
	 */
	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
		//ascii art credit:
		//https://mizbizbby.tumblr.com/post/12937794639/happy-taco-ascii-art-for-taco-thursday
	}
	
	/**
	 * Prints menu and prompts user for input for kind of taco and number in order. If tacos are available,
	 * will update total funds and confirm order with user, otherwise error message given
	 */
	public static void takeOrder() //TODO: upgrade per documentation
	{
		//DECLARATION + INITIALIZATION SECTION
		int option, numTacosOrdered;

		//INPUT SECTION
		TacoStand.printMenu();
		option = UtilityBelt.readInt("Enter choice> ", minOrderOption, maxOrderOption);
		numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", minNumTacos, maxNumTacos);

		//CHECK if we have the number of tacos available
		if (TacoStand.areTacosAvailable(option, numTacosOrdered) == true){
			TacoStand.updateTotalFunds(option, numTacosOrdered);
			Main.printConfirmation(numTacosOrdered);
		}
		else {
			System.out.println("We don't have that many tacos, sorry! Try again :(");
		}
		TacoStand.getStatus();

		//CALCULATION + OUTPUT SECTION

	}

	/**
	 * Prints confirmation message that varies based on number of tacos in order
	 * 
	 * @param numTacos
	 */
	public static void printConfirmation(int numTacos) //TODO: upgrade per documentation
	{
		String tacoSymbol = "🌮";
		System.out.println("Here you go, buen provecho!");

		//implemented a for loop to automate printing the tacos (i didnt use chat gpt i already knew about for loops from previous programming experience)
		for (int i = 0; i < numTacos; i++)
		{
			System.out.print(tacoSymbol);
		}
		System.out.println();
		System.out.println();
	}
}