import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeradorXLS {
	 
	public static List<File> lista = new ArrayList<File>();

	public String pathDAT;
	public String pathREL;

	public List<File> getListFile(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		try {
			for (File f : files) {
				lista.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public File getFile(String dir) {
		File file = new File(dir);
		return file;
	}
	
	public static String lerArquivo(File file) throws IOException {
		String conteudo = "";
		FileReader reader = new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader buffReader = new BufferedReader(reader);
		while (buffReader.readLine() != null) {
			conteudo += buffReader.readLine()+"\n";
		}
		return conteudo;
	}
	
	public void gerarArquivoREL(File fileREL, File fileDAT, String path, int index) {
		try {
			String arquivo = formataArquivoREL(fileREL, fileDAT, path, index);
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathREL));
			buffWrite.append(arquivo);
			buffWrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	@SuppressWarnings("resource")
	private String formataArquivoREL(File fileREL, File fileDAT, String path, int index) throws IOException {
		
		List<String> rel = new ArrayList<String>();
		List<String> dat = new ArrayList<String>();
		String stringAux = "";
			
		FileReader readerREL = new FileReader(fileREL);
		BufferedReader buffReaderREL = new BufferedReader(readerREL);
		for (int i = 0; i < 9; i++) {
			rel.add(buffReaderREL.readLine());
		}
		stringAux = stringAux.concat(RELReaderUtil.getDadosREL(rel));
		
		FileReader readerDAT = new FileReader(fileDAT);
		BufferedReader buffReaderDAT = new BufferedReader(readerDAT);
		for (int i = 0; i < 9; i++) {
			dat.add(buffReaderDAT.readLine());
		}
		stringAux = stringAux.concat(DATReaderUtil.getDadosDAT(dat));
		
		this.pathREL = path+"/nw-arquivo.xls";
		
		return stringAux;
	}

	
}
