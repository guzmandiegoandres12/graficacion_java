/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nova
 */
public class numeros {

    public double  fun_lin(double val2,double val1, double xval){
       double result=0;
       int contsec=-551; 
       result=(val2*xval)+val1; 
       return result;
    }
        public double  fun_cua(double val3,double val2,double val1, double xval){
       double result=0;
       int contsec=-551; 
       result=(val3*xval*xval)+(val2*xval)+val1; 
       return result;
    }
       public double  fun_cub(double val4,double val3,double val2,double val1, double xval){
       double result=0;
       int contsec=-551; 
       result=(val4*xval*xval*xval)+(val3*xval*xval)+(val2*xval)+val1; 
       return result;
    }
}