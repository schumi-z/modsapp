package hu.modsstore.controller.servlet;

import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLatestItemServlet
 */
public class GetLatestItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLatestItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Servlet");
		PrintWriter out = response.getWriter();
//		out.write("<table><tr><td>Hello</td></tr></table>");
		
		TermekService ts = (TermekService) SpringUtil.getBean("termekService");
		
		List<Termek> latestFive = ts.getLatestTermek(5);
		
		
		out.write("<table>");
		for (Termek termek : latestFive) {
			out.write("<tr>");
			out.write("<td>");
			out.write("<a href='http://www.modsstore.hu/markakaphatotermekei.do?tipusId="+termek.getTipus().getId()+"&markaId="+termek.getMarka().getId()+"'>"+termek.getNev()+"</a>");
			out.write("</td>");
			out.write("<td>");
			out.write(termek.getEgysegar()+" Ft/db");
			out.write("</td>");
			out.write("</tr>");
		}
		out.write("</table>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
