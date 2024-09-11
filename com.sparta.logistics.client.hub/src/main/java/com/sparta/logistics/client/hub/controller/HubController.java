package com.sparta.logistics.client.hub.controller;

import com.sparta.logistics.client.hub.dto.HubRequestDto;
import com.sparta.logistics.client.hub.dto.HubResponseDto;
import com.sparta.logistics.client.hub.service.HubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hubs")
@RequiredArgsConstructor
public class HubController {

    private final HubService hubService;

    // 허브 생성 API
    @PostMapping
    public ResponseEntity<HubResponseDto> createHub(@RequestBody HubRequestDto requestDto) {
        // DTO를 서비스로 전달하여 허브 생성
        HubResponseDto responseDto = hubService.createHub(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 허브 목록 조회 API
    @GetMapping
    public ResponseEntity<List<HubResponseDto>> getAllHubs() {
        List<HubResponseDto> hubs = hubService.getAllHubs();
        return ResponseEntity.ok(hubs);
    }


    // 허브 단건 조회 API
    @GetMapping("/{hubId}")
    public ResponseEntity<HubResponseDto> getHubById(@PathVariable UUID hubId) {
        HubResponseDto responseDto = hubService.getHubById(hubId);
        return ResponseEntity.ok(responseDto);
    }

    //허브 수정 API
    @PatchMapping("/{id}")
    public ResponseEntity<HubResponseDto> updateHub(
            @PathVariable("id") UUID hubID,
            @RequestBody HubRequestDto requestDto
    ){
        HubResponseDto responseDto = hubService.updateHub(hubID,requestDto);
        return ResponseEntity.ok(responseDto);
    }


    // 허브 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHub(@PathVariable("id") UUID hubId) {
        hubService.deleteHub(hubId);
        return ResponseEntity.noContent().build();
    }

}