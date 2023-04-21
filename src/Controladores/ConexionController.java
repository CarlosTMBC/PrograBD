/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Conexion;
import Modelos.PersonasModel;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author carlt
 */
public class ConexionController implements ActionListener {
    frmPrincipal VistaPrincipal;
    frmLogin VistaLogin;
    frmPersonas VistaPersonas;
    Conexion ModeloConexion;
    PersonasModel ModeloPersonas;

    public ConexionController(frmPrincipal VistaPrincipal,frmLogin VistaLogin, frmPersonas VistaPersonas, Conexion ModeloConexion, PersonasModel ModeloPersonas) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaLogin = VistaLogin;
        this.VistaPersonas = VistaPersonas;
        this.ModeloConexion = ModeloConexion;
        this.ModeloPersonas = ModeloPersonas;
        
        
        //Levantar Formulario Principal
        this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        this.VistaPrincipal.setVisible(true);
        
        //Poner a la escucha el boton principal
        this.VistaLogin.btnAceptar.addActionListener(this);
        
        //
        this.VistaLogin.setLocationRelativeTo(null);
        this.VistaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==this.VistaLogin.btnAceptar)
        {
            this.ModeloConexion.Conectar(this.VistaLogin.txtUsuario.getText(), 
            this.VistaLogin.txtContrasena.getText());
            if(ModeloConexion != null)
            {
                this.VistaLogin.dispose();;
                this.VistaPersonas.btnGuardar.addActionListener(this);
                this.VistaPersonas.setLocationRelativeTo(null);
                this.VistaPersonas.setVisible(true);
            }
        }
        
        if(e.getSource()==this.VistaPersonas.btnGuardar)
        {
            JOptionPane.showMessageDialog(null, "Si escucho Pendejo");
            // MANDAR Y GUARDAR EL REGISTRO
            this.ModeloPersonas.GuardarPersona(this.VistaPersonas.txtApellidos.getText(),this.VistaPersonas.txtNombre.getText(),this.VistaPersonas.txtTelefono.getText());
        }
  
}

    
    
    
    
    
    
    
   
}
