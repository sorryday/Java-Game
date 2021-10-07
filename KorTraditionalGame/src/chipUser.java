import java.io.Serializable;

public class chipUser extends User implements Serializable	//3장유저
{
	private int chip = 0;   		 //3장 섯다 게임유저의 돈
	private String meddlePe;	     //3장 섯다 유저의 중간패
	public chipUser(String Name,String Id, String Password) 
	{
		super(Name,Id, Password);
	}

	public int getChip() 
	{
		return chip;
	}

	public void setChip(int chip) 
	{
		this.chip = chip;
	}

	public String getMeddlePe() {
		return meddlePe;
	}

	public void setMeddlePe(String meddlePe) {
		this.meddlePe = meddlePe;
	}
		
	@Override
	public boolean check() 
	{
		if(chip<100000)
		{
			System.out.println("게임할 chip이 없습니다. 충전해주세요 (최소금액 : 100,000)\n");
			return false;
		}
		else
			return true;
	}
	
	@Override
	public int charge(int wallet) //chip을 충전하는 메소드
	{
		this.chip += wallet;	
		System.out.println("회원님의 chip을 충전하였습니다. 남은 chip : " + getChip() + "\n");
		return 0;
	}
}
