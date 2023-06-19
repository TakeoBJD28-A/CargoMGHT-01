package net.ims.controller;



import net.ims.utility.CreatePdfFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetPdfController {


    private CreatePdfFileService createPdfFileService;

    @Autowired
    public GetPdfController(CreatePdfFileService createPdfFileService) {
        this.createPdfFileService = createPdfFileService;
    }

    @GetMapping("/pdfFile")
    public String getPdf(){

        return "getPdfFile";
    }

    @GetMapping("/createPdf")
        public String pdfFile(){
        createPdfFileService.PdfGenerator();
            return "redirect:/pdfFile";
        }
}
