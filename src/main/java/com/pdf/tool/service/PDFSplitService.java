package com.pdf.tool.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.stereotype.Service;

@Service
public class PDFSplitService {
	
	public boolean splitPDF(String outputdir, File file, int startindex, int endindex, String outputfilename) {
		
		System.out.println("getting into splitpdf service..");
		
		boolean value=false;
		System.out.println(outputdir);
		PDDocument doc;
		try {
			doc = PDDocument.load(file);
			//get the total number of pages in the pdf file
			int totalpages =  doc.getNumberOfPages();
			
			System.out.println(totalpages);
			
			//validate the startindex and endindex
			if(startindex > totalpages)
				return value;
			
			if(endindex > totalpages)
				return value;
			
			//Split the PDF file based on the start page number and end page number
			System.out.println("split starts...");
			Splitter splitter = new Splitter();
			splitter.setStartPage(startindex);
			System.out.println("--------------start page set-----------------"+startindex);
			splitter.setEndPage(endindex);
			System.out.println("--------------end page set-----------------"+ endindex);
			splitter.setSplitAtPage(endindex);
			System.out.println("--------------set split at page-----------------"+endindex);
			List<PDDocument> splittedlist =  splitter.split(doc);
			File downloadfilepath = new File(outputdir +  File.separator + outputfilename);
			for(PDDocument document: splittedlist) {
				document.save(downloadfilepath);
				System.out.println("--------------document saved-----------------");
				document.close();
				doc.close();
				value = true;
				return value;
			}
		} catch (InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return value;
	}

}
