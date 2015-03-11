package com.web.checkin;

 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.discuss.Discuss;
import com.web.discuss.DiscussMgrDao;
import com.web.util.Tool;



@SuppressWarnings("serial")
public class CheckInMgrServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	   	resp.setCharacterEncoding("utf-8");
	 
	    System.out.println( "barCode==" + req.getParameter("barCode") );

	    DiscussMgrDao dao = new DiscussMgrDao();

	    long news_id = Long.valueOf( req.getParameter("barCode") ) ;
	    String user_id = req.getParameter("user_id") ;
	    
	    if( dao.isExist(news_id, user_id, Tool.getNowDayTime()) ){
    		resp.getWriter().write( "2");
	    }else{
		   	Discuss object  = new Discuss(); 
		   	object.setContent( req.getParameter("user_name")   ) ;
		   	object.setNews_id( news_id ) ;
		   	object.setType( 1 ) ;
		   	object.setTbl_date( Tool.getNowTime() ) ;
		   	object.setAnswer(user_id) ;
	 
		   	dao.save( object ) ;
		   	
    		resp.getWriter().write( "1");
	    }
	    	
	}
 
  
	
}
