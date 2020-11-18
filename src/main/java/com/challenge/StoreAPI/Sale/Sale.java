package com.challenge.StoreAPI.Sale;

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
		
		private float evaluation;
		
		public Sale() {
			
		}
		
		public Sale(Integer saleId, int sellerId, int customerId, int productId, float evaluation) {
			this.sellerId = sellerId;
			this.customerId = customerId;
			this.productId = productId;
			this.evaluation = evaluation;
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

		public float getEvaluation() {
			return evaluation;
		}

		public void setEvaluation(float evaluation) {
			this.evaluation = evaluation;
		}		

}
