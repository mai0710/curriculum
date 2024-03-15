package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 配送情報 Entity
 */
@Data
@Entity
@Table(name = "delivery")
public class DeliveryEntity {
	/**
	 * 配送ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private Integer delivery_id;

	/**
	 * 配送先小学校
	 */
	@Column(name = "school")
	private String school;
	
	/**
	 * メニュー
	 */
	@Column(name = "menu")
	private String menu;
	
	/**
	 * オーダー数
	 */
	@Column(name = "number_of_order")
	private Integer number_of_order;
	
	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;
}
