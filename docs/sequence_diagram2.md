```mermaid
sequenceDiagram
    actor 회원
    activate 회원
    activate ItemFacade
    회원-->>ItemFacade: 상위 상품 페이지 요청
    ItemFacade-->>ItemService: 금일 기준 상위 상품 요청
    activate ItemService
    ItemService--)ItemFacade: 상위 상품 응답
    deactivate  ItemService
    ItemFacade--)회원: 상위 상품 노출
    deactivate ItemFacade
    회원-->>ItemFacade: 전체 상품 페이지 요청
    activate ItemFacade
    ItemFacade-->>ItemService: 상품 목록 요청
    activate ItemService
    ItemService--)ItemFacade: 검색된 상품 응답
    deactivate ItemService
    ItemFacade--)회원: 상품 페이지 정보 응답
    deactivate ItemFacade
    deactivate 회원
```