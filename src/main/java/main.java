import com.itextpdf.io.IOException;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.net.MalformedURLException;
/*
public class main extends PdfPageEventHelper {

    //declaring resources
    public static final String FONT = "/Users/ketikakhniauri/IdeaProjects/CMA_eng/src/ttf/sylfaen.ttf";
    public static final String dest = "result/addingTable.pdf";
    public static final String image = "/Users/ketikakhniauri/IdeaProjects/CMA_eng/src/ttf/logo.jpg";
    public static final String stamp = "/Users/ketikakhniauri/IdeaProjects/CMA_eng/src/ttf/signature.png";
    static Image img;

    {
        try {
            img = new Image(ImageDataFactory.create(image));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    Image stmp;

    {
        try {
            stmp = new Image(ImageDataFactory.create(stamp));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private PdfTemplate t;
    private Image total;

    public void onOpenDocument(PdfWriter writer, Document document) {
        //t = writer.getDirectContent().createTemplate(30, 16);
        //try {
            //total = Image.getInstance(t);
            //total.setRole(PdfName.ARTIFACT);
        //} catch (DocumentException de) {
           // throw new ExceptionConverter(de);
       // }
    }

    //@Override
    public void onEndPage(PdfWriter writer, Document document) {
        addHeader(writer);
        addFooter(writer);
    }

    private void addHeader(PdfWriter writer){
        PdfPTable header = new PdfPTable(2);
        try {
            // set defaults
            header.setWidths(new int[]{2, 24});
            header.setTotalWidth(527);
            header.setLockedWidth(true);
            header.getDefaultCell().setFixedHeight(40);
            //header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add image

            header.addCell(String.valueOf(stmp.scale(0.08F, 0.08F).setHorizontalAlignment(HorizontalAlignment.CENTER)));

            // write content
           // header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(3);
        try {
            // set defaults
            footer.setWidths(new int[]{24, 2, 1});
            footer.setTotalWidth(527);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(40);
            //footer.getDefaultCell().setBorder(Rectangle.TOP);
            footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add copyright
            footer.addCell(new Phrase("\u00A9 Memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

            // add current page count
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
           // footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

            // add placeholder for total page count
            //PdfPCell totalPageCount = new PdfPCell(total);
            //totalPageCount.setBorder(Rectangle.TOP);
            //totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
            //footer.addCell(totalPageCount);

            // write page
            //PdfContentByte canvas = writer.getDirectContent();
            //canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
            //footer.writeSelectedRows(0, -1, 34, 50, canvas);
            //canvas.endMarkedContentSequence();
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document) {
        //int totalLength = String.valueOf(writer.getPageNumber()).length();
        //int totalWidth = totalLength * 5;
       // ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
        //        new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
         //       totalWidth, 6, 0);
    }



    public static void main(String[] args) throws Exception, NullPointerException {

        PdfFont gefont = PdfFontFactory.createFont(FONT, "Identity-H");
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf, PageSize.A4);


        // add header and footer
        main event = new main();
        //pdf.addEventHandler(event);

        Paragraph page_header = new Paragraph("Copy")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(14)
                .setFontColor(ColorConstants.RED);

        for (int i = 1; i <= pdf.getNumberOfPages(); i++) {
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getTop() - 20;
            doc.showTextAligned(page_header, x, y, i, TextAlignment.LEFT, VerticalAlignment.BOTTOM, 0);
        }

        //data for body table
        String operation[] = new String[20];
        String bill[] = new String[20];
        String cont[] = new String[20];
        String type[] = new String[20];
        String par[] = new String[20];
        String unit[] = new String[20];
        String sum[] = new String[20];
        String total[] = new String[20];

        for (int i = 0; i < 20; i++) {
            operation[i] = "";
        }
        for (int i = 0; i < 20; i++) {
            bill[i] = "NAM4383715";
        }
        for (int i = 0; i < 20; i++) {
            cont[i] = "";
        }
        for (int i = 0; i < 20; i++) {
            type[i] = "40FF";
        }
        for (int i = 0; i < 20; i++) {
            par[i] = "";
        }
        for (int i = 0; i < 20; i++) {
            unit[i] = "";
        }
        for (int i = 0; i < 20; i++) {
            sum[i] = "";
        }
        for (int i = 0; i < 20; i++) {
            total[i] = "";
        }
        for (int i = 0; i < 6; i++) {
            operation[i] = "THC ~";
        }
        operation[6] = "Delivery Order Fees";
        operation[7] = "Surveyor charges";
        for (int i = 8; i < 15; i++) {
            operation[i] = "Discharge Survey";
        }
        for (int i = 15; i < 20; i++) {
            operation[i] = "Unlashing fee";
        }
        operation[15] = "Surveyor charges";
        for (int i = 0; i < 6; i++) {
            unit[i] = "546.66";
            sum[i] = "546.66";
            total[i] = "546.66";
        }
        unit[6] = "30.00";
        sum[6] = "30.00";
        total[6] = "30.00";
        unit[7] = "450.00";
        sum[7] = "450.00";
        total[7] = "450.00";
        for (int i = 8; i < 15; i++) {
            unit[i] = "162.00";
            sum[i] = "162.00";
            total[i] = "162.00";
        }
        for (int i = 15; i < 20; i++) {
            unit[i] = "250.00";
            sum[i] = "250.00";
            total[i] = "250.00";
        }


        // data for info table
        String policyinfoheader = "Total : 6231.96 USD (six thousand two hundred and thirty one point ninety six)\n" +
                "Please transfer this amount to the account of :";
        String bottom11 = "Beneficiary's Bank :";
        String bottom12 = "\"CMA - CGM GEORGIA\", L.L.C.";
        String bottom13 = "Intermediary :";
        String bottom14 = "";
        String bottom15 = "Beneficiary's Bank :";
        String bottom16 = "VTB BANK GEORGIA";
        String bottom17 = "Swift :";
        String bottom18 = "";
        String bottom21 = "Bank Swift :";
        String bottom22 = "UGEBGE22";
        String bottom23 = "";
        String bottom24 = "Beneficiary's Account :";
        String bottom25 = "GE03VT0400103596403612";
        String bottom26 = "General Director\n" +
                "Khatuna Sanadze:";


        // declaring tables
        Table headerstrings = new Table(2, true);
        Table header = new Table(1, true);
        Table body = new Table(8, true);
        Table info = new Table(4, true);
        Table info1 = new Table(3, true);
        Table cperiod = new Table(2, true);
        Table addservices = new Table(2, true);
        Table footertable = new Table(2, true);

        //setting fonts
        headerstrings.setFont(gefont);
        body.setFont(gefont);
        info.setFont(gefont);
        cperiod.setFont(gefont);
        footertable.setFont(gefont);
        addservices.setFont(gefont);

        //setting font sizes
        headerstrings.setFontSize(9.0F);
        body.setFontSize(9.0F);
        body.setFontSize(9.0F);
        info.setFontSize(8.0F);
        info1.setFontSize(8.0F);
        cperiod.setFontSize(9.0F);
        addservices.setFontSize(9.0F);
        footertable.setFontSize(9.0F);

        // creating paragraphs for head table
        Cell policeheadC = new Cell();
        Paragraph p;
        p = new Paragraph("სამოგზაურო დაზღვევის პოლისი").setTextAlignment(TextAlignment.CENTER).setBold();
        policeheadC.add(p);
        p = new Paragraph("Travel Insurance Policy").setTextAlignment(TextAlignment.CENTER).setBold();
        policeheadC.add(p);


        //header.addCell(img.scale(0.07F, 0.07F).setHorizontalAlignment(HorizontalAlignment.CENTER));
        //header.addCell(new Paragraph("Invoice No :19809").setTextAlignment(TextAlignment.CENTER).setBold());
        //header.addCell(new Paragraph("თარიღი: 09/13/21 ").setTextAlignment(TextAlignment.CENTER).setBold());
        headerstrings.addCell("CMA - CGM S.A.\n" +
                "MARSEILLE / FRANCE");
        headerstrings.addCell("5/31/21 12:00 AM");



        //adding cells to body table
        body.addCell(new Paragraph("Operation").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Bill Of\n" +
                "Lading").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Cont.\n" +
                "Number").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Type\n" +
                "/ Size").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Parameters").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Unit\n" +
                "Price\n" +
                "(USD)").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Unit Price\n" +
                "Sum (USD)").setTextAlignment(TextAlignment.CENTER).setBold());
        body.addCell(new Paragraph("Total Price\n" +
                "(USD)").setTextAlignment(TextAlignment.CENTER).setBold());


        for (int i = 0; i < 20; i++) {
            body.addCell(operation[i]);
            body.addCell(bill[i]);
            body.addCell(cont[i]);
            body.addCell(type[i]);
            body.addCell(par[i]);
            body.addCell(unit[i]);
            body.addCell(sum[i]);
            body.addCell(total[i]);
        }

        Cell incel = new Cell(1, 6);
        Paragraph kk = new Paragraph("Unit Price In ( USD ), Total Amount ( USD )");
        incel.add(kk);
        body.addCell(incel);
        body.addCell(new Paragraph("6231.96").setBold());
        body.addCell(new Paragraph("6231.96").setBold());


        //adding cells to info table
        Cell poCell = new Cell(1, 4);
        Paragraph myparagraph = new Paragraph(policyinfoheader);
        poCell.add(myparagraph);
        info.addCell(poCell);
        info.addCell(bottom11);
        info.addCell(bottom12);
        info.addCell(bottom13);
        info.addCell(bottom14);
        info.addCell(bottom15);
        info.addCell(bottom16);
        info.addCell(bottom17);
        info.addCell(bottom18);
        info1.addCell(bottom21);
        info1.addCell(bottom22);
        info1.addCell(bottom23);
        info1.addCell(bottom24);
        info1.addCell(bottom25);
        info1.addCell(bottom26);

        //info.addCell(stmp.scale(0.08F, 0.08F).setHorizontalAlignment(HorizontalAlignment.CENTER));

        //adding tables to the doc
        doc.add(img.scale(0.08F, 0.08F));
        doc.add(header);
        headerstrings.setMarginTop(40f);
        doc.add(headerstrings);
        headerstrings.complete();
        //setting gap between headers and body
        body.setMarginTop(80f);
        doc.add(body);
        body.complete();
        //setting gap between body and info
        info.setMarginTop(65f);
        doc.add(info);
        info.complete();
        doc.add(info1);
        info1.complete();
        //setting gap between info and footertable
        footertable.setMarginTop(80f);
        doc.add(footertable);
        footertable.complete();
        doc.close();
        System.out.println("Table created successfully..");

    }
}

 */


