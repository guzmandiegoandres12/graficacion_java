/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
     private  BorderLayout maquetado,maquetado2;
     public  JTextField text1,text2,text3,text4,text5;
     public   JRadioButton lin,cua,cub,pol;
     private  ButtonGroup  selector;
     private  numeros  funcion;
     public  JTextArea  tabla;
     private JScrollPane scroll;
     public void ventFuncEje() {
     //definicion  de variables  elementos graficos     
     ventana2 =new JFrame();
     ventana2.setSize(450,300);
     ventana2.setTitle("MODO FUNCION ALGEBRAICA");
     ventana2.setVisible(true);
     panel1=new JPanel();
     panel2=new JPanel();
     panel4=new JPanel();
     panel5=new JPanel();
     panel6=new JPanel();
     carga_datos=new JButton("CARGADATOS");
     maquetado=new BorderLayout();
     maquetado2=new BorderLayout();
     text1 = new JTextField(5);
     text2 = new JTextField(5);
     text3 = new JTextField(5);
     text4 = new JTextField(5);
     tabla= new JTextArea(10,35);
     lin=new JRadioButton();
     cua=new JRadioButton();
     cub=new JRadioButton();
     selector= new ButtonGroup();
     funcion= new numeros();
     tabla.setLineWrap(true);
     scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
             
             
             ;
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
     panel4.add(scroll);
     panel5.setLayout(maquetado2);
     panel5.add(panel4,BorderLayout.NORTH);
     panel5.add(carga_datos,BorderLayout.CENTER);
     ventana2.add(panel1,BorderLayout.NORTH);
     ventana2.add(panel2,BorderLayout.CENTER);
     ventana2.add(panel5,BorderLayout.SOUTH);
     cont_lin();
     selec_form selec_panel = new selec_form();
     lin.addActionListener(selec_panel);
     cua.addActionListener(selec_panel);
     cub.addActionListener(selec_panel);
     carga_datos.addActionListener(selec_panel);
     
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
            if(e.getSource()==carga_datos){
                tabla.setText("");
                double  valor_y=0;
                int contador=-551;
           
                if (lin.isSelected()==true){ 
                    for (int i=0;i<=1100;i++){
                      valor_y= funcion.fun_lin(Double.valueOf(text2.getText()), Double.valueOf(text1.getText()),contador);
                     String contenido =tabla.getText();
                      tabla.setText(contenido+"\n"+"x= "+contador+"   y="+valor_y);
                      contador++;
                  }
                }
                if (cua.isSelected()==true){
                    System.err.println("dhshfdsf");
                   for (int i=0;i<=1100;i++){
                    valor_y= funcion.fun_cua(Double.valueOf(text3.getText()),Double.valueOf(text2.getText()), Double.valueOf(text1.getText()),contador);
                     String contenido =tabla.getText();
                      tabla.setText(contenido+"\n"+"x= "+contador+"   y="+valor_y);
                      contador++;
                     }
                }
                if (cub.isSelected()==true){
                    
                   for (int i=0;i<=1100;i++){
                    valor_y= funcion.fun_cub(Double.valueOf(text4.getText()),Double.valueOf(text3.getText()),Double.valueOf(text2.getText()), Double.valueOf(text1.getText()),contador);
                     String contenido =tabla.getText();
                      tabla.setText(contenido+"\n"+"x= "+contador+"   y="+valor_y);
                      contador++;
                     }

                }
             
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
