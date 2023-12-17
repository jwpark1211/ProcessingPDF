package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class PdfReadUtil implements PdfRead {
    public String readPDF(String filePath) throws Exception{
        File file = new File(filePath);
        String result = "";
        PDDocument pDDocument = PDDocument.load(file);
        String text = new PDFTextStripper().getText(pDDocument);
        String res[] = text.split("\n");
        return text;
    }
}
