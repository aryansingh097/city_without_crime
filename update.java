

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status=request.getParameter("status");
		String uid=request.getParameter("user_id");
		String name=request.getParameter("name");
		try {
			
			Connection conn = null;
			  String url = "jdbc:mysql://localhost:3306/";
			  String dbName = "test";
			  String driver = "com.mysql.jdbc.Driver";
			  String query2="select * from add_missing_person";
			//  String strQuery = "select * from image_tab";
			  
			  Class.forName(driver).newInstance();
				java.sql.Connection  con = DriverManager.getConnection(url+dbName);
				  java.sql.PreparedStatement st = null;
				  Statement stmt = con.createStatement();

				  
				  int k=0;
					// int i1=stmt.executeUpdate("insert into hcss(username,password) values('"+log+"','"+s+"')");
					ResultSet rs = stmt.executeQuery(query2);
					while (rs.next()) {
			             if ((name.equals(rs.getString("missing_person_name")) && uid.equals(rs.getString("user_id")))) {
			            	  st = con.prepareStatement("UPDATE add_missing_person SET status = '"+status+"' WHERE  user_id = '"+uid+"' and missing_person_name='"+name+"'");
							  
							  int i = st.executeUpdate();
							  
							  System.out.println("Query Executed Successfully++++++++++++++");
							  k=-1;
					 break;
					 // the data
			             }
			             else
			            k++;	 }
				
					if(k>0)
				 {response.sendRedirect("missupdate.jsp");}
					else
						response.sendRedirect("update.jsp");	
				  st.close();
				  con.close();
			}
			catch (Exception e){
				e.printStackTrace();
				}

			
		}
	}


