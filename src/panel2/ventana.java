/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author logytech
 */
public class ventana {
    ventFunc funcion=new ventFunc();
    numeros class_num=new numeros();
    private  JFrame  ventana,ventana2;
    private  JPanel  panel1,panel2,panel3,panel4, panel5, panel6;
    private  JTextField  texto,texto2;
    private  JButton  boton1,botgraffun;
    private  JLabel etiqueta;
    private  BorderLayout maquetado;
    private  BorderLayout maquetado2;
    private  JRadioButton   selecunit, selecsec,funalge,funsin;
    private  JComboBox  scalas_graphx,scalas_graphy;
    dibujo dib = new dibujo();
    
     public ventana() {

        //selector de  scala
        scalas_graphx= new JComboBox();
        scalas_graphx.addItem("0.1div/unid");
        scalas_graphx.addItem("1div/unid");
        scalas_graphx.addItem("5div/unid");
        scalas_graphx.addItem("10div/unid");
        scalas_graphx.addItem("20div/unid");
        scalas_graphy= new JComboBox();
        scalas_graphy.addItem("0.1div/unid");
        scalas_graphy.addItem("1div/unid");
        scalas_graphy.addItem("5div/unid");
        scalas_graphy.addItem("10div/unid");
        scalas_graphy.addItem("20div/unid");

        ventana=new JFrame();
        ventana2 = new JFrame("grafica funcion");
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        texto=new JTextField(15);
        texto2=new JTextField(15);
        etiqueta= new JLabel();
        maquetado = new BorderLayout();
        maquetado2 = new BorderLayout();  
        selecsec= new JRadioButton();
        selecunit= new JRadioButton();
        funalge=new  JRadioButton();
        funsin= new  JRadioButton();
        boton1=new JButton("graficar");
        botgraffun= new JButton("funcion");

        
       
        // DEFINICION PARAMETROS  VENTANA PRINCIPAL 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1446, 850);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLayout(maquetado);
        ventana.setTitle("SRGP evaluation");
        //LLAMADO ELEMENTOS FEAFICOS  
        //clases maquetadoras de elementos graficos  
        GridLayout cuadricula2 = new GridLayout( 30, 1 );
        GridLayout cuadricula3 = new GridLayout( 1, 4 );
        //---- configuracion grupo de botones selectables
        //  cereacion de grupo para selecion 
        ButtonGroup grupo1 =new ButtonGroup();
        grupo1.add(selecsec);
        grupo1.add(selecunit);
        grupo1.add(funalge);
        grupo1.add(funsin);
        // selector por defecto de grupo de seleccion 
        selecunit.setSelected(true);
        //-------
         panel1.setLayout(maquetado);
         ventana.add(dib,BorderLayout.CENTER);
         ventana.add(panel1,BorderLayout.EAST);
         ventana.add(panel2,BorderLayout.NORTH);
         panel2.add(new JLabel("GRAFICACION"));
         panel1.setLayout(maquetado2);
         panel1.add(panel3);
         panel3.setLayout(cuadricula2);
         panel3.add(new JLabel("punto x"));
         panel3.add(texto);
         panel3.add(new JLabel("punto y"));
         panel3.add(texto2);
         panel4.setLayout(cuadricula3);
         panel4.add(selecunit);
         panel4.add(new JLabel("punto"));        
         panel4.add(selecsec);
         panel4.add(new JLabel("sec puntos"));   
        panel5.add(funalge);
        panel5.add(new JLabel("funsion algebraica"));
        panel5.add(funsin);
        panel5.add(new JLabel("funsion senoidal"));
         panel3.add(panel5);
         panel3.add(panel4);
         panel3.add(boton1);
         panel3.add(new JLabel("scala x:"));
         panel3.add(scalas_graphx);
         panel3.add(new JLabel("scala y:"));
         panel3.add(scalas_graphy); 
         //definicion de   instancias y escuchadores de eventos 
         panel3.add(botgraffun);
         accion act=new accion();
         lista  milista= new lista();
         boton1.addActionListener(act);
         botgraffun.addActionListener(act);
         scalas_graphx.addItemListener(milista);
         scalas_graphy.addItemListener(milista);
         // preparacion sde calores escalares para primer punto 
         dib.det_scalx(returnScalx());
         dib.det_scaly(returnScaly());
         
     //clase privada para control de evento de listas 
         scalas_graphx.addItemListener(milista);
         scalas_graphy.addItemListener(milista);
         texto.setText("0");
         texto2.setText("0");
     }

     private class lista  implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
           if (e.getSource().equals(scalas_graphx)){
            dib.det_scalx(returnScalx());
           }
           if (e.getSource().equals(scalas_graphy)){
            dib.det_scaly(returnScaly());
           }
           
           
        }
    }

     //clase intena pàra control de evento de  boton
    private class accion implements ActionListener{
        
         
        int cont=0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==boton1){
            float  num1=Float.parseFloat(texto.getText());
            float num2=Float.parseFloat(texto2.getText());
             int scalax=0;
             int scalay=0;
                if(selecunit.isSelected()==true){
                    dib.activ(1, num1, num2, 0);     
                }
                if(selecsec.isSelected()==true){
                  dib.activ(2, num1, num2, cont);
                   cont++;
                   if(cont>=1200){
                   cont=0;
                     }
            } 
                
                if(funalge.isSelected()==true){
                  double  valor_y;
                  int contador=-551;
                  if (funcion.lin.isSelected()==true){
                      for (int i=0;i<=1100;i++){
                      valor_y= class_num.fun_lin(Double.valueOf(funcion.text2.getText()), Double.valueOf(funcion.text1.getText()),contador);
                      dib.activ(3, contador, valor_y, i);
                      contador++;
                      }
                  }
                  if(funcion.cua.isSelected()==true){
                      for (int i=0;i<=1100;i++){
                      valor_y= class_num.fun_cua(Double.valueOf(funcion.text3.getText()),Double.valueOf(funcion.text2.getText()), Double.valueOf(funcion.text1.getText()),contador);
                      dib.activ(3, contador, valor_y, i);
                      contador++;
                      }
                  }
                  if(funcion.cub.isSelected()==true){
                      for (int i=0;i<=1100;i++){
                      valor_y= class_num.fun_cub(Double.valueOf(funcion.text4.getText()),Double.valueOf(funcion.text3.getText()),Double.valueOf(funcion.text2.getText()), Double.valueOf(funcion.text1.getText()),contador);
                      dib.activ(3, contador, valor_y, i);
                      contador++;
                      }
                  }
                } 
                
            }
            if(e.getSource()==botgraffun){
           funcion.ventFuncEje();;
            }
        }
    }
      ///definicion de metodos   para obtener valores de escalas  x y
        private int  returnScalx(){
         int compara=scalas_graphx.getSelectedIndex();
         int retorno; 
         switch(compara){
             case 0:retorno=1;
             break;
             case 1:retorno=10;
             break;
             case 2:retorno=50;
             break;
             case 3:retorno=100;
             break;
             case 4:retorno=200;
             break;
             default: retorno=10;
         }
         return retorno;
     }  
        private int  returnScaly(){
         int compara=scalas_graphy.getSelectedIndex();
         int retorno; 
         switch(compara){
             case 0:retorno=1;
             break;
             case 1:retorno=10;
             break;
             case 2:retorno=50;
             break;
             case 3:retorno=100;
             break;
             case 4:retorno=200;
             break;
             default: retorno=10;
         }
         return retorno;
     }  
}
