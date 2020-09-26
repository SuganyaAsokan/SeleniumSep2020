package week3.day1;

public class AxisBank extends BankInfo {

	public void deposit() {
		
		System.out.println("Amount deposited in Axis bank");

	}
	
	public static void main(String[] args) {
		
		AxisBank axis = new AxisBank();
		
		axis.deposit();
		axis.saving();
		axis.fixed();

	}

}
