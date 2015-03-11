package com.web.info;

 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;



@SuppressWarnings("serial")
public class InfoMgrServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	    String flag = req.getParameter("f");
		InfoMgrDao infoMgrDao = new InfoMgrDao();
	 	String type = req.getParameter("type");
	 	
	 	if ( req.getParameter("method") != null){
	 		
	 		if( req.getParameter("method").equals("del") ) {
	 	        String id = req.getParameter("id") ;
	 	        infoMgrDao.delete(id);
	 		}else if( req.getParameter("method").equals("searchCode") ) {
	 		     JSONArray jsonArray = null;
	 		     jsonArray = JSONArray.fromObject( infoMgrDao.searchCode(  req.getParameter("search_type")  ) );
	 		      
//	 		      resp.setContentType("application/x-json");
	 		      resp.setCharacterEncoding("gb2312");
	 		      resp.getWriter().write(jsonArray.toString());
	 		      return;
	 		}
	 	}
	 	
	    if (type != null) {
	      JSONArray jsonArray = null;
	      if (flag != null)
	        jsonArray = JSONArray.fromObject( infoMgrDao.getFoodsByFlag( flag ) );
	      else {
	        jsonArray = JSONArray.fromObject( infoMgrDao.getAll( req.getParameter("search_type") ) );
	      }
	      
//	      resp.setContentType("application/x-json");
	      resp.setCharacterEncoding("gb2312");

	      resp.getWriter().write(jsonArray.toString());
	    }  else {
	    
	    	if( req.getParameter("all") != null && !"null".equals( req.getParameter("all") ) ){
	    		req.setAttribute("all",  "1" ); 
	  			req.setAttribute("list",  infoMgrDao.getAll(null) ); 
	    	}else{
	  	      if ((flag != null) && (!flag.equals(""))) {
		    	  	req.setAttribute("list", infoMgrDao.getFoodsByFlag(flag ));
		    	  	req.setAttribute("flag", flag);
		      } else { 
		  			req.setAttribute("all",  "1" ); 
		  			req.setAttribute("list",  infoMgrDao.getAll(null ) ); 
		      }
	    	}

			req.getRequestDispatcher("/infoList.jsp").forward(req, resp);
	    }
		    
	}
 
  
	
}
