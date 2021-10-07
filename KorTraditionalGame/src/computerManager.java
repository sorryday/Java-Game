import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class computerManager // ��ǻ�� ��ü�� ���Ϸ� �����ϴ� ����� ���.
{
	private computer computer;
	private String filename; // ��ǻ�� ��ü ������ �̸��� ������ ��ü
	
	public computerManager(computer computer)
	{
		this.computer=computer;
	}
	
	public void setObjectFile(String filename)
	{
		this.filename=filename;     
	}
	
	public void saveComputer() //computer ��ü�� ���Ͽ� ����
	{
		try {
			FileOutputStream cos = new FileOutputStream(filename);  
			ObjectOutputStream os = new ObjectOutputStream(cos);
			
			os.writeObject(computer);  
			
			os.flush();  
			
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
