package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.office.OfficeService;
import com.guizKev.api.exeptions.ErrorResponses;
import com.guizKev.api.exeptions.NotFoundEndPoint;
import com.guizKev.api.persistence.entity.Office;
import com.guizKev.api.persistence.entity.ProductRange;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/office")
public class OfficeController {
    
    @Autowired
    private OfficeService  officeService ;

    @GetMapping("/all")
    public List<Office> getAllEmployee() {
        return officeService.getAllOffice();
    }

    //PERFECT
    @GetMapping("/codes")
    public List<Object[]> getAllCodesAndCities() {
        return officeService.findAllOfficeCodesAndCities();
    }

    //PERFECT
    @GetMapping("/cities/{country}")
    public List<Object[]> getCitiesAndPhonesInCountry(@PathVariable String country) {
        return officeService.findCitiesAndPhonesInCountry(country);
    }

    //PERFECT
    @GetMapping("/addresses/{city}")
    public List<Object[]> getOfficeAddressesWithClientsInCity(@PathVariable String city) {
        return officeService.findOfficeAddressesWithClientsInCity(city);
    }

    
    //PERFECT
    //EXAMPLE :http://localhost:8080/api/office/withoutReps/Frutales
    @GetMapping("/withoutReps/{range}")
    public List<Office> getOfficesWithoutSalesRepsForFruitsProducts(@PathVariable ProductRange range) {
        return officeService.findOfficesWithoutSalesRepsForFruitsProducts(range);
    }
    
    // Exception handling for endpoint not found
    @ExceptionHandler(NotFoundEndPoint.class)
    public ResponseEntity<Object> handleNotFoundEndPoint(NotFoundEndPoint ex) {
        ErrorResponses errorResponse = new ErrorResponses("The requested endpoint is not defined in the API", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
}