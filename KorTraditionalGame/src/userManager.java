import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class userManager 
{
	private String filename; // ������ ������ ��ü�� ���ϸ��� ���� ��ü
	private Scanner sc = new Scanner(System.in);
	
	ArrayList<User> members = new ArrayList<User>(); //���Ե� ������ ������ List
	
	private static userManager manager = new userManager();	 	//�Ŵ��� ��ü�� �ϳ��� ����� ���� �̱������� ����
	
	public static userManager getInstance() 					// ��ü�� ��ȯ�ϴ� �޼ҵ�
	{
	        return manager;
	}
	
	public User login(String Id, String Password)  				// �α����ϱ�
	{
		for(User findUser : members)  							// members�迭�� foreach �������� Ž�� 
		{
			if(findUser.getId().equals(Id) && findUser.getPassword().equals(Password)) //���̵�� ��й�ȣ�� ��ġ�Ѵٸ�		
				return findUser;
		}
		return null;
	}
	
	public void createUser(String Name,String Id, String Password,String Option)// ������ ������ ���� ���� ����
	{
		for(User findUser : members)  									// members�迭�� foreach �������� Ž�� 
		{
			if(findUser.getName().equals(Id)) // ���̵� �ߺ��˻�.
			{
				System.out.println("�̹� ���ԵǾ� �ִ� ���̵��Դϴ�. �ٽ� �Է����ּ���");
				return;
			}
		}
		
		if(Option.equals("1")) 	// money �����̸�
		{
			members.add(new moneyUser(Name,Id,Password));		//money ���� ��ü ���� �� �迭�� ����
			System.out.println(Name + "����  ȸ�������� �Ϸ�Ǿ����ϴ�. " + "ȸ������ : 2�� ���� ���� (money user)");
		}
		
		else if(Option.equals("2")) //chip �����̸�
		{
			members.add(new chipUser(Name, Id,Password));		//chip ���� ��ü ���� �� �迭�� ����
			System.out.println(Name + "����  ȸ�������� �Ϸ�Ǿ����ϴ�. " + "ȸ������ : 3�� ���� ���� (chip user)");
		}
		else
		{
			System.out.println("ȸ�� ������ �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
		}
	}
	
	public void deleteUser(String Id)						//�Է¹��� Id�� �´� ���� ����
	{
		Iterator<User> ite = members.iterator();
		
		while(ite.hasNext())  							
		{
			User findUser = ite.next();
			if(findUser.getId().equals(Id))
			{
				ite.remove();
				System.out.println("ȸ���� ������ �����Ǿ����ϴ�");
			}
			else
				System.out.println("�����Ϸ��� ȸ���� ������ �����ϴ�. �ٽ� �Է����ּ���");
		}
		
		File file = new File(Id+ ".obj");
		
		if(file.exists()) 				//������ ������ ������ �����Ѵٸ�
		{
			file.delete();				//�� ������ ����.
			System.out.println();
			System.out.println("ȸ���� ���������� �����Ǿ����ϴ�");
		}	
	}

	public void changeInfo(User loginUser,String Password)		//�α����� ������ ��й�ȣ�� �����մϴ�.
	{
		loginUser.setPassword(Password);
		System.out.println("��й�ȣ�� ���������� �����Ͽ����ϴ�.\n");
	}
	
	public void getWallet(User loginUer)	//������ money Ȥ�� chip�� �����մϴ�.
	{
		System.out.println();  
		while(true)
		{
			try					// nextInt�� ���ڰ� �ƴ� ���� ���� ���� ����ó��
			{
				System.out.print("�����ϰ� ���� money Ȥ�� chip �� �Է����ּ��� : ");
				int wallet=sc.nextInt(); 	// �����ϰ���� �ݾ�
				if(loginUer instanceof moneyUser) ((moneyUser)loginUer).charge(wallet);
				
				else ((chipUser)loginUer).charge(wallet);
				break;
			}
		
			catch(InputMismatchException e)
			{
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ��Է����ּ���\n");
				sc = new Scanner(System.in);
			}	
		}
	}
	
	public void setObject(String filename)	// ������ ������ ���ϸ��� ����
	{
		this.filename=filename;
	}
	
	public void saveUser(User loginUser)  // �α����� ������ ��ü�� ����.
	{
		try {
			FileOutputStream fos = new FileOutputStream(filename); 
			ObjectOutputStream os = new ObjectOutputStream(fos);
				
			os.writeObject(loginUser); 			//�α����� ������ ����.
		
			os.flush();  
			os.close();	
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("������ �Ϸ��Ͽ����ϴ�.\n");
	}
	
	public void loadUser(String Id)	// ���Ե� ������ ��ü�� �ҷ����� �޼ҵ�.
	{
		User user;   //��ü�� ���� �� � Ŭ������ ��ü���� �𸣱� ������ �ް� ���� ��ü���� ������ �̸� ����
		
		try {
			FileInputStream fis = new FileInputStream(Id + ".obj");
			ObjectInputStream is = new ObjectInputStream(fis);
		
			while((user = (User)is.readObject()) != null) //objectŸ������ ��ü�� �����ϱ� ������ ĳ���� �ؾ���
			{	
				members.add(user);				
			}
			
			is.close(); // ���� �ݱ�.
			}
		catch (EOFException e) 
		{ }
		catch (FileNotFoundException e) 
		{ } 
		catch (NullPointerException e) 
		{ } 
		catch (IOException e) 
		{ e.printStackTrace(); } 
		catch (ClassNotFoundException e) 
		{ e.printStackTrace(); }
	}
}
