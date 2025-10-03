package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.CustomerDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Customer;
import com.base.admin.inventory.service.CustomerService;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = modelMapper.map(customer.get(), new TypeToken<CustomerDTO>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", customerDTO);
        }
        return ResponseHandler.generateResponseError("Customer not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Customer> pageCustomer = customerService.findPage(pagedRequest);
        if (pageCustomer.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<>(Collections.emptyList(), pageCustomer.getNumber(), pageCustomer.getSize(), pageCustomer.getTotalElements(), pageCustomer.getTotalPages(), pageCustomer.isLast()));
        }
        List<CustomerDTO> customerDTOs = modelMapper.map(pageCustomer.getContent(), new TypeToken<List<CustomerDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(customerDTOs, pageCustomer.getNumber(), pageCustomer.getSize(), pageCustomer.getTotalElements(), pageCustomer.getTotalPages(), pageCustomer.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated CustomerDTO customerDTO) {
        if (customerService.existByName(customerDTO.getCustomername())) {
            return ResponseHandler.generateResponseError("Customer name already exists", HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();
        customer.setCustomercode(customerDTO.getCustomercode());
        customer.setCustomername(customerDTO.getCustomername());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setTaxnumber(customerDTO.getTaxnumber());



        UUID customerId = customerService.save(customer);
        if (customerId == null) {
            return ResponseHandler.generateResponseError("Save group fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Group created", customerId);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated CustomerDTO customerDTO) {

        Optional<Customer> customeropt = customerService.findById(customerDTO.getId());
        if (!customeropt.isPresent()) {
            return ResponseHandler.generateResponseError("Customer not found", HttpStatus.NOT_FOUND);
        }
        Customer customer = customeropt.get();
        customer.setCustomercode(customerDTO.getCustomercode());
        customer.setCustomername(customerDTO.getCustomername());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setTaxnumber(customerDTO.getTaxnumber());

        UUID customerId = customerService.save(customer);
        if (customerId == null) {
            return ResponseHandler.generateResponseError("Save Customer fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Customer updated", customerId);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "customerid", required = true) UUID customerid) {

        if (!customerService.existById(customerid)) {
            return ResponseHandler.generateResponseError("Customer not found", HttpStatus.NOT_FOUND);
        }

        if (!customerService.delete(customerid)) {
            return ResponseHandler.generateResponseError("Delete group fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Group deleted", null);
    }
}
