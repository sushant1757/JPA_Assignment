public class Account {
	
	private static long accNo;
	protected double balance;
	protected Person person;
	//static int accNo;
	
	public Account(double balance, Person person) {
			this.person = person;
			this.balance = balance;
			accNo++;
	}
	
	public void deposit(double deposit)
	{
		balance += deposit;
		System.out.println("Hello " + person.getName() + ", Rs " + deposit +" has been deposited in your account");
	}
	
	public void withdrawl(double withdrawl)
	{
		if((balance-withdrawl) > 0)
			balance -= withdrawl;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public static long getAccNo()
	{
		return accNo;
	}

	@Override
	public String toString() {
		return "Hello " + person.getName() + ", your balance is: " + balance;
	}

	
	
	

}
