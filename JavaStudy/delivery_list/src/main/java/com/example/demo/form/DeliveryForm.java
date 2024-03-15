package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 配送情報 リクエストデータ
 */
@Data
public class DeliveryForm {
	/**
	   * 配送ID
	   */
	private Integer delivery_id;

	/**
	 * 配送先小学校
	 */
	@NotEmpty(message = "配送先小学校を入力してください")
	private String school;

	/**
	 * メニュー
	 */
	@NotEmpty(message = "メニューを入力してください")
	private String menu;

	/**
	 * オーダー数
	 */
	@NotNull(message = "オーダー数を入力してください")
	private Integer number_of_order;

	/**
	 * ステータス
	 */
	@NotEmpty(message = "ステータスを入力してください")
	private String status;

}
