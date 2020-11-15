package dad.InicioDeSesion.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import dad.InicioDeSesion.model.Model;
import dad.InicioDeSesion.view.View;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;

public class Controller {
	Model modelo=new Model();
	View vista= new View();
	ArrayList<String>lista=new ArrayList<>();
	BufferedReader csvReader;
	
	public Controller() {
		Bindings.bindBidirectional(vista.getUsuario().textProperty(),modelo.UsuarioProp());
		vista.getAcceder().setOnAction(e -> onAccederButtonAction(e));
		vista.getCancelar().setOnAction(e -> onCancelarButtonAction(e));
		
		//Carga csv
		try {
			String linea;
			csvReader= new BufferedReader(new FileReader("users.csv",Charset.forName("UTF-8")));
			while ((linea=csvReader.readLine())!=null)
				lista.add(linea);
			 csvReader.close();
		}
		catch(IOException e) {
			
		}
	}

	private void onAccederButtonAction(ActionEvent a) {
		try {
			if (compruebaUsuarios())
				vista.getExito().showAndWait();
			else
				vista.getError().showAndWait();
		}
		catch(Exception e){
			
		}
	}

	private boolean compruebaUsuarios() throws IOException {
		Boolean comprobado=false;
		String contraseñaIntroducida=DigestUtils.md5Hex(vista.getContraseña().textProperty().get()).toUpperCase();
		
		for(int i = 0; i< lista.size();i++) {
			String[] datos= lista.get(i).split(",");
			String usuario=datos[0];
			String contraseña= datos[1];
			
			if (usuario.equals(modelo.getUsuario()) && contraseña.equals(contraseñaIntroducida)) {
				comprobado=true;
				break;
			}
		}
		return comprobado;
	}

	private void onCancelarButtonAction(ActionEvent e) {
		Platform.exit();
	}
	public View getView() {
		return this.vista;
	}
}
