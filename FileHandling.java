package practice_project_3;
import java.io.*;
import java.util.Scanner;

public class FileHandling {

	public void read()
	{
		try {
	        File Obj = new File("myfile.txt");
	        Scanner Reader = new Scanner(Obj);
	        while (Reader.hasNextLine()) {
	            String data = Reader.nextLine();
	            System.out.println(data);
	        }
	        Reader.close();
	    }
	    catch (FileNotFoundException e) {
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
	    }
	}
	
	public void write()
	{
		try {
			String s;
			System.out.println("Enter text to write");
			Scanner sc = new Scanner(System.in);
			s = sc.nextLine();
	        FileWriter Writer = new FileWriter("myfile.txt");
	        Writer.write(s);
	        Writer.close();
	        System.out.println("Successfully written.");
	    }
	    catch (IOException e) {
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
	    }
	}
	
	public void append()
	{
		try {
		BufferedWriter out = new BufferedWriter(new FileWriter("myfile.txt", true));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text to append");
		String str = sc.nextLine();
        out.write(str);
        out.close();
        System.out.println("Added successfully");
		}
		catch(IOException e) {
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileHandling f = new FileHandling();
		File Obj = new File("myfile.txt");
        if (Obj.createNewFile()) {
            System.out.println("File created: "
                               + Obj.getName());
        }
        else {
            System.out.println("File already exists.");
        }
        
        
        System.out.println("Choose 1 to read, 2 to write or 3 to append" );
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        switch(num)
        {
        case 1:
        	f.read();
        	break;
        	
        case 2:
        	f.write();
        	break;
        	
        case 3:
        	f.append();
        	break;
        	
        default:
        	System.out.println("Invalid option!");
        	
        }


	}

}
