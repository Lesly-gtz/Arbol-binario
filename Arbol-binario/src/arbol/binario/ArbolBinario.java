
package arbolgrafico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ArbolBinario {

   Arbol ArbolB = new Arbol();

    public ArbolBinario() {
    }

    public boolean insertar(String dato) {
        return (this.ArbolB.agregar(dato));
    }
    

    public void Empezar(){
        this.ArbolB.Empezar();
    }
    
    public void Guardar(){
     javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
     FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat","dat");
        jF1.setFileFilter(filter);
     String ruta = ""; 
        try
      {
         if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
         ruta = jF1.getSelectedFile().getAbsolutePath(); 
         } 
         final FileOutputStream fo = new FileOutputStream(ruta);
         final ObjectOutputStream oos = new ObjectOutputStream(fo);
         oos.writeObject(this.ArbolB);
         oos.flush();
         oos.close();
      }
      catch (Exception ex)
      {
         // write stack trace to standard error
         ex.printStackTrace();
      }
    
    }
    
    public void abrir() {
        javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
        String ruta = ""; 
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat","dat");
        jF1.setFileFilter(filter);
        try{
            if(jF1.showOpenDialog(null)==jF1.APPROVE_OPTION){ 
                
             ruta = jF1.getSelectedFile().getAbsolutePath(); 
         		final FileInputStream fis = new FileInputStream(ruta);
         		final ObjectInputStream ois = new ObjectInputStream(fis);  
         		final Object deserializedObject = ois.readObject();
         		System.out.println("Tipo de objeto " + deserializedObject.getClass().getName());
         		if (deserializedObject instanceof Arbol){
            		this.ArbolB = (Arbol) deserializedObject;
         		}
         		else
         		{
            		System.out.println("No se esperaba " + deserializedObject.getClass().getName());
         		}
         		ois.close();

        		
      		}
        }catch (Exception ex){
         	 	
      		}
        }
        
    

    

    public String preOrden() {
        ArrayList it = this.ArbolB.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        ArrayList it = this.ArbolB.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String posOrden() {
        ArrayList it = this.ArbolB.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }

    public String imprimirPorNiveles() {
        ArrayList it = this.ArbolB.impNiveles();
        return (recorrido(it, "Imprimir Por niveles"));
    }

    public String darHojas() {
        ArrayList it = this.ArbolB.getHojas();
        return (recorrido(it, "Hojas del Arbol"));
    }

   

    private String recorrido(ArrayList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
    }
    
    public String CantidadNodos(){
        return this.ArbolB.cantidadNodos();
    }
    
    public String CantidadHojas(){
        return this.ArbolB.cantidadNodosHoja();
    }
    public String alturaArbol(){
        return this.ArbolB.retornarAltura();
    }
   
    public String porNivel(){
       int r=this.ArbolB.alturaArbol();
       String nivel = Integer.toString(r);

       return nivel;
    }
   
    public String ramaMayor() {
        ArrayList it = this.ArbolB.ObtenerRamamayor();
        return (recorrido(it, "Rama(s) con mas valores"));
    }
    
    public void limpiar(){
        ArbolB.Limpiar();
    }
   
    public boolean isFull(){
        return ArbolB.isFull(ArbolB.raiz);
    }
    
    public boolean perfecto(){
        return ArbolB.isPerfect(ArbolB.raiz);
    }
    public boolean degenerado(){
        return ArbolB.isDegenerate(ArbolB.raiz);
    }

    public JPanel getDibujo() {
        return this.ArbolB.getdibujo();
    }

   /* boolean respuesta(String r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
