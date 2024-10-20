# 이커머스 서비스 API 명세

---

## 1. 잔액 조회

- **URL**: `GET /api/user/balance`
- **설명**: 사용자의 잔액을 조회한다

### 요청

- **Headers**:
    - `Content-Type`: `application/json`

### 응답

- **Status Code**: `200 OK`
- **Response Body**:
  ```json
  {
    "id" : 1,
    "balance" : 2000
  }
  ```

---

## 2. 잔액 충전

- **URL**: `POST /api/user/balance`
- **설명**: 사용자의 잔액을 충전한다

### 요청
- **Headers**:
  - `Content-Type`: `application/json`
- **Request Body**:
  ```json
  {
    "id": 1,
    "amount": 5000
  }
  ```
### 응답

- **Status Code**: `200 OK`
- **Response Body**:
  ```json
  {
    "id" : 1,
    "balance" : 7000
  }
  ```

---

## 3. 상품 정보 조회

- **URL**: `GET /api/item`
- **설명**: 상품 정보를 조회한다

### 응답

- **Status Code**: `200 OK`
  - **Response Body**:
    ```json
    [
      {
        "id": 1,
        "name": "itemA",
        "price": 10000,
        "stock": 10
      },
      {
        "id": 2,
        "name": "itemB",
        "price": 5000,
        "stock": 50
      },
      {
        "id": 3,
        "name": "itemC",
        "price": 30000,
        "stock": 90
      },
      {
        "id": 4,
        "name": "itemD",
        "price": 15000,
        "stock": 20
      },
      {
        "id": 5,
        "name": "itemE",
        "price": 100000,
        "stock": 30
      },
      {
        "id": 6,
        "name": "itemF",
        "price": 25000,
        "stock": 40
      }
    ]
    ```
---

## 4. 상위 상품 조회

- **URL**: `GET /api/item/top`
- **설명**: 최근 3일간 가장 많이 팔린 상위 5개 상품을 조회한다

### 응답

- **Status Code**: `200 OK`
- **Response Body**:
  ```json
  [
    {
      "id": 1,
      "name": "itemA",
      "price": 10000,
      "stock": 10
    },
    {
      "id": 2,
      "name": "itemB",
      "price": 5000,
      "stock": 50
    },
    {
      "id": 3,
      "name": "itemC",
      "price": 30000,
      "stock": 90
    },
    {
      "id": 4,
      "name": "itemD",
      "price": 15000,
      "stock": 20
    },
    {
      "id": 5,
      "name": "itemE",
      "price": 100000,
      "stock": 30
    }
  ]
  ```
---

## 5. 주문

- **URL**: `POST /api/order`
- **설명**: 상품을 주문한다

### 요청

- **Headers**:
    - `Content-Type`: `application/json`
  ```json
  {
    "id":1,
    "itemList": [{
      "id": 1,
      "name": "itemA",
      "price": 10000,
      "quantity": 1
    }, {
      "id": 2,
      "name": "itemB",
      "price": 5000,
      "quantity": 3
    }]
  }  
  ```
### 응답

- **Status Code**: `200 OK`
  - **Response Body**:
    ```json
    {
      "id": 1,
      "totalPrice": 250000,
      "status": 1,
      "itemList": [
        {
          "id": 1,
          "name": "itemA",
          "price": 10000,
          "quantity": 1
        },
        {
          "id": 2,
          "name": "itemB",
          "price": 5000,
          "quantity": 3
        }
      ]
    }
    ```

---

## 6. 결제

- **URL**: `POST /api/payment`
- **설명**: 주문을 결제한다

### 요청

- **Headers**:
  - `Content-Type`: `application/json`
  ```json
  {
    "userId": 1,
    "orderId": 1
  }
  ```
### 응답

- **Status Code**: `200 OK`
  - **Response Body**:
    ```json
    {
      "id": 1,
      "price": 250000,
      "status": 1
    }
    ```

---

## 7. 장바구니 조회

- **URL**: `GET /api/cart`
- **설명**: 장바구니에 담긴 품목을 조회한다

### 요청

- **Headers**:
  - `Content-Type`: `application/json`
  
### 응답

- **Status Code**: `200 OK`
- **Response Body**:
  ```json
  [
    {
      "id": 1,
      "itemId": 1,
      "name": "itemA",
      "price": 10000,
      "quantity": 1
    },
    {
      "id": 1,
      "itemId": 2,
      "name": "itemB",
      "price": 5000,
      "quantity": 2
    },
    {
      "id": 2,
      "itemId": 1,
      "name": "itemA",
      "price": 10000,
      "quantity": 2
    }
  ]
  ```

---

## 8. 장바구니 추가

- **URL**: `POST /api/cart/add`
- **설명**: 장바구니에 품목을 추가한다

### 요청

- **Headers**:
  - `Content-Type`: `application/json`
- **Request Body**:
  ```json
  {
    "userId": 1,
    "itemId": 2,
    "quantity": 4
  }
  ```

### 응답

- **Status Code**: `200 OK`
  - **Response Body**:
    ```json
    [
      {
        "userId": 1,
        "itemId": 1,
        "name": "itemA",
        "quantity": 1,
        "price": 10000
      },
      {
        "userId": 1,
        "itemId": 2,
        "name": "itemB",
        "quantity": 4,
        "price": 5000
      }
    ]
    ```

---


## 9. 장바구니 삭제

- **URL**: `POST /api/cart/remove`
- **설명**: 장바구니에 담긴 품목을 삭제한다

### 요청

- **Headers**:
  - `Content-Type`: `application/json`
- **Request Body**:
  ```json
  {
    "userId": 1,
    "itemId": 1
  }
  ```

### 응답

- **Status Code**: `200 OK`
- **Response Body**:
  ```json
    [
      {
        "userIid": 2,
        "itemId": 2,
        "name": "itemB",
        "quantity": 4,
        "price": 5000
      }
    ]
  ```

---