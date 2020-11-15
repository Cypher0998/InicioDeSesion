package dad.InicioDeSesion.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Model {
	StringProperty Usuario=new SimpleStringProperty();
	StringProperty Contraseña= new SimpleStringProperty();
	
	public final StringProperty UsuarioProp() {
		return this.Usuario;
	}
	public final String getUsuario() {
		return this.UsuarioProp().get();
	}
	public final void setUsuario(final String Usuario) {
		this.UsuarioProp().set(Usuario);
	}
	public final StringProperty ContraseñaProp() {
		return this.Contraseña;
	}
	public final String getContraseña() {
		return this.ContraseñaProp().get();
	}
	public final void setContraseña(final String Contraseña) {
		this.ContraseñaProp().set(Contraseña);
	}
}
