package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user" , schema = "public")
public class UserEntity  {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	//2行追加
	private Integer id;
	/**
	 * 名前
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 住所
	 */
	@Column(name = "address")
	private String address;

	/**
	 * 電話番号
	 */
	//2行追加
	@Column(name = "phone")
	private String phone;
	/**
	 * 更新日時
	 */
	//2行追加
	@Column(name = "update_date")
	private  Date updateDate;

	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;
}