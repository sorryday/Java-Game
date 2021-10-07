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
	private String filename; // 유저의 저장할 객체의 파일명을 받을 객체
	private Scanner sc = new Scanner(System.in);
	
	ArrayList<User> members = new ArrayList<User>(); //가입된 유저를 저장할 List
	
	private static userManager manager = new userManager();	 	//매니저 객체를 하나만 만들기 위해 싱글톤으로 생성
	
	public static userManager getInstance() 					// 객체를 반환하는 메소드
	{
	        return manager;
	}
	
	public User login(String Id, String Password)  				// 로그인하기
	{
		for(User findUser : members)  							// members배열을 foreach 구문으로 탐색 
		{
			if(findUser.getId().equals(Id) && findUser.getPassword().equals(Password)) //아이디와 비밀번호가 일치한다면		
				return findUser;
		}
		return null;
	}
	
	public void createUser(String Name,String Id, String Password,String Option)// 유저의 종류에 따라서 유저 생성
	{
		for(User findUser : members)  									// members배열을 foreach 구문으로 탐색 
		{
			if(findUser.getName().equals(Id)) // 아이디 중복검사.
			{
				System.out.println("이미 가입되어 있는 아이디입니다. 다시 입력해주세요");
				return;
			}
		}
		
		if(Option.equals("1")) 	// money 유저이면
		{
			members.add(new moneyUser(Name,Id,Password));		//money 유저 객체 생성 및 배열에 대입
			System.out.println(Name + "님의  회원가입이 완료되었습니다. " + "회원종류 : 2장 섯다 유저 (money user)");
		}
		
		else if(Option.equals("2")) //chip 유저이면
		{
			members.add(new chipUser(Name, Id,Password));		//chip 유저 객체 생성 및 배열에 대입
			System.out.println(Name + "님의  회원가입이 완료되었습니다. " + "회원종류 : 3장 섯다 유저 (chip user)");
		}
		else
		{
			System.out.println("회원 유형을 잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}
	
	public void deleteUser(String Id)						//입력받은 Id에 맞는 유저 삭제
	{
		Iterator<User> ite = members.iterator();
		
		while(ite.hasNext())  							
		{
			User findUser = ite.next();
			if(findUser.getId().equals(Id))
			{
				ite.remove();
				System.out.println("회원의 정보가 삭제되었습니다");
			}
			else
				System.out.println("삭제하려는 회원의 정보가 없습니다. 다시 입력해주세요");
		}
		
		File file = new File(Id+ ".obj");
		
		if(file.exists()) 				//저장한 유저의 파일이 존재한다면
		{
			file.delete();				//그 파일을 삭제.
			System.out.println();
			System.out.println("회원의 저장정보가 삭제되었습니다");
		}	
	}

	public void changeInfo(User loginUser,String Password)		//로그인한 유저의 비밀번호를 변경합니다.
	{
		loginUser.setPassword(Password);
		System.out.println("비밀번호를 정상적으로 변경하였습니다.\n");
	}
	
	public void getWallet(User loginUer)	//유저의 money 혹은 chip을 충전합니다.
	{
		System.out.println();  
		while(true)
		{
			try					// nextInt에 숫자가 아닌 값이 들어갔을 때의 예외처리
			{
				System.out.print("충전하고 싶은 money 혹은 chip 를 입력해주세요 : ");
				int wallet=sc.nextInt(); 	// 충전하고싶은 금액
				if(loginUer instanceof moneyUser) ((moneyUser)loginUer).charge(wallet);
				
				else ((chipUser)loginUer).charge(wallet);
				break;
			}
		
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 값을 입력하셨습니다. 다시입력해주세요\n");
				sc = new Scanner(System.in);
			}	
		}
	}
	
	public void setObject(String filename)	// 유저를 저장할 파일명을 설정
	{
		this.filename=filename;
	}
	
	public void saveUser(User loginUser)  // 로그인한 유저의 객체를 저장.
	{
		try {
			FileOutputStream fos = new FileOutputStream(filename); 
			ObjectOutputStream os = new ObjectOutputStream(fos);
				
			os.writeObject(loginUser); 			//로그인한 유저를 저장.
		
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
		System.out.println("저장을 완료하였습니다.\n");
	}
	
	public void loadUser(String Id)	// 가입된 유저의 객체를 불러오는 메소드.
	{
		User user;   //객체를 받을 때 어떤 클래스의 객체인지 모르기 때문에 받고 싶은 객체참조 변수를 미리 선언
		
		try {
			FileInputStream fis = new FileInputStream(Id + ".obj");
			ObjectInputStream is = new ObjectInputStream(fis);
		
			while((user = (User)is.readObject()) != null) //object타입으로 객체를 리턴하기 때문에 캐스팅 해야함
			{	
				members.add(user);				
			}
			
			is.close(); // 파일 닫기.
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
