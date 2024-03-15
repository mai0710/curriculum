package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryEntity;
import com.example.demo.form.DeliveryForm;
import com.example.demo.repository.DeliveryRepository;

/**
 * 配送情報 Service
 */
@Service
public class DeliveryService {
	/**
	 * 配送情報 Repository
	 */
	@Autowired
	private DeliveryRepository deliveryRepository;

	/**
	 * 配送情報 全検索
	 * @return  検索結果
	 */
	public List<DeliveryEntity> searchAll() {
		return deliveryRepository.findAll();
	}
	/**
	 * 配送情報 新規登録
	 * @param  delivery 配送情報
	 */
	public void create(DeliveryForm deliveryRequest) {
		DeliveryEntity delivery = new DeliveryEntity();
		delivery.setSchool(deliveryRequest.getSchool());
		delivery.setMenu(deliveryRequest.getMenu());
		delivery.setNumber_of_order(deliveryRequest.getNumber_of_order());
		delivery.setStatus(deliveryRequest.getStatus());
		deliveryRepository.save(delivery);
	}
	/**
	 * 配送情報 主キー検索
	 * @return  検索結果
	 */
	public DeliveryEntity findById(Integer delivery_id) {
		return deliveryRepository.getOne(delivery_id);
	}
	/**
	 * 配送情報 更新
	 * @param  delivery 配送情報
	 */
	public void update(DeliveryForm deliveryUpdateRequest) {
		DeliveryEntity delivery = findById(deliveryUpdateRequest.getDelivery_id());
		delivery.setSchool(deliveryUpdateRequest.getSchool());
		delivery.setMenu(deliveryUpdateRequest.getMenu());
		delivery.setNumber_of_order(deliveryUpdateRequest.getNumber_of_order());
		delivery.setStatus(deliveryUpdateRequest.getStatus());
		deliveryRepository.save(delivery);
	}
	/**
	 * 配送情報 物理削除
	 * @param  delivery_id ID
	 */
	public void delete(Integer delivery_id) {
		DeliveryEntity delivery = findById(delivery_id);
		deliveryRepository.delete(delivery);
	}

}
