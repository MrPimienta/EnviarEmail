package dad.javafx.enviaremail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;

public class Controller implements Initializable{
	
	//MODELO
	Model modelo = new Model();
	
	@FXML
	private GridPane view;
	
	@FXML
    private TextArea tfMensaje;

    @FXML
    private TextField tfNombreip;

    @FXML
    private CheckBox chSSL;

    @FXML
    private TextField tfRemitente;

    @FXML
    private TextField tfDestinatario;

    @FXML
    private TextField tfAsunto;

    @FXML
    private TextField tfContrasena;

    @FXML
    private Button btEnviar;

    @FXML
    private Button btVaciar;

    @FXML
    private Button btCerrar;

    @FXML
    private TextField tfPuerto;

    @FXML
    void onCerrarAction(ActionEvent event) {
    	Platform.exit();
    	System.exit(0);
    }

    @FXML
    void onEnviarAction(ActionEvent event) {
    	Email email = new SimpleEmail();
    	
    	try {
    	email.setHostName(modelo.getServidorSMTP());
    	email.setSmtpPort(modelo.getPuerto());
    	email.setAuthenticator(new DefaultAuthenticator(modelo.getRemitente(), modelo.getContrasena()));
    	email.setSSLOnConnect(modelo.isSSL());		
		email.setFrom(modelo.getRemitente());
		email.setSubject(modelo.getAsunto());
		email.setMsg(modelo.getMensaje());
		email.addTo(modelo.getDestinatario());			
		email.send();
		
    	}catch(EmailException e) {
    		//MOSTRAMOS UNA ALERTA DE QUE NO SE HA ENVIADO EL EMAIL
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("No se ha podido enviar el email");
    		alerta.setHeaderText("No se ha podido enviar el email");
    		alerta.showAndWait();
    		e.printStackTrace();
    	}
    	
    	//SI SE HA ENVIADO EL EMAIL CON EXITO
    	Alert alerta = new Alert(AlertType.INFORMATION);
    	alerta.setTitle("Email enviado");
    	alerta.setHeaderText("Mensaje enviado con éxito");
    }

    @FXML
    void onVaciarAction(ActionEvent event) {
    	modelo.setServidorSMTP("");
		modelo.setPuerto(0);
		modelo.setSSL(false);
		modelo.setRemitente("");
		modelo.setContrasena("");
		modelo.setDestinatario("");
		modelo.setAsunto("");
		modelo.setMensaje("");
    }

	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(modelo.servidorSMTPProperty(), tfNombreip.textProperty());		
		Bindings.bindBidirectional(tfPuerto.textProperty(), modelo.puertoProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(modelo.SSLProperty(), chSSL.selectedProperty());
		Bindings.bindBidirectional(modelo.remitenteProperty(), tfRemitente.textProperty());
		Bindings.bindBidirectional(modelo.contrasenaProperty(), tfContrasena.textProperty());
		Bindings.bindBidirectional(modelo.destinatarioProperty(), tfDestinatario.textProperty());
		Bindings.bindBidirectional(modelo.asuntoProperty(), tfAsunto.textProperty());
		Bindings.bindBidirectional(modelo.mensajeProperty(), tfMensaje.textProperty());
	}
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public GridPane getView() {
		return view;
	}
}
