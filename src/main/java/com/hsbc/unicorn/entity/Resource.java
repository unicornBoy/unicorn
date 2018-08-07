package com.hsbc.unicorn.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 实体类
 */
@Data
@Entity
@Table(name = "resource" )
public class Resource {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;//资源id
	@Column(name = "url")
	private String url;//资源链接

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
