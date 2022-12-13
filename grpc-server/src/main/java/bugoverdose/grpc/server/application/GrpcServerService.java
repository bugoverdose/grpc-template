package bugoverdose.grpc.server.application;

import devsisters.proto.HelloReply;
import devsisters.proto.HelloRequest;
import devsisters.proto.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.atomic.AtomicInteger;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    private static final String GREETINGS_FORMAT = "Hello, %s! You are our %dth visitor!";

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(String.format(GREETINGS_FORMAT, request.getName(), counter.getAndIncrement()))
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
