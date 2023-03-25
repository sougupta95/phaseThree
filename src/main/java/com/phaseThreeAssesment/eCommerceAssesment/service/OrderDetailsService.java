package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.OrderDetails;
import com.phaseThreeAssesment.eCommerceAssesment.model.ProductDetails;
import com.phaseThreeAssesment.eCommerceAssesment.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    ProductDetailsService productDetailsService;

    public List<OrderDetails> fetchList(){return orderDetailsRepository.findAll();}

    public OrderDetails findById(long id){return orderDetailsRepository.findById(id).orElse(null);}

    public OrderDetails create(OrderDetails orderDetails){
        if(orderDetails.getProductDetails().getQuantity() - orderDetails.getQuantity() >=0) {
            ProductDetails productDetails = orderDetails.getProductDetails();
            productDetails.setQuantity(productDetails.getQuantity()-orderDetails.getQuantity());
            productDetails.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
            productDetailsService.update(productDetails.getProductId(),productDetails);

            orderDetails.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
            orderDetails.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
           return orderDetailsRepository.save(orderDetails);
        }
        return null;
    }

    public OrderDetails update(long id, OrderDetails orderDetails){

        OrderDetails orderDetailsEntity = orderDetailsRepository.findById(id).orElse(null);
        if(null == orderDetailsEntity) return null;
       if(orderDetailsEntity.getStatus().equalsIgnoreCase("Draft")){

           ProductDetails productDetailsOld = orderDetailsEntity.getProductDetails();
           ProductDetails productDetailsNew = orderDetails.getProductDetails();
            //TO DO Handling of updating more than available quantity
           if(productDetailsNew.getProductId() == productDetailsOld.getProductId()){
               productDetailsNew.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
               productDetailsNew.setQuantity(productDetailsNew.getQuantity()+orderDetailsEntity.getQuantity()-orderDetails.getQuantity());
               productDetailsService.update(productDetailsNew.getProductId(),productDetailsNew);
           } else {
               productDetailsOld.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
               productDetailsOld.setQuantity(productDetailsOld.getQuantity()+orderDetailsEntity.getQuantity());
               productDetailsService.update(productDetailsOld.getProductId(),productDetailsOld);

               productDetailsNew.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
               productDetailsNew.setQuantity(productDetailsNew.getQuantity()-orderDetails.getQuantity());
               productDetailsService.update(productDetailsNew.getProductId(),productDetailsNew);

           }
            orderDetails.setId(orderDetailsEntity.getId());
            orderDetails.setCreatedAt(orderDetailsEntity.getCreatedAt());
            orderDetails.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
            return orderDetailsRepository.save(orderDetails);
        }
        return null;
    }


    public void delete(long id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElse(null);
        if (null != orderDetails){
            orderDetailsRepository.delete(orderDetails);
        }
    }
}
