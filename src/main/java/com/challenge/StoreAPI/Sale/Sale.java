package com.challenge.StoreAPI.Sale;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
			
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int saleId;
		
		private int sellerId;
		
		private int customerId;
		
		private int productId;
		
		private double evaluation;
		
		private Date saleDate;
		
		public Sale() {
			
		}
		
		public Sale(int sellerId, int customerId, int productId, double evaluation, Date saleDate) {
			this.sellerId = sellerId;
			this.customerId = customerId;
			this.productId = productId;
			this.evaluation = evaluation;
			this.saleDate = saleDate;
		}

		public int getSaleId() {
			return saleId;
		}

		public void setSaleId(int saleId) {
			this.saleId = saleId;
		}

		public int getSellerId() {
			return sellerId;
		}

		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public double getEvaluation() {
			return evaluation;
		}

		public void setEvaluation(double evaluation) {
			this.evaluation = evaluation;
		}		
		
		public Date getSaleDate() {
			return saleDate;
		}

		public void setSaleDate(Date saleDate) {
			this.saleDate = saleDate;
		}	

}
