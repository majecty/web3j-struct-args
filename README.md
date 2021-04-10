# Web3J의 function signature 생성 테스트

## 테스트 돌리는 법

Run `./gradlew test --info`

## 테스트 설명

Custom struct[]를 인자로 받는 스마트 컨트랙트 콜을 인코딩 합니다.

https://github.com/majecty/web3j-struct-args/blob/master/src/test/java/io/borre/HelloTest.java

master 브랜치는 4.6.3 버전의 web3j를 사용했고, update-web3j 브랜치에서는 4.8.4 버전의 web3j를 사용.
둘의 결과가 다르며 4.8.4를 사용했을 때 결과가 맞다.
