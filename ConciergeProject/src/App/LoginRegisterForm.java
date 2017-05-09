/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class LoginRegisterForm extends javax.swing.JFrame {
//***************
    private javax.swing.JButton loginButton;
    private javax.swing.JButton registrarButton;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JTextField senhaTextField;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTextField;
    public class LoginPanelX extends javax.swing.JPanel {
        public LoginPanelX(){
            configLogin();
        }
        private void configLogin(){
        senhaLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        usuarioTextField = new javax.swing.JTextField("",10);
        
        senhaTextField = new javax.swing.JTextField("",10);
        loginButton = new javax.swing.JButton();
        registrarButton = new javax.swing.JButton();
        senhaLabel.setText("Senha");
        usuarioLabel.setText("Usuario");
        loginButton.setText("Login");
        
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            ConnectionProperties cp;
            cp = new ConnectionProperties("sql10.freesqldatabase.com","3306","sql10173560","sql10173560","fgGZXQncvF");
        
            ServerConnect sc = new ServerConnect();
            sc.setConnectionProp(cp);
            sc.initConnection();
            ResultSet rs = sc.QueryGeneric("SELECT * FROM Login WHERE Usuario=\""+usuarioTextField.getText()+"\" and Senha=\""+senhaTextField.getText()+"\";");
                try {
                    if(rs.next()){ //se existe esse valor
                        System.out.println("Existe"+rs.next());
                        //AQUI COMECARIA MSM O NEGOCIO
                    }else{ //se n existe esse valor
                        JOptionPane.showMessageDialog(null,"Login errado","Falha ao Logar",JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("N existe");
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(LoginRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
        });
        
        
        
        registrarButton.setText("Registrar");
        registrarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                RegisterPanelX rpx = new RegisterPanelX();
                Container contain = getContentPane();
                contain.removeAll();
                
                //removeAll();
                
                repaint();
                validate();
                
                
                setContentPane(rpx);
                setVisible(true);
                pack();
                //invalidate();
                //repaint();
                //validate();
                repaint();
                revalidate();
                
                System.out.println("Acaboo");
            }
           
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioLabel)
                    .addComponent(senhaLabel)
                    .addComponent(loginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrarButton)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(registrarButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        }
    }
    
    
    
//**************
public class RegisterPanelX extends javax.swing.JPanel {

    /**
     * Creates new form RegisterPanelX
     */
    public RegisterPanelX() {
        configRegister();
    }

    private void configRegister() {

        usuarioRegLabel = new javax.swing.JLabel();
        senhaRegLabel = new javax.swing.JLabel();
        cpfRegLabel = new javax.swing.JLabel();
        usuarioRegTextField = new javax.swing.JTextField("",10);
        senhaRegTextField = new javax.swing.JTextField("",10);
        cpfRegTextField = new javax.swing.JTextField("",10);
        registrarRegButton = new javax.swing.JButton();

        usuarioRegLabel.setText("Usuario");

        senhaRegLabel.setText("Senha");

        cpfRegLabel.setText("CPF");


        registrarRegButton.setText("Registrar");
        registrarRegButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            ConnectionProperties cp;
            cp = new ConnectionProperties("sql10.freesqldatabase.com","3306","sql10173560","sql10173560","fgGZXQncvF");
        
            ServerConnect sc = new ServerConnect();
            sc.setConnectionProp(cp);
            sc.initConnection();
            ResultSet rs = sc.QueryGeneric("SELECT * FROM Login WHERE Usuario=\""+usuarioRegTextField.getText()+"\" or cpf=\""+cpfRegTextField.getText()+"\";");
                try {
                    if(rs.next()){ //se existe esse valor
                        JOptionPane.showMessageDialog(null,"Registro CPF/Usuario ja existe","Falha ao Registrar",JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Existe"+rs.next());
                        //AQUI COMECARIA MSM O NEGOCIO
                    }else{ //se n existe esse valor
                        System.out.println("N existe");
                        sc.initConnection();
                        INSERT INTO Profile (CPF,Nome,Sobre) VALUES ("12345678910","Eduardo Augusto","Algo");
                        sc.insertQuery(INSERT INTO"");
                        sc.insertQuery("INSERT INTO Login VALUES (\""+usuarioRegTextField.getText()+"\",\""+senhaRegTextField.getText()+"\",\""+cpfRegTextField.getText()+"\");");

                        JOptionPane.showMessageDialog(null,"Registrado com sucesso","Registro Confirmado",JOptionPane.INFORMATION_MESSAGE);
                        
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(LoginRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registrarRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioRegLabel)
                            .addComponent(senhaRegLabel)
                            .addComponent(cpfRegLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioRegLabel)
                    .addComponent(usuarioRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaRegLabel)
                    .addComponent(senhaRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfRegLabel)
                    .addComponent(cpfRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(registrarRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        
    }                      


    // Variables declaration - do not modify                     
    private javax.swing.JLabel cpfRegLabel;
    private javax.swing.JTextField cpfRegTextField;
    private javax.swing.JButton registrarRegButton;
    private javax.swing.JLabel senhaRegLabel;
    private javax.swing.JTextField senhaRegTextField;
    private javax.swing.JLabel usuarioRegLabel;
    private javax.swing.JTextField usuarioRegTextField;
    // End of variables declaration                   
}    
//**************
    /**
     * Creates new form LoginRegisterForm
     */
    public LoginRegisterForm() {
        initComponents();
        openLoginForm();
    }
    
    private void openLoginForm(){
        LoginPanelX lp = new LoginPanelX();
        setContentPane(lp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
