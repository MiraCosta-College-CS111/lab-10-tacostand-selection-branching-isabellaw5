public class TacoStand
{
    /* CONSTANT VARIABLES */
	public static final String BAR = "----------------------------------------";
	//added constant for cost per taco:
	public static final double tacoCost = .75;

	//added constant for individual taco price:
	private static double asadaCost = 2.5, polloCost = 1.75, lenguaCost = 3.0, ultimateCost = 18.0;

	/* STATIC VARIABLES */
	private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
	private static double totalFunds = 0;

	/**
	 * Sets the store to zero for use in automated testing.
	 */
	public static void initialize()
	{
		numAsada = numPollo = numLengua = numUltimate = 0;
		totalFunds = 0.0D;
	}

	/**
	 * Outputs menu options (kinds of tacos) customer can use to order
	 */
	public static void printMenu()
	{
		System.out.println("Menu options:\n" + TacoStand.BAR);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", asadaCost);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)",polloCost);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", lenguaCost);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", ultimateCost);
		System.out.println(TacoStand.BAR);
	}
	
	/**
	* Returns a summary (all static variables) of the CURRENT status of the taco stand
	*
	* @return String containing current values related to taco stand, no new line at end
	*/
	public static String getStatus()
	{
		return String.format("%s%nMCC Taco Stand Status%n%s%n" +
			"%-23s$%-7.2f%n%s%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n%s",
			TacoStand.BAR, TacoStand.BAR, 
      "Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
      "# of Asada Left:", TacoStand.numAsada,
			"# of Pollo Left:", TacoStand.numPollo,
      "# of Lengua Left:", TacoStand.numLengua,
      "# of Ultimate Left:",TacoStand.numUltimate, TacoStand.BAR);
	}

	/**
	 * Increases totalFunds static variable
	 * 
	 * @param funds assumes >0 value added to total funds available for cart
	 */
	public static void addTotalFunds(int funds)
	{
		TacoStand.totalFunds += funds;
	}
	
	/**
	 * Checks if proposed budget to order supplies can be used to buy more supplies. If within total funds,
	 * will update total funds and increment number of each option of tacos based on budget. Otherwise,
	 * no variables are changed.
	 * 
	 * @param budget funds to use to order supplies
	 * 
	 * @return boolean representing if supplies could be ordered (within total funds)
	 */
	public static boolean orderSupplies(double budget)
	{
		//added boolean variable to assign return statement value
		boolean hasEnoughFunds = false;

		//added conditional statement to only update variables if we have the funds
		if (budget <= totalFunds){

		//tacos cost 75 cents each in supplies, keeping it simple
		int tacosEach = (int)(Math.round(budget / 0.75 / 4));

	    TacoStand.totalFunds -= budget;

	    TacoStand.numAsada += tacosEach;
	    TacoStand.numPollo += tacosEach;
	    TacoStand.numLengua += tacosEach;
	    TacoStand.numUltimate += tacosEach;

		hasEnoughFunds = true;  //TODO: this is stubbed, replace this line with your actual code!
		}

		return hasEnoughFunds;
	}

	/**
	 * Adds funds to total (static variable) based on kind of taco (different prices) and number of tacos
	 * in order. Will also update appropriate number of tacos left (static variables).
	 * 
	 * @param tacoOption menu option (kind of taco)
	 * @param numTacos number of tacos as part of order, assume > 0
	 */
	public static void updateTotalFunds(int tacoOption, int numTacos)
	{
		double tacoPrice;
		switch (tacoOption){
			case 1:
				TacoStand.numAsada -= numTacos;
				tacoPrice = numTacos * asadaCost;
				TacoStand.totalFunds += tacoPrice;
				break;
			case 2:
				TacoStand.numPollo -= numTacos;
				tacoPrice = numTacos * polloCost;
				TacoStand.totalFunds += tacoPrice;
				break;
			case 3:
				TacoStand.numLengua -= numTacos;
				tacoPrice = numTacos * lenguaCost;
				TacoStand.totalFunds += tacoPrice;
				break;
			case 4:
				TacoStand.numUltimate -= numTacos;
				tacoPrice = numTacos * ultimateCost;
				TacoStand.totalFunds += tacoPrice;
				break;
		}
	}
	
	
	/**
	 * Determines if taco order can be fullfilled (number of tacos for specific kinda are available)
	 * 
	 * @param tacoOption menu option (kind of taco)
	 * @param numTacos number of tacos as part of order
	 * 
	 * @return boolean representing if specific kind of tacos, for the number in order, are available
	 */
	public static boolean areTacosAvailable(int tacoOption, int numTacos)
	{
		boolean tacosAvailable = false; //TODO: this is stubbed, replace this line with your actual code!
		switch (tacoOption){
			case 1:
				if (TacoStand.numAsada >= numTacos)
				{
					tacosAvailable = true;
				}
				break;
			case 2:
				if (TacoStand.numPollo >= numTacos)
				{
					tacosAvailable = true;
				}
				break;
			case 3:
				if (TacoStand.numLengua >= numTacos)
				{
					tacosAvailable = true;
				}
				break;
			case 4:
				if (TacoStand.numUltimate >= numTacos)
				{
					tacosAvailable = true;
				}
				break;
		}
		return tacosAvailable;
	}
}