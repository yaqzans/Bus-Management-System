package Account;
import java.lang.*;
import java.io.*; 
import java.util.*; 

public class Account
{
	private String user;
	private String pass;
	private File file;
	private FileWriter fwriter; 
	private Scanner sc; 

	public Account() { }
	public Account(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}
	public void setUser(String user) { this.user = user; }
	public void setPass(String pass) { this.pass = pass; }
	public String getUser() { return this.user; }
	public String getPass() { return this.pass; }

	public void addAccount() 
	{
		try 
		{
			file = new File("./data.txt"); 
			file.createNewFile(); 
			fwriter = new FileWriter(file,true);
			fwriter.write(getUser()+"\t");
			fwriter.write(getPass()+"\n");
			fwriter.flush();
			fwriter.close();
		}
		catch(IOException ioe) 
		{

			ioe.printStackTrace(); 
		}
	}

	public boolean checkAccount(String user)
	{
		boolean flag = false;
		file = new File("./data.txt");
		try 
		{
			sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				if(value[0].equals(user))
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
	public boolean validAccount(String user, String pass)
	{
		boolean flag = false;
		file = new File("./data.txt");
		try 
		{
			sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				if(value[0].equals(user) && value[1].equals(pass))
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