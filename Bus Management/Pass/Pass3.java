package Pass;
import java.lang.*;
import java.io.*; 
import java.util.*; 

public class Pass3
{
	private String seat;
	private File file;
	private FileWriter fwriter; 
	private Scanner sc; 

	public Pass3() { }
	public Pass3(String seat)
	{
		this.seat = seat;
	}
	public void setSeat(String seat) { this.seat = seat; }
	public String getSeat() { return this.seat; }

	public void addSeat() {
		try {
			file = new File("./data3.txt"); 
			file.createNewFile(); 
			fwriter = new FileWriter(file, true);
			fwriter.write(getSeat() + "\n");
			fwriter.flush();
			fwriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
		}
	}

	public boolean checkSeat(String seat) {
		boolean flag = false;
		file = new File("./data3.txt");
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.equals(seat)) {
					flag = true;
					break;
				}
			}
			sc.close(); 
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
		}
		return flag;
	}

	public void removeSeat(String seat) {
		try {
			File inputFile = new File("./data3.txt");
			File tempFile = new File("./temp.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove = seat;
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if (trimmedLine.equals(lineToRemove)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			inputFile.delete();
			tempFile.renameTo(inputFile);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public boolean validPass(String seat)
	{
		boolean flag = false;
		file = new File("./data3.txt");
		try 
		{
			sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				if(value[0].equals(seat))
				{
					flag = true;
				}
			}
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace(); 
		}
		return flag;
	}
}