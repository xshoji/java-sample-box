package com.xshoji.springbootgrpc.client.usermessage

import com.xshoji.springbootgrpc.Application
import com.xshoji.springbootgrpc.service.usermessage.UserMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class UserMessageClientTest extends Specification {

    @Autowired
    private UserMessageClient client
    /**
     *  - [Spock - No Tests Found Matching Method - Graham Russell's Blog](https://blog.ham1.co.uk/2017/01/27/spock-no-tests-found-matching-method/)
     */
    def "scenario test"() {
        when:
        UserMessage emptyMessage = client.get("test")

        then:
        assert emptyMessage == null

        then:
        UserMessage addedMessage = client.add("test", "Hello!", 20)

        then:
        addedMessage.with {
            assert name == "test"
            assert message == "Hello!"
            assert age == 20
            true
        }

        then:
        UserMessage foundMessage = client.get("test")

        then:
        foundMessage.with {
            assert name == "test"
            assert message == "Hello!"
            assert age == 20
            true
        }
    }

}
