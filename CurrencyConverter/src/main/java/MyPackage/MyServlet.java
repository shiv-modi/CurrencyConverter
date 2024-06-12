package MyPackage;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String amount = request.getParameter("amount");
	    float a= Float.parseFloat(amount);
	    long ab = (long)a;
	    String baseCurrency = request.getParameter("base_currency");
	    String targetCurrency = request.getParameter("target_currency");
	    
	    // Construct the URL for the API request
	    String urlString = "https://v6.exchangerate-api.com/v6/-----YOUR API KEY ----/latest/" + baseCurrency;
	    
	    try {
	        URL url = new URL(urlString);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        // Check if the request was successful
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            InputStream stream = connection.getInputStream();
	            InputStreamReader reader = new InputStreamReader(stream);
	            Scanner scanner = new Scanner(reader);
	            StringBuilder sBuilder = new StringBuilder();
	            while (scanner.hasNext()) {
	                sBuilder.append(scanner.next());
	            }

	            // Parse the JSON response
	            Gson gson = new Gson();
	            JsonObject jObject = gson.fromJson(sBuilder.toString(), JsonObject.class);
	            // Get the conversion rate for the target currency
	            Float conversionRate = jObject.getAsJsonObject("conversion_rates").get(targetCurrency).getAsFloat();

	            // Calculate the converted amount
	            Float convertedAmount = conversionRate * ab;

	            // Set the attribute and forward to the JSP
	            request.setAttribute("conversion_rates", convertedAmount);
	            request.setAttribute("targetCurrency", targetCurrency);

	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } else {
	            // Handle API request failure
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to get exchange rate");
	        }
	    } catch (Exception e) {
	        // Handle exceptions
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
	    }
	}

}
