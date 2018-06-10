package com.georgen.jcommand;

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit test for simple App.
 */
class AppTest extends Specification
{
    @Unroll
    def "unittest sample"() {
        setup:
        def app = new App()

        expect:
        is_bool == result

        where:
        is_bool || result
        true    || true
        false   || false
    }

}
