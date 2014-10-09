/**
 * Class used to do the markup calculation given the base price, number of workers, and the material.
 * 
 * @author Dweep
 */
public class MarkupCalculator {
	/**
	 * Adds the flat markup for the job to the base price
	 * 
	 * @param basePrice the base price given by the user
	 * @return the flat markup plus the base price
	 */
	private static double flatMarkup(double basePrice) {
		// Add a flat markup of 5% to the base price and return the total
		return basePrice * 1.05;
	}
	
	/**
	 * Calculates the markup on the job due to the number of workers required to accomplish the job.
	 * 
	 * @param workers the number of workers value given by the user
	 * @param basePlusFlatMarkup the base price plus the flat markup value calculated
	 * @return the amount of markup that needs to be added due to the number of workers for the job
	 */
	private static double workersMarkup(int workers, double basePlusFlatMarkup) {
		// Calculate the percetage markup needed (1.2% for each worker)
		double markupPercentage = workers * 1.2;
		
		// Calculate the markup value for the based on the markup percentage calculated on the previous 
		// step and the given base price.
		return (markupPercentage/100) * basePlusFlatMarkup;
	}
	
	/**
	 * Calculates the markup on the job due to the material required to involved in the job.
	 * 
	 * @param material the material value given by the user
	 * @param basePlusFlatMarkup the base price plus the flat markup value calculated
	 * @return the amount of markup that needs to be added depending on the types of materials involved for the job.
	 */
	private static double materialMarkup(String material, double basePlusFlatMarkup) {
		// Check if the pharmaceutical materials are involved and add a markup of 7.5%
		if(material.equals("drugs") || material.equals("drug") || material.equals("pharmaceuticals")){
			return basePlusFlatMarkup*0.075;
		} 
		// Check if food materials are involved and add a markup of 13%
		else if(material.equals("food")){
			return basePlusFlatMarkup*0.13;
		} 
		// Check if electronics are involved and add a markup of 2%
		else if(material.equals("electronics") || material.equals("electronic")){
			return basePlusFlatMarkup*0.02;
		}
		// For any other materials there is no markup
		return 0;
	}
	
	/**
	 * Calculates the total estimated price for the job based on the base price, number of workers, and materials.
	 *
	 * @param basePrice the base price given by the user
	 * @param workers the number of workers value given by the user
	 * @param material the material value given by the user
	 * @return
	 */
	public static double calculate(double basePrice, int workers, String material) {
		// Calculate the flat markup using the base price given
		double basePlusFlatMarkup = flatMarkup(basePrice);
		// Calculate the worker markup using the base price and number of workers value given
		double workersMarkup = workersMarkup(workers, basePlusFlatMarkup);
		// Calculate the material markup using the base price and the material value given.
		double materialMarkup = materialMarkup(material, basePlusFlatMarkup);
		
		// Add the base price, flat markup, worker markup, and material markup to calculate the total value.
		return basePlusFlatMarkup + workersMarkup + materialMarkup;
	}
}
