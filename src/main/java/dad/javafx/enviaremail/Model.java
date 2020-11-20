package dad.javafx.enviaremail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty servidorSMTP = new SimpleStringProperty();
	private IntegerProperty puerto = new SimpleIntegerProperty();
	private BooleanProperty SSL = new SimpleBooleanProperty();
	private StringProperty remitente = new SimpleStringProperty();
	private StringProperty contrasena = new SimpleStringProperty();
	private StringProperty destinatario = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	
	//SERVIDOR SMTP/////////////////////////////////////////////////////
	public final StringProperty servidorSMTPProperty() {
		return this.servidorSMTP;
	}
	
	public final String getServidorSMTP() {
		return this.servidorSMTPProperty().get();
	}
	
	public final void setServidorSMTP(final String servidorSMTP) {
		this.servidorSMTPProperty().set(servidorSMTP);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	//PUERTO////////////////////////////////////////////////////////////
	public final IntegerProperty puertoProperty() {
		return this.puerto;
	}
	
	public final int getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final int puerto) {
		this.puertoProperty().set(puerto);
	}
	////////////////////////////////////////////////////////////////////
	
	
	//SSL///////////////////////////////////////////////////////////////
	public final BooleanProperty SSLProperty() {
		return this.SSL;
	}
	
	public final boolean isSSL() {
		return this.SSLProperty().get();
	}
	
	public final void setSSL(final boolean SSL) {
		this.SSLProperty().set(SSL);
	}
	////////////////////////////////////////////////////////////////////
	
	
	//REMITENTE/////////////////////////////////////////////////////////
	public final StringProperty remitenteProperty() {
		return this.remitente;
	}
	
	public final String getRemitente() {
		return this.remitenteProperty().get();
	}
	
	public final void setRemitente(final String remitente) {
		this.remitenteProperty().set(remitente);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	//CONTRASEÑA////////////////////////////////////////////////////////
	public final StringProperty contrasenaProperty() {
		return this.contrasena;
	}
	
	public final String getContrasena() {
		return this.contrasenaProperty().get();
	}
	
	public final void setContrasena(final String contrasena) {
		this.contrasenaProperty().set(contrasena);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	//DESTINATARIO//////////////////////////////////////////////////////
	public final StringProperty destinatarioProperty() {
		return this.destinatario;
	}
	
	public final String getDestinatario() {
		return this.destinatarioProperty().get();
	}
	
	public final void setDestinatario(final String destinatario) {
		this.destinatarioProperty().set(destinatario);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	//ASUNTO///////////////////////////////////////////////////////////
	public final StringProperty asuntoProperty() {
		return this.asunto;
	}
	
	public final String getAsunto() {
		return this.asuntoProperty().get();
	}
	
	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	//MENSAJE///////////////////////////////////////////////////////////
	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}
	
	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	
	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	////////////////////////////////////////////////////////////////////
	
	
	
	
}
