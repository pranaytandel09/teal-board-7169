package com.stockguru.utils;



	public class SellingPriceGenerator {

		public static int generatePrice() {

			// random function generates value between 0.0000111 to 0.9999

			return (int) (Math.random() * 10000);
		}

	}

