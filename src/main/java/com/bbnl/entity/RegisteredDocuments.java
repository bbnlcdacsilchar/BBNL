package com.bbnl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "service_provider_documents")
public class RegisteredDocuments {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "sp_doc_id")
	    private Long spDocId;
	  
		
		@ManyToOne()
		@JoinColumn(name = "sp_id")
	    private ServiceProvider serviceProvider;
	     
		@Column(name = "sp_doc_name")
	    private String spDocName;

		public RegisteredDocuments() {
			
		}

		/*
		 * public RegisteredDocuments(ServiceProvider serviceProvider, String spDocName)
		 * {
		 * 
		 * this.serviceProvider = serviceProvider; this.spDocName = spDocName; }
		 */
		public RegisteredDocuments(String spDocName, ServiceProvider serviceProvider) {
			super();
			this.spDocName = spDocName;
			this.serviceProvider = serviceProvider;
			
		}

		public Long getSpDocId() {
			return spDocId;
		}

		public void setSpDocId(Long spDocId) {
			this.spDocId = spDocId;
		}

		public ServiceProvider getServiceProvider() {
			return serviceProvider;
		}

		public void setServiceProvider(ServiceProvider serviceProvider) {
			this.serviceProvider = serviceProvider;
		}

		public String getSpDocName() {
			return spDocName;
		}

		public void setSpDocName(String spDocName) {
			this.spDocName = spDocName;
		}

		@Override
		public String toString() {
			return "RegisteredDocuments [spDocId=" + spDocId + ", serviceProvider=" + serviceProvider + ", spDocName="
					+ spDocName + "]";
		}
}