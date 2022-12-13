package bugoverdose.grpc.client.presentation;

import bugoverdose.grpc.client.application.GrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Jeong") String name) {
        return grpcClientService.sendMessage(name);
    }
}
