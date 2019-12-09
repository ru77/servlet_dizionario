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

    private String msg;
    public void init() throws ServletException
    {
       msg = "<h1> Http Servlet Dizionario </h1>";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
    out.println(msg);
    File file = new File("C:/Users/user/Documents/dizionario_servlet_mastro/dizionario.txt");

    if(!file.exists()) { file.createNewFile(); }

    if(req.getParameter("search")!=null)
		{
			FileReader fr = new FileReader("C:/Users/user/Documents/dizionario_servlet_mastro/dizionario.txt"); //put here full path

			BufferedReader br = new BufferedReader(fr);
			String s1,s2,s3;
			while (true)
			{
				s1=br.readLine();
				if(s1==null)
				{
					out.println("<p> parola non trovata </p>");
				}
				else if(s1.equalsIgnoreCase(req.getParameter("search")))
				{
					s2=br.readLine();
					s3=br.readLine();
					break;
				}
			}	
			out.println("<br>"+s1+"<br>"+s2+"<br>"+s3);
			}
			else if(req.getParameter("add")!=null)
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/user/Documents/dizionario_servlet_mastro/dizionario.txt", true));
				bw.newLine();
				bw.write(req.getParameter("add"));
				bw.newLine();
				bw.write("-"+req.getParameter("sinonimi"));
				bw.newLine();
				bw.write("-"+req.getParameter("contrari"));
				bw.close();
			}
			/*else if(req.getParameter("del"))
			{

			}*/
    }
}
