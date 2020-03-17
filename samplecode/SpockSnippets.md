# Snippet

```
// オブジェクトのnewと同時に中身のサービスなどをStub化
given:
def obj = new SampleServiceImpl(
  helperUtilField: Stub(HelperUtil) {
      1 * getHelperString() >> "test"
    } 
)

when:
// ↑のStubで設定したとおり、runの中で helperUtilField.getHelperString() が呼ばれることの検証が行われる
obj.run()


// Mockの引数をチェックする
1 * target.methodName(
    expectedArgumentValue, // プリミティブ系は渡すだけでOK
    { // オブジェクトの場合は中身をチェックする必要あり
      def args = it as ExpectedClass
      args.with {
        assert name == "name"
        assert age == 20
        true
      }
      true
    },
    ExpectedClass.class
) >> expectedResponse


// Stubの返り値として例外を投げる
1 * target.methodName() >> {
  throw new Exception()
}

// newと同時に値設定
def config = new Config(
  host: "host",
  port: 80,
  ssl: false
)

// streamでリスト内をassertする（クロージャにする）
list.each {
  assert it.xxx == xxx
  assert it.yyy == yyy
  assert it.zzz == zzz
  true
}

// オブジェクト内のフィールド全部チェックするときのやり方
then:
  with(dto) {
    id == eId
    name == eName
    age == eAge
  }

// Mockの引数を検証する場合のフィールドチェックはxxx.with{}でないとだめ
1 * target.methodName({
  def args = it as ExpectedClass
  args.with {
    assert name == "name"
    assert age == 20
    true
  }
  true
})

// Mockの引数を検証する場合のフィールドチェックは愚直にやっても良い
1 * target.methodName({
  def args = it as ExpectedClass
  assert args.name == "name"
  assert args.age == 20
  true
})


// テンプレート
def "when-thenパターン"() {
  setup: ...    // Setup
  when: ...     // Stimulus
  then: ...     // Response
  cleanup: ...  // Cleanup
}

// インスタンスの型確認
assert ExpectedClass.class.isAssignableFrom(actualObject.getClass())

// メソッドの一部をMock化（Spy）　※privateメソッドはMock化不可能（やりべきじゃない）
TargetClass target = Spy(TargetClassImpl)
target.getName(_) >> "???"



```
