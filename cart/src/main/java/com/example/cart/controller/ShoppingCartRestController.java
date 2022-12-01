package com.example.cart.controller;
import com.example.cart.common.ApiResponse;
import com.example.cart.dto.cart.AddToCartDto;
import com.example.cart.dto.cart.CartDto;
import com.example.cart.entity.Product;
import com.example.cart.entity.User;
import com.example.cart.service.CartService;
import com.example.cart.service.ProductService;
import com.example.cart.service.UserService;
import com.example.cart.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/cart")
public class ShoppingCartRestController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam Integer id) {
        User user = userService.getUserById(id);
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getName());
        cartService.addToCart(addToCartDto, product, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam Integer id)  {
    	 System.out.println("userdetails"+  id);
    	 User user = userService.getUserById(id);
         CartDto cartDto = cartService.listCartItems(user);
         return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
//    @PutMapping("/update/{cartItemId}")
//    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto,
//                                                      @RequestParam("token") String token) {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
//        Product product = productService.getProductById(cartDto.getProductId());
//        cartService.updateCartItem(cartDto, user,product);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
//    }

//    @DeleteMapping("/delete/{cartItemId}")
//    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) {
//       authenticationService.authenticate(token);
//        int userId = authenticationService.getUser(token).getId();
//        cartService.deleteCartItem(itemID, userId);
//       return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//    }

}