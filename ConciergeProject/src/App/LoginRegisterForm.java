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
    
    protected void close() {
        this.dispose();
    }
    
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
                        System.out.println("Existe"+rs.first());
                        close();
                        Tela mt = new Tela(usuarioTextField.getText());
                        mt.setVisible(true);
                        ResultSet user = sc.QueryGeneric("SELECT * FROM Profile WHERE CPF LIKE " + rs.getNString("CPF"));
                        user.next();
                        mt.fillJArea1(user.getNString("Nome"));
                        mt.fillJArea2("Sobre: " + user.getString("Sobre") + "\nPedidos Completos: " + user.getString("PedidosCompletos") + "\nPontualidade: " + user.getString("Pontualidade"));
                        
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
                
                System.out.println("Ok Repaint");
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
        voltarButton = new javax.swing.JButton("Voltar");
        
        usuarioRegLabel = new javax.swing.JLabel();
        senhaRegLabel = new javax.swing.JLabel();
        cpfRegLabel = new javax.swing.JLabel();
        usuarioRegTextField = new javax.swing.JTextField("",10);
        senhaRegTextField = new javax.swing.JTextField("",10);
        cpfRegTextField = new javax.swing.JTextField("",10);
        registrarRegButton = new javax.swing.JButton();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        sobreRegTextArea = new javax.swing.JTextArea();
        sobreRegLabel = new javax.swing.JLabel();
        nomeRegLabel = new javax.swing.JLabel();
        nomeRegTextField = new javax.swing.JTextField("",10);
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
                        
                        sc.insertQuery("INSERT INTO Profile (CPF,Nome,Sobre) VALUES (\""+cpfRegTextField.getText()+"\",\""+nomeRegTextField.getText()+"\",\""+sobreRegTextArea.getText()+"\");");
                        sc.insertQuery("INSERT INTO Login VALUES (\""+usuarioRegTextField.getText()+"\",\""+senhaRegTextField.getText()+"\",\""+cpfRegTextField.getText()+"\");");

                        JOptionPane.showMessageDialog(null,"Registrado com sucesso","Registro Confirmado",JOptionPane.INFORMATION_MESSAGE);
                        LoginPanelX lp = new LoginPanelX();
                        setContentPane(lp);
                        pack();
                        repaint();

                        
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(LoginRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
        });


        sobreRegTextArea.setColumns(20);
        sobreRegTextArea.setRows(5);
        jScrollPane1.setViewportView(sobreRegTextArea);

        sobreRegLabel.setText("Sobre");

        nomeRegLabel.setText("Nome");
        
        
        voltarButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               LoginPanelX lp = new LoginPanelX();
               setContentPane(lp);
               pack();
               repaint();

           }
        });

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltarButton)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeRegLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registrarRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioRegLabel)
                                    .addComponent(cpfRegLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sobreRegLabel)
                                        .addComponent(senhaRegLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpfRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senhaRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeRegLabel)
                            .addComponent(nomeRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioRegLabel)
                    .addComponent(usuarioRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaRegLabel)
                    .addComponent(senhaRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfRegLabel)
                    .addComponent(cpfRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(sobreRegLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)))
                .addComponent(registrarRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        
    }                      


    // Variables declaration - do not modify                     
    private javax.swing.JLabel cpfRegLabel;
    private javax.swing.JTextField cpfRegTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomeRegLabel;
    private javax.swing.JTextField nomeRegTextField;
    private javax.swing.JButton registrarRegButton;
    private javax.swing.JLabel senhaRegLabel;
    private javax.swing.JTextField senhaRegTextField;
    private javax.swing.JLabel sobreRegLabel;
    private javax.swing.JTextArea sobreRegTextArea;
    private javax.swing.JLabel usuarioRegLabel;
    private javax.swing.JTextField usuarioRegTextField;
    private javax.swing.JButton voltarButton;

    // End of variables declaration                   
}    
//**************
//public class TelaSearchX extends javax.swing.JPanel {
//    
//    public TelaSearchX(){
//        configTelaSearchX();
//    }
//    private void configTelaSearchX() {
//
//        searchSearchPanel = new javax.swing.JPanel();
//        searchSearchLabel = new javax.swing.JLabel();
//        buscarTextField = new java.awt.TextField();
//        buscarSearchButton = new javax.swing.JButton();
//        voltarSearchButton = new javax.swing.JButton();
//        PedidoScrollPanel = new javax.swing.JScrollPane();
//
//        searchSearchLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
//        searchSearchLabel.setText("Search");
//
//        buscarSearchButton.setText("Buscar");
//        
//        buscarSearchButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//            ConnectionProperties cp;
//            cp = new ConnectionProperties("sql10.freesqldatabase.com","3306","sql10173560","sql10173560","fgGZXQncvF");
//        
//            ServerConnect sc = new ServerConnect();
//            sc.setConnectionProp(cp);
//            sc.initConnection();
//            ResultSet rs = sc.QueryGeneric("SELECT * FROM Pedido WHERE Descricao LIKE \"%"+buscarTextField.getText()+"%\";");
//            System.out.println("Comecou a busca");
//               try {
//                   while(rs.next()){
//                       System.out.println("Buscando");
//                       String endereco = rs.getNString("Endereco");
//                       String valorPago = rs.getNString("ValorPago");
//                       System.out.println(valorPago);
//                   }
//               } catch (SQLException ex) {
//                   Logger.getLogger(LoginRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
//                   System.out.println(ex.getMessage());
//               }
//               System.out.println("Saiu do loop");
//           } 
//        });
//
//        voltarSearchButton.setText("Voltar");
//        
//        voltarSearchButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//           }
//           
//        });
//
//        PedidoScrollPanel.setPreferredSize(new java.awt.Dimension(377, 195));
//        PedidoScrollPanel.setSize(new java.awt.Dimension(377, 195));
//
//        javax.swing.GroupLayout searchSearchPanelLayout = new javax.swing.GroupLayout(searchSearchPanel);
//        searchSearchPanel.setLayout(searchSearchPanelLayout);
//        searchSearchPanelLayout.setHorizontalGroup(
//            searchSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(searchSearchPanelLayout.createSequentialGroup()
//                .addGroup(searchSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(searchSearchPanelLayout.createSequentialGroup()
//                        .addContainerGap()
//                        .addComponent(voltarSearchButton)
//                        .addGap(77, 77, 77)
//                        .addComponent(searchSearchLabel)
//                        .addGap(0, 0, Short.MAX_VALUE))
//                    .addGroup(searchSearchPanelLayout.createSequentialGroup()
//                        .addGap(22, 22, 22)
//                        .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(buscarSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
//                .addContainerGap())
//            .addGroup(searchSearchPanelLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(PedidoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        searchSearchPanelLayout.setVerticalGroup(
//            searchSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(searchSearchPanelLayout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addGroup(searchSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(searchSearchLabel)
//                    .addComponent(voltarSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
//                .addGap(20, 20, 20)
//                .addGroup(searchSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(buscarSearchButton))
//                .addGap(18, 18, 18)
//                .addComponent(PedidoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(29, 29, 29))
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(25, 25, 25)
//                .addComponent(searchSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(searchSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 63, Short.MAX_VALUE))
//        );
//
//
//}    
//
//    private javax.swing.JScrollPane PedidoScrollPanel;
//    private javax.swing.JButton buscarSearchButton;
//    private java.awt.TextField buscarTextField;
//    private javax.swing.JLabel searchSearchLabel;
//    private javax.swing.JPanel searchSearchPanel;
//    private javax.swing.JButton voltarSearchButton;
//
//}


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
