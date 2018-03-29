package com.rand.projetomaven.domain;

import java.io.Serializable;

public class Address implements Serializable{
		private static final long serialVersionUID = 1L;
	
		private Integer id;
		private String number;
		private String complement;
		private String district;
		private String publicPlace;
		private String zipCode;
		
		
		private Costumer costumer;
		
		private City city; 
		
		public Address() {
			
		}

		public Address(Integer id, String number, String complement, String district, String publicPlace,
				String zipCode, Costumer costumer, City city) {
			super();
			this.id = id;
			this.number = number;
			this.complement = complement;
			this.district = district;
			this.publicPlace = publicPlace;
			this.zipCode = zipCode;
			this.costumer = costumer;
			this.setCity(city);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Address other = (Address) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getComplement() {
			return complement;
		}

		public void setComplement(String complement) {
			this.complement = complement;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getPublicPlace() {
			return publicPlace;
		}

		public void setPublicPlace(String publicPlace) {
			this.publicPlace = publicPlace;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public Costumer getCostumer() {
			return costumer;
		}

		public void setCostumer(Costumer costumer) {
			this.costumer = costumer;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}
		
		
		
}
