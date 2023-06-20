package com.example.demo.bus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusRouteAPI busRouteAPI;

    @GetMapping(value = "/route")
    public String getBusRoute (Integer busId) throws IOException {
        return busRouteAPI.getBusRoute(busId);
    }
}
