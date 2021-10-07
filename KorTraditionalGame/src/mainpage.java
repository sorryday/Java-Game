import java.util.Scanner;

public class mainpage implements game  {

	public static void beLoginMenu()		//�α����� �޴� ȭ��
	{
		System.out.print(  "1. Login (���ԵǾ��ִ� ���̵�� �α����մϴ�.)\n" 
						 + "2. Create user (�α����� ���̵�� ��й�ȣ�� ����ϴ�.)\n"
						 + "3. Delete user (����Ǿ� �ִ� ȸ���� ������ �����մϴ�.)\n"
						 + "4. Finish\n");
		System.out.print("Choic => ");
	}
	
	public static void afLoginMenu()		//�α��� �� �޴� ȭ��
	{
		System.out.print(  "1. Play game (���� �α����� ������ ������ �����մϴ�. �ּ� ���� �ݾ� : 100,000��)\n" 
						 + "2. Change user Info(������ ��й�ȣ�� �����մϴ�.)\n"
						 + "3. Get wallet (money user��� ���� �����ϰ� chip ������� chip�� �����մϴ�)\n"
						 + "4. Save user (������ ������ ������ �����մϴ�.)\n"
						 + "5. Logout (�α׾ƿ� �մϴ�.)\n");
		System.out.print("Choic => ");
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc = new Scanner(System.in); // switch���� �����ϱ� ���� ��ĳ�� 
		
		String Name,Id,Password;  				//�̸��� ���̵�� �н����� �Է¹��� ��ü��������
		String Option;							// ������ ������ �Ǻ�
		
		userManager manager = userManager.getInstance();  // Manager ��ü�� �ν��Ͻ�
		User loginUser; //���� �α����� ������ ��ü�� �޴� ��ü ��������
		
		computer computer = new computer();					// ������ ������ ��ǻ�� ��ü�� ����
		computerManager comManager = new computerManager(computer);	// ��ǻ�� ��ü�� �����ϴ� �Ŵ��� ��ü ����
		comManager.setObjectFile("computer.obj");
		comManager.saveComputer();  
		
		System.out.println();
		System.out.println("<���� ���ӿ� ���Ű� ȯ���մϴ�.>");
		
		while(true)
		{	
			System.out.println();
			beLoginMenu();
			String s1= sc.next();			// switch case�� ���� ��ü ��������
			System.out.println();
			
			if (s1.equals("4")) 
			{
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			}//if
			
			switch(s1)
			{
				case "1":  // �α����ϱ�
					System.out.println("�α����� ���̵�� ��й�ȣ�� �Է����ּ���.");
					
					System.out.print("���̵� : "); Id = sc.next();			  // ���̵�� �н����� �Է¹ޱ�
					System.out.print("��й�ȣ : "); Password=sc.next();
					
					manager.loadUser(Id);
					loginUser=manager.login(Id,Password); 				  // �α����ϱ� ���� �Լ��� �����Ͽ� �α����� ��ü�� �޾ƿ´�.
					
					if(loginUser==null) 
					{
						 System.out.println("���ԵǾ� ���� �ʰų� ���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���");
						 break;					  // �α��ο� �����ϸ�  �ٽ� 
					}
					
					else
					{
						manager.setObject(loginUser.getId() + ".obj");	  // �α����� ����� �̸����� ������ ���ϸ��� ����
						System.out.println();   
						while(true) 
						{						
							if(loginUser instanceof moneyUser)
								System.out.println(loginUser.getName()+"�� ȯ���մϴ�. " + "2�� ���� ���� "  
													+ " money : " +((moneyUser)loginUser).getMoney()+ " �޴��� �������ּ��� \n");
							else
								System.out.println(loginUser.getName()+"�� ȯ���մϴ�." + "3�� ���� ���� " 
													+ " chip : " +((chipUser)loginUser).getChip()+ " �޴��� �������ּ��� \n");
							
							afLoginMenu();	//�α��� �� �� ���� ȭ�� ���
							s1=sc.next(); 
							
							if (s1.equals("5")) 		//�α׾ƿ� : �ٽ� ó�� ����ȭ������ ���ư���. (beLoginMenu)
							{
								System.out.println();
								System.out.println("�α׾ƿ��մϴ�.");
								break;
							}
							
							switch(s1)
							{
								case "1":
									boolean check = loginUser.check();
									if(check==true)
										{ loginUser.gameMain(loginUser,computer); }	//���� ����.
									break;
								case "2":				// ��й�ȣ ����
									System.out.println();
									System.out.print("�����ϰ� ���� ��й�ȣ�� �Է��ϼ��� : ");
									Password = sc.next(); 
									manager.changeInfo(loginUser,Password);	// �α����� ������ ��й�ȣ�� �����մϴ�.
									break;
									
								case "3":							   //������ money Ȥ�� chip�� �����մϴ�
									manager.getWallet(loginUser);	// �Է��� �ݾװ� ���� �α����� ������ ��ü�� �ѱ��.
									break;
									
								case "4":						      //�α����� ������ ��ü�� �����մϴ�.
									manager.saveUser(loginUser);
									break;
									
								default :
									System.out.println();
									System.out.println("�޴��� �����ϴ�. �ٽ� �Է����ּ���\n");
									break;	
							}//switch
						}//while
					} // else if
					break;
					
				case "2":  // ���� ����
					
					System.out.println("������ ȸ���� �̸��� ���̵�� ��и�ȣ�� �Է����ּ���");
					
					System.out.print("�̸� : "); Name = sc.next(); //�̸��� ���̵�� �н����� �Է¹ޱ�		
					System.out.print("���̵� : "); Id = sc.next();
					System.out.print("��й�ȣ : "); Password=sc.next();
					
					System.out.print("�����ϰ� ���� ȸ���� ������ �Է����ּ��� (1: 2�� ���� ����, 2: 3�� ���� ����) ==> ");
					Option = sc.next();							//2�� ���� ��������, 3�� ���� �������� ������ ���� �ִ� ��ü
					
					manager.createUser(Name,Id,Password,Option);			//������ ��������� �Լ� ����.
					
					break;
					
				case "3":
					System.out.print("������ ȸ���� Id�� �Է����ּ��� : ");
					Id = sc.next();
					manager.deleteUser(Id);	// �α����� ������ �����մϴ�.
					break ;
					
				default :
					System.out.println("�޴��� �����ϴ�. �ٽ� �Է����ּ���");
			}//switch
		}//while
	}//main
}//mainpage
