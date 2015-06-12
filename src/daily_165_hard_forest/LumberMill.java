package daily_165_hard_forest;

public class LumberMill {
	//this class manages the Lumberjacks
	private int wood;
	private int mawIncidents;
	private Forest forest;
	private final int LUMBERJACK_COST = 9;
	public LumberMill(Forest forest) {
		this.wood = 0;
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
		//hiring lumberjacks
		if (wood > 9) {
			int numberToHire =  (int) wood / LUMBERJACK_COST; 
			System.out.println("hired " + numberToHire + " lumberjacks");
			for (int i=0; i<numberToHire;i++) {
				forest.addLumberjack();
				wood -= LUMBERJACK_COST;
			}
		}
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
