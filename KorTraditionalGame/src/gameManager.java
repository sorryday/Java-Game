import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class gameManager 
{
	private HashMap<String, Integer> jokbo = new HashMap<>();	// ������ ���� ������ �ؽ��� 
	public String[] pe = {"1��","3��","8��","1","2","3","4","5","6","7","8","9","10","2","4","5","6","7","9","10"}; // �� ���� ����Ʈ
	
	public int cnt = 500; // ������ ��� �ǵ��� ���̴� ��, ó�� ���� �ݾ� 500��
	
	public String Upe,Cpe; 		// left ��, right �и� ���� ���� ������ ��ü��������
	public int Upoint,Cpoint = 0;	// ����, ��ǻ�� ���ڰ� ������ �ִ� �п� ���� �ؽ����� value�� ������ ����
	
	Scanner sc = new Scanner(System.in);
	public String UserPeChoice; 		// 3�� ���� ������ ��� � �и� �������� ������ ��ü ���� ����
	public String ComPeChoice;			// ��ǻ�Ͱ� 3�� ���� ������ ���� �ϴ� ��� � �и� ������ �� ������ ��ü ���� ����
	
	Random r = new Random();
	
	public gameManager()
	{	// ���� ����
		jokbo.put("3��8��", 1); jokbo.put("8��3��", 1);
		jokbo.put("1��3��", 2); jokbo.put("3��1��", 2); jokbo.put("1��8��", 2); jokbo.put("8��1��", 2);
		// �� ����
		jokbo.put("1010", 3);
		jokbo.put("99", 4);
		jokbo.put("8��8", 5); jokbo.put("88��",5); jokbo.put("88", 5);
		jokbo.put("77", 6);
		jokbo.put("66", 7);
		jokbo.put("55", 8);
		jokbo.put("44", 9);
		jokbo.put("3��3", 10); jokbo.put("33��", 10); jokbo.put("33", 10);
		jokbo.put("22", 11);
		jokbo.put("1��1", 12); jokbo.put("11��", 12);jokbo.put("11", 12);
		//�˸�
		jokbo.put("1��2", 13); jokbo.put("12", 13); 
		//����
		jokbo.put("1��4", 14);  jokbo.put("14", 14);
		//����
		jokbo.put("1��9", 15);  jokbo.put("19", 15);
		//���
		jokbo.put("1��10", 16); jokbo.put("110", 16); 
		//���
		jokbo.put("410", 17);
		//����
		jokbo.put("46", 18);
		//����
		jokbo.put("1��8", 19); jokbo.put("81��", 19); jokbo.put("18", 19); jokbo.put("81", 19); jokbo.put("8��1", 19); jokbo.put("18��", 19);
		jokbo.put("27", 19); jokbo.put("72", 19);
		jokbo.put("3��6", 19); jokbo.put("63��", 19); jokbo.put("36", 19); jokbo.put("63", 19);
		jokbo.put("45", 19); jokbo.put("54", 19);
		
		jokbo.put("109", 19); jokbo.put("910", 19);
		//8��
		jokbo.put("1��7", 20); jokbo.put("71��", 20); jokbo.put("17", 20); jokbo.put("71", 20);
		jokbo.put("26", 20); jokbo.put("62", 20);
		jokbo.put("3��5", 20); jokbo.put("53��", 20); jokbo.put("35", 20); jokbo.put("53", 20);
		
		jokbo.put("8��10", 20); jokbo.put("108��", 20); jokbo.put("108", 20); jokbo.put("810", 20);
		//7��
		jokbo.put("1��6", 21); jokbo.put("61��", 21); jokbo.put("16", 21); jokbo.put("61", 21);
		jokbo.put("25", 21); jokbo.put("52", 21);
		jokbo.put("3��4", 21); jokbo.put("43��", 21); jokbo.put("34", 21); jokbo.put("43", 21);
		
		jokbo.put("8��9", 21); jokbo.put("98��", 21); jokbo.put("98", 21); jokbo.put("89", 21);
		jokbo.put("710", 21); jokbo.put("107", 21);
		//6��
		jokbo.put("1��5", 22); jokbo.put("51��", 22); jokbo.put("15", 22); jokbo.put("51", 22);
		jokbo.put("24", 22); jokbo.put("42", 22);
		
		jokbo.put("79", 22); jokbo.put("97", 22);
		jokbo.put("610", 22); jokbo.put("106", 22);
		//5��
		jokbo.put("41��", 23);  jokbo.put("41", 23);
		jokbo.put("23", 23);  jokbo.put("32", 23); jokbo.put("3��2", 23); jokbo.put("23��", 23);
		
		jokbo.put("78��", 23); jokbo.put("8��7", 23); jokbo.put("78", 23); jokbo.put("87", 23);
		jokbo.put("69", 23); jokbo.put("96", 23);
		jokbo.put("510", 23); jokbo.put("105", 23);
		//4��
		jokbo.put("1��3", 24); jokbo.put("31��", 24); jokbo.put("13", 24); jokbo.put("31", 24); 
		jokbo.put("3��1", 24); jokbo.put("13��", 24);
		
		jokbo.put("8��6", 24); jokbo.put("68��", 24); jokbo.put("86", 24); jokbo.put("68", 24);
		jokbo.put("95", 24); jokbo.put("59", 24);
		jokbo.put("104", 24);
		//3��
		jokbo.put("1��2", 25); jokbo.put("21��", 25); jokbo.put("12", 25); jokbo.put("21", 25);
		
		jokbo.put("76", 25); jokbo.put("67", 25);
		jokbo.put("8��5", 25); jokbo.put("58��", 25); jokbo.put("85", 25); jokbo.put("58", 25);
		jokbo.put("103��", 25); jokbo.put("3��10", 25); jokbo.put("103", 25); jokbo.put("310", 25);
		//2��
		jokbo.put("75", 26); jokbo.put("57", 26);
		jokbo.put("8��4", 26); jokbo.put("48��", 26); jokbo.put("84", 26); jokbo.put("48", 26);
		jokbo.put("93��", 26); jokbo.put("3��9", 26); jokbo.put("93", 26); jokbo.put("39", 26);
		jokbo.put("102", 26); jokbo.put("210", 26);
		//1��
		jokbo.put("56", 27); jokbo.put("65", 27); 
		jokbo.put("47", 27); jokbo.put("74", 27); 
		jokbo.put("38", 27); jokbo.put("83", 27); jokbo.put("3��8", 27); jokbo.put("83��", 27); 
		jokbo.put("38��", 27); jokbo.put("8��3", 27);
		jokbo.put("92", 27); jokbo.put("29", 27); 
		jokbo.put("101", 27); jokbo.put("101��", 27); 
		//����
		jokbo.put("64", 28); 
		jokbo.put("73", 28); jokbo.put("37", 28); jokbo.put("73��", 28); jokbo.put("3��7", 28); 
		jokbo.put("82", 28); jokbo.put("28", 28); jokbo.put("8��2", 28); jokbo.put("28��", 28);  
		jokbo.put("91", 28); jokbo.put("91��", 28); 
		//���� : ���� �����
		jokbo.put("49", 29); jokbo.put("94", 29); 
	}
	
	public boolean Compare(User loginUser, computer computer) throws InterruptedException		// �� �� �޼ҵ�
	{
		if(loginUser instanceof moneyUser)								// 2�� ���� ������ ���
		{
			System.out.println("��ø� ��ٷ��ּ���..\n");
			Thread.sleep(2000);
			
			Upe = loginUser.getLeftPe() + loginUser.getRightPe();		// ������ �и� ��ģ��.
			Cpe = computer.getLeftPe() + computer.getRightPe();			// ��ǻ���� �и� ��ģ��.
			
			Upoint = jokbo.get(Upe);									// ������ �и� key�� �ؽ��ʿ��� �����Ǵ� value ���� ã�� ��ȯ�Ͽ� ����
			Cpoint = jokbo.get(Cpe);									// ��ǻ���� �и� key�� �ؽ��ʿ��� �����Ǵ� value ���� ã�� ��ȯ�Ͽ� ����
			
			System.out.println("�и� ���մϴ�.\n");
			System.out.println("�� �� : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
							  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
		}
		
		else														// 3�� ���� ������ ���
		{
			System.out.print("������ �и� �������ּ���\n");
			System.out.print("1. " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() + "\n"
							+"2. " + ((chipUser)loginUser).getMeddlePe() + " " + loginUser.getRightPe() + "\n"
							+"3. " + loginUser.getLeftPe()+" "+loginUser.getRightPe() + "\n");
			System.out.print("choice ==> ");
			UserPeChoice = sc.next();
			System.out.println();
			
			System.out.println("��ø� ��ٷ��ּ���..\n");
			Thread.sleep(2000);
			
			switch(UserPeChoice)													
			{
				case "1" : 														//�����п� �߰��и� �������� ���
					Upe = loginUser.getLeftPe() + ((chipUser)loginUser).getMeddlePe();	
					
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
						switch(ComPeChoice)
						{
							case "1" :
								Cpe = computer.getLeftPe() + computer.getMeddlePe();

								System.out.println("�и� ���մϴ�.\n");
								System.out.println("�� �� : " +  loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  " 
												  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
								break;
								
							case "2" :
								Cpe = computer.getMeddlePe() + computer.getRightPe();

								System.out.println("�и� ���մϴ�.\n");
								System.out.println("�� �� : " + loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  "
												  +"��ǻ���� ��  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");
								break;
								
							case "3" :
								Cpe = computer.getLeftPe() + computer.getRightPe();	
								
								System.out.println("�и� ���մϴ�.\n");
								System.out.println("�� �� : " + loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  "
												  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
								break;
						}
						
					Upoint = jokbo.get(Upe);									
					Cpoint = jokbo.get(Cpe);									
					break;
				
				case "2" : 														//�߰��п� �������и� �������� ���
					Upe = ((chipUser)loginUser).getMeddlePe() + loginUser.getRightPe();		
					
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
					switch(ComPeChoice)
					{
						case "1" :
							Cpe = computer.getLeftPe() + computer.getMeddlePe();
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
							break;
							
						case "2" :
							Cpe = computer.getMeddlePe() + computer.getRightPe();
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");	
							break;
							
						case "3" :
							Cpe = computer.getLeftPe() + computer.getRightPe();
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
							break;
					}		
					Cpoint = jokbo.get(Cpe);
					Upoint = jokbo.get(Upe);									
									
					break;
				
				case "3" : 														//�����п� �������и� �������� ���
					Upe = loginUser.getLeftPe() + loginUser.getRightPe();		
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
					switch(ComPeChoice)
					{
						case "1" :
							Cpe = computer.getLeftPe() + computer.getMeddlePe();
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
							break;
							
						case "2" :
							Cpe = computer.getMeddlePe() + computer.getRightPe();	
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");
							break;
							
						case "3" :
							Cpe = computer.getLeftPe() + computer.getRightPe();	
							
							System.out.println("�и� ���մϴ�.\n");
							System.out.println("�� �� : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"��ǻ���� ��  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
							break;
					}		
					
					Upoint = jokbo.get(Upe);									
					Cpoint = jokbo.get(Cpe);									
					break;		
			}
		}
		
		if(Upoint < Cpoint)											// ���� ���� ����� �̱�Ƿ� ������ ��
		{
			System.out.println("�����մϴ�. �¸��ϼ̽��ϴ�.\n");
			
			if(loginUser instanceof moneyUser)
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() + cnt);	
				System.out.println("���� �ܾ� : " + ((moneyUser)loginUser).getMoney() + "\n");
				return true;
			}
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() + cnt);
				System.out.println("���� �ܾ� : " + ((chipUser)loginUser).getChip() + "\n");
				return true;
			}	
		}
		else if (Upoint > Cpoint)									// ��ǻ���� ��
		{
			System.out.println("��Ÿ���׿�... �й��Ͽ����ϴ� \n");
			computer.setCmoney(computer.getCmoney() + cnt);
			System.out.println("��ǻ�� �ܾ� : " + computer.getCmoney());
			
			if(loginUser instanceof moneyUser)
			{
				System.out.println("���� �ܾ� : " + ((moneyUser)loginUser).getMoney() + "\n");
				return true;
			}
			
			else
			{
				System.out.println("���� �ܾ� : " + ((chipUser)loginUser).getChip() + "\n");
				return true;
			}
		}
		
		if(Upoint == Cpoint || Upoint==29 || Cpoint==29)			// �а� ���ų� ������ ��ǻ�Ͱ� �����а� ������ ���.
		{
			if(Upoint == Cpoint)
				System.out.println("�а� �����ϴ�. ���⸦ �����մϴ�.\n");
			
			else if(Upoint==29 || Cpoint==29)
				System.out.println("������ !! ���⸦ �����մϴ�.\n");
			
			return false;
		}
		return true;
	}
	
	public void userHalf(User loginUser)		// ���� ����  �Լ�
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < cnt)
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
	
			else 
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - cnt);
				cnt *=2;
				System.out.println("����!  " +"���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < cnt)
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((chipUser)loginUser).getChip());
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - cnt);
				cnt *=2;
				System.out.println("����!  " +"���� �ܾ� : " + ((chipUser)loginUser).getChip());
			}
		}
	}
	
	public void userCall(User loginUser)	  // ���� ��  �Լ�
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < (cnt/2))
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
			
			else
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - (cnt/2));
				cnt = cnt + (cnt/2);
				System.out.println("��!  " +"���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < (cnt/2))
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((chipUser)loginUser).getChip());
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - (cnt/2));
				cnt = cnt + (cnt/2);
				System.out.println("��!  " +"���� �ܾ� : " + ((chipUser)loginUser).getChip());	
			}
		}
	}
	
	public void userBeing(User loginUser)	  // ���� ��  �Լ�
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < 500)
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
			
			else
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - 500);
				cnt+=500;
				System.out.println("��!  " +"���� �ܾ� : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < 500)
				System.out.println("������ ���� �����մϴ�. ���� �ܾ� : " + ((chipUser)loginUser).getChip());
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - 500);
				cnt+=500;
				System.out.println("��!  " +"���� �ܾ� : " + ((chipUser)loginUser).getChip());	
			}
		}
	}
	
	public void userDie(User loginUser, computer computer)		//���� ���� �Լ�
	{
		System.out.println("����.. ��ǻ�Ͱ� �¸��Ͽ����ϴ�.\n");
		System.out.println("��ǻ���� �� : " + computer.getLeftPe() +" "+computer.getRightPe() + "\n");
		computer.setCmoney(computer.getCmoney() + cnt);
		System.out.println("��ǻ�� �ܾ� : " + computer.getCmoney() + "\n");
	}
	
	public void comHalf(computer computer)		// ��ǻ�� ����  �Լ�
	{
		if(computer.getCmoney() < cnt)
			System.out.println("��ǻ���� ������ ���� �����մϴ�.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-cnt);
			cnt *=2;
			System.out.println();
			System.out.println("����!");
		}
	}
	
	public void comCall(computer computer)	  // ��ǻ�� ��  �Լ�
	{
		if(computer.getCmoney() < (cnt/2))
			System.out.println("��ǻ���� ������ ���� �����մϴ�.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-(cnt/2));
			cnt = cnt + (cnt/2);
			System.out.println();
			System.out.println("��!");  
		}
	}
	
	public void comBeing(computer computer)	  // ��ǻ�� ��  �Լ�
	{
		if(computer.getCmoney() < (cnt/2))
			System.out.println("��ǻ���� ������ ���� �����մϴ�.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-500);
			cnt += 500;
			System.out.println();
			System.out.println("��!");  
		}
	}
}
