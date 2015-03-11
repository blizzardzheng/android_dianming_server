package com.web.info;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@SuppressWarnings("serial")
public class InfoEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
 

		InfoMgrDao infoMgrDao = new InfoMgrDao();

		Info info = new Info();

		info.info_name = req.getParameter("name") ;
		info.info_description = req.getParameter("description") ;
		info.info_flag = req.getParameter("flag") ;
		

		// 生成二维码
		String barcodeFile = String.valueOf(System.currentTimeMillis());
		String contents = barcodeFile; 
		barcodeFile = barcodeFile + ".png";

		String imgPath = req.getRealPath("") + "/barcode/" + barcodeFile;
		
		System.out.println( "=== InfoEditServlet imgPath ===" + imgPath );
		
		int width = 300, height = 300;
		this.encode(contents, width, height, imgPath);

		info.info_pic = barcodeFile ;
		info.info_count = contents ;
		
		infoMgrDao.save(info);

		req.setAttribute("s", "0");
		req.getRequestDispatcher("/infoEdit.jsp").forward(req, resp);

	}

	
	/**
	 * 编码
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	public void encode(String contents, int width, int height, String imgPath) {
		Hashtable hints = new Hashtable();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter
					.writeToFile(bitMatrix, "png", new File(imgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
