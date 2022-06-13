package com.pfa.sudodental.export;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.pfa.sudodental.model.Certificat;
import com.pfa.sudodental.model.Patient;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;


public class CertificatExport {
    Certificat certificat;
    Patient patient;

    public CertificatExport(Certificat certificat, Patient patient) {
        this.certificat = certificat;
        this.patient = patient;
    }

    public void writeData(HttpServletResponse response) throws IOException {
        //Read file using PdfReader
        PdfReader pdfReader = new PdfReader("src/main/resources/resource export/certificat.pdf");

        //Modify file using PdfReader
        PdfStamper pdfStamper = new PdfStamper(pdfReader,response.getOutputStream());
        PdfContentByte pageContentByte = pdfStamper.getOverContent(1);

        pageContentByte.beginText();

        font1(pageContentByte);
        //certificat id
        pageContentByte.setTextMatrix(390,602);
        pageContentByte.showText(certificat.getId().toString());

        font2(pageContentByte);
        //patient
        pageContentByte.setTextMatrix(355, 414);
        pageContentByte.showText(patient.getNom()+" "+patient.getPrenom());
        //date debut
        pageContentByte.setTextMatrix(235, 351);
        pageContentByte.showText(certificat.getDebutCer());
        //date fin
        pageContentByte.setTextMatrix(235, 301);
        pageContentByte.showText(certificat.getFinCer());
        //Traitement
        pageContentByte.setTextMatrix(235, 256);
        pageContentByte.showText(certificat.getTraitement());
        //date
        pageContentByte.setTextMatrix(200, 161);
        pageContentByte.showText(certificat.getDateCer());

        pageContentByte.endText();

        pdfStamper.close();

    }

    public  void font1(PdfContentByte pageContentByte) throws IOException {
        BaseFont baseFont = BaseFont.createFont(
                BaseFont.TIMES_BOLD,
                BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        pageContentByte.setRGBColorFill(0,176,240);
        pageContentByte.setFontAndSize(baseFont,28);

    }
    public void font2(PdfContentByte pageContentByte) throws IOException {
        BaseFont baseFont=BaseFont.createFont(
                BaseFont.TIMES_BOLD,
                BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        pageContentByte.setColorFill(Color.BLACK);
        pageContentByte.setFontAndSize(baseFont,14);
    }

}
