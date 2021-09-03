package com.mocadev.jpabook.jpashop.respository;

import com.mocadev.jpabook.jpashop.domain.item.UploadItem;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-03
 **/
@Repository
public class UploadItemRepository {

	private final Map<Long, UploadItem> store = new HashMap<>();
	private long sequence = 0L;

	public UploadItem save(UploadItem item) {
		item.setId(++sequence);
		store.put(item.getId(), item);

		return item;
	}

	public UploadItem findById(Long id) {
		return store.get(id);
	}

}
