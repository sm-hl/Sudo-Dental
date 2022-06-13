package com.pfa.sudodental.export;


import com.lowagie.text.pdf.*;
import com.pfa.sudodental.model.Decrire;
import com.pfa.sudodental.model.Ordonance;
import com.pfa.sudodental.model.Patient;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class OrdonanceExport {
    Ordonance ordonance;
    Patient patient;

    public OrdonanceExport(Ordonance ordonance,Patient patient) {
        this.patient=patient;
        this.ordonance = ordonance;
    }


    public void writeData(HttpServletResponse response) throws IOException {

        //Read file using PdfReader
        PdfReader pdfReader = new PdfReader("src/main/resources/resource export/ordonance.pdf");

        //Modify file using PdfReader
        PdfStamper pdfStamper = new PdfStamper(pdfReader,response.getOutputStream());
           PdfContentByte pageContentByte = pdfStamper.getOverContent(1);

        pageContentByte.beginText();

        font1(pageContentByte);
        //ordonance id
        pageContentByte.setTextMatrix(392, 602);
        pageContentByte.showText(ordonance.getId().toString());
        //date
        pageContentByte.setTextMatrix(230, 561);
        pageContentByte.showText(ordonance.getDateO());

        font2(pageContentByte);
        //patient
        pageContentByte.setTextMatrix(128, 521);
        pageContentByte.showText(patient.getNom()+" "+patient.getPrenom());
        //Cin
        pageContentByte.setTextMatrix(128, 482);
        pageContentByte.showText(patient.getCin());
        //les medicament
        float dy=391;
        for (Decrire decrire : ordonance.getDecrireList()){
            String ligne1=""+decrire.getMedicament().getNomM()+"  "+decrire.getMedicament().getType()+"  "+ decrire.getMedicament().getNbrgrain();
            String ligne2=""+decrire.getDosage();
            font3(pageContentByte);
            pageContentByte.setTextMatrix(50,dy);
            pageContentByte.showText(ligne1);
            dy-=40;
            font4(pageContentByte);
            pageContentByte.setTextMatrix(50, dy);
            pageContentByte.showText(ligne2);
            dy-=50;
        }



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
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        pageContentByte.setColorFill(Color.BLACK);
        pageContentByte.setFontAndSize(baseFont,24);
    }
    public void font3(PdfContentByte pageContentByte) throws IOException {
        BaseFont baseFont = BaseFont.createFont(
                BaseFont.COURIER,
                BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        pageContentByte.setColorFill(Color.BLACK);
        pageContentByte.setFontAndSize(baseFont,22);
    }
    public void font4(PdfContentByte pageContentByte) throws IOException {
        BaseFont baseFont = BaseFont.createFont(
                BaseFont.COURIER_BOLD,
                BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        pageContentByte.setColorFill(Color.BLACK);
        pageContentByte.setFontAndSize(baseFont,19);
    }
}
