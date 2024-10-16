package com.project.demo.controllers;

import com.project.demo.dtos.requests.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @PostMapping("/")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDTO , BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                List<String> errMess = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errMess);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Created Order");
        }catch(Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/lists/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@Valid @PathVariable("userId") int userId){
        return ResponseEntity.status(HttpStatus.CREATED).body("Lists of order with :" + userId);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@Valid @PathVariable("orderId") int orderId){
        return ResponseEntity.status(HttpStatus.CREATED).body("Order with id :" + orderId);
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrderByid(@PathVariable("orderId") int orderId){
        return ResponseEntity.status(HttpStatus.CREATED).body("delete sucessfully with id" + orderId);
    }

}
