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
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import tableModels.CajaDiaTableModel;

public class ContarCajaPdf {
    
    /**
     * metodo que hace uso de la clase itext para generar archivos PDF
     * @param venta datos del tablemodels
     * @throws Exception 
     */
    
    public static void ITextHelloWorld(double venta) throws Exception{
        Document document = new Document();        
        Paragraph parrafo,parrafo1, parrafo2;
        Image imagen = Image.getInstance("src/icon/Spa.jpg");       
        
        // Le indicamos donde se guardara el archivo
        PdfWriter.getInstance(document, new FileOutputStream("src/pdfGenerados/"+venta+"_"+"caja_del_dia.pdf"));
        
         // Este codigo genera una tabla de 2 columnas
            PdfPTable table = new PdfPTable(2);                
            String total= venta+" €";
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Caja total del dia:");
            table.addCell(total);
        
        document.open();
        
        //Creamos una cantidad significativa de paginas para probar el encabezado
        
        parrafo = new Paragraph("Gracias por confiar en nuestros servicios SpaRelajate");
        parrafo1 = new Paragraph("           ");
        parrafo2 = new Paragraph("           ");
        
        //este codigo hace que se nos centre tanto el texto como la imagen
        parrafo.setAlignment(Element.ALIGN_CENTER);
        parrafo1.setAlignment(Element.ALIGN_CENTER);
        parrafo2.setAlignment(Element.ALIGN_CENTER);
        imagen.setAlignment(Element.ALIGN_CENTER);

        //añade la documentacion que tendra el pdf
        document.add(imagen);  
        document.add(parrafo1);
        document.add(table);
        document.add(parrafo2); 
         document.add(parrafo);   
        document.close(); 
            
    }
    
   
}
