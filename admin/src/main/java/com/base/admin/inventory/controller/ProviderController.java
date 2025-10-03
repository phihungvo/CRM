package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.BrandDTO;
import com.base.admin.inventory.dto.ProviderDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.entity.Provider;
import com.base.admin.inventory.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/provider")
@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Provider> provider = providerService.findById(id);
        if (provider.isPresent()) {
            ProviderDTO providerDTO = modelMapper.map(provider.get(), new TypeToken<ProviderDTO>() {}.getType());
            return ResponseHandler.generateResponseSuccess("", providerDTO);
        }
        return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        List<Provider> providers = providerService.findAll();
        if (providers != null ) {
            List<ProviderDTO> providerDTOS = modelMapper.map(providers, new TypeToken<List<ProviderDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", providerDTOS);
        }
        return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Provider> providerPage = providerService.findPage(pagedRequest);
        if (providerPage.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<>(Collections.emptyList(), providerPage.getNumber(),
                    providerPage.getSize(), providerPage.getTotalElements(), providerPage.getTotalPages(), providerPage.isLast()));
        }
        List<ProviderDTO> providerDTOS = modelMapper.map(providerPage.getContent(), new TypeToken<List<ProviderDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(providerDTOS, providerPage.getNumber(),
                providerPage.getSize(), providerPage.getTotalElements(), providerPage.getTotalPages(), providerPage.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated ProviderDTO providerDTO) {
        if (providerService.existsByName(providerDTO.getProvidername())) {
            return ResponseHandler.generateResponseError("Group name already exists", HttpStatus.BAD_REQUEST);
        }

        Provider provider = new Provider();
        provider.setProvidername(providerDTO.getProvidername());
        provider.setAddress(providerDTO.getAddress());
        provider.setPhone(providerDTO.getPhone());
        provider.setEmail(providerDTO.getEmail());
        provider.setTaxnumber(providerDTO.getTaxnumber());

        UUID providerId = providerService.save(provider);
        if (providerId == null) {
            return ResponseHandler.generateResponseError("Save Provider fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Provider created", providerId);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated ProviderDTO providerDTO) {

        Optional<Provider> providerOptional = providerService.findById(providerDTO.getId());
        if (!providerOptional.isPresent()) {
            return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
        }
        if (providerService.existsByName(providerDTO.getProvidername())) {
            if (!providerDTO.getProvidername().equals(providerOptional.get().getProvidername()))
                return ResponseHandler.generateResponseError("Group name already exists", HttpStatus.BAD_REQUEST);
        }
        Provider provider = providerOptional.get();
        provider.setProvidername(providerDTO.getProvidername());
        provider.setAddress(providerDTO.getAddress());
        provider.setPhone(providerDTO.getPhone());
        provider.setEmail(providerDTO.getEmail());
        provider.setTaxnumber(providerDTO.getTaxnumber());

        UUID providerId = providerService.save(provider);
        if (providerId == null) {
            return ResponseHandler.generateResponseError("Save Provider fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Provider updated", providerId);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "providerid", required = true) UUID providerid) {

        if (!providerService.existById(providerid)) {
            return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
        }

        if (!providerService.delete(providerid)) {
            return ResponseHandler.generateResponseError("Delete Provider fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Provider deleted", null);
    }
}
