import java.io.Serializable;

public class computer implements Serializable				//게임을 하기 위한 컴퓨터 객체
								  					//컴퓨터 객체는 저장하는 기능이 없으며 게임을 실행하면 객체를 불러와서 현재 로그인한 유저와 게임을 한다.
{
	private int cmoney = 2000000000;  			 // 컴퓨터가 가지고 있는 돈, 컴퓨터는 저장하지 않으므로 게임을 실행할 때 마다 이 값을 가지고 사용한다.
	private String leftPe;						 // 컴퓨터 유저의 왼쪽 패
	private String meddlePe;					 // 컴퓨터 유저의 중간 패	
	private String rightPe;						 // 컴퓨터 유저의 오른쪽패
		
	public int getCmoney() {
		return cmoney;
	}
	
	public void setCmoney(int cmoney) {
		this.cmoney = cmoney;
	}

	public String getLeftPe() {
		return leftPe;
	}

	public void setLeftPe(String leftpe) {
		this.leftPe = leftpe;
	}
	
	public String getMeddlePe() {
		return meddlePe;
	}

	public void setMeddlePe(String meddlePe) {
		this.meddlePe = meddlePe;
	}

	public String getRightPe() {
		return rightPe;
	}

	public void setRightPe(String rightPe) {
		this.rightPe = rightPe;
	}
}
