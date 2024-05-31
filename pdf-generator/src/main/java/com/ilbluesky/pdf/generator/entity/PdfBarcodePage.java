package com.ilbluesky.pdf.generator.entity;

import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.List;

/**
 * Pdf
 * @author Orca Zhang
 * date 5/29/2024
 */
public class PdfBarcodePage implements Serializable {

    /**
     * Content of barcode
     */
    @Nonnull
    private String barcodeContent;
    /**
     * Labels
     */
    private List<String> labelList;
    private Integer barcodeWidth = 230;
    private Integer barcodeHeight = 200;
    private Integer pageWidth = 600;
    private Integer pageHeight = 400;
    private Integer fontSize = 30;
    private Integer gap = 5;
    private Integer labelColumn = 1;
    private Integer lineGap = 35;
    private Integer leftMargin = 20;


    public String getBarcodeContent() {
        return barcodeContent;
    }

    public void setBarcodeContent(String barcodeContent) {
        this.barcodeContent = barcodeContent;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public Integer getBarcodeWidth() {
        return barcodeWidth;
    }

    public void setBarcodeWidth(Integer barcodeWidth) {
        this.barcodeWidth = barcodeWidth;
    }

    public Integer getBarcodeHeight() {
        return barcodeHeight;
    }

    public void setBarcodeHeight(Integer barcodeHeight) {
        this.barcodeHeight = barcodeHeight;
    }

    public Integer getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(Integer pageWidth) {
        this.pageWidth = pageWidth;
    }

    public Integer getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(Integer pageHeight) {
        this.pageHeight = pageHeight;
    }

    public Integer getGap() {
        return gap;
    }

    public void setGap(Integer gap) {
        this.gap = gap;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getLabelColumn() {
        return labelColumn;
    }

    public void setLabelColumn(Integer labelColumn) {
        this.labelColumn = labelColumn;
    }

    public Integer getLineGap() {
        return lineGap;
    }

    public void setLineGap(Integer lineGap) {
        this.lineGap = lineGap;
    }

    public Integer getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(Integer leftMargin) {
        this.leftMargin = leftMargin;
    }
}
