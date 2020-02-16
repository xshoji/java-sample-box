package io.github.xshoji.samplecode


import spock.lang.Specification
import spock.lang.Unroll

class SamplecodeApplicationSpockTests extends Specification {
  def setupSpec() {
    println("== TestSample.setupSpec() ==")
  }

  @Unroll
  def "SampleTest [ #testCase ]"() {
    setup: "フィーチャメソッドの前提条件を記述する。（Setupフェース）"
    def value = v

    when: "ブロックは任意の実行コードを記述する。（Stimulusフェース）"
    def result = value.contains("v")

    then: "変数宣言、コンディションなどを含めることができる。（Responseフェース）"
    result == e

    cleanup: "フィクスチャのお掃除ブロック。（Cleanupフェース）"

    where: "データドリブン"
    v       | e     || testCase
    "value" | true  || "value"
    "apple" | false || "apple"
  }

  def "Stimulus+Response"() {
    expect: "Stimulus + Response"
    def value = "value"
    assert value == "value"
  }

  def cleanupSpec() {
    println("== TestSample.cleanupSpec() ==")
  }
}
