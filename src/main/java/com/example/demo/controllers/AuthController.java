// package com.example.demo.controllers;

// import java.io.IOException;
// import java.util.Base64;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.CrossOrigin;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @RestController

// public class AuthController {

//     // @PostMapping("/login")
//     // public void login(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @ RequestParam String password) throws IOException{
//     //     // Perform authentication logic here
//     //     System.out.println(password);

//     //     // Perform authentication logic using username and password
//     //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//     //     auth.setAuthenticated(true);
//     //     // if (/* authentication successful */) {
//     //     // // Redirect to home page after successful login
//     //     // return "redirect:/home";
//     //     // } else {
//     //     // // Authentication failed, redirect to login page with error message
//     //     // return "redirect:/login?error";
//     //     // }
//     //     response.sendRedirect("/books");

//     // }
//     @PostMapping("/login")
// @CrossOrigin
//     
//     public ResponseEntity<String> login(HttpServletRequest request) {
//                 System.out.println("heyyyyy");
//         String authHeader = request.getHeader("Authorization");
//         if (authHeader != null && authHeader.startsWith("Basic ")) {
//             String encodedCredentials = authHeader.substring(6).trim();
//             byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
//             String decodedCredentials = new String(decodedBytes);
//             String[] credentials = decodedCredentials.split(":", 2);
//             String username = credentials[0];
//             String password = credentials[1];
//             System.out.println("hedha password" + password);
//             
//             // Perform authentication logic here, e.g., validate username and password against a database
//             
//             if (true) {
//                 // return success response
//                 return ResponseEntity.ok("Login successful");
//             } else {
//                 // return unauthorized response
//                 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//             }
//         } else {
//             // return unauthorized response
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization header missing");
//         }
// }
// }
