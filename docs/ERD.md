```mermaid
erDiagram
    USER ||--|| POINT : ""
    USER ||--o{ BASKET : ""
    USER ||--o{ ORDER : ""
    USER {
        BIGINT id PK
        VARCHAR username
        DATETIME created_at
    }

    POINT ||--|{ POINT_HISTORY : ""
    POINT {
        BIGINT id PK
        BIGINT user_id
        INT BALANCE
        DATETIME created_at
    }
    
    POINT_HISTORY {
        BIGINT id PK
        BIGINT point_id
        VARCHAR status
        INT amount
        DATETIME created_at
    }

    ORDER ||--o{ ORDER_ITEM : ""
    ORDER {
        BIGINT id PK
        BIGINT user_id
        INT total_price
        DATETIME created_dt
    }
    
    ORDER_ITEM {
        BIGINT id PK
        BIGINT order_id
        BIGINT item_id
    }

    BASKET ||--o{ BASKET_ITEM : ""
    BASKET {
        BIGINT id PK
        BIGINT user_id
        INT total_price
        DATETIME created_dt
    }

    BASKET_ITEM {
        BIGINT id PK
        BIGINT basket_id
        BIGINT item_id
    }

    ITEM ||--o{ ORDER_ITEM : ""
    ITEM ||--o{ BASKET_ITEM : ""
    ITEM {
        BIGINT id PK
        VARCHAR name
        INT price
        INT stock
    }

```