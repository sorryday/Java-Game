import java.io.Serializable;

public class moneyUser extends User implements Serializable	//2장 유저
{
	private int money = 0;   // 사용자가 가지고 있는 돈
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
			System.out.println("게임할 돈이 없습니다. 충전해주세요 (최소금액 : 100,000)\n");
			return false;
		}
		else
			return true;
	}
	
	@Override
	public int charge(int wallet) // money를 충전하는 메소드
	{
		this.money += wallet; 
		System.out.println("회원님의 money를 충전하였습니다. 남은 money : " + getMoney() + "\n");
		return 0;
	}
}
