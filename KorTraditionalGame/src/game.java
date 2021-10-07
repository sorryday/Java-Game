import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public interface game //������ ������ ���� interface, 1������� 2������
{
	default public void gameMain(User loginUser,computer computer) throws InterruptedException // ���� �α����� ������ ��ü�� computer��ü�� ������ �����Ѵ�.
	{
		gameManager gamemanager = new gameManager();	 	//gameManager�� �޼ҵ带 ����ϱ� ���� ��ü
		Scanner sc = new Scanner(System.in);
		Random r = new Random();						//��ǻ���� ������ ���� ���� Ŭ����
		
		boolean reGame;									// �а� ���ų� �����а� ������ ��� �Ǵ����ִ� ����
		String reStart;									// ������ �� ���� �� �� ���� �ǻ縦 ���� ��ü ��������
		
		System.out.println();
		System.out.println("\t���� ���� !!\n");
		System.out.println("\t�и� �����ϴ�.\n");
		System.out.println("\t<1 ������>\n");
		System.out.println("���� �ǵ� : " + gamemanager.cnt + "\n");
		
		//1������
		if(loginUser instanceof moneyUser)							//2�� ���� ������ ���, ó���� ���� �и� �޴´�.
		{
			Collections.shuffle(Arrays.asList(gamemanager.pe));		// gamemanager�� pe�迭�� ���ҵ��� �������� ���� collectionŬ������ �޼ҵ�
			
			computer.setLeftPe(gamemanager.pe[0]);					// �������� ���� �迭���� 0��° �ε����� ���� �̾Ƽ� �п� �ִ´�.	
			loginUser.setLeftPe(gamemanager.pe[1]);
		}
		else 
		{
			Collections.shuffle(Arrays.asList(gamemanager.pe));		//3�� ���� ������ ���, ó���� ���� �п� �߰��и� �޴´�.
			computer.setLeftPe(gamemanager.pe[0]);	
			computer.setMeddlePe(gamemanager.pe[1]);	
			
			((chipUser)loginUser).setLeftPe(gamemanager.pe[2]);	
			((chipUser)loginUser).setMeddlePe(gamemanager.pe[3]);
		}
		
		while(true)
		{
			if(loginUser instanceof moneyUser)
				System.out.println("�� : " + loginUser.getLeftPe() +"\n");			//���� �и� Ȯ���Ѵ� : 2�� ���� ����
				
			else																	//���� �и� Ȯ���Ѵ� : 3�� ����.
				System.out.println("�� : " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() +"\n");
			
			System.out.println("��ǻ���� �� : " + computer.getLeftPe() + "\n");
			System.out.println("�������ּ��� : ����(1) , ��(2)");
			System.out.print("choice ==> ");
			String userIn = sc.next();					// ���� ���� ���� 
			System.out.println();
			
			switch(userIn) // 1��������� ���̰� ����.
			{
				case "1" :
					gamemanager.userHalf(loginUser);					//���� ���� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt + "\n");
					break;
				
				case "2" :
					gamemanager.userCall(loginUser);					//���� �� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt + "\n");
					break;
					
				default :
					System.out.println("�ٽü������ּ���");
					break;
			}
			
			String comIn = String.valueOf((r.nextInt(2)+1));		// 1~2���� �����ϰ� �ϳ��� �̾� ��ǻ���� ���� ��ü ������ ��´�.
			System.out.print("��ǻ���� ����");
			switch(comIn)
			{
				case "1" :
					gamemanager.comHalf(computer);					//��ǻ�� ����
					System.out.println("���� �ǵ� : "+ gamemanager.cnt + "\n");
					break;
				
				case "2" :
					gamemanager.comCall(computer);					//��ǻ�� �� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt + "\n");
					break;
			}
			
			if (userIn.equals("2") && comIn.equals("2"))				// �Ѵ� ���� ���� ���
				break;
		}//while
		
		// 2������ ����
		System.out.println("\t<2 ������>\n"); 
		
		computer.setRightPe(gamemanager.pe[4]);					
		loginUser.setRightPe(gamemanager.pe[5]);
		
		while(true)
		{
			if(loginUser instanceof moneyUser)
				System.out.println("�� : " + loginUser.getLeftPe() + " "+ loginUser.getRightPe()+"\n");			//���� �и� ���� Ȯ���Ѵ�.
			
			else 
				System.out.println("�� : " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() +" "+ loginUser.getRightPe()+"\n");	
			
			System.out.println("��ǻ���� �� : " + computer.getLeftPe() + "\n");
			System.out.println("�������ּ��� : ����(1), ��(2), ��(3), ����(4)");
			System.out.print("choice ==> ");
			String userIn = sc.next();					// ���� ���� ���� 
			System.out.println();
			
			switch(userIn) 
			{
				case "1" :
					gamemanager.userHalf(loginUser);					//���� ���� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt);
					break;
				
				case "2" :
					gamemanager.userCall(loginUser);					//���� �� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt);
					break;
				
				case "3" :
					gamemanager.userBeing(loginUser);					//���� ��
					System.out.println("���� �ǵ� : " + gamemanager.cnt);
					break;
					
				case "4" :
					gamemanager.userDie(loginUser,computer);			//���� ����, ���̸� ������ �ٷ� �� ���ϴ� �޼ҵ�� �Ѿ��.
					return;
					
				default :
					System.out.println("�ٽü������ּ���");
					break;
			}
			
			String comIn = String.valueOf((r.nextInt(3)+1));		// 1~3���� �����ϰ� �ϳ��� �̾� ��ǻ���� ���� ��ü ������ ��´�.
			System.out.println();
			System.out.print("��ǻ���� ����");
			switch(comIn)											// ��ǻ�ʹ� ��ü������ ������ �� ���� ����
			{
				case "1" :
					gamemanager.comHalf(computer);					//��ǻ�� ����
					System.out.println("���� �ǵ� : "+ gamemanager.cnt+ "\n");
					break;
				
				case "2" :
					gamemanager.comCall(computer);					//��ǻ�� �� 
					System.out.println("���� �ǵ� : " + gamemanager.cnt + "\n");
					break;
					
				case "3" :
					gamemanager.comBeing(computer);					//��ǻ�� ��
					System.out.println("���� �ǵ� : " + gamemanager.cnt+ "\n");
					break;
			}
			
			if (userIn.equals("2") && comIn.equals("2"))  					// �Ѵ� ���� ���� ��� 
			{
				reGame = gamemanager.Compare(loginUser,computer);			//User�� computer�� �� �� ���� ������ �� �� ���ϴ� �޼ҵ�� �Ѿ��.
			
				if(reGame == false && loginUser instanceof moneyUser)		// �����г� �а� ������ ��� ���⸦ �����Ѵ�.(2�� ����)
				{
					Collections.shuffle(Arrays.asList(gamemanager.pe));		
					computer.setLeftPe(gamemanager.pe[0]);					
					loginUser.setLeftPe(gamemanager.pe[1]);
					
					computer.setRightPe(gamemanager.pe[2]);					
					loginUser.setRightPe(gamemanager.pe[3]);
				
					gamemanager.Compare(loginUser,computer);
				}
				
				else if(reGame == false && loginUser instanceof chipUser)	// �����г� �а� ������ ��� ���⸦ �����Ѵ�.(3�� ����)
				{
					Collections.shuffle(Arrays.asList(gamemanager.pe));		
					computer.setLeftPe(gamemanager.pe[0]);					
					computer.setMeddlePe(gamemanager.pe[1]);	
					computer.setRightPe(gamemanager.pe[2]);
					
					loginUser.setLeftPe(gamemanager.pe[3]);
					((chipUser)loginUser).setMeddlePe(gamemanager.pe[4]);						
					loginUser.setRightPe(gamemanager.pe[5]);
				
					gamemanager.Compare(loginUser,computer);
				}
				break;
			}
		}//while
		
		System.out.println("�� ������ �����Ͻðڽ��ϱ�? (yes : y , no :n)");
		System.out.print("choice ==> ");
		reStart = sc.next();
		
		if(reStart.equals("y"))
		{
			if(loginUser instanceof moneyUser && ((moneyUser)loginUser).getMoney()>=100000)
				gameMain(loginUser,computer);
			
			else if(loginUser instanceof chipUser && ((chipUser)loginUser).getChip()>=100000)
				gameMain(loginUser,computer);
			
			else
				System.out.println("money Ȥ�� chip�� �����Ͽ� ������ ������ �� �����ϴ�. ���� �������� �̵��մϴ�.\n");
		}
		else
			System.out.println("�����մϴ�.\n");
	}
}
