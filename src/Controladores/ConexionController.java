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

/**
 *
 * @author carlt
 */
public class ConexionController implements ActionListener {
    frmPrincipal VistaPrincipal;
    frmLogin VistaLogin;
    frmPersonas VistaPersonas;
    Conexion ModeloConexion;

    public ConexionController(frmPrincipal VistaPrincipal,frmLogin VistaLogin, frmPersonas VistaPersonas, Conexion ModeloConexion) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaLogin = VistaLogin;
        this.VistaPersonas = VistaPersonas;
        this.ModeloConexion = ModeloConexion;
        
        
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
                this.VistaPersonas.setLocationRelativeTo(null);
                this.VistaPersonas.setVisible(true);
            }
        }
        
//        if(e.getSource()==this.VistaPersonas.btnGuardar)
//        {
//            this.ModeloPersonas.GuardarPersona();
//        }
        //this.VistaPrincipal.setVisible(false);
        //this.VistaLogin.setVisible(true);    
}

    
    
    
    
    
    
    
   
}
