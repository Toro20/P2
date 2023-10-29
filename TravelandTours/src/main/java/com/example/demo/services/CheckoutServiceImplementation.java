package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Excursion;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImplementation implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImplementation(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseData purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();


        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        if(customer == null || cart.getCartItem().isEmpty()){
            return new PurchaseResponse("Customer or order is empty. Cannot place empty order");
        }

        customer.add(cart);



        cart.setStatus(Cart.StatusType.ordered);
        cartRepository.save(cart);


        System.out.println(orderTrackingNumber);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
