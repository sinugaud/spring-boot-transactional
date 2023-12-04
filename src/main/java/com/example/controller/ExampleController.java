//package com.example;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestC  ontroller
//@RequestMapping("/example")
//public class ExampleController {
//
//    @GetMapping("/info")
//    @ResponseBody // This annotation is optional since @RestController implies @ResponseBody
//    public String getInfo() {
//        return "This is an example response.";
//    }
//
//    @GetMapping("/data")
//    public ResponseEntity<String> getData() {
//        return ResponseEntity.ok("Some data as a response.");
//    }
//
//    @PostMapping("/create")
//    @ResponseBody
//    public ResponseEntity<String> createData(@RequestBody String requestData) {
//        // Process the request data and return a response
//        return ResponseEntity.ok("Created: " + requestData);
//    }
//}
