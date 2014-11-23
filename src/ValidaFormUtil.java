import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ValidaFormUtil {
	
	JFrame frame;
	
	public ValidaFormUtil(JFrame frame) {
		this.frame = frame;
	}

	public boolean validaCampos(String... paths){
		for (int i = 0; i < paths.length; i++) {
			if(!this.validaPath(paths[i])){
				return false;
			}
		}
		return true;
	}
	
	private boolean validaPath(String path){
		if(path == null || path.equals("")){
			JOptionPane.showMessageDialog(frame,
					"Favor informar todos os campos",
					"Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/**	Método que verifica se o arquivo está no formato REL **/
	public boolean validaFileREL(File fileREL) {
		if (fileREL.getName().toLowerCase().endsWith(".rel")){
			return true;
		}
		return false;
	}

	/** Método que verifica se a lista dos arquivos está no formato REL **/
	public boolean validaListaFileREL(List<File> listFileREL) {
		for (File fileREL : listFileREL) {
			if (fileREL.getName().toLowerCase().endsWith(".rel")) {
				return true;
			}
		}

		return false;
	}
}
