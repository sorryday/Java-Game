import java.util.Scanner;

public class mainpage implements game  {

	public static void beLoginMenu()		//로그인전 메뉴 화면
	{
		System.out.print(  "1. Login (가입되어있는 아이디로 로그인합니다.)\n" 
						 + "2. Create user (로그인할 아이디와 비밀번호를 만듭니다.)\n"
						 + "3. Delete user (저장되어 있는 회원의 정보를 삭제합니다.)\n"
						 + "4. Finish\n");
		System.out.print("Choic => ");
	}
	
	public static void afLoginMenu()		//로그인 후 메뉴 화면
	{
		System.out.print(  "1. Play game (현재 로그인한 유저로 게임을 시작합니다. 최소 게임 금액 : 100,000원)\n" 
						 + "2. Change user Info(유저의 비밀번호를 변경합니다.)\n"
						 + "3. Get wallet (money user라면 돈을 충전하고 chip 유저라면 chip을 충전합니다)\n"
						 + "4. Save user (게임한 유저의 정보를 저장합니다.)\n"
						 + "5. Logout (로그아웃 합니다.)\n");
		System.out.print("Choic => ");
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc = new Scanner(System.in); // switch문을 실행하기 위한 스캐너 
		
		String Name,Id,Password;  				//이름과 아이디와 패스워드 입력받을 객체참조변수
		String Option;							// 유저의 종류를 판별
		
		userManager manager = userManager.getInstance();  // Manager 객체의 인스턴스
		User loginUser; //현재 로그인한 유저의 객체를 받는 객체 참조변수
		
		computer computer = new computer();					// 유저와 게임할 컴퓨터 객체를 선언
		computerManager comManager = new computerManager(computer);	// 컴퓨터 객체를 관리하는 매니저 객체 선언
		comManager.setObjectFile("computer.obj");
		comManager.saveComputer();  
		
		System.out.println();
		System.out.println("<섯다 게임에 오신걸 환영합니다.>");
		
		while(true)
		{	
			System.out.println();
			beLoginMenu();
			String s1= sc.next();			// switch case를 받을 객체 참조변수
			System.out.println();
			
			if (s1.equals("4")) 
			{
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}//if
			
			switch(s1)
			{
				case "1":  // 로그인하기
					System.out.println("로그인할 아이디와 비밀번호를 입력해주세요.");
					
					System.out.print("아이디 : "); Id = sc.next();			  // 아이디와 패스워드 입력받기
					System.out.print("비밀번호 : "); Password=sc.next();
					
					manager.loadUser(Id);
					loginUser=manager.login(Id,Password); 				  // 로그인하기 위한 함수를 실행하여 로그인한 객체를 받아온다.
					
					if(loginUser==null) 
					{
						 System.out.println("가입되어 있지 않거나 아이디 혹은 비밀번호가 일치하지 않습니다. 다시 입력해주세요");
						 break;					  // 로그인에 실패하면  다시 
					}
					
					else
					{
						manager.setObject(loginUser.getId() + ".obj");	  // 로그인한 사람의 이름으로 저장할 파일명을 설정
						System.out.println();   
						while(true) 
						{						
							if(loginUser instanceof moneyUser)
								System.out.println(loginUser.getName()+"님 환영합니다. " + "2장 섯다 유저 "  
													+ " money : " +((moneyUser)loginUser).getMoney()+ " 메뉴를 선택해주세요 \n");
							else
								System.out.println(loginUser.getName()+"님 환영합니다." + "3장 섯다 유저 " 
													+ " chip : " +((chipUser)loginUser).getChip()+ " 메뉴를 선택해주세요 \n");
							
							afLoginMenu();	//로그인 한 후 다음 화면 출력
							s1=sc.next(); 
							
							if (s1.equals("5")) 		//로그아웃 : 다시 처음 선택화면으로 돌아간다. (beLoginMenu)
							{
								System.out.println();
								System.out.println("로그아웃합니다.");
								break;
							}
							
							switch(s1)
							{
								case "1":
									boolean check = loginUser.check();
									if(check==true)
										{ loginUser.gameMain(loginUser,computer); }	//게임 실행.
									break;
								case "2":				// 비밀번호 변경
									System.out.println();
									System.out.print("변경하고 싶은 비밀번호를 입력하세요 : ");
									Password = sc.next(); 
									manager.changeInfo(loginUser,Password);	// 로그인한 유저의 비밀번호를 변경합니다.
									break;
									
								case "3":							   //유저의 money 혹은 chip을 충전합니다
									manager.getWallet(loginUser);	// 입력한 금액과 현재 로그인한 유저의 객체를 넘긴다.
									break;
									
								case "4":						      //로그인한 유저의 객체를 저장합니다.
									manager.saveUser(loginUser);
									break;
									
								default :
									System.out.println();
									System.out.println("메뉴에 없습니다. 다시 입력해주세요\n");
									break;	
							}//switch
						}//while
					} // else if
					break;
					
				case "2":  // 유저 생성
					
					System.out.println("가입할 회원의 이름과 아이디와 비밀먼호를 입력해주세요");
					
					System.out.print("이름 : "); Name = sc.next(); //이름과 아이디와 패스워드 입력받기		
					System.out.print("아이디 : "); Id = sc.next();
					System.out.print("비밀번호 : "); Password=sc.next();
					
					System.out.print("가입하고 싶은 회원의 종류를 입력해주세요 (1: 2장 섯다 유저, 2: 3장 섯다 유저) ==> ");
					Option = sc.next();							//2장 섯다 유저인지, 3장 섯다 유저인지 선택한 값이 있는 객체
					
					manager.createUser(Name,Id,Password,Option);			//유저를 만들기위한 함수 실행.
					
					break;
					
				case "3":
					System.out.print("삭제할 회원의 Id를 입력해주세요 : ");
					Id = sc.next();
					manager.deleteUser(Id);	// 로그인한 유저를 삭제합니다.
					break ;
					
				default :
					System.out.println("메뉴에 없습니다. 다시 입력해주세요");
			}//switch
		}//while
	}//main
}//mainpage
