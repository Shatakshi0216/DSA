import java.util.* ;
import java.io.*; 
/*

    --------------------------- Car class for reference ---------------------------

	class Car {
    	public int priceOfCar;
	    public int maintenanceCostPerMonth;
	    public int numberOfkilometerCarRunInOneLiter;
	    public int pricePerLiter;
	    public int numberOfKilometerCarRunInaMonth;

	    Car(int priceOfCar, int maintenanceCostPerMonth, int numberOfkilometerCarRunInOneLiter,
	        int pricePerLiter, int numberOfKilometerCarRunInaMonth) {

	        this.priceOfCar = priceOfCar;
	        this.maintenanceCostPerMonth = maintenanceCostPerMonth;
	        this.numberOfkilometerCarRunInOneLiter = numberOfkilometerCarRunInOneLiter;
	        this.numberOfKilometerCarRunInaMonth = numberOfKilometerCarRunInaMonth;
	        this.pricePerLiter = pricePerLiter;

	    }
	};
*/

public class Solution {
	public static int mostCostEfficientCar(Car petrolCar, Car dieselCar) {
  		// Write your code here.
		long petrolCost = petrolCar.priceOfCar+(long)petrolCar.maintenanceCostPerMonth*6+(long)petrolCar.pricePerLiter*petrolCar.numberOfKilometerCarRunInaMonth*6/petrolCar.numberOfkilometerCarRunInOneLiter;

		long dieselCost = dieselCar.priceOfCar+(long)dieselCar.maintenanceCostPerMonth*6+(long)dieselCar.pricePerLiter*dieselCar.numberOfKilometerCarRunInaMonth*6/dieselCar.numberOfkilometerCarRunInOneLiter;

		if(petrolCost<dieselCost) return 0;
		else if(petrolCost>dieselCost) return 1;
		else return -1;
	}
}
