package hu.modsstore.utility;

import hu.modsstore.webshop.CartItem;
import hu.modsstore.webshop.ShoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateCartContent
 */
public class UpdateCartContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("count")+" "+request.getParameter("itemId"));
		
		HttpSession session = request.getSession();
		
		PrintWriter pw = response.getWriter();
		
		long cartItemId = Long.parseLong(request.getParameter("itemId"));
		
		long neccessaryQuantity = Long.parseLong(request.getParameter("count"));
		
		if (neccessaryQuantity<=0)
		{
			pw.write("invalidquantity");
		}
		
		else{
				ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
				
				List<CartItem> items = sc.getCart();
				
				CartItem item = null;
				
				for(int i=0; i<items.size(); i++){
					if ((item=items.get(i)).getItemID()==cartItemId){
						
						item.setCount(neccessaryQuantity);
						
						item.setTotalPrice(item.getItemPrice()*neccessaryQuantity);
						
						break;
					}
				}
				
				sc.setCart((ArrayList<CartItem>) items);
				
				pw.write(cartItemId+" "+item.getTotalPrice()+" "+sc.getTotalPrice());
		}
	}

}
