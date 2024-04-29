import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class Reverse {

	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream ("input.txt");
		InputStreamReader isr = new InputStreamReader (fis);
		BufferedReader br = new BufferedReader(isr);
		FileOutputStream fos = new FileOutputStream("output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw= new BufferedWriter(osw);
		String data;
		ArrayList<String> strarr = new ArrayList<String>();
		int i = 0;
		while((data = br.readLine())!= null) {
			strarr.add(data);
			i++;
		}
		for( int j = i; j > 0; j--) {
			bw.write(strarr.get(j-1));
			bw.newLine();
		}
		bw.flush();
		bw.close(); osw.close(); fos.close();
		br.close(); isr.close(); fis.close();
	}

}
