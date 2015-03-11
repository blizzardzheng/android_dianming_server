package com.web.discuss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.origin.base.DAOBase; 



public class DiscussMgrDao {

	

	public  void delete( String id ){
			DAOBase dao = new DAOBase(); 
			String sql = " delete from  discuss where id=" + id  ; 
			dao.executeSql(sql);   	  
	}
	
	
	public  void save( Discuss object ){

    	DAOBase dao = new DAOBase(); 
    	String sql = null; 
    	if( object.getId() == 0) {
    		sql =   "insert into discuss (  news_id , content , tbl_date ,  type , answer )" +
					"  values(  " + object.getNews_id()    + "  , '" + object.getContent()   +   "' , '" + 
					object.getTbl_date() +  "' , " +  object.getType() +   " , '" + object.getAnswer()  + "' )";   
    	} 

		dao.executeSql(sql);   	 
	}
	
	
	public  void update( String id , String answer ){

    	DAOBase dao = new DAOBase(); 
    	String sql = null; 
    	sql = " update discuss  set  answer = '" + answer + "'  where id = " + id  ; 
    	 
		dao.executeSql(sql);   	 
	}
	

	public  Discuss getObjectById( String id ){
		
    	DAOBase dao = new DAOBase();
		Discuss object =  null ; 
		try { 
			String sql = "select * from  discuss  where id=" + id ;  
			 
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			if(rs.next()) {

				object = new Discuss(); 
				object.setId(  rs.getInt("id")  ); 
				object.setNews_id(    rs.getLong("news_id")   );   
				object.setContent(  rs.getString("content") );
				object.setTbl_date(  rs.getString("tbl_date") );
				object.setType(   rs.getInt("type")    );
				object.setAnswer( rs.getString("answer") ); 
				return object ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dao != null)
				dao.release();			
		}
		return null;
	}
	

	public boolean isExist( long newsId  , String userId , String dateTime ){
		
		List<Discuss> list = new ArrayList() ;
    	DAOBase dao = new DAOBase();
		try { 
			String sql = "select * from discuss   where news_id=" + newsId  + " and answer = '" + userId + "' and tbl_date  like '%" + dateTime + "%' ";   
			
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			if(rs.next()) {
				return true ; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dao != null)
				dao.release();			
		}
		return false ;
	}
	

	
	public  List getAll( String id  , String t  ){
		
		List<Discuss> list = new ArrayList() ;
    	DAOBase dao = new DAOBase();
		try { 
			String sql = "select * from discuss   where news_id=" + id  + " and type = " + t ;   
			
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			while(rs.next()) {
				Discuss object = new Discuss(); 
				object.setId(  rs.getInt("id")  ); 
				object.setNews_id(    rs.getLong("news_id")   );   
				object.setContent(  rs.getString("content") );
				object.setTbl_date(  rs.getString("tbl_date") );
				object.setType(   rs.getInt("type")    );
				object.setAnswer( rs.getString("answer") ); 
				list.add(object); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dao != null)
				dao.release();			
		}
		return list;
	}
	
	 
	
	
	
}
