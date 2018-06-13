
特定のイメージに紐づくコンテナID一覧を出す

```
$ docker ps --filter="ancestor=mywebapp_java:0.1" -q
```
