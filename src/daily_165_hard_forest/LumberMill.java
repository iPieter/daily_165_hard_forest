package daily_165_hard_forest;

public class LumberMill {
	//this class manages the Lumberjacks
	private int wood;
	private int[] mawIncidents;
	private Forest forest;
	
	public LumberMill(Forest forest) {
		this.wood = 0;
		this.mawIncidents = new int[400];
		this.forest = forest;
	}
	
	public void addWood(int wood) {
		this.wood += wood;
	}
	
	public void reportMaw() {
		this.mawIncidents[forest.getYear()]++;
	}
	
	public void tick() {
		//hiring lumberjacks
		
		//need for a bear-hunt?
	}
}
