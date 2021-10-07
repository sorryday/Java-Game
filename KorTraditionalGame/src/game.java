import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public interface game //게임의 내용을 담은 interface, 1페이즈와 2페이즈
{
	default public void gameMain(User loginUser,computer computer) throws InterruptedException // 현재 로그인한 유저의 객체와 computer객체로 게임을 진행한다.
	{
		gameManager gamemanager = new gameManager();	 	//gameManager의 메소드를 사용하기 위한 객체
		Scanner sc = new Scanner(System.in);
		Random r = new Random();						//컴퓨터의 선택을 위한 랜덤 클래스
		
		boolean reGame;									// 패가 같거나 구사패가 나왔을 경우 판단해주는 변수
		String reStart;									// 게임이 다 끝난 후 새 게임 의사를 묻는 객체 참조변수
		
		System.out.println();
		System.out.println("\t게임 시작 !!\n");
		System.out.println("\t패를 돌립니다.\n");
		System.out.println("\t<1 페이즈>\n");
		System.out.println("현재 판돈 : " + gamemanager.cnt + "\n");
		
		//1페이즈
		if(loginUser instanceof moneyUser)							//2장 섯다 유저의 경우, 처음에 왼쪽 패만 받는다.
		{
			Collections.shuffle(Arrays.asList(gamemanager.pe));		// gamemanager의 pe배열의 원소들을 무작위로 섞는 collection클래스의 메소드
			
			computer.setLeftPe(gamemanager.pe[0]);					// 무작위로 섞은 배열에서 0번째 인덱스의 값을 뽑아서 패에 넣는다.	
			loginUser.setLeftPe(gamemanager.pe[1]);
		}
		else 
		{
			Collections.shuffle(Arrays.asList(gamemanager.pe));		//3장 섯다 유저의 경우, 처음에 왼쪽 패와 중간패를 받는다.
			computer.setLeftPe(gamemanager.pe[0]);	
			computer.setMeddlePe(gamemanager.pe[1]);	
			
			((chipUser)loginUser).setLeftPe(gamemanager.pe[2]);	
			((chipUser)loginUser).setMeddlePe(gamemanager.pe[3]);
		}
		
		while(true)
		{
			if(loginUser instanceof moneyUser)
				System.out.println("패 : " + loginUser.getLeftPe() +"\n");			//뽑은 패를 확인한다 : 2장 섯다 유저
				
			else																	//뽑은 패를 확인한다 : 3장 섯다.
				System.out.println("패 : " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() +"\n");
			
			System.out.println("컴퓨터의 패 : " + computer.getLeftPe() + "\n");
			System.out.println("선택해주세요 : 하프(1) , 콜(2)");
			System.out.print("choice ==> ");
			String userIn = sc.next();					// 유저 선택 변수 
			System.out.println();
			
			switch(userIn) // 1페이즈에서는 다이가 없음.
			{
				case "1" :
					gamemanager.userHalf(loginUser);					//유저 하프 
					System.out.println("현재 판돈 : " + gamemanager.cnt + "\n");
					break;
				
				case "2" :
					gamemanager.userCall(loginUser);					//유저 콜 
					System.out.println("현재 판돈 : " + gamemanager.cnt + "\n");
					break;
					
				default :
					System.out.println("다시선택해주세요");
					break;
			}
			
			String comIn = String.valueOf((r.nextInt(2)+1));		// 1~2부터 랜덤하게 하나를 뽑아 컴퓨터의 선택 객체 변수에 담는다.
			System.out.print("컴퓨터의 선택");
			switch(comIn)
			{
				case "1" :
					gamemanager.comHalf(computer);					//컴퓨터 하프
					System.out.println("현재 판돈 : "+ gamemanager.cnt + "\n");
					break;
				
				case "2" :
					gamemanager.comCall(computer);					//컴퓨터 콜 
					System.out.println("현재 판돈 : " + gamemanager.cnt + "\n");
					break;
			}
			
			if (userIn.equals("2") && comIn.equals("2"))				// 둘다 콜이 나올 경우
				break;
		}//while
		
		// 2페이즈 시작
		System.out.println("\t<2 페이즈>\n"); 
		
		computer.setRightPe(gamemanager.pe[4]);					
		loginUser.setRightPe(gamemanager.pe[5]);
		
		while(true)
		{
			if(loginUser instanceof moneyUser)
				System.out.println("패 : " + loginUser.getLeftPe() + " "+ loginUser.getRightPe()+"\n");			//뽑은 패를 전부 확인한다.
			
			else 
				System.out.println("패 : " + loginUser.getLeftPe() + " " + ((chipUser)loginUser).getMeddlePe() +" "+ loginUser.getRightPe()+"\n");	
			
			System.out.println("컴퓨터의 패 : " + computer.getLeftPe() + "\n");
			System.out.println("선택해주세요 : 하프(1), 콜(2), 삥(3), 다이(4)");
			System.out.print("choice ==> ");
			String userIn = sc.next();					// 유저 선택 변수 
			System.out.println();
			
			switch(userIn) 
			{
				case "1" :
					gamemanager.userHalf(loginUser);					//유저 하프 
					System.out.println("현재 판돈 : " + gamemanager.cnt);
					break;
				
				case "2" :
					gamemanager.userCall(loginUser);					//유저 콜 
					System.out.println("현재 판돈 : " + gamemanager.cnt);
					break;
				
				case "3" :
					gamemanager.userBeing(loginUser);					//유저 삥
					System.out.println("현재 판돈 : " + gamemanager.cnt);
					break;
					
				case "4" :
					gamemanager.userDie(loginUser,computer);			//유저 다이, 다이를 누르면 바로 패 비교하는 메소드로 넘어간다.
					return;
					
				default :
					System.out.println("다시선택해주세요");
					break;
			}
			
			String comIn = String.valueOf((r.nextInt(3)+1));		// 1~3부터 랜덤하게 하나를 뽑아 컴퓨터의 선택 객체 변수에 담는다.
			System.out.println();
			System.out.print("컴퓨터의 선택");
			switch(comIn)											// 컴퓨터는 자체적으로 다이할 수 없게 설계
			{
				case "1" :
					gamemanager.comHalf(computer);					//컴퓨터 하프
					System.out.println("현재 판돈 : "+ gamemanager.cnt+ "\n");
					break;
				
				case "2" :
					gamemanager.comCall(computer);					//컴퓨터 콜 
					System.out.println("현재 판돈 : " + gamemanager.cnt + "\n");
					break;
					
				case "3" :
					gamemanager.comBeing(computer);					//컴퓨터 삥
					System.out.println("현재 판돈 : " + gamemanager.cnt+ "\n");
					break;
			}
			
			if (userIn.equals("2") && comIn.equals("2"))  					// 둘다 콜이 나올 경우 
			{
				reGame = gamemanager.Compare(loginUser,computer);			//User와 computer가 둘 다 콜을 눌렀을 때 패 비교하는 메소드로 넘어간다.
			
				if(reGame == false && loginUser instanceof moneyUser)		// 구사패나 패가 동일할 경우 재경기를 시작한다.(2장 섯다)
				{
					Collections.shuffle(Arrays.asList(gamemanager.pe));		
					computer.setLeftPe(gamemanager.pe[0]);					
					loginUser.setLeftPe(gamemanager.pe[1]);
					
					computer.setRightPe(gamemanager.pe[2]);					
					loginUser.setRightPe(gamemanager.pe[3]);
				
					gamemanager.Compare(loginUser,computer);
				}
				
				else if(reGame == false && loginUser instanceof chipUser)	// 구사패나 패가 동일할 경우 재경기를 시작한다.(3장 섯다)
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
		
		System.out.println("새 게임을 시작하시겠습니까? (yes : y , no :n)");
		System.out.print("choice ==> ");
		reStart = sc.next();
		
		if(reStart.equals("y"))
		{
			if(loginUser instanceof moneyUser && ((moneyUser)loginUser).getMoney()>=100000)
				gameMain(loginUser,computer);
			
			else if(loginUser instanceof chipUser && ((chipUser)loginUser).getChip()>=100000)
				gameMain(loginUser,computer);
			
			else
				System.out.println("money 혹은 chip이 부족하여 게임을 시작할 수 없습니다. 메인 페이지로 이동합니다.\n");
		}
		else
			System.out.println("감사합니다.\n");
	}
}
