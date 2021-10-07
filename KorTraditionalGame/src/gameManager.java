import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class gameManager 
{
	private HashMap<String, Integer> jokbo = new HashMap<>();	// 족보와 값을 저장할 해쉬맵 
	public String[] pe = {"1광","3광","8광","1","2","3","4","5","6","7","8","9","10","2","4","5","6","7","9","10"}; // 패 저장 리스트
	
	public int cnt = 500; // 게임할 당시 판돈이 모이는 곳, 처음 시작 금액 500원
	
	public String Upe,Cpe; 		// left 패, right 패를 합한 것을 저장할 객체참조변수
	public int Upoint,Cpoint = 0;	// 유저, 컴퓨터 각자가 가지고 있는 패에 대한 해쉬맵의 value를 저장할 변수
	
	Scanner sc = new Scanner(System.in);
	public String UserPeChoice; 		// 3장 섯다 유저일 경우 어떤 패를 선택할지 결정할 객체 참조 변수
	public String ComPeChoice;			// 컴퓨터가 3장 섯다 유저와 게임 하는 경우 어떤 패를 선택할 지 결정할 객체 참조 변수
	
	Random r = new Random();
	
	public gameManager()
	{	// 광땡 족보
		jokbo.put("3광8광", 1); jokbo.put("8광3광", 1);
		jokbo.put("1광3광", 2); jokbo.put("3광1광", 2); jokbo.put("1광8광", 2); jokbo.put("8광1광", 2);
		// 땡 족보
		jokbo.put("1010", 3);
		jokbo.put("99", 4);
		jokbo.put("8광8", 5); jokbo.put("88광",5); jokbo.put("88", 5);
		jokbo.put("77", 6);
		jokbo.put("66", 7);
		jokbo.put("55", 8);
		jokbo.put("44", 9);
		jokbo.put("3광3", 10); jokbo.put("33광", 10); jokbo.put("33", 10);
		jokbo.put("22", 11);
		jokbo.put("1광1", 12); jokbo.put("11광", 12);jokbo.put("11", 12);
		//알리
		jokbo.put("1광2", 13); jokbo.put("12", 13); 
		//독사
		jokbo.put("1광4", 14);  jokbo.put("14", 14);
		//구삥
		jokbo.put("1광9", 15);  jokbo.put("19", 15);
		//장삥
		jokbo.put("1광10", 16); jokbo.put("110", 16); 
		//장사
		jokbo.put("410", 17);
		//세륙
		jokbo.put("46", 18);
		//갑오
		jokbo.put("1광8", 19); jokbo.put("81광", 19); jokbo.put("18", 19); jokbo.put("81", 19); jokbo.put("8광1", 19); jokbo.put("18광", 19);
		jokbo.put("27", 19); jokbo.put("72", 19);
		jokbo.put("3광6", 19); jokbo.put("63광", 19); jokbo.put("36", 19); jokbo.put("63", 19);
		jokbo.put("45", 19); jokbo.put("54", 19);
		
		jokbo.put("109", 19); jokbo.put("910", 19);
		//8끗
		jokbo.put("1광7", 20); jokbo.put("71광", 20); jokbo.put("17", 20); jokbo.put("71", 20);
		jokbo.put("26", 20); jokbo.put("62", 20);
		jokbo.put("3광5", 20); jokbo.put("53광", 20); jokbo.put("35", 20); jokbo.put("53", 20);
		
		jokbo.put("8광10", 20); jokbo.put("108광", 20); jokbo.put("108", 20); jokbo.put("810", 20);
		//7끗
		jokbo.put("1광6", 21); jokbo.put("61광", 21); jokbo.put("16", 21); jokbo.put("61", 21);
		jokbo.put("25", 21); jokbo.put("52", 21);
		jokbo.put("3광4", 21); jokbo.put("43광", 21); jokbo.put("34", 21); jokbo.put("43", 21);
		
		jokbo.put("8광9", 21); jokbo.put("98광", 21); jokbo.put("98", 21); jokbo.put("89", 21);
		jokbo.put("710", 21); jokbo.put("107", 21);
		//6끗
		jokbo.put("1광5", 22); jokbo.put("51광", 22); jokbo.put("15", 22); jokbo.put("51", 22);
		jokbo.put("24", 22); jokbo.put("42", 22);
		
		jokbo.put("79", 22); jokbo.put("97", 22);
		jokbo.put("610", 22); jokbo.put("106", 22);
		//5끗
		jokbo.put("41광", 23);  jokbo.put("41", 23);
		jokbo.put("23", 23);  jokbo.put("32", 23); jokbo.put("3광2", 23); jokbo.put("23광", 23);
		
		jokbo.put("78광", 23); jokbo.put("8광7", 23); jokbo.put("78", 23); jokbo.put("87", 23);
		jokbo.put("69", 23); jokbo.put("96", 23);
		jokbo.put("510", 23); jokbo.put("105", 23);
		//4끗
		jokbo.put("1광3", 24); jokbo.put("31광", 24); jokbo.put("13", 24); jokbo.put("31", 24); 
		jokbo.put("3광1", 24); jokbo.put("13광", 24);
		
		jokbo.put("8광6", 24); jokbo.put("68광", 24); jokbo.put("86", 24); jokbo.put("68", 24);
		jokbo.put("95", 24); jokbo.put("59", 24);
		jokbo.put("104", 24);
		//3끗
		jokbo.put("1광2", 25); jokbo.put("21광", 25); jokbo.put("12", 25); jokbo.put("21", 25);
		
		jokbo.put("76", 25); jokbo.put("67", 25);
		jokbo.put("8광5", 25); jokbo.put("58광", 25); jokbo.put("85", 25); jokbo.put("58", 25);
		jokbo.put("103광", 25); jokbo.put("3광10", 25); jokbo.put("103", 25); jokbo.put("310", 25);
		//2끗
		jokbo.put("75", 26); jokbo.put("57", 26);
		jokbo.put("8광4", 26); jokbo.put("48광", 26); jokbo.put("84", 26); jokbo.put("48", 26);
		jokbo.put("93광", 26); jokbo.put("3광9", 26); jokbo.put("93", 26); jokbo.put("39", 26);
		jokbo.put("102", 26); jokbo.put("210", 26);
		//1끗
		jokbo.put("56", 27); jokbo.put("65", 27); 
		jokbo.put("47", 27); jokbo.put("74", 27); 
		jokbo.put("38", 27); jokbo.put("83", 27); jokbo.put("3광8", 27); jokbo.put("83광", 27); 
		jokbo.put("38광", 27); jokbo.put("8광3", 27);
		jokbo.put("92", 27); jokbo.put("29", 27); 
		jokbo.put("101", 27); jokbo.put("101광", 27); 
		//망통
		jokbo.put("64", 28); 
		jokbo.put("73", 28); jokbo.put("37", 28); jokbo.put("73광", 28); jokbo.put("3광7", 28); 
		jokbo.put("82", 28); jokbo.put("28", 28); jokbo.put("8광2", 28); jokbo.put("28광", 28);  
		jokbo.put("91", 28); jokbo.put("91광", 28); 
		//구사 : 게임 재시작
		jokbo.put("49", 29); jokbo.put("94", 29); 
	}
	
	public boolean Compare(User loginUser, computer computer) throws InterruptedException		// 패 비교 메소드
	{
		if(loginUser instanceof moneyUser)								// 2장 섯다 유저일 경우
		{
			System.out.println("잠시만 기다려주세요..\n");
			Thread.sleep(2000);
			
			Upe = loginUser.getLeftPe() + loginUser.getRightPe();		// 유저의 패를 합친다.
			Cpe = computer.getLeftPe() + computer.getRightPe();			// 컴퓨터의 패를 합친다.
			
			Upoint = jokbo.get(Upe);									// 유저의 패를 key로 해쉬맵에서 대응되는 value 값을 찾아 반환하여 저장
			Cpoint = jokbo.get(Cpe);									// 컴퓨터의 패를 key로 해쉬맵에서 대응되는 value 값을 찾아 반환하여 저장
			
			System.out.println("패를 비교합니다.\n");
			System.out.println("내 패 : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
							  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
		}
		
		else														// 3장 섯다 유저일 경우
		{
			System.out.print("제시할 패를 선택해주세요\n");
			System.out.print("1. " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() + "\n"
							+"2. " + ((chipUser)loginUser).getMeddlePe() + " " + loginUser.getRightPe() + "\n"
							+"3. " + loginUser.getLeftPe()+" "+loginUser.getRightPe() + "\n");
			System.out.print("choice ==> ");
			UserPeChoice = sc.next();
			System.out.println();
			
			System.out.println("잠시만 기다려주세요..\n");
			Thread.sleep(2000);
			
			switch(UserPeChoice)													
			{
				case "1" : 														//왼쪽패와 중간패를 선택했을 경우
					Upe = loginUser.getLeftPe() + ((chipUser)loginUser).getMeddlePe();	
					
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
						switch(ComPeChoice)
						{
							case "1" :
								Cpe = computer.getLeftPe() + computer.getMeddlePe();

								System.out.println("패를 비교합니다.\n");
								System.out.println("내 패 : " +  loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  " 
												  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
								break;
								
							case "2" :
								Cpe = computer.getMeddlePe() + computer.getRightPe();

								System.out.println("패를 비교합니다.\n");
								System.out.println("내 패 : " + loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  "
												  +"컴퓨터의 패  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");
								break;
								
							case "3" :
								Cpe = computer.getLeftPe() + computer.getRightPe();	
								
								System.out.println("패를 비교합니다.\n");
								System.out.println("내 패 : " + loginUser.getLeftPe()+" "+((chipUser)loginUser).getMeddlePe() + "  "
												  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
								break;
						}
						
					Upoint = jokbo.get(Upe);									
					Cpoint = jokbo.get(Cpe);									
					break;
				
				case "2" : 														//중간패와 오른쪽패를 선택했을 경우
					Upe = ((chipUser)loginUser).getMeddlePe() + loginUser.getRightPe();		
					
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
					switch(ComPeChoice)
					{
						case "1" :
							Cpe = computer.getLeftPe() + computer.getMeddlePe();
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
							break;
							
						case "2" :
							Cpe = computer.getMeddlePe() + computer.getRightPe();
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");	
							break;
							
						case "3" :
							Cpe = computer.getLeftPe() + computer.getRightPe();
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  ((chipUser)loginUser).getMeddlePe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
							break;
					}		
					Cpoint = jokbo.get(Cpe);
					Upoint = jokbo.get(Upe);									
									
					break;
				
				case "3" : 														//왼쪽패와 오른쪽패를 선택했을 경우
					Upe = loginUser.getLeftPe() + loginUser.getRightPe();		
					ComPeChoice = String.valueOf((r.nextInt(3)+1));
					switch(ComPeChoice)
					{
						case "1" :
							Cpe = computer.getLeftPe() + computer.getMeddlePe();
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getMeddlePe() + "\n");
							break;
							
						case "2" :
							Cpe = computer.getMeddlePe() + computer.getRightPe();	
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getMeddlePe()+" "+computer.getRightPe() + "\n");
							break;
							
						case "3" :
							Cpe = computer.getLeftPe() + computer.getRightPe();	
							
							System.out.println("패를 비교합니다.\n");
							System.out.println("내 패 : " +  loginUser.getLeftPe()+" "+loginUser.getRightPe() + "  " 
											  +"컴퓨터의 패  : " + computer.getLeftPe()+" "+computer.getRightPe() + "\n");
							break;
					}		
					
					Upoint = jokbo.get(Upe);									
					Cpoint = jokbo.get(Cpe);									
					break;		
			}
		}
		
		if(Upoint < Cpoint)											// 값이 낮은 사람이 이기므로 유저의 승
		{
			System.out.println("축하합니다. 승리하셨습니다.\n");
			
			if(loginUser instanceof moneyUser)
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() + cnt);	
				System.out.println("현재 잔액 : " + ((moneyUser)loginUser).getMoney() + "\n");
				return true;
			}
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() + cnt);
				System.out.println("현재 잔액 : " + ((chipUser)loginUser).getChip() + "\n");
				return true;
			}	
		}
		else if (Upoint > Cpoint)									// 컴퓨터의 승
		{
			System.out.println("안타깝네요... 패배하였습니다 \n");
			computer.setCmoney(computer.getCmoney() + cnt);
			System.out.println("컴퓨터 잔액 : " + computer.getCmoney());
			
			if(loginUser instanceof moneyUser)
			{
				System.out.println("현재 잔액 : " + ((moneyUser)loginUser).getMoney() + "\n");
				return true;
			}
			
			else
			{
				System.out.println("현재 잔액 : " + ((chipUser)loginUser).getChip() + "\n");
				return true;
			}
		}
		
		if(Upoint == Cpoint || Upoint==29 || Cpoint==29)			// 패가 같거나 유저나 컴퓨터가 구사패가 나왔을 경우.
		{
			if(Upoint == Cpoint)
				System.out.println("패가 같습니다. 재경기를 시작합니다.\n");
			
			else if(Upoint==29 || Cpoint==29)
				System.out.println("구사패 !! 재경기를 시작합니다.\n");
			
			return false;
		}
		return true;
	}
	
	public void userHalf(User loginUser)		// 유저 하프  함수
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < cnt)
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((moneyUser)loginUser).getMoney());
	
			else 
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - cnt);
				cnt *=2;
				System.out.println("하프!  " +"나의 잔액 : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < cnt)
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((chipUser)loginUser).getChip());
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - cnt);
				cnt *=2;
				System.out.println("하프!  " +"나의 잔액 : " + ((chipUser)loginUser).getChip());
			}
		}
	}
	
	public void userCall(User loginUser)	  // 유저 콜  함수
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < (cnt/2))
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((moneyUser)loginUser).getMoney());
			
			else
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - (cnt/2));
				cnt = cnt + (cnt/2);
				System.out.println("콜!  " +"나의 잔액 : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < (cnt/2))
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((chipUser)loginUser).getChip());
			
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - (cnt/2));
				cnt = cnt + (cnt/2);
				System.out.println("콜!  " +"나의 잔액 : " + ((chipUser)loginUser).getChip());	
			}
		}
	}
	
	public void userBeing(User loginUser)	  // 유저 삥  함수
	{
		if(loginUser instanceof moneyUser)
		{ 
			if(((moneyUser)loginUser).getMoney() < 500)
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((moneyUser)loginUser).getMoney());
			
			else
			{
				((moneyUser)loginUser).setMoney(((moneyUser)loginUser).getMoney() - 500);
				cnt+=500;
				System.out.println("삥!  " +"나의 잔액 : " + ((moneyUser)loginUser).getMoney());
			}
		}
		
		else
		{
			if(((chipUser)loginUser).getChip() < 500)
				System.out.println("배팅할 돈이 부족합니다. 나의 잔액 : " + ((chipUser)loginUser).getChip());
			else
			{
				((chipUser)loginUser).setChip(((chipUser)loginUser).getChip() - 500);
				cnt+=500;
				System.out.println("삥!  " +"나의 잔액 : " + ((chipUser)loginUser).getChip());	
			}
		}
	}
	
	public void userDie(User loginUser, computer computer)		//유저 다이 함수
	{
		System.out.println("다이.. 컴퓨터가 승리하였습니다.\n");
		System.out.println("컴퓨터의 패 : " + computer.getLeftPe() +" "+computer.getRightPe() + "\n");
		computer.setCmoney(computer.getCmoney() + cnt);
		System.out.println("컴퓨터 잔액 : " + computer.getCmoney() + "\n");
	}
	
	public void comHalf(computer computer)		// 컴퓨터 하프  함수
	{
		if(computer.getCmoney() < cnt)
			System.out.println("컴퓨터의 배팅할 돈이 부족합니다.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-cnt);
			cnt *=2;
			System.out.println();
			System.out.println("하프!");
		}
	}
	
	public void comCall(computer computer)	  // 컴퓨터 콜  함수
	{
		if(computer.getCmoney() < (cnt/2))
			System.out.println("컴퓨터의 배팅할 돈이 부족합니다.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-(cnt/2));
			cnt = cnt + (cnt/2);
			System.out.println();
			System.out.println("콜!");  
		}
	}
	
	public void comBeing(computer computer)	  // 컴퓨터 삥  함수
	{
		if(computer.getCmoney() < (cnt/2))
			System.out.println("컴퓨터의 배팅할 돈이 부족합니다.\n");
		else
		{
			computer.setCmoney(computer.getCmoney()-500);
			cnt += 500;
			System.out.println();
			System.out.println("삥!");  
		}
	}
}
