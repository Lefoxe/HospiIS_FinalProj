import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.table.DefaultTableModel;
import static java.nio.file.StandardOpenOption.*;

public class Main{
	Login login = new Login();

	Path path = Paths.get("Records.txt");
	Path path2 = Paths.get("Doctors.txt");
	Path path3 = Paths.get("Patients.txt");
	File file = new File("Records.txt");
	File file2 = new File("Doctors.txt");
	File file3 = new File("Patients.txt");

	String l = "";
	String sep = ",";
	String un;
	String pass;
	DefaultTableModel mod =  new DefaultTableModel();;


	public static String verifyFile(File file) throws IOException {

        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }
        br.close();
        in.close();
        return sb.toString();
    }

    public void logme(String a, String b){
    	String content = null;
    	try{
            content = verifyFile(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        boolean found = false;
        boolean ref = false;
        String tempuser = "";
        String temppass = "";
         try{

           Scanner z = new Scanner(new File("Records.txt"));
            z.useDelimiter("[,\n]");

            while (z.hasNext() && !found){
                tempuser = z.next();
                temppass = z.next();


                if(tempuser.trim().equals(a.trim())&& temppass.trim().equals(b.trim())){
                    found = true;
                    login.part2();
                }
            }

            if (ref = !found) {
                login.notfound();

            }
            z.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void editD(String a, String b, String c){
    	String x = path2.toString();
    	String tempFile = "temp.txt";
    	File old = new File(x);
    	File newFile = new File(tempFile);
    	String currentLine;
    	String data[];
    	int position = 0;

    	if(a.equalsIgnoreCase("ID")){
    		position = 0;
    	}

    	else if(a.equalsIgnoreCase("Name")){
    		position = 1;
    	}

    	else if(a.equalsIgnoreCase("Specialization")){
    		position = 2;
    	}

    	try{
    		FileWriter fw = new FileWriter(tempFile, true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter pw = new PrintWriter(bw);

    		FileReader fr = new FileReader(x);
    		BufferedReader br = new BufferedReader(fr);

    		while((currentLine = br.readLine()) != null){
    			data = currentLine.split(",");

    			if(!(data[position].equalsIgnoreCase(b))){
    				pw.println(currentLine);
    			}
    			else if((data[position].equalsIgnoreCase(b))){
    				data[position] = c;
    				StringBuilder build = new StringBuilder();

				    for(String value : data){
				    build.append(value);
				    build.append(sep);
				    }
				    String edited = build.toString();
				    edited = edited.substring(0, edited.length() - sep.length());

				    pw.println(edited);
    			}
    		}

    		pw.flush();
    		pw.close();
    		fr.close();
    		br.close();
    		bw.close();
    		fw.close();

    		old.delete();
    		File dump = new File(x);
    		newFile.renameTo(dump);
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}
    }


    public void editP(String a, String b, String c){
    	String x = path3.toString();
    	String tempFile = "temp.txt";
    	File old = new File(x);
    	File newFile = new File(tempFile);
    	String currentLine;
    	String data[];
    	int position = 0;

    	if(a.equalsIgnoreCase("Name")){
    		position = 0;
    	}

    	else if(a.equalsIgnoreCase("Room No.")){
    		position = 1;
    	}

    	else if(a.equalsIgnoreCase("Ailment")){
    		position = 2;
    	}

    	else if(a.equalsIgnoreCase("Physician")){
    		position = 3;
    	}

    	try{
    		FileWriter fw = new FileWriter(tempFile, true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter pw = new PrintWriter(bw);

    		FileReader fr = new FileReader(x);
    		BufferedReader br = new BufferedReader(fr);

    		while((currentLine = br.readLine()) != null){
    			data = currentLine.split(",");

    			if(!(data[position].equalsIgnoreCase(b))){
    				pw.println(currentLine);
    			}
    			else if((data[position].equalsIgnoreCase(b))){
    				data[position] = c;
    				StringBuilder build = new StringBuilder();

				    for(String value : data){
				    build.append(value);
				    build.append(sep);
				    }
				    String edited = build.toString();
				    edited = edited.substring(0, edited.length() - sep.length());

				    pw.println(edited);
    			}
    		}

    		pw.flush();
    		pw.close();
    		fr.close();
    		br.close();
    		bw.close();
    		fw.close();

    		old.delete();
    		File dump = new File(x);
    		newFile.renameTo(dump);
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}
    }


    public void rmvP(String b){
    	String a = path3.toString();
    	String tempFile = "temp.txt";
    	File old = new File(a);
    	File newFile = new File(tempFile);
    	String currentLine;
    	String data[];
    	int position = 0;

    	try{
    		FileWriter fw = new FileWriter(tempFile, true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter pw = new PrintWriter(bw);

    		FileReader fr = new FileReader(a);
    		BufferedReader br = new BufferedReader(fr);

    		while((currentLine = br.readLine()) != null){
    			data = currentLine.split(",");
    			if(!(data[position].equalsIgnoreCase(b))){
    				pw.println(currentLine);
    			}
    		}

    		pw.flush();
    		pw.close();
    		fr.close();
    		br.close();
    		bw.close();
    		fw.close();

    		old.delete();
    		File dump = new File(a);
    		newFile.renameTo(dump);
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}

    }

    public void rmvD(String b){
    	String a = path2.toString();
    	String tempFile = "temp.txt";
    	File old = new File(a);
    	File newFile = new File(tempFile);
    	String currentLine;
    	String data[];
    	int position = 0;

    	try{
    		FileWriter fw = new FileWriter(tempFile, true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter pw = new PrintWriter(bw);

    		FileReader fr = new FileReader(a);
    		BufferedReader br = new BufferedReader(fr);

    		while((currentLine = br.readLine()) != null){
    			data = currentLine.split(",");
    			if(!(data[position].equalsIgnoreCase(b))){
    				pw.println(currentLine);
    			}
    		}

    		pw.flush();
    		pw.close();
    		fr.close();
    		br.close();
    		bw.close();
    		fw.close();

    		old.delete();
    		File dump = new File(a);
    		newFile.renameTo(dump);
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}

    }

    public DefaultTableModel tebeldoc(){
    	try{
    		BufferedReader br = new BufferedReader(new FileReader(file2));
    		String[] column = {"ID","Name","Specialization"};
    		mod.setColumnIdentifiers(column);

    		Object[] tableLine = br.lines().toArray();

    		for(int i = 0; i < tableLine.length; i++){
    			String line = tableLine[i].toString().trim();
    			String[] dataRow = line.split(",");
    			mod.addRow(dataRow);
    		}
    		br.close();
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}

    	return mod;
    }

    public void update(){
    	mod.fireTableDataChanged();
    	mod.setRowCount(0);
    }

    public DefaultTableModel tebelpat(){
    	try{
    		BufferedReader br = new BufferedReader(new FileReader(file3));
    		String[] column = {"Name","Room No.","Ailment","Physician"};
    		mod = new DefaultTableModel();
    		mod.setColumnIdentifiers(column);

    		Object[] tableLine = br.lines().toArray();

    		for(int i = 0; i < tableLine.length; i++){
    			String line = tableLine[i].toString().trim();
    			String[] dataRow = line.split(",");
    			mod.addRow(dataRow);
    		}
    		br.close();
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}

    	return mod;
    }

    public void DocKwak(String a, String b, String c){
    	try{
    		OutputStream output = new BufferedOutputStream(Files.newOutputStream(path2, CREATE, APPEND));
    		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

    		l = a + sep + b + sep + c;
	        writer.write(l, 0, l.length());
	        writer.newLine();
            writer.close();
            output.close();
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}
    }

    public void Pasyents(String a, String b, String c, String d){
    	try{
    		OutputStream output = new BufferedOutputStream(Files.newOutputStream(path3, CREATE, APPEND));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

        l = a + sep + b + sep + c +sep + d;
        writer.write(l, 0, l.length());
        writer.newLine();
        writer.close();
        output.close();
    	}

    	catch(Exception e){
    		System.out.println(e);
    	}
    }

	public static void main(String[] args){
		Login login = new Login();
		login.activate();
	}
}