import java.io.Serializable;

public class computer implements Serializable				//������ �ϱ� ���� ��ǻ�� ��ü
								  					//��ǻ�� ��ü�� �����ϴ� ����� ������ ������ �����ϸ� ��ü�� �ҷ��ͼ� ���� �α����� ������ ������ �Ѵ�.
{
	private int cmoney = 2000000000;  			 // ��ǻ�Ͱ� ������ �ִ� ��, ��ǻ�ʹ� �������� �����Ƿ� ������ ������ �� ���� �� ���� ������ ����Ѵ�.
	private String leftPe;						 // ��ǻ�� ������ ���� ��
	private String meddlePe;					 // ��ǻ�� ������ �߰� ��	
	private String rightPe;						 // ��ǻ�� ������ ��������
		
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
