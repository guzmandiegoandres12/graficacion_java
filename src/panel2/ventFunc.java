/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel2;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author nova
 */
public class ventFunc  extends JFrame{
    // definicion de clases de  elementos graficos 
     private  JFrame ventana2;
     private  JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
     private  JButton graficar,carga_datos;
     private  JLabel etiqueta;
     private  GridLayout maquetado;
     public  JTextField text1,text2,text3,text4,text5;
     public   JRadioButton lin,cua,cub,pol;
     private  ButtonGroup  selector;
     private  numeros  funcion;
     public void ventFuncEje() {
     //definicion  de variables  elementos graficos     
     ventana2 =new JFrame();
     ventana2.setSize(450,160);
     ventana2.setTitle("MODO FUNCION ALGEBRAICA");
     ventana2.setVisible(true);
     panel1=new JPanel();
     panel2=new JPanel();
     panel4=new JPanel();
     panel5=new JPanel();
     panel6=new JPanel();
     maquetado=new GridLayout(3,1);
     text1 = new JTextField(5);
     text2 = new JTextField(5);
     text3 = new JTextField(5);
     text4 = new JTextField(5);
     lin=new JRadioButton();
     cua=new JRadioButton();
     cub=new JRadioButton();
     selector= new ButtonGroup();
     funcion= new numeros();
 //llamdo y estucruracion de elementos graficos 
     ventana2.setLayout(maquetado);
     //definicion de contenidos listas de   selectores y grupo  de botones selectores
     selector.add(lin);
     selector.add(cua);
     selector.add(cub);
     lin.setSelected(true);
     panel2.add(lin);
     panel2.add(new JLabel("lineal"));
     panel2.add(cua);
     panel2.add(new JLabel("cuadratica"));
     panel2.add(cub);
     panel2.add(new JLabel("cubica"));
     ventana2.add(panel1);
     ventana2.add(panel2);
     cont_lin();
     selec_form selec_panel = new selec_form();
     lin.addActionListener(selec_panel);
     cua.addActionListener(selec_panel);
     cub.addActionListener(selec_panel);
     
     graficar.addActionListener(selec_panel);
    }
     private class selec_form implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==lin){
             cont_lin();
  
            }
            if (e.getSource()==cua){
             cont_cua();
            }
            if (e.getSource()==cub){
             cont_cub();
            }
        }
     
     }
   private void  cont_lin(){
    panel1.removeAll();
    panel1.add(new JLabel("+o-"));
    panel1.add(text2);
    panel1.add(new JLabel("x"));
   panel1.add(new JLabel("+o-"));
    panel1.add(text1);
    panel1.updateUI();
   };
    private void  cont_cua(){
    panel1.removeAll();
    panel1.add(new JLabel("+o-"));
    panel1.add(text3);
    panel1.add(new JLabel("x2"));
    panel1.add(new JLabel("+o-"));
    panel1.add(text2);
    panel1.add(new JLabel("x"));
    panel1.add(new JLabel("+o-"));
    panel1.add(text1);
    panel1.updateUI();
   };
    private void  cont_cub(){
    panel1.removeAll();
    panel1.add(new JLabel("+o-"));
    panel1.add(text4); 
    panel1.add(new JLabel("+o-"));
    panel1.add(text3);
    panel1.add(new JLabel("+o-"));
    panel1.add(text2);
    panel1.add(new JLabel("+o-"));
    panel1.add(text1);
    panel1.updateUI();
   };
}
