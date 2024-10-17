package util;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class CreatePdf {
    public String create(String text) {
        try {
            String dest = "Bill.pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(text));
            document.close();
            return dest;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
