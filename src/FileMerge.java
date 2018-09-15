import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileMerge fR = new FileMerge();
		
		String filename = "/Work/java/Practice_LinkedList/MergeFiles/Input/File1.txt";
        String filename2 = "/Work/java/Practice_LinkedList/MergeFiles/Input/File2.txt";
        List <String> al = new ArrayList<String>();
        List <String> al1 = new ArrayList<String>();
        List <String> diff1 = new ArrayList<String>();
        List <String> diff2 = new ArrayList<String>();
        String str = null;
        String str2 = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((str = in.readLine()) != null) {
                al.add("--"+str);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename2));
            while ((str2 = in.readLine()) != null) {
                al1.add(str2);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String str3 : al) {
            if (!al.contains(str3)) {
                diff1.add(str3);
            }
            else {
            	System.out.println("i am commmented out in file2");
            	fR.writeToFile(str3);
            }
        }
        for (String str5 : al1) {
            if (!al.contains(str5)) {
                diff2.add(str5);
            }
        }
        for (String str4 : diff1) {
            System.out.println("Removed Path: "+str4);
        }
        for (String str4 : diff2) {
            System.out.println("Added Path: "+str4);
            fR.writeToFile(str4);
        }

        
        

    }

	public void writeToFile(String str) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			str=str.replaceAll("--","");
			String content = str+"\n";

			File file = new File("/Work/java/Practice_LinkedList/MergeFiles/Input/Merged.txt");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

	}
	
	
	}}


