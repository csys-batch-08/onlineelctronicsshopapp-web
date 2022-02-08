package com.onlineelectronicshop.model;

	import java.util.Objects;
	public class Components {
		private int componentId;
		private String componentName;
		private String categoryName;
		private String description;
		private double price;
		private String available;
		private  String image;
		
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getComponentId() {
			return componentId;
		}
		public void setComponentId(int componentId) {
			this.componentId = componentId;
		}
		public String getComponentName() {
			return componentName;
		}
		public void setComponentName(String componentName) {
			this.componentName = componentName;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getAvailable() {
			return available;
		}
		public void setAvailable(String available) {
			this.available = available;
		}
		
	
		
		public Components() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		public Components(int componentId, String componentName, String categoryName, String description, double price,
				String available, String image) {
			super();
			this.componentId = componentId;
			this.componentName = componentName;
			this.categoryName = categoryName;
			this.description = description;
			this.price = price;
			this.available = available;
			this.image = image;
		}
		public Components(String componentName, String categoryName, String description, double price,
				String available) {
			super();
			this.componentName = componentName;
			this.categoryName = categoryName;
			this.description = description;
			this.price = price;
			this.available = available;
		}
		
		
		public Components(int componentId, String componentName, String categoryName, String description, double price,
				String available) {
			super();
			this.componentId = componentId;
			this.componentName = componentName;
			this.categoryName = categoryName;
			this.description = description;
			this.price = price;
			this.available = available;
		}
		public Components(String componentName2, String categoryName2, String description2, Double price2,
				String available2, String image2) {
			this.componentName = componentName2;
			this.categoryName = categoryName2;
			this.description = description2;
			this.price = price2;
			this.available=available2;
			this.image=image2;
			// TODO Auto-generated constructor stub
		}
		public Components(int int1, String string, String string2, String string3, double double1) {
			this.componentId = int1;
			this.componentName = string;
			this.categoryName = string2;
			this.description = string3;
			this.price = double1;
			
			
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Components [componentName=" + componentName + ", categoryName=" + categoryName + ", description="
					+ description + ", price=" + price + ", available=" + available + "]";
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(available, categoryName, componentName, description, price);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Components other = (Components) obj;
			return Objects.equals(available, other.available) && Objects.equals(categoryName, other.categoryName)
					&& Objects.equals(componentName, other.componentName)
					&& Objects.equals(description, other.description)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
		}
		
	
		}
		
		
		
		
	
