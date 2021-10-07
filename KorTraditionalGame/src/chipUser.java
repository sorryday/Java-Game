import java.io.Serializable;

public class chipUser extends User implements Serializable	//3������
{
	private int chip = 0;   		 //3�� ���� ���������� ��
	private String meddlePe;	     //3�� ���� ������ �߰���
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
			System.out.println("������ chip�� �����ϴ�. �������ּ��� (�ּұݾ� : 100,000)\n");
			return false;
		}
		else
			return true;
	}
	
	@Override
	public int charge(int wallet) //chip�� �����ϴ� �޼ҵ�
	{
		this.chip += wallet;	
		System.out.println("ȸ������ chip�� �����Ͽ����ϴ�. ���� chip : " + getChip() + "\n");
		return 0;
	}
}
