/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
import com.itextpdf.text.BaseColor;    
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import tableModels.CajaDiaTableModel;

public class FacturaPdf {
    
    /**
     * metodo que hace uso de la clase itext para generar archivos PDF recogiendo 
     * los datos para una factura
     * @param _nombre recoge el cliente que realiza la reserva
     * @param _dni optiene la documentacion del cliente
     * @param _telefono se le pasa numero de contacto del cliente
     * @param _cantidad se indica numero de servicios que ha comprado
     * @param _servicio recoge el nombre del servicio comprado 
     * @param _fecha optiene fecha en la que el cliente tiene la "cita"
     * @param _total coste de todos los servicios comprados "cantidad*precio del servicio - la promocion"
     * @throws Exception 
     */
  
    public static void ITextHelloWorld(String _nombre, String _dni, String _telefono, 
            String _cantidad, String _servicio, String _fecha, String _total) throws Exception{
        Document document = new Document();        
        Paragraph parrafo,paragraph_2, parrafo2, parrafo3, parrafo4;
        
        Image imagen = Image.getInstance("src/icon/Spa.jpg");       
        
        // Le indicamos donde se guardara el archivo
        PdfWriter.getInstance(document, new FileOutputStream("src/pdfGenerados/"+"Factura_"+_nombre+"_"+_servicio+"_"+_cantidad+"_"+_total+".pdf"));
        
         // Este codigo genera una tabla de 2 columnas
            PdfPTable table = new PdfPTable(7); 
            table.setWidthPercentage(100);
            String nombre= _nombre;
            String dni= _dni;
            String telefono= _telefono;
            String cantidad= _cantidad;
            String servicio= _servicio;
            String fecha= _fecha;
            String total= _total+" €";
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Nombre");
            table.addCell("Dni");
            table.addCell("Telefono");
            table.addCell("Cantidad");
            table.addCell("Servicio");
            table.addCell("Fecha reserva");
            table.addCell("Precio total");
            
            table.addCell(nombre);
            table.addCell(dni);
            table.addCell(telefono);
            table.addCell(cantidad);
            table.addCell(servicio);
            table.addCell(fecha);
            table.addCell(total);
        
        document.open();

        //Creamos una cantidad significativa de paginas para probar el encabezado
        
        parrafo = new Paragraph("Gracias por confiar en nuestros servicios SpaRelajate");
        paragraph_2 = new Paragraph(" FACTURA ");
        parrafo2 = new Paragraph("           ");
        parrafo3 = new Paragraph("           ");
        parrafo4 = new Paragraph("           ");

        
        //este codigo hace que se nos centre tanto el texto como la imagen
        parrafo.setAlignment(Element.ALIGN_CENTER);
        paragraph_2.setAlignment(Element.ALIGN_CENTER);
        parrafo2.setAlignment(Element.ALIGN_CENTER);
        imagen.setAlignment(Element.ALIGN_CENTER);
paragraph_2.setFont(new Font(FontFactory.getFont("Helvetica", 40, Font.BOLD, BaseColor.BLACK)));
        //añade la documentacion que tendra el pdf
        
        document.add(parrafo4); 
        document.add(parrafo4);
        document.add(imagen);
        document.add(parrafo4); 
        document.add(parrafo4);
        document.add(paragraph_2);
        document.add(parrafo3); 
        document.add(parrafo4);
        document.add(parrafo4); 
        document.add(parrafo4);
        document.add(parrafo4);
        document.add(table); 
        document.add(parrafo4);
        document.add(parrafo2);
        document.add(parrafo3); 
        document.add(parrafo4);
        document.add(parrafo4); 
        document.add(parrafo4);
        document.add(parrafo4); 
        document.add(parrafo4);
        document.add(parrafo2); 
         document.add(parrafo);   
        document.close(); 
            
    }
    
   
}
