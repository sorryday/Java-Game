import java.io.Serializable;

public abstract class User implements Serializable,game
{
	private String Name,Id,Password;
	private String leftPe;						 // ������ ���� ��
	private String rightPe;						 // ������ ������ ��
	
	public abstract boolean check(); // ���ӿ� ������ �� ���� �����ִ� �� Ȥ�� Ĩ�� Ȯ����. �����ִٸ� true, ���ٸ� false�� ��ȯ��.
	public abstract int charge(int wallet); // �� Ȥ�� chip�� �����մϴ�.

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
