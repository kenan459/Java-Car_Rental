/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car_rental;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author kenan
 */
public class Reports_Panel extends javax.swing.JFrame {

    /**
     * Creates new form Reports_Panel
     */
    public Reports_Panel() {
        initComponents();
        setLocationRelativeTo(null);
        carStatus_Report();
        carList_Report();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this frame
//        System.out.println("test.");
//
//        String filePath = System.getProperty("user.dir") + "/Report.pdf";  // Specify your path
//
//        if (generatePDFReport(filePath)) {
//            System.out.println("PDF report created successfully at: " + filePath);
//            openPDF(filePath);
//        } else {
//            System.out.println("Failed to create PDF report.");
//        }
    }

    public static void carStatus_Report() {

        Document document = new Document();

        try {
            // Create a PDF writer to write to file
            PdfWriter.getInstance(document, new FileOutputStream("Car_Status_Report.pdf"));
            document.open();

            // Font settings
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            // Add a title to the PDF
            Paragraph title = new Paragraph("Car Status Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Space before the table
            document.add(new Paragraph(" "));

            // Create a table with columns matching your ResultSet
            PdfPTable table = new PdfPTable(3);  // Adjust column count based on your table
            table.setWidthPercentage(100);

            // Adding table headers
            table.addCell(new PdfPCell(new Phrase("Vehicle_ID", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Vehicle Name", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Status", headerFont)));

            // Add table rows with data from ResultSet
            table.addCell(new PdfPCell(new Phrase(String.valueOf("1"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota Vios 2023"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Available"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("2"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Mistusbishi Xpander 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Available"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("3"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota Innova 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Available"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("6"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota Wigo 2022"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Unavailable - Rented"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("7"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Honda Accord 2020"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Unavailable - Rented"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("8"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Mazda CX-5 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Available"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("11"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Hondda Civic 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Available"), bodyFont)));

            // Add the table to the document
            document.add(table);

            System.out.println("PDF report created successfully.");
            String filePath = System.getProperty("user.dir") + "/Car_Status_Report.pdf";
            openPDF(filePath);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close the document
            document.close();
        }
    }

    public static void carList_Report() {

        Document document = new Document();

        try {
            // Create a PDF writer to write to file
            PdfWriter.getInstance(document, new FileOutputStream("Car_List_Report.pdf"));
            document.open();

            // Font settings
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            // Add a title to the PDF
            Paragraph title = new Paragraph("Car List Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Space before the table
            document.add(new Paragraph(" "));

            // Create a table with columns matching your ResultSet
            PdfPTable table = new PdfPTable(4);  // Adjust column count based on your table
            table.setWidthPercentage(100);

            // Adding table headers
            table.addCell(new PdfPCell(new Phrase("Vehicle_ID", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Make", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Model", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Rate", headerFont)));

            // Add table rows with data from ResultSet
            table.addCell(new PdfPCell(new Phrase(String.valueOf("1"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Vios 2023"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("1500"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("2"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Mistusbishi"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Xpander 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("2000"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("3"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Innova 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("2400"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("6"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Toyota"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Wigo 2022"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("1500"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("7"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Honda"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Accord 2020"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("2000"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("8"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Mazda"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("CX-5 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("2700"), bodyFont)));

            table.addCell(new PdfPCell(new Phrase(String.valueOf("11"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Honda"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("Civic 2021"), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("1800"), bodyFont)));

            // Add the table to the document
            document.add(table);

            System.out.println("PDF report created successfully.");
            String filePath = System.getProperty("user.dir") + "/Car_List_Report.pdf";
            openPDF(filePath);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close the document
            document.close();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Reports Generated for:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Car_List_Report.pdf");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Car_Status_Report.pdf");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reports_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    //sample
    public static boolean generatePDFReport(String filePath) {
        System.out.println("init.");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add content to your PDF
            document.add(new com.itextpdf.text.Paragraph("Hello, this is a sample PDF!"));

            document.close();

            // Check if the file was created
            File pdfFile = new File(filePath);
            return pdfFile.exists();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void openPDF(String filePath) {
        try {
            File pdfFile = new File(filePath);
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile); // Opens the PDF in the default viewer
            } else {
                System.out.println("The file does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not open the PDF.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
