package com.geekbrains.spring.ws;

import com.geekbrains.geek.market.dto.OrderDto;
import com.geekbrains.geek.market.dto.ProductDto;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.repositories.ProductRepository;
import com.geekbrains.market.product.GetProductRequest;
import com.geekbrains.market.product.GetProductResponse;
import com.geekbrains.spring.ws.countries.GetCountryRequest;
import com.geekbrains.spring.ws.countries.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.com/market/ws/product";

    private ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProducts(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProducts( productRepository.findAll().stream().map( ProductDto::new ).collect( Collectors.toList()) );

        return response;
    }
}
