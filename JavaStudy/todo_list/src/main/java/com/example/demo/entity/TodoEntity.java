package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Todo情報 Entity
 */
@Data
@Entity
@Table(name = "todo")
public class TodoEntity  {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	/**
	 * todo
	 */
	@Column(name = "todo")
	private String todo;
	/**
	 * 担当者
	 */
	@Column(name = "person")
	private String person;
	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;
	/**
	 * todo
	 */
	@Column(name = "memo")
	private String memo;
	
}