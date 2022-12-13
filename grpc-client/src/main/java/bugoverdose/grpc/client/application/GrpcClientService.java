package bugoverdose.grpc.client.application;

import devsisters.proto.HelloReply;
import devsisters.proto.HelloRequest;
import devsisters.proto.SimpleGrpc.SimpleBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

// 참고문헌: https://yidongnan.github.io/grpc-spring-boot-starter/en/client/getting-started.html
@Service
public class GrpcClientService {

    @GrpcClient("target-grpc-server")
    private SimpleBlockingStub simpleStub; // no final!

    public String sendMessage(final String name) {
        final HelloReply response = this.simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
