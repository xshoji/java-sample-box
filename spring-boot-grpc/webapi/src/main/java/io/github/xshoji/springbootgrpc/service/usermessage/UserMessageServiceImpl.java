package io.github.xshoji.springbootgrpc.service.usermessage;

import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


@GrpcService
public class UserMessageServiceImpl extends UserMessageServiceGrpc.UserMessageServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMessageServiceImpl.class);

    private Map<String, UserMessage> userMessageTable = new HashMap<>();

    @Override
    public void get(GetUserMessageRequest request, StreamObserver<UserMessageResponse> responseObserver) {
        LOGGER.info("[get] server received {}", request);
        UserMessageResponse.Builder builder = UserMessageResponse.newBuilder();
        UserMessage userMessage = null;
        if (userMessageTable.containsKey(request.getName())) {
            userMessage = userMessageTable.get(request.getName());
            builder.addMessage(userMessage);
        }
        UserMessageResponse response = builder.build();
        LOGGER.info("[get] server response {}", response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(AddUserMessageRequest request, StreamObserver<UserMessageResponse> responseObserver) {
        LOGGER.info("[add] server received {}", request);
        userMessageTable.put(request.getMessage().getName(), request.getMessage());
        UserMessageResponse response = UserMessageResponse
                .newBuilder()
                .addMessage(request.getMessage())
                .build();
        LOGGER.info("[add] server response {}", response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
