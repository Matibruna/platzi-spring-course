package com.platzi.market.web.controller;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<PurchaseDTO> clientMadeAPurchase(@RequestBody PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(purchaseService.save(purchaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<PurchaseDTO>> getPurchasesByClient(@PathVariable("clientId") String clientId){
        return ResponseEntity.of(purchaseService.getByClient(clientId));
    }

}
