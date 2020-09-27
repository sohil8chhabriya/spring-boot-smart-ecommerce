// package com.smart.controller;
//
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.smart.model.InputWrapper;
// import com.smart.model.SubCategory;
// import com.smart.service.CategorySubCatService;
//
// @RestController
// @RequestMapping(headers = "Accept=application/json", produces = "application/json",
// path = "/api/subcat")
// public class CategorySubCatController {
//
// @Autowired
// private CategorySubCatService categorySub;
//
// @GetMapping(value = {"", "/"})
// public List<SubCategory> getSubCategoryByCategory(@RequestBody InputWrapper input) {
// return categorySub.getSubCategoryByCategory(input);
// }
//
// }
