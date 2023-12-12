package com.collicode.pdfmodule;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;

//@SpringBootApplication
public class PdfmoduleApplication {

    public static void main(String[] args) throws IOException {

//		File oldFile = new File("/home/collins/Documents/spring_boot_tutorial.pdf");
//		PDDocument document = PDDocument.load(oldFile);
//		Splitter splitter = new Splitter();
//		List<PDDocument>spitPages=splitter.split(document);
// int num =1;
//		for (PDDocument pdDocument : spitPages) {
//			pdDocument.save("/home/collins/Desktop/pdfmodule/split_o"+num+".pdf");
//		    num++;
//			pdDocument.close();
//		}
//		System.out.println("Splitting done");


//
//		PDDocument document = new PDDocument();
//		PDPage page = new PDPage();
//		document.addPage(page);
//		PDDocumentInformation docInfo = document.getDocumentInformation();
//		docInfo.setAuthor("Collins");
//		docInfo.setTitle("My first pdf");
//		docInfo.setSubject("My first pdf");
//		docInfo.setKeywords("My first pdf");
//		docInfo.setCreator("Collins");
//
//
//		final int keyLength = 128;
//		AccessPermission accessPermission = new AccessPermission();
//		accessPermission.setCanPrint(false);
//		accessPermission.setCanExtractContent(false);
//		accessPermission.setCanModify(false);
//		StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("1234", "hello", accessPermission);
//		standardProtectionPolicy.setEncryptionKeyLength(keyLength);
//		standardProtectionPolicy.setPermissions(accessPermission);
//		document.protect(standardProtectionPolicy);
//		document.save("/home/collins/Desktop/pdfmodule/my_first_pdf.pdf");
//		document.close();
//		System.out.println("Done");

        PDDocument document = new PDDocument();
        PDRectangle pdRectangle = new PDRectangle(600, 900);
        PDPage page = new PDPage(pdRectangle);
        document.addPage(page);
//		PDPageContentStream contentStream = new PDPageContentStream(document, page);
//		contentStream.beginText();
//		contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
//		contentStream.setLeading(16.0f);
//		contentStream.newLineAtOffset(25, page.getTrimBox().getHeight()-25);
//
//		String text = "This is a sample document and we are adding content to it.";
//		String text2 = "This is a sample document and we are adding content to it.";
//		String text3 = "This is a sample document and we are adding content to it.";
//
//		contentStream.showText(text);
//		contentStream.newLine();
//		contentStream.showText(text2);
//		contentStream.newLine();
//		contentStream.showText(text3);
//		contentStream.endText();
//		contentStream.close();


//		PDImageXObject pdImageXObject = PDImageXObject.createFromFile("/home/collins/Desktop/IMG-20230409-WA0028.jpg", document);
//		PDPageContentStream contentStream = new PDPageContentStream(document, page);
//		contentStream.drawImage(pdImageXObject, 25, 25);
//       		contentStream.close();

	/*	int pageHeight =(int) page.getTrimBox().getHeight();
		int pageWidth = (int) page.getTrimBox().getWidth();
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.setStrokingColor(Color.DARK_GRAY);
		contentStream.setLineWidth(1);

		int initX =50;
		int initY = pageHeight-50;
		int cellHeight = 30;
		int cellWidth = 100;

		int colCount = 5;
		int rowCount = 10;

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				contentStream.addRect(initX, initY, cellWidth, -cellHeight);
				contentStream.beginText();
				contentStream.newLineAtOffset( initX+10, initY-cellHeight+10);
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
				contentStream.showText("Hello");
				contentStream.endText();


				initX += cellWidth;

			}
			initX = 50;
			initY -= cellHeight;
		}
		contentStream.stroke();
		contentStream.close();
*/
        String[] visitorDetails = {"Collins", "11", "Juja", "20-14-2022", "9:00 am to 4:00 pm"};
        int pageWidth = (int) page.getTrimBox().getWidth();
        int pageHeight = (int) page.getTrimBox().getHeight();

        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //background image
        PDImageXObject pdImageXObject = PDImageXObject.createFromFile("/home/collins/Desktop/pdfmodule/src/main/resources/img/background.png", document);
        contentStream.drawImage(pdImageXObject, 0, 0);
        contentStream.fill();
        //blue rect

        contentStream.setNonStrokingColor(new Color(0, 191, 243));
        contentStream.addRect(0, pageHeight - 90, pageWidth, 90);
        contentStream.fill();

        //birdImage
        PDImageXObject birdImage = PDImageXObject.createFromFile("/home/collins/Desktop/pdfmodule/src/main/resources/img/bird.png", document);
        contentStream.drawImage(birdImage, 0, pageHeight - 268);

//belo bird image
        contentStream.setNonStrokingColor(new Color(46, 49, 146));
        contentStream.addRect(0, pageHeight - 278, pageWidth, 10);
        contentStream.fill();
// for button rect
        contentStream.setNonStrokingColor(new Color(20, 187, 180));
        contentStream.addRect(0, 0, pageWidth, 60);
        contentStream.fill();
// for deer image
        PDImageXObject deerImage = PDImageXObject.createFromFile("/home/collins/Desktop/pdfmodule/src/main/resources/img/deer.png", document);
        contentStream.drawImage(deerImage, 10, 60, 171, 200);
// for tiger image

        PDImageXObject tigerImage = PDImageXObject.createFromFile("/home/collins/Desktop/pdfmodule/src/main/resources/img/tiger.png", document);
        contentStream.drawImage(tigerImage, 270, 62, 314, 146);

// natianal park
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.WHITE);
        String text = "CORBETT NATIONAL PARK";

        float width = font.getStringWidth(text) / 1000 * 40;
        contentStream.newLineAtOffset((pageWidth - width) / 2, pageHeight - 55);
        contentStream.showText(text);
        contentStream.endText();
// visitor pass
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.BLACK);
        String text1 = "VISITOR PASS";

        float width1 = font.getStringWidth(text1) / 1000 * 40;
        contentStream.newLineAtOffset((pageWidth - width1) / 2, pageHeight - 330);
        contentStream.showText(text1);
        contentStream.endText();
//Details head
        contentStream.beginText();
        contentStream.setFont(font, 30);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setLeading(45);
        contentStream.newLineAtOffset(200, pageHeight - 400);

        String[] detailsArray = {"Name     ", "Age ", "City ", "Date", "Time"};
        for (String detail : detailsArray) {
            contentStream.showText(detail);
            contentStream.newLine();
        }
        contentStream.endText();


        contentStream.beginText();
        contentStream.setFont(font, 30);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setLeading(45);
        contentStream.newLineAtOffset(200, pageHeight - 400);


        for (String visitorDetail : visitorDetails) {
            contentStream.showText("            :     " + visitorDetail);
            contentStream.newLine();
        }
        contentStream.endText();
//stay away array
        contentStream.beginText();
        contentStream.setFont(font, 40);
        contentStream.setNonStrokingColor(Color.WHITE);
        String text2 = "Stay away from the wild animals";
        float width2 = font.getStringWidth(text2) / 1000 * 40;
        contentStream.newLineAtOffset((pageWidth - width2) / 2, 20);
        contentStream.showText(text2);
        contentStream.endText();


        contentStream.close();
        document.save("/home/collins/Desktop/pdfmodule/my_first_pdf.pdf");
        document.close();
        System.out.println("Done");
    }

}

