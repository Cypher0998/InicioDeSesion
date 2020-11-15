package dad.InicioDeSesion.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane{
	TextField usuario;
	PasswordField contraseña;
	Button acceder, cancelar;
	HBox abajo;
	Alert exito,error;
	public View(){
		usuario=new TextField();
		usuario.setPromptText("Usuario");
		contraseña=new PasswordField();
		contraseña.setPromptText("Contraseña");
		acceder=new Button("Acceder");
		acceder.setDefaultButton(true);
		cancelar= new Button("Cancelar");
		
		//Parte abajo
		abajo=new HBox();
		abajo.setSpacing(10);
		abajo.setAlignment(Pos.CENTER);
		abajo.setPadding(new Insets(5));
		abajo.getChildren().addAll(acceder,cancelar);
		
		//GridPane
		this.setPadding(new Insets(15));
		this.setHgap(35);
		this.setVgap(15);
		this.setAlignment(Pos.CENTER);
		this.addRow(0, new Label("Usuario: "),usuario);
		this.addRow(1,new Label("Contraseña: "),contraseña);
		this.addRow(2, abajo);
		
		GridPane.setColumnSpan(abajo, 3);
		
		//Alerta de Éxito
		exito=new Alert(AlertType.INFORMATION);
		exito.setTitle("Iniciar Sesión");
		exito.setHeaderText("Acceso Permitido");
		exito.setContentText("Los datos de acceso son válidos.");
		
		//Alerta de Error
		error=new Alert(AlertType.ERROR);
		error.setTitle("Iniciar Sesión");
		error.setHeaderText("Acceso Denegado");
		error.setContentText("El usuario y/o la contraseña no son válidos.");
	}
	public TextField getUsuario() {
		return usuario;
	}
	public void setUsuario(TextField usuario) {
		this.usuario = usuario;
	}
	public PasswordField getContraseña() {
		return contraseña;
	}
	public void setContraseña(PasswordField contraseña) {
		this.contraseña = contraseña;
	}
	public Button getAcceder() {
		return acceder;
	}
	public void setAcceder(Button acceder) {
		this.acceder = acceder;
	}
	public Button getCancelar() {
		return cancelar;
	}
	public void setCancelar(Button cancelar) {
		this.cancelar = cancelar;
	}
	public HBox getAbajo() {
		return abajo;
	}
	public void setAbajo(HBox abajo) {
		this.abajo = abajo;
	}
	public Alert getExito() {
		return exito;
	}
	public void setExito(Alert exito) {
		this.exito = exito;
	}
	public Alert getError() {
		return error;
	}
	public void setError(Alert error) {
		this.error = error;
	}

}
