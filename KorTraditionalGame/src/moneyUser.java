import java.io.Serializable;

public class moneyUser extends User implements Serializable	//2�� ����
{
	private int money = 0;   // ����ڰ� ������ �ִ� ��
	public moneyUser(String Name, String Id,String Password)
	{
		super(Name,Id,Password);
	}
	
	public int getMoney() 
	{
		return money;
	}

	public void setMoney(int money) 
	{
		this.money = money;
	}

	@Override
	public boolean check() 
	{
		if(money<100000)
		{
			System.out.println("������ ���� �����ϴ�. �������ּ��� (�ּұݾ� : 100,000)\n");
			return false;
		}
		else
			return true;
	}
	
	@Override
	public int charge(int wallet) // money�� �����ϴ� �޼ҵ�
	{
		this.money += wallet; 
		System.out.println("ȸ������ money�� �����Ͽ����ϴ�. ���� money : " + getMoney() + "\n");
		return 0;
	}
}
