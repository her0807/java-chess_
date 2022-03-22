# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항 도출

### 입력

- [ ] start/end 를 입력받아 게임을 시작하거나, 종료한다.
    - [ ] [ 예외 ] start/end 외에 다른 문자가 올 경우 에러를 던진다.
    - [ ] 대소문자 구분 없이 입력 가능하도록 한다.

## 진행

- [ ] 보드판을 생성한다.
- [ ] 보드판에 말을 초기화한다.

```text
RNBQKBNR
PPPPPPPP
........
........
........
........
pppppppp
rnbqkbnr
```

## 출력

- [ ] 게임 시작 안내 메세지를 출력한다. (체스 게임을 시작합니다. 게임 시작은 start, 종료는 end 명령을 입력하세요.)
- [ ] 입력 명령어를 받은 후, 보드판 상태를 출력한다

## 보드판

- 가로(Row)
    - [ ] a,b,c,d,e,f,g,h 로 이뤄져 있다.
    - [ ] [ 예외 ] a,b,c,d,e,f,g,h 외에 다른 문자가 올 경우 에러를 던진다.

- 세로(Column)
    - [ ] 1,2,3,4,5,6,7,8 로 이뤄져 있다.
    - [ ] [ 예외 ] 1,2,3,4,5,6,7,8 외에 다른 문자가 올 경우 에러를 던진다.

## 페어 프로그래밍 룰

- 타이머는 10분으로 한다.
