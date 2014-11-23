import java.util.List;


public class RELReaderUtil {
	
	public static String getDadosREL(List<String> rel){
		String dadoREL = "";
		for (int i = 0; i < rel.size(); i++) {
			dadoREL = dadoREL.concat(rel.get(i))+"\n";	
		}
		return dadoREL;
	}

}
