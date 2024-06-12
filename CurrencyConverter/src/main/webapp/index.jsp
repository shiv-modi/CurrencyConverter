<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Converter</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
        <h1 class="text-2xl font-bold mb-4 text-center">Currency Converter</h1>
       <form action="MyServlet" method="post" class="space-y-4">
	    <div>
	        <label for="amount" class="block text-gray-700">Amount:</label>
	        <input type="number" id="amount" name="amount" class="mt-1 p-2 w-full border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" required>
	    </div>
	    <div>
	        <label for="from-currency" class="block text-gray-700">From:</label>
	        <select id="from-currency" name="base_currency" class="mt-1 p-2 w-full border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
	            <option value="USD">USD - United States Dollar</option>
	            <option value="INR">INR - Indian Rupee </option>
	            <!-- Add more currencies as needed -->
	        </select>
	    </div>
	    <div>
	        <label for="to-currency" class="block text-gray-700">To:</label>
	        <select id="to-currency" name="target_currency" class="mt-1 p-2 w-full border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
	            <option value="USD">USD - United States Dollar</option>
	            <option value="INR">INR - Indian Rupee </option>
	            <!-- Add more currencies as needed -->
	        </select>
	    </div>
	    <div>
	        <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded-lg hover:bg-blue-600">Convert</button>
	    </div>
	</form>
        <div id="result" class="mt-4 text-center text-lg">Amount : ${conversion_rates} ${targetCurrency}</div>
    </div>