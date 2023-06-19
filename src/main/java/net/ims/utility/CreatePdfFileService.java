package net.ims.utility;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import net.ims.entity.Users;


import net.ims.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.layout.Document;
import java.io.FileNotFoundException;

import java.util.List;


@Service
public class CreatePdfFileService {
    @Autowired
    private UserService service;


    public void PdfGenerator() {
        String filePdf = "/Users/nanirambhujel/Desktop/pdf/sample.pdf";
     
        List<Users> userlist=  service.getAllUsers();
    

        try {
            PdfWriter writer = new PdfWriter(filePdf);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new  Document(pdfDoc);
            Paragraph p1 = new Paragraph("Hello Welcome To Takeo Group A");
            float[] columnWidth = {200f, 200f, 200f};
            Table table = new Table(columnWidth);
            table.addCell(new Cell().add("ID"));
            table.addCell(new Cell().add("Name"));
            table.addCell(new Cell().add("PHONE"));
            table.addCell(new Cell().add("ADDRESS"));
            table.addCell(new Cell().add("EAMIL"));
         
            for(Users usr:userlist){
                table.addCell(new Cell().add(String.valueOf(usr.getUid())));
                table.addCell(new Cell().add(usr.getUname()));
                table.addCell(new Cell().add(String.valueOf(usr.getPhone())));
                table.addCell(new Cell().add(usr.getAddress()));
                table.addCell(new Cell().add(usr.getEmail()));

            }
            document.add(p1);
            document.add(table);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
