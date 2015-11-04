package com.silverneem.study.core.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@CreatedBy
	@Column(name = "CREATEDBY", length = 250)
	private String createdBy;
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@CreatedDate
	@Column(name = "CREATED")
	private Date created;
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@LastModifiedBy
	@Column(name = "LASTMODIFIEDBY", length = 250)
	private String lastmodifiedBy;
	
	public String getLastmodifiedBy() {
		return lastmodifiedBy;
	}

	public void setLastmodifiedBy(String lastmodifiedBy) {
		this.lastmodifiedBy = lastmodifiedBy;
	}

	@LastModifiedDate
	@Column(name = "LASTMODIFIED")
	private Date lastmodified;

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	@Column(name = "DELETED")
	private Boolean deleted;

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
