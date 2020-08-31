package com.pdf.tool.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pdf.tool.service.PDFSplitService;



@RestController
public class PDFSplitController {
	
	@Autowired
	private PDFSplitService service;
	
	@GetMapping(value = "splitpage")
	public ModelAndView mergepage(ModelMap model) {
		// return new ModelAndView("home","","");
		System.out.println("Get mapping split ...");
		//return "Merge";
		return new ModelAndView("split");		
		// return new ModelAndView(new RedirectView("home.jsp"));

	}
	
		
	@SuppressWarnings("resource")
	@PostMapping(value="split")
	public ModelAndView splitPDF(@RequestParam MultipartFile file, int startindex, int endindex, HttpServletResponse response)  {
		
		System.out.println("getting into split controller");
		
		boolean value = false;
		ModelAndView modelandview = new ModelAndView();
		// Setting the Upload Directory which is also a Backup Directory
		String UploadDir = "/home/ec2-user/pdfdir/splitpdf";
		String outputfilename = "splitfile.pdf";
		String finalname=null;
		InputStream in = null;
		String outputdir=(UploadDir + File.separator + outputfilename);
		try {
			byte[] bytes = file.getBytes();			
			String fullfilename2=file.getOriginalFilename();
			System.out.println(fullfilename2);
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			
			String[] firstfile = fileName.split("/");
			for (String name : firstfile) {
				if (name.endsWith(".pdf")) {
					finalname = name;
				}
			}
			System.out.println(finalname);
			// Write the File to the upload directory path
			Path path = Paths.get(UploadDir + File.separator + finalname);
			System.out.println("got the first path: " + path);
			Files.write(path, bytes);
			
			String filepath = (UploadDir + File.separator + finalname);
			File uploadfilepath = new File(filepath);			
			File downloadoutput =  new File(outputdir);
			
			value = service.splitPDF(UploadDir,uploadfilepath, startindex, endindex, outputfilename);
			
			if(value) {
					
				response.setContentType("application/octet-stream");
				String disHeader = "Attachment; Filename=" + outputfilename;
				System.out.println(disHeader);
				response.setHeader("Content-Disposition", disHeader);

				ServletOutputStream outs = response.getOutputStream();

				try {
					in = new BufferedInputStream(new FileInputStream(downloadoutput));

					System.out.println(in);

					int ch;
					while ((ch = in.read()) != -1) {
						outs.print((char) ch);
					}
				} finally {
					if (in != null)
						in.close(); // very important
				}

				outs.flush();
				outs.close();
				// in.close();
				downloadoutput.delete();
				uploadfilepath.delete();
				modelandview=new ModelAndView("split");
				return modelandview;
			}else
			{
				System.out.println("Error message...");
				modelandview=new ModelAndView("split");			 
				modelandview.addObject("errormessage", "Either of the Page Number is INVALID. Please try again with Correct Page Number.");
				return modelandview;
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return modelandview;
		
		
		
		
		
	}

}
