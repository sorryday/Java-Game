import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class computerManager // 컴퓨터 객체를 파일로 저장하는 기능을 담당.
{
	private computer computer;
	private String filename; // 컴퓨터 객체 파일의 이름을 저장할 객체
	
	public computerManager(computer computer)
	{
		this.computer=computer;
	}
	
	public void setObjectFile(String filename)
	{
		this.filename=filename;     
	}
	
	public void saveComputer() //computer 객체를 파일에 저장
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
