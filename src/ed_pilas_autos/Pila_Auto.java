package ed_pilas_autos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class Pila_Auto {
    vista vis;
    Nodo cima;
    
    public Pila_Auto() {
    this.cima=null;
    
    }

    

class Nodo{
    ClassAuto info;
    Nodo anterior;
}

public void push(ClassAuto valor){
        Nodo nuevo=new Nodo();
        nuevo.info=valor;
        if (cima==null) {
            nuevo.anterior=null;
            cima=nuevo;
        }else{
            nuevo.anterior=cima;
            cima=nuevo;
        }
    }
    boolean vacia(){
        return(cima==null);
    }
    public ClassAuto pop(){
        ClassAuto valor=cima.info;
        cima=cima.anterior;
        return valor;
    }
    public void imprimir(){
      Nodo temp;
      temp=cima;
        while (temp!=null) { 
            System.out.println(temp.info.getPlaca()+"   "+temp.info.getMarca()+"     "+temp.info.getModelo()+"   "+temp.info.getHoraEntrada()+"     "+temp.info.getCostoPorHora());
            temp=temp.anterior;
        }
        
    }
    

}//FIN DE LA CLASE
