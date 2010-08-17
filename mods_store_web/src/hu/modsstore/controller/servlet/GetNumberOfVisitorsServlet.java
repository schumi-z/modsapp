package hu.modsstore.controller.servlet;

import hu.modsstore.model.dto.Szamlalo;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetNumberOfVisitorsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		FelhasznaloService fs = ((FelhasznaloService) SpringUtil
				.getBean("felhasznaloService"));
		
		Szamlalo latogatokSzama = fs.findSzamlalo(new Long(1));

		if (latogatokSzama == null) {
			latogatokSzama = new Szamlalo();
			latogatokSzama.setLatogatokSzama(new Long(1));
			out.write("1");
			fs.create(latogatokSzama);
		} else {

			if (Boolean.getBoolean(request.getSession().getAttribute("belepett")+"")){
			Long latogatokSzamaUj = latogatokSzama.getLatogatokSzama() + 1;
			out.write(latogatokSzamaUj+"");

			latogatokSzama.setLatogatokSzama(latogatokSzamaUj);
			fs.update(latogatokSzama);
			}else{
				
				out.write(latogatokSzama.getLatogatokSzama()+"");
				
			}

		}
		
		request.getSession().setAttribute("belepett","false");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
