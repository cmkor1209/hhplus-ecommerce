```mermaid
sequenceDiagram
    actor 회원
    activate 회원
    회원->>PointFacade: 회원 ID 전송
    activate PointFacade
    PointFacade->>PointService: 잔액 조회
    activate PointService
    PointService--)PointFacade: 회원 잔액 응답
    deactivate PointService
    PointFacade--)회원: 잔액 응답
    deactivate PointFacade
    회원->>PointFacade: 충전 금액 입력
    activate PointFacade
    PointFacade->>PointService: 충전 금액 조회
    activate PointService
    PointService--)PointFacade: 잔액 응답
    PointFacade-->>결제대행사: 결제 승인 요청
    activate 결제대행사
    결제대행사--)PointFacade: 승인 결과 응답
    deactivate 결제대행사
    alt 응답==실패
        PointFacade->>PointService: 응답 결과만 저장
    else [else]
        PointFacade->>PointService: 충전 금액, 응답 결과, 내역 저장
    end
    deactivate PointService
    PointFacade--)회원: 결제 결과 전달
    deactivate PointFacade
    deactivate 회원
```