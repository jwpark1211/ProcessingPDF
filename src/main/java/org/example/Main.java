package org.example;

public class Main {
    public static void main(String[] args) {
        // pdfReadUtil code <= 보강 필요
        try {
            PdfRead reader = new PdfReadB();
            String result = reader.readPDF("건축기사20150308(교사용).pdf");
            System.out.println(result);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}