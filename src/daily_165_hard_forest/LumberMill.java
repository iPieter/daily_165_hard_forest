package daily_165_hard_forest;

public class LumberMill {
	//this class manages the Lumberjacks
	private int wood;
	private int mawIncidents;
	private Forest forest;
	private Economy economy;
	private double money;
	
	public LumberMill(Forest forest, Economy economy) {
		this.wood = 0;
		this.money = 1000;
		
		this.economy = economy;
		
		this.mawIncidents = 0;
		this.forest = forest;
	}
	
	public void addWood(int wood) {
		this.wood += wood;
	}
	
	public void reportMaw() {
		this.mawIncidents++;
	}
	
	public void tick() {
		//sell the wood
		int woodcount = 0;
		double moneycount = 0;
		while(this.wood > 0) {
			moneycount += economy.sellWood();
			woodcount++;
			this.wood--;
			
		}
		this.money += moneycount;
		System.out.println(forest.getYear());
		System.out.println("Sold " + woodcount + " for " + moneycount + " coins.");
		
		//hire lumberjacks
		int lumberjackcount = 0;
		while(this.money > 1000.0) {
			forest.addLumberjack();
			this.money -= economy.buyLumberjack();
			lumberjackcount++;
		}
		System.out.println("Hired " + lumberjackcount + " lumberjacks.");
		
		//need for a bear-hunt?
		if (mawIncidents != 0) {
			forest.removeBear();
			System.out.println("Removed a bear");
		} else {
			forest.addBear();
		}
		
		mawIncidents = 0;
		
	}
}
