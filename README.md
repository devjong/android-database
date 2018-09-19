## DATABASE

#### 데이터베이스 4단계

1. 저장소를 만들거나 저장소에 접근하기 위해서 오픈을 하는 단계
2. 테이블의 구조 만들기 (테이블이 하나의 단위)
3. 테이블 구조에 맞게 데이트를 집어 넣는 단계
4. 데이터를 조회하는 단계 (데이터 조회 == 쿼리)



#### 4단계 코드 예시

- 테이블 구조 만들기

```sql
CREATE TABLE tablename
			(field1, field2, ...)
      options ;
```

```sql
sql> CREATE TABLE CUSTOMER (
//  	칼럼이름     타입크기(길이값)  초기화값        
    	accountNumber VARCHAR(8) NOT NULL,    
    	clientID	  VARCHAR(40) NOT NULL,
    	balance		  DOUBLE	DEFAULT '0',
    	acailableBalance	DOUBLE DEFAULT '0'
		) ; 
```



-  테이블 삭제

```sql
DROP TABLE tablename;
```

```SQL
sql> DROP TABLE CUSTOMER;
```



- 테이터 삽입

```sql
INSERT INTO table (field1, field2, ...)
	VALUES ( data1, data2, ..);
```

```sql
sql> INSERT INTO Accounts
		(accountNumer, balance, accountName)
     VALUES건
     	('2222222', 10000000, 'Ample Rich');
     	// 문자열: 작은따옴표, 숫자: 작은따옴표 안붙임 
```

| accountNumber | accountName | clientID | balance  |
| :-----------: | :---------: | :------: | :------: |
|    2222222    | Ample Rich  |          | 10000000 |



- 데이터 업데이트

```sql
UPDATE table
	SET field1=value1, field2=value2
	WHERE condition;
	//WHRER는 특정 조건일 때에만 그 값을 수정 해주겠다
```

```sql
sql>  UPDATE city
		SET population=40000
		WHERE name='Bangsaen' AND countrycode='THA'; // 조건
```

| name     | countrycode | district | pupulation |
| -------- | ----------- | -------- | ---------- |
| 11111111 | THA         | Chonburi | 40000      |



- 데이터 조회

```sql
SELECT field1, field2, field3
	FROM table
	WHERE condition
	ORDER BY field1, ... [ASC|DESC];
```

```SQL
sql> SELECT *FROM city
		WHERE Population > 5000000
		ORDER BY population DESC;
```



#### 모바일 데이터 베이스란?

- 데이터 베이스

  - 여개의 테이블을 담고 있는 하나의 그릇 역할


- 데이터 베이스를 만드는 가장 간단한 방법
  - Context 클래스에 정의된 openOrCreateDataase() 메소드를 사용
  - 애플리케이션에서 기본적으로 사용하든 Activity 클래스가 Context를 상속한 것이므로 액티비티 안에서 데이터베이스 생성가능



#### 데이터베이스와 테이블 만들기

- 데이터베이스를 열거나 삭제할 수 있는 메소드

```JAVA
public abstract SQLiteDatabase openOrCreateDatabase (String name, int mode, SQLiteDatabase.CursorFactory factory)
    
public abstract boolean deleteDatabase (String name)
```



- SQL을 실행할 수 있는 메소드

  - createm insert, delete 등 결과데이터가 없는 SQL문

    ```JAVA
    public void exeSQL(String sql) throws SQLException
    ```

  - select와 같이 조회에 따른 결과 데이터가 있는 SQL문

    ```JAVA
    public cursor rawQuery(String sql) throws SQLException
    ```


