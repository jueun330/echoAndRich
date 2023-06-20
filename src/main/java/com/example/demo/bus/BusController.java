package com.example.demo.bus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@Api(tags = {"open api - 버스노선정보"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusRouteAPI busRouteAPI;
    @ApiImplicitParam(name = "busId", value = "버스의 아이디 - 첨부 드린 9글자 숫자", dataType = "Integer")
    @GetMapping(value = "/route")
    public String getBusRoute (Integer busId) throws IOException {
        return busRouteAPI.getBusRoute(busId);
    }
}
