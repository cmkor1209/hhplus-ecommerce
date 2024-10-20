package com.hanghae.e_commerce.interfaces.api.item;

import com.hanghae.e_commerce.interfaces.api.item.response.ItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    /**
     * 품목 조회
     */
    @GetMapping("/api/item")
    public ResponseEntity<ItemResponse> getItem() {
        return ResponseEntity.ok().body((ItemResponse) List.of(
                new ItemResponse(1L, "itemA", 1000, 10),
                new ItemResponse(2L, "itemB", 2000, 5),
                new ItemResponse(3L, "itemC", 500, 20),
                new ItemResponse(4L, "itemD", 2500, 10),
                new ItemResponse(5L, "itemE", 5000, 15)
        ));
    }

    @GetMapping("/api/item/top")
    public ResponseEntity<ItemResponse> getTopItem() {
        return ResponseEntity.ok().body((ItemResponse) List.of(
                new ItemResponse(1L, "itemA", 1000, 10),
                new ItemResponse(2L, "itemB", 2000, 5),
                new ItemResponse(3L, "itemC", 500, 20)
        ));
    }
}
