package com.project.demo.controllers;

import com.project.demo.dtos.requests.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/order-details")
public class OrderDetailController {
    @PostMapping("/")  // http://localhost:8080/api/v1/order-details
    public ResponseEntity<?> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailDTO , BindingResult bindingResult){
         try {
            if(bindingResult.hasErrors()){
                List<String> errMess =  bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMess);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Created Order Detail");
         }catch(Exception ex){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("errors");
         }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body("Get Order Detail by id: " + id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable("id") int id, @Valid @RequestBody OrderDetailDTO orderDetailDTO, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                List<String> errMess =  bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMess);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Update Order Detail by id: " + id);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("errors");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body("Delete Order Detail by id: " + id);
    }
    // list orderDetail by orderId
    @GetMapping("/lists-detail/{orderId}")
    public ResponseEntity<?> listOrderDetailByOrderId(@PathVariable("orderId") int orderId){
        return ResponseEntity.status(HttpStatus.OK).body("List Order Detail by orderId: " + orderId);
    }

}
