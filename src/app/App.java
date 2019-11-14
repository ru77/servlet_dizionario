package app;

import java.io.*;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class App extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = -3967314453512919811L;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java 1");
    }

    private String mymsg;
    public void init() throws ServletException
    {
       mymsg = "Http Servlet Demo";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		while(true)
		{
			if(req.getParameter("search")!=null)
			{
				FileReader fr = new FileReader("dizionario.txt");
				BufferedReader br = new BufferedReader(fr);
				String s1,s2,s3;
				while(true)
				{
					s1=br.readLine();
					if(s1==null)
					{ 
						out.println("<p> parola non trovata </p>"); 
						break; 
					}
					if(s1.equalsIgnoreCase(req.getParameter("search")))
					{
						s2=br.readLine();
						s3=br.readLine();
						out.println(s1+s2+s3);
					}
				  }
			}
			else if(req.getParameter("add")!=null)
			{	
				BufferedWriter bw = new BufferedWriter(new FileWriter("dizionario.txt", true));
				bw.newLine();
				bw.write(req.getParameter("add"));
				bw.newLine();
				bw.write("-"+req.getParameter("Sinonimi"));
				bw.newLine();
				bw.write("-"+req.getParameter("Contrari"));
				bw.close();
			}
				 
			/*else if(req.getParameter("del"))
			{
					
			}*/
			
		}
    }
}

