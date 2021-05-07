package utils;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class Pdf2WordSpire {

    public static void main(String[] args) throws Exception {
        PdfDocument pdf = new PdfDocument("E:/temp/test.pdf");
        pdf.saveToFile("E:/temp/ToWord.docx", FileFormat.DOCX);
        System.out.println("pdf转换word成功！");
    }
}
