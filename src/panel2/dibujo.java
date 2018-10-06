package panel2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class dibujo extends JPanel{  
     double[] puntos_x= new double[1200];
     double[] puntos_y= new double[1200]; 
     double[] puntos_fun_x = new double[1200]; 
     double[] puntos_fun_y= new double[1200];
     private double temp1,temp2;
     private  numeros este = new numeros();
     private int indexsec,scalx,scaly,indicador=0;
     public void paintComponent( Graphics g ){
     super.paintComponent( g ); int val1,val2;
     g.setColor(Color.LIGHT_GRAY);
     g.fillRect(0, 0, 1200, 750);
     g.setColor(Color.WHITE);
     g.fillRect(20, 25, 1160, 700 );
      //lines secundaria de divicion 
     dib_cuad(g, 10, 35, 60,Color.decode("#BDBDBD"));
     dib_cuad(g, 50,  8, 12, Color.decode("#848484") );
     dib_cuad(g, 100,  4, 6, Color.decode("#424242") );
     //lineas de eje 
     g.drawLine(20, 375, 1180, 375);
     g.drawLine(600, 25, 600, 725 );
     //linea de unidad eje y
     for(int i=0;i<36;i++){
     val1=i*10;
     g.drawLine(598, 375-val1, 602,375-val1 );
     g.drawLine(598, 375+val1, 602,375+val1 );
     }
    for(int i=0;i<59;i++){
     val1=i*10;
     g.drawLine(600-val1, 373, 600-val1,377);
     g.drawLine(600+val1, 373, 600+val1,377 );
     } 
    //graficacion punto a punto ingresaso
     if(indicador==1){
         dibuja_punto(g, temp1, temp2, scalx,scaly );
        // JOptionPane.showMessageDialog(this, scalx+ " "+ scaly);
     }
   //graficacion de secuencia de puntos ingresados
     if(indicador==2){
         for(int i=0;i <=indexsec;i++){
             dibuja_punto(g, puntos_x[i], puntos_y[i], scalx, scaly);
         }
     };
     if (indicador==3){
         for(int i=0;i <=indexsec;i++){
             dibuja_punto(g, puntos_fun_x[i], puntos_fun_y[i], scalx, scaly);
         }
        
      }
    }
     // metodo  dibujar puntp
    private void dibuja_punto(Graphics g, double x, double y, int scalex,int scaley){
    g.setColor(Color.red);
    //variables de pra   graficacion  de puntos
     int puntogrfx=(ctra_0_x((int)(x*scalex)))-3;
     int puntogrfy=(ctra_0_y((int)(y*scaley)))-3;
     //evaluacion para graficacion en limites de  marco de dibujo
     if(puntogrfx>=15&& puntogrfx<=1180){
        if(puntogrfy>=20 &&puntogrfy<=725){
          g.fillOval(puntogrfx, puntogrfy, 7, 7);
     }
     };
  // 
    g.setColor(Color.BLACK);
    repaint();
    } 
    
    //metodo centrado de puntos xy
    private int ctra_0_x(int x){
    int valXSal; 
        valXSal=600+x;  
        return valXSal;
    }
    private int  ctra_0_y(int y){
        int valYSal;
        valYSal=375-y;
        return valYSal;
    }
   // metodo generador de cuadricula 
    private void dib_cuad(Graphics g,int var,int max_x, int max_y, Color color){
     int val1=0;
     for(int i=0;i<max_x;i++){
     val1=i*var;
     g.setColor(color );
     g.drawLine(20, 375-val1, 1180,375-val1 );
     g.drawLine(20, 375+val1, 1180,375+val1 );
     g.setColor(Color.BLACK);
     }
     for(int i=0;i<max_y;i++){
     val1=i*var;
     g.setColor(color );
     g.drawLine(600-val1, 25, 600-val1,725);
     g.drawLine(600+val1, 25, 600+val1,725 );
     g.setColor(Color.BLACK);
     }
    }
    public void  activ(int sysin, double x, double y,int indice){
    if (sysin==1){
     indicador=sysin;
     temp1=x ;
     temp2=y; 
     }
    if(sysin==2){
     indicador=sysin;
     indexsec=indice;
     puntos_x[indice]=x;
     puntos_y[indice]=y; 
    }
     if(sysin==3){
     indicador=sysin;
     indexsec=indice;
     puntos_fun_x[indice]=x;
     puntos_fun_y[indice]=y; 
      
    }
     if(sysin==4){
    
      
    }
     repaint();
  };
   public void mod_val_fun(int indice,double x, double y){
    
   }     
// metodo para definir  valor de escala x
  public void  det_scalx(int escalax){
      scalx=escalax;
      repaint();
  }
// metodo para definir  valor de escala x
  public void  det_scaly(int escalay){
      scaly=escalay;
      repaint();
  }
}
