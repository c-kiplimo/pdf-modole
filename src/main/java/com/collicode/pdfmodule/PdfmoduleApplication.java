package com.collicode.pdfmodule;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
		PDPage page = new PDPage();
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

		int pageHeight =(int) page.getTrimBox().getHeight();
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


		document.save("/home/collins/Desktop/pdfmodule/my_first_pdf.pdf");
		document.close();
		System.out.println("Done");
	}

}

