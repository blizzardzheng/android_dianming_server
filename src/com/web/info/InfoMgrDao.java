package com.web.info;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.origin.base.DAOBase;  
import com.web.util.Constant;



public class InfoMgrDao {

	

	public  void delete( String id ){
			DAOBase dao = new DAOBase(); 
			String sql = " delete from  " + Constant.DB_PREFIX + "info_info   where  info_id=" + id  ; 
			dao.executeSql(sql);   	  
	}
	
	
	public  void save( Info object ){

    	DAOBase dao = new DAOBase(); 
		String sql =  "insert into " + Constant.DB_PREFIX + "info_info ( info_name  , info_pic , info_description ,   info_count , info_flag ) values( '" + 
								object.info_name  + "' , '" + object.info_pic  + "' , '" + object.info_description + "' , '" + 
								object.info_count +   "' , " + object.info_flag  + " )";   
		dao.executeSql(sql);   	 
	}

	
	public  List getAll( String search_type ){
		
		List<Info> list = new ArrayList() ;
    	DAOBase dao = new DAOBase();
		try { 
			String sql=" select * from " + Constant.DB_PREFIX + "info_info where 1=1  ";  
			
			if( search_type != null ){
				sql += " and info_description  like '%" + search_type + "%'  "  ;
			}
			sql += "    order by info_id desc   " ;
			
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			while(rs.next()) {
				Info object = new Info();
				object.info_id =   String.valueOf( rs.getInt(1))  ;
				object.info_name =  rs.getString(2)  ;
				object.info_pic =  rs.getString(3)  ; 
				object.info_description =  rs.getString(4) ; 
				object.info_flag =   String.valueOf( rs.getInt("info_flag") )  ;
				object.info_count =   rs.getString("info_count") ;
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
	
 
	public  List getFoodsByFlag( String flag   ){
		
		List<Info> list = new ArrayList() ;
    	DAOBase dao = new DAOBase();
		try { 
			String sql=" select * from " + Constant.DB_PREFIX + "info_info  where info_flag=  " + flag + "  "  ;
			sql += "    order by info_id desc   " ;
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			while(rs.next()) {
				Info object = new Info();
				object.info_id =   String.valueOf( rs.getInt(1))  ;
				object.info_name =  rs.getString(2)  ;
				object.info_pic =  rs.getString(3)  ; 
				object.info_description =  rs.getString(4) ; 
				object.info_flag =   String.valueOf( rs.getInt("info_flag") )  ;
				object.info_count =   rs.getString("info_count") ;
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
	
	 
	public  List searchCode( String flag   ){
		
		List<Info> list = new ArrayList() ;
    	DAOBase dao = new DAOBase();
		try { 
			String sql=" select * from " + Constant.DB_PREFIX + "info_info  where info_count like '%" + flag + ".png%'  "  ;
			sql += "    order by info_id desc   " ;
	    	dao.querySql(sql);
    		ResultSet rs = dao.getRes(); 
			while(rs.next()) {
				Info object = new Info();
				object.info_id =   String.valueOf( rs.getInt(1))  ;
				object.info_name =  rs.getString(2)  ;
				object.info_pic =  rs.getString(3)  ; 
				object.info_description =  rs.getString(4) ; 
				object.info_flag =   String.valueOf( rs.getInt("info_flag") )  ;
				object.info_count =   rs.getString("info_count") ;
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
