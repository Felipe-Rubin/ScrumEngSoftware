/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import javax.swing.SwingUtilities;

/**
 *
 * @author 15201850
 */
public class MaqueteDeTela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try{
				new Tela();
				}catch(Exception e){
					System.out.println("Bad initialization, cause:\n"+e.getMessage());
					System.exit(0);
				}
			}
		});	        
        
    }
    
}
