package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.DeliveryEntity;
import com.example.demo.form.DeliveryForm;
import com.example.demo.service.DeliveryService;

/**
 * 配送情報 Controller
 */
@Controller
public class DeliveryController {

	/**
	 * 配送情報 Service
	 */
	@Autowired
	DeliveryService deliveryService;

	/**
	 * 配送情報一覧画面を表示
	 * @param  model Model
	 * @return  配送情報一覧画面のHTML
	 */

	@GetMapping("/delivery/list")
	public String deliveryList(Model model) {
		List<DeliveryEntity> deliverylist = deliveryService.searchAll();
		model.addAttribute("deliverylist", deliverylist);
		return "delivery/list";
	}

	/**
	 * 配送新規登録画面を表示
	 * @param  model Model
	 * @return  配送新規登録画面
	 */
	@GetMapping("/delivery/add")
	public String deliveryRegister(Model model) {
		model.addAttribute("deliveryRequest", new DeliveryForm());
		return "delivery/add";
	}

	/**
	 * 配送新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  配送情報一覧画面
	 */
	@PostMapping("/delivery/create")
	public String deliveryCreate(@Validated @ModelAttribute DeliveryForm deliveryRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("deliveryRequest", new DeliveryForm());
			model.addAttribute("validationError", errorList);
			return "delivery/add";
		}
		// 配送情報の登録
		deliveryService.create(deliveryRequest);
		return "redirect:/delivery/list";
	}

	/**
	 * 配送情報詳細画面を表示
	 * @param  delivery_id 表示する科目ID
	 * @param  model Model
	 * @return  配送情報詳細画面
	 */
	@GetMapping("/delivery/{delivery_id}")
	public String deliveryDetail(@PathVariable Integer delivery_id, Model model) {
		DeliveryEntity delivery = deliveryService.findById(delivery_id);
		model.addAttribute("delivery", delivery);
		return "delivery/detail";
	}

	/**
	 * 配送編集画面を表示
	 * @param  delivery_id 表示する科目ID
	 * @param  model Model
	 * @return  科目編集画面
	 */
	@GetMapping("/delivery/{delivery_id}/edit")
	public String deliveryEdit(@PathVariable Integer delivery_id, Model model) {
		DeliveryEntity delivery = deliveryService.findById(delivery_id);
		DeliveryForm deliveryUpdateRequest = new DeliveryForm();
		deliveryUpdateRequest.setDelivery_id(delivery.getDelivery_id());
		deliveryUpdateRequest.setSchool(delivery.getSchool());
		deliveryUpdateRequest.setMenu(delivery.getMenu());
		deliveryUpdateRequest.setNumber_of_order(delivery.getNumber_of_order());
		deliveryUpdateRequest.setStatus(delivery.getStatus());
		model.addAttribute("deliveryForm", deliveryUpdateRequest);
		return "delivery/edit";
	}

	/**
	 * 配送更新
	 * @param  deliveryRequest リクエストデータ
	 * @param  model Model
	 * @return  配送情報詳細画面
	 */
	@PostMapping("/delivery/update")
	public String deliveryUpdate(@Validated @ModelAttribute DeliveryForm deliveryUpdateRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "delivery/edit";
		}
		// 配送情報の更新
		deliveryService.update(deliveryUpdateRequest);
		return String.format("redirect:/delivery/%d", deliveryUpdateRequest.getDelivery_id());
	}
	 /**
		 * 配送情報削除
		 * @param  id 表示するID
		 * @param  model Model
		 * @return  配送情報詳細画面
		 */
		@GetMapping("/delivery/{delivery_id}/delete")
		public String deliveryDelete(@PathVariable Integer delivery_id, Model model) {
			// 科目情報の削除
			deliveryService.delete(delivery_id);
			return "redirect:/delivery/list";
		}

}