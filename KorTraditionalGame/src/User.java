import java.io.Serializable;

public abstract class User implements Serializable,game
{
	private String Name,Id,Password;
	private String leftPe;						 // 섯다의 왼쪽 패
	private String rightPe;						 // 섯다의 오른쪽 패
	
	public abstract boolean check(); // 게임에 입장할 때 현재 남아있는 돈 혹은 칩을 확인함. 남아있다면 true, 없다면 false를 반환함.
	public abstract int charge(int wallet); // 돈 혹은 chip을 충전합니다.

	public User(String Name,String Id, String Password)
	{
		this.Id = Id;
		this.Password = Password;
		this.Name=Name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getLeftPe() {
		return leftPe;
	}
	public void setLeftPe(String leftPe) {
		this.leftPe = leftPe;
	}
	public String getRightPe() {
		return rightPe;
	}
	public void setRightPe(String rightPe) {
		this.rightPe = rightPe;
	}	
}
