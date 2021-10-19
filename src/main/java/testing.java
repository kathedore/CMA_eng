
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;

import javax.swing.text.StyleConstants;
import java.io.File;

public class testing {
    public static final String DEST = "result/result.pdf";
    public static final String SRC = "result/addingTable.pdf";
    public static final String image = "/Users/ketikakhniauri/IdeaProjects/CMA_eng/src/ttf/logo.jpg";
    static Image img;

    public static void main(String[] args) throws Exception {

        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new testing().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {

        img = new Image(ImageDataFactory.create(image));

        Image img;
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        //img = new Image(ImageDataFactory.create(image));
        img = new Image(ImageDataFactory.create(image));

        Paragraph header = new Paragraph("Invoice No :21050378")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(16)
                .setBold();
        Paragraph footer1 = new Paragraph("11 Turgenev Street.")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7).setFontColor(ColorConstants.LIGHT_GRAY);
        Paragraph footer2 = new Paragraph("0102 Tbilisi, Georgia")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7).setFontColor(ColorConstants.LIGHT_GRAY);
        Paragraph footer3 = new Paragraph("Tel.: (+995 32) 940889, 940890")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7).setFontColor(ColorConstants.LIGHT_GRAY);
        Paragraph footer4 = new Paragraph("Any Remitance Charges .... xxxxxx ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7);
        Paragraph footer5 = new Paragraph("Signature ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7);
        Paragraph footer6 = new Paragraph("CMA CGM LTd XXXXXXX ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(7);
        //info.addCell(stmp.scale(0.08F, 0.08F).setHorizontalAlignment(HorizontalAlignment.CENTER));
        Rectangle pge = pdfDoc.getPage(1).getPageSize();
        img.setFixedPosition(pge.getWidth() /2-200, pge.getTop() - 70);
        doc.add(img.scale(0.08F, 0.08F));
        //Paragraph mm = new Paragraph(img.scale(0.08F, 0.08F));
        for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
            Rectangle pageSize = pdfDoc.getPage(i).getPageSize();
            Paragraph page = new Paragraph(String.valueOf(i))
                    .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                    .setFontSize(12);
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getTop() - 30;

            doc.showTextAligned(header, x, y, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer1, 10, 30, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer2, 10, 20, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer3, 10, 10, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer4, 170, 30, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer5, 170, 20, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(footer6, 170, 10, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            doc.showTextAligned(page, pageSize.getWidth()-50, 20, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            //doc.showTextAligned(imageCell, x, y, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
            //ColumnText.showTextAligned(img, x, y, Element.ALIGN_UNDEFINED);
        }

        doc.close();
    }
}


