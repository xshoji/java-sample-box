package com.xshoji.springbootgrpc.client.usermessage;

import com.xshoji.springbootgrpc.service.usermessage.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserMessageClient {
  private UserMessageServiceGrpc.UserMessageServiceBlockingStub userMessageServiceBlockingStub;

  @PostConstruct
  private void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
            .forAddress("localhost", 6565)
            .usePlaintext()
            .build();
    userMessageServiceBlockingStub = UserMessageServiceGrpc.newBlockingStub(managedChannel);
  }

  public UserMessage get(String userName) {
    GetUserMessageRequest request = GetUserMessageRequest.newBuilder().setName(userName).build();
    UserMessageResponse response = userMessageServiceBlockingStub.get(request);
    if (response.getMessageCount() == 0) {
      return null;
    }
    return response.getMessage(0);
  }

  public UserMessage add(String userName, String message, Integer age) {
    AddUserMessageRequest request = AddUserMessageRequest
            .newBuilder()
            .setMessage(
                    UserMessage
                            .newBuilder()
                            .setName(userName)
                            .setMessage(message).setAge(age)
                            .build()
            ).build();
    UserMessageResponse response = userMessageServiceBlockingStub.add(request);
    return response.getMessage(0);
  }
}
