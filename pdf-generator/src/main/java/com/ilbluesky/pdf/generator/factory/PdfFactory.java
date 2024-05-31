package com.ilbluesky.pdf.generator.factory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ilbluesky.pdf.generator.entity.PdfBarcodePage;
import jakarta.annotation.Nullable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Orca Zhang
 * date 5/29/2024
 */
public class PdfFactory {
    public static void main(String[] args) throws FileNotFoundException {
        List<PdfBarcodePage> list = new ArrayList<>();
        PdfBarcodePage page = new PdfBarcodePage();
        list.add(page);
        page.setBarcodeContent("abc");
        page.setLabelList(Arrays.asList("alkdfa;jslkd", "asdlfadsf", "asdfasdf", "adfasdf", "asdfasd"));
        PDDocument document = new PDDocument();
        generatePdf(document, new FileOutputStream(new File("pdf.pdf")), list, new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN),
                BarcodeFormat.CODE_128);

    }
    public static void generatePdf(PDDocument document, OutputStream os, List<PdfBarcodePage> pageList,
                                   PDFont font, BarcodeFormat format) {

        MultiFormatWriter barcodeWriter = new MultiFormatWriter();
        try {
            // Create page
            for (PdfBarcodePage page : pageList) {
                BitMatrix bitMatrix = barcodeWriter.encode(page.getBarcodeContent(), format, page.getBarcodeWidth(),
                        page.getBarcodeHeight());
                PDPage pg = new PDPage(new PDRectangle(page.getPageWidth(), page.getPageHeight()));
                document.addPage(pg);

                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                MatrixToImageWriter.writeToStream(bitMatrix, "png", bytes);

                PDPageContentStream stream = new PDPageContentStream(document, pg);

                    if (page.getLabelList() != null && page.getLabelList().size() > 0) {
                        for (int i = 0; i < page.getLabelList().size(); i++) {
                            stream.beginText();
                            if (font != null) {
                                stream.setFont(font, page.getFontSize());
                            }
                            stream.setLeading(15.5f);
                            stream.newLineAtOffset(page.getLeftMargin() + (i % page.getLabelColumn())
                                            * (page.getPageWidth() / page.getLabelColumn()),
                                    (page.getPageHeight() - page.getBarcodeHeight() - page.getLineGap())
                                            - ((i / page.getLabelColumn()) * (page.getLineGap())));
                            stream.showText(page.getLabelList().get(i) == null ? "" : page.getLabelList().get(i));
                            stream.endText();
                        }
                    }
                    PDImageXObject pdImageXObject = PDImageXObject.createFromByteArray(document,
                            bytes.toByteArray(), "png");
                    stream.drawImage(pdImageXObject, 0, page.getPageHeight() - page.getBarcodeHeight(),
                            page.getPageWidth(), page.getBarcodeHeight() - page.getGap());
                    stream.close();
                }
            document.save(os);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Generate barcode failed, %s", e.getMessage()));
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
