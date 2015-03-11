package edu.self.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RegisterAccount
 * 
 * @author mzba
 */
public class SendComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendComment() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String result = "";
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String rid = request.getParameter("rid");
		String uid = request.getParameter("uid");

		boolean userResult = DBControl.insertComent( rid, price, description, uid) ;
		 
		if (userResult) { 
			result = "SUCCESS";
		} else {
			result = "ERROR";
		}
			  
		response.getWriter().println(result);
	}

}
