/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_pilas_autos;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Main {
    public static void main(String[] args) {
        Pila_Auto estacionamiento1=new Pila_Auto();
        Pila_Auto estacionamiento2=new Pila_Auto();
        
        int opcion;
        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("1:AGREGAR AUTO\n2:VISUALIZAR AUTO\n3:BUSCAR AUTO\n4:MOSTRAR AUTOS EN ESTACIONAMIENTO 1\n5:REGRRESAR AUTOS A ESTACIONAMIENTO1\n6:LIMPIAR TODO"));
            switch(opcion){
                case 1:
                    ClassAuto au=new ClassAuto();
                    int placa=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de placa"));
                    String marca=JOptionPane.showInputDialog("Ingrese la marca");
                    String modelo=JOptionPane.showInputDialog("Ingrese el modelo");
                    int horaEntrada=Integer.parseInt(JOptionPane.showInputDialog("Ingrese hora entrada"));
                    int horaSalida=Integer.parseInt(JOptionPane.showInputDialog("Ingrese hora salida"));
                    double costoPorHora=Integer.parseInt(JOptionPane.showInputDialog("Costo por hora"));
                    au.setPlaca(placa);
                    au.setMarca(marca);
                    au.setModelo(modelo);
                    au.setHoraEntrada(horaEntrada);
                    au.setCostoPorHora(costoPorHora);
                    estacionamiento1.push(au);
                    break;
                case 2:
                    if (!estacionamiento1.vacia()) {
                        System.out.println("Autos del estacionamiento 1");
                        estacionamiento1.imprimir();
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay autos en el estacionamiento");
                    }
                    break;
                case 3:
                    if (!estacionamiento1.vacia()){
                        int valorBuscado=Integer.parseInt(JOptionPane.showInputDialog(":¿Buscar por placa?"));
                        int valorCima;
                        do {
                            valorCima=estacionamiento1.cima.info.getPlaca();
                            if (valorCima!=valorBuscado) {
                                estacionamiento2.push(estacionamiento1.cima.info);
                                estacionamiento1.pop();
                            }
                            if (valorCima==valorBuscado) {
                                estacionamiento1.pop();
                            }
                            
                        } while (valorBuscado!=valorCima); 
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay autos en el estacionamiento 1");
                    }   
                    break;
                case 4:
                    if (!estacionamiento2.vacia()) {
                        System.out.println("AUTOS DEL ESTACIONAMIENTO 2");
                        estacionamiento2.imprimir();
                        }else{
                        JOptionPane.showMessageDialog(null, "NO HAY AUTOS EN EL ESTACIONAMIENTO 2");
                    }
                    break;
                case 5:
                    if (!estacionamiento2.vacia()) {
                        do {
                            estacionamiento1.push(estacionamiento2.cima.info);
                            estacionamiento2.pop();
                        } while (!estacionamiento2.vacia());
                    }else{
                        JOptionPane.showMessageDialog(null, "NO AUTOS QUE REGRESAR");
                    }
                    break;
                case 6:
                    if (!estacionamiento1.vacia()) {
                        do {
                            estacionamiento1.pop();
                        } while (!estacionamiento1.vacia());
                    if (!estacionamiento2.vacia()) {
                         do {
                            estacionamiento2.pop();
                        } while (!estacionamiento2.vacia());
                           
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"LOS ESTACIONAMIENTOS ESTAN VACIOS");
                    } 
                    break;
                default:
                    break;
                    
            }
        } while (opcion<7);
        
    }
}
