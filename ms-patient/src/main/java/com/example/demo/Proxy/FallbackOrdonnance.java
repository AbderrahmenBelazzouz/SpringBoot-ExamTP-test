package com.example.demo.Proxy;

import org.springframework.stereotype.Component;


import com.example.demo.DTO.OrdonnanceDTO;
        import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class FallbackOrdonnance implements OrdonnanceProxy{
    @Override
    public OrdonnanceDTO getOrdonnance(Long ido) {
        return new OrdonnanceDTO(1L, Date.valueOf("1999-01-01"), "il ya plusieurs medicaments");
    }

    @Override
    public OrdonnanceDTO FallbackOrdonnance(Long ido, Throwable throwable) {
        return new OrdonnanceDTO(1L, Date.valueOf("1999-01-01"), "il ya plusieurs medicaments");
    }
}

